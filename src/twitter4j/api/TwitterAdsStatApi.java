package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.HttpParameter;
import twitter4j.TwitterException;
import twitter4j.models.Granularity;
import twitter4j.models.ads.TwitterAdStatistics;
import twitter4j.models.ads.TwitterOrganicTweetStatistics;
import twitter4j.models.ads.TwitterPromotedTweetStatistics;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 11:31 AM
 */
public interface TwitterAdsStatApi {

    BaseAdsListResponseIterable<TwitterOrganicTweetStatistics> fetchOrganicTweetsStats(String accountId, Collection<String> tweetIds, long startTime,
                                                                                       long endTime, String granularity) throws TwitterException;

    BaseAdsListResponseIterable<TwitterPromotedTweetStatistics> fetchPromotedTweetStats(String accountId, Collection<String> promotedTweetIds,
                                                                                        long startTime, long endTime, String granularity,
                                                                                        String segmentationType) throws TwitterException;
    BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdStatsDaily(String accountId, Collection<String> lineItemIds, long startTime, long endTime,
                                                                       boolean withDeleted) throws TwitterException;

    BaseAdsListResponseIterable<TwitterAdStatistics> fetchStats(String accountId, Collection<String> lineItemIds, long startTime, long endTime,
                                                                String segmentationType, boolean withDeleted, Granularity granularity,
                                                                String objective) throws TwitterException;

    BaseAdsListResponseIterable<TwitterAdStatistics> fetchStatsTotal(String accountId, Collection<String> lineItemIds, long startTime, long endTime,
                                                                     String segmentationType, boolean withDeleted) throws TwitterException;

    BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdSetStats(String accountId, Collection<String> campaignIds, long startTime, long endTime)
            throws TwitterException;

    BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdStatsHourly(String accountId, Collection<String> lineItemIds, long startTime,
                                                                        long endTime, boolean withDeleted) throws TwitterException;

    BaseAdsListResponseIterable<TwitterAdStatistics> fetchAdStats(String accountId, Collection<String> lineItemIds, long startTime, long endTime,
                                                                  boolean withDeleted, HttpParameter... extraParams) throws TwitterException;


}
