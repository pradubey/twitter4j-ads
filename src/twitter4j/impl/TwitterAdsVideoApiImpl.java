package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;
import twitter4j.*;
import twitter4j.api.TwitterAdsVideoApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.models.video.AssociateVideoToAccountResponse;
import twitter4j.models.video.TwitterAccountMediaResponse;
import twitter4j.models.video.TwitterCreativeType;
import twitter4j.models.video.UploadMediaObjectResponse;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:41 AM
 */
public class TwitterAdsVideoApiImpl implements TwitterAdsVideoApi {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsVideoApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsResponse<TwitterAccountMediaResponse> transformMediaInAccount(String accountId, String mediaId, String videoId,
                                                                                TwitterCreativeType twitterCreativeType) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(twitterCreativeType, "Twitter Creative Type");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_CREATIVE_TYPE, twitterCreativeType.name()));
        if (!TwitterAdUtil.isNotNullOrEmpty(videoId) && !TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            throw new TwitterException("Both Media Id and Video Id cannot be null");
        }
        if (TwitterAdUtil.isNotNullOrEmpty(videoId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoId));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_MEDIA_ID, mediaId));
        }

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_ACCOUNT_MEDIA;
        HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<TwitterAccountMediaResponse>>() {}.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response for transform media to account", e);
        }
    }

    @Override
    public String uploadVideoAndGetMediaId(String videoUrl) throws TwitterException {
        UploadMediaObjectResponse responseFromFinalize = twitterAdsClient.uploadAndGetMediaId(videoUrl);
        String mediaIdString = responseFromFinalize.getMediaIdString();
        UploadMediaObjectResponse statusResponse = twitterAdsClient.getUploadStatus(mediaIdString);
        if (statusResponse == null) {
            throw new TwitterException("Could not upload Video successfully");
        }

        //as per documentation if media process info is null then the video is ready
        if (statusResponse.getUploadMediaProcessingInfo() == null) {
            return mediaIdString;
        }

        if (statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo() != null) {
            throw new TwitterException(statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo().getMessage());
        }

        String state = statusResponse.getUploadMediaProcessingInfo().getState();
        Integer progressPercentage = statusResponse.getUploadMediaProcessingInfo().getProgressPercentage();
        if ((TwitterAdUtil.isNotNullOrEmpty(state) && state.equalsIgnoreCase("succeeded")) ||
            (progressPercentage != null && progressPercentage == 100)) {
            return mediaIdString;
        }
        return waitForVideoProcessingAndReturnId(mediaIdString, statusResponse);
    }

    @Override
    public String waitForVideoProcessingAndReturnId(String mediaIdString, UploadMediaObjectResponse statusResponse) throws TwitterException {
        if (statusResponse == null) {
            statusResponse = twitterAdsClient.getUploadStatus(mediaIdString);
        }

        Long timeToWait = 0l;
        Long checkAfterSeconds = statusResponse.getUploadMediaProcessingInfo().getCheckAfterSeconds();
        while (timeToWait < TwitterAdsConstants.WAIT_INTERVAL_MEDIA_UPLOAD) {
            TwitterAdUtil.reallySleep(checkAfterSeconds);
            timeToWait = timeToWait + checkAfterSeconds;
            statusResponse = twitterAdsClient.getUploadStatus(mediaIdString);
            if (statusResponse == null) {
                throw new TwitterException("Could not upload Video successfully");
            }
            //as per documentation if media process info is null then the video is ready
            if (statusResponse.getUploadMediaProcessingInfo() == null) {
                return mediaIdString;
            }
            if (statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo() != null) {
                throw new TwitterException(statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo().getMessage());
            }
            String state = statusResponse.getUploadMediaProcessingInfo().getState();
            Integer progressPercentage = statusResponse.getUploadMediaProcessingInfo().getProgressPercentage();
            if ((TwitterAdUtil.isNotNullOrEmpty(state) && state.equalsIgnoreCase("succeeded")) ||
                (progressPercentage != null && progressPercentage == 100)) {
                return mediaIdString;
            }
        }
        if (statusResponse.getUploadMediaProcessingInfo().getProgressPercentage() != null &&
            statusResponse.getUploadMediaProcessingInfo().getProgressPercentage() < 100 &&
            statusResponse.getUploadMediaProcessingInfo().getState() != null &&
            statusResponse.getUploadMediaProcessingInfo().getState().equalsIgnoreCase("in_progress")) {
            throw new TwitterException("Please retry playing the ad, the video processing is in progress and will take more time");
        }
        throw new TwitterException(statusResponse.getUploadMediaProcessingInfo().getUploadErrorInfo().getMessage());
    }

    @Override
    public BaseAdsResponse<AssociateVideoToAccountResponse> associateVideoWithAccount(String accountId, String mediaId, String title,
                                                                                      String description) throws TwitterException {
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + VIDEOS;
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_VIDEO_MEDIA_ID, mediaId));
        if (TwitterAdUtil.isNotNullOrEmpty(title)) {
            params.add(new HttpParameter(PARAM_TITLE, title));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(description)) {
            params.add(new HttpParameter(PARAM_DESCRIPTION, description));
        }
        Type type = new TypeToken<BaseAdsResponse<AssociateVideoToAccountResponse>>() {}.getType();
        HttpResponse httpResponse = twitterAdsClient.postRequest(url, params.toArray(new HttpParameter[params.size()]));
        try {
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Exception occurred while associating video with account");
        }
    }
}
