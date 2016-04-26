package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.TailoredAudience;
import twitter4j.models.ads.TailoredAudienceChangeInfo;
import twitter4j.models.ads.TailoredAudienceDataType;
import twitter4j.models.ads.TailoredAudienceOperation;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public interface TwitterAdsAudienceApi {

    /**
     * @return all possible custom audience targets to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Integer count, Boolean withDeleted)
            throws TwitterException;

    BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, int batchSize, String cursor) throws TwitterException;

    BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException;

    BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException;

    BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name, TailoredAudienceDataType tailoredAudienceDataType)
            throws TwitterException;

    BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForTailoredAudienceById(String accountId, String tailoredAudienceId)
            throws TwitterException;

    BaseAdsResponse<TailoredAudienceChangeInfo> editUsersInTailoredAudience(String accountId, String tailoredAudienceId, String bucketLocation,
                                                                            TailoredAudienceOperation tailoredAudienceOperation)
            throws TwitterException;

    BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForAllTailoredAudiences(String accountId, Integer count, String nextCursor)
            throws TwitterException;

}

