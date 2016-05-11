package twitter4j.api;

import com.google.common.base.Optional;
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

    BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Optional<Integer> count,
                                                                          Optional<Boolean> withDeleted, Optional<String> cursor)
            throws TwitterException;

    BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException;

    BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException;

    BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name, TailoredAudienceDataType tailoredAudienceDataType)
            throws TwitterException;

    BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForTailoredAudienceById(String accountId, String tailoredAudienceId)
            throws TwitterException;

    BaseAdsResponse<TailoredAudienceChangeInfo> editUsersInTailoredAudience(String accountId, String tailoredAudienceId, String bucketLocation,
                                                                            TailoredAudienceOperation tailoredAudienceOperation)
            throws TwitterException;

    BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForAllTailoredAudiences(String accountId, Optional<Integer> count, Optional<String> nextCursor)
            throws TwitterException;

}

