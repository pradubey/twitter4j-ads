package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsVideoApi;
import twitter4j.models.video.AssociateVideoToAccountResponse;
import twitter4j.models.video.TwitterAccountMediaResponse;
import twitter4j.models.video.TwitterCreativeType;
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

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_ACCOUNT_MEDIA;
        HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<TwitterAccountMediaResponse>>() {}.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response for transform media to account", e);
        }
    }

    @Override
    public BaseAdsResponse<AssociateVideoToAccountResponse> associateVideoWithAccount(String accountId, String mediaId, String title,
                                                                                      String description) throws TwitterException {
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + VIDEOS;
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
