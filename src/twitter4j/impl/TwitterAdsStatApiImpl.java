package twitter4j.impl;

import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4j.*;
import twitter4j.api.TwitterAdsStatApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.models.Granularity;
import twitter4j.models.ads.TwitterAdStatistics;
import twitter4j.models.ads.TwitterAdStatisticsMetrics;
import twitter4j.models.ads.TwitterOrganicTweetStatistics;
import twitter4j.models.ads.TwitterPromotedTweetStatistics;
import twitter4j.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.*;

import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.TwitterAdsConstants.PARAM_PROMOTED_TWEET_IDS;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 11:35 AM
 */
public class TwitterAdsStatApiImpl implements TwitterAdsStatApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsStatApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TwitterPromotedTweetStatistics> fetchPromotedTweetStats(String accountId, Collection<String> promotedTweetIds,
                                                                                               long startTime, long endTime, String granularity,
                                                                                               String segmentationType) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(promotedTweetIds, "promotedTweetIds");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_PROMOTED_TWEETS;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }
        if (StringUtils.isNotBlank(segmentationType)) {
            params.add(new HttpParameter(PARAM_SEGMENTATION_TYPE, segmentationType));
        }

        Set<String> metrics = TwitterPromotedTweetStatistics.PROMOTED_TWEET_METRICS;
        String joinedMetrics = StringUtils.join(metrics, ",");
        params.add(new HttpParameter(PARAM_METRICS, joinedMetrics));

        params.add(new HttpParameter(PARAM_PROMOTED_TWEET_IDS, TwitterAdUtil.getCsv(promotedTweetIds)));
        Type type = new TypeToken<BaseAdsListResponse<TwitterPromotedTweetStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type, true);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdStatsDaily(String accountId, Collection<String> lineItemIds, long startTime,
                                                                              long endTime, boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(lineItemIds, "lineItemId");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LINE_ITEMS;

        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(GRANULARITY, Granularity.DAY.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));

        String lineItemIdsAsString = null;

        lineItemIdsAsString = TwitterAdUtil.getCsv(lineItemIds);
        params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, lineItemIdsAsString));

        Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);

    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchStatsTotal(String accountId, Collection<String> lineItemIds, long startTime,
                                                                            long endTime, String segmentationType, boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(lineItemIds, "lineItemId");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LINE_ITEMS;

        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(GRANULARITY, Granularity.TOTAL.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }
        if (StringUtils.isNotBlank(segmentationType)) {
            params.add(new HttpParameter(PARAM_SEGMENTATION_TYPE, segmentationType));
        }
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));

        String lineItemIdsAsString = null;

        lineItemIdsAsString = TwitterAdUtil.getCsv(lineItemIds);
        params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, lineItemIdsAsString));

        Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);

    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdSetStats(String accountId, Collection<String> campaignIds, long startTime,
                                                                            long endTime) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(campaignIds, "campaignIds");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_REACH_STATS;

        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(PARAM_CAMPAIGN_IDS, TwitterAdUtil.getCsv(campaignIds)));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchStats(String accountId, Collection<String> lineItemIds, long startTime, long endTime,
                                                                       String segmentationType, boolean withDeleted, Granularity granularity,
                                                                       String objective) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(lineItemIds, "lineItemId");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LINE_ITEMS;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }
        if (StringUtils.isNotBlank(segmentationType)) {
            params.add(new HttpParameter(PARAM_SEGMENTATION_TYPE, segmentationType));
        }

        String metrics = StringUtils.join(TwitterAdStatisticsMetrics.getMetrics(objective), ",");
        params.add(new HttpParameter(PARAM_METRICS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, TwitterAdUtil.getCsv(lineItemIds)));

        Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdStatsHourly(String accountId, Collection<String> lineItemIds, long startTime,
                                                                               long endTime, boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(lineItemIds, "lineItemId");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LINE_ITEMS;

        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(GRANULARITY, Granularity.HOUR.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, TwitterAdUtil.getCsv(lineItemIds)));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));

        Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdStats(String accountId, Collection<String> lineItemIds, long startTime,
                                                                         long endTime, boolean withDeleted, HttpParameter... extraParams)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(lineItemIds, "lineItemId");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LINE_ITEMS;

        List<HttpParameter> params = new ArrayList<>();

        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        String lineItemIdsAsString = TwitterAdUtil.getCsv(lineItemIds);

        params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, lineItemIdsAsString));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        Collections.addAll(params, extraParams);

        Type type = new TypeToken<BaseAdsListResponse<TwitterAdStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterOrganicTweetStatistics> fetchOrganicTweetsStats(String accountId, Collection<String> tweetIds,
                                                                                              long startTime, long endTime, String granularity)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(tweetIds, "tweetId");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + TwitterAdsConstants.PATH_ORGANIC_TWEETS_STATS;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_TWEET_IDS, TwitterAdUtil.getCsv(tweetIds)));
        params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));

        Type type = new TypeToken<BaseAdsListResponse<TwitterOrganicTweetStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type, true);
    }
}
