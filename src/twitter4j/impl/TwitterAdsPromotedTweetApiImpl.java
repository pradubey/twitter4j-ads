package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsPromotedTweetApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.json.StatusJSONImpl;
import twitter4j.internal.org.json.JSONException;
import twitter4j.internal.org.json.JSONObject;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.ListStatusResponse;
import twitter4j.models.ads.PromotedTweets;
import twitter4j.models.ads.cards.PromotedVideoTweetResponse;
import twitter4j.models.ads.cards.VideoObjectResponseData;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static twitter4j.TwitterAdsClient.GSON_INSTANCE;
import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.TwitterAdsConstants.PATH_PROMOTED_TWEETS;
import static twitter4j.TwitterAdsConstants.PREFIX_ACCOUNTS_URI_0;
import static twitter4j.util.TwitterAdUtil.getDelimiterSeparatedMethod;

/**
 * User: abhay
 * Date: 4/22/16
 * Time: 1:06 PM
 */
public class TwitterAdsPromotedTweetApiImpl implements TwitterAdsPromotedTweetApi {

    private static final Integer MAX_REQUEST_PARAMETER_SIZE = 50;

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsPromotedTweetApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<PromotedTweets> getPromotedTweets(String accountId, String lineItemId, boolean withDeleted, String sortBy,
                                                                         Integer count, String cursor) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotNullOrEmpty(lineItemId)) {
            params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(sortBy)) {
            params.add(new HttpParameter(PARAM_SORT_BY, sortBy));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_PROMOTED_TWEETS;
        Type type = new TypeToken<BaseAdsListResponse<PromotedTweets>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<PromotedTweets> getPromotedTweetsById(String accountId, String promotedTweetsId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(promotedTweetsId, "promotedTweetsId");
        Type type = new TypeToken<BaseAdsResponse<PromotedTweets>>() {}.getType();
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_PROMOTED_TWEETS + promotedTweetsId;
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponse<PromotedTweets> createPromotedTweets(String accountId, String lineItemId, Collection<String> tweetIds)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        String tweetIdsAsString;
        if (TwitterAdUtil.isNotEmpty(tweetIds)) {
            TwitterAdUtil.ensureMaxSize(tweetIds, MAX_REQUEST_PARAMETER_SIZE);
            tweetIdsAsString = TwitterAdUtil.getCsv(tweetIds);
            params.add(new HttpParameter(PARAM_TWEET_IDS, tweetIdsAsString));
        }
        HttpResponse httpResponse = twitterAdsClient.postRequest(twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId +
                                                                 PATH_PROMOTED_TWEETS, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsListResponse<PromotedTweets>>() {}.getType();
            return TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse promoted tweets.");
        }
    }

    @Override
    public BaseAdsResponse<PromotedTweets> deletePromotedTweets(String accountId, String tweetId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(tweetId, "Tweet Id");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_PROMOTED_TWEETS +
                         tweetId;
        Type type = new TypeToken<BaseAdsResponse<PromotedTweets>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }


    @Override
    public BaseListResponseIterable<ListStatusResponse, Status> getScopedTimeLine(String accountId, List<String> promotedUserIds,
                                                                                  AdScopeTimelineScope scope) throws TwitterException {
        TwitterAdUtil.ensureNotNull(promotedUserIds, "promotedUserIds");
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_SCOPED_TIMELINE;
        List<HttpParameter> param = new ArrayList<>();
        param.add(new HttpParameter(PARAM_USER_IDS, getDelimiterSeparatedMethod(promotedUserIds, ",")));
        param.add(new HttpParameter(PARAM_SCOPED_TO, AdScopeTimelineScope.getScopeValue(scope)));
        return twitterAdsClient.executeAndGetStatusIterable(baseUrl, param);
    }

    @Override
    public Status createPromotedVideoTweet(String accountId, String tweetText, String videoUrl, String videoTitle, String videoDescription,
                                           String callToAction, String ctaValue) throws TwitterException {
        try {
            VideoObjectResponseData videoObjectResponseData = twitterAdsClient.uploadAndCreateVideoObject(videoUrl, accountId);
            String videoId = videoObjectResponseData.getId();

            List<HttpParameter> params =
                    validateAndCreateParamsForPromotedVideoTweet(accountId, tweetText, videoId, videoTitle, videoDescription, callToAction, ctaValue);
            String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_PROMOTED_VIDEO_TWEET;
            HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
            BaseAdsResponse<PromotedVideoTweetResponse> promotedVideoTweetResponse =
                    twitterAdsClient.executeHttpRequest(url, parameters, PromotedVideoTweetResponse.class, HttpVerb.POST);
            PromotedVideoTweetResponse data = promotedVideoTweetResponse.getData();
            if (data == null) {
                throw new TwitterException("Unable to create Video promoted Tweet");
            }
            String responseAsString = GSON_INSTANCE.toJson(promotedVideoTweetResponse.getData().getStatusJSON());
            return new StatusJSONImpl(new JSONObject(responseAsString));
        } catch (JSONException eX) {
            throw new TwitterException("Unable to Create Promoted Video Tweet");
        }
    }

    // --------------------------------------- Private Methods ----------------------------------------------

    private List<HttpParameter> validateAndCreateParamsForPromotedVideoTweet(String accountId, String tweetText, String videoId, String videoTitle,
                                                                             String videoDescription, String callToAction, String ctaValue)
            throws TwitterException {

        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tweetText, "Tweet text");
        TwitterAdUtil.ensureNotNull(videoId, "Video");

        if (TwitterAdUtil.isNotNullOrEmpty(tweetText)) {
            params.add(new HttpParameter(PARAM_STATUS, tweetText));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(videoId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(videoTitle)) {
            params.add(new HttpParameter(PARAM_VIDEO_TITLE, videoTitle));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(videoDescription)) {
            params.add(new HttpParameter(PARAM_VIDEO_DESCRIPTION, videoDescription));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction) && TwitterAdUtil.isNotNullOrEmpty(ctaValue)) {
            params.add(new HttpParameter(PARAM_VIDEO_CTA, callToAction));
            params.add(new HttpParameter(PARAM_VIDEO_CTA_VALUE, ctaValue));
        }
        return params;
    }
}
