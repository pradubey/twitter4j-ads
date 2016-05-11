package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.Granularity;
import twitter4j.models.TwitterSegmentationType;
import twitter4j.models.ads.*;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 11:31 AM
 */
public interface TwitterAdsStatApi {

    BaseAdsListResponseIterable<TwitterEntityStatistics> fetchStatsSync(String accountId, TwitterEntityType twitterEntity, Collection<String> ids,
                                                                        long startTime, long endTime, boolean withDeleted, Granularity granularity,
                                                                        TwitterAdObjective objective, Placement placement) throws TwitterException;

    BaseAdsResponse<JobDetails> createAsyncJob(String accountId, TwitterEntityType twitterEntityType, Collection<String> ids, long startTime,
                                               long endTime, boolean withDeleted, Granularity granularity, TwitterAdObjective twitterAdObjective,
                                               Placement placement, Optional<TwitterSegmentationType> twitterSegmentationType) throws TwitterException;

    BaseAdsListResponseIterable<JobDetails> getJobExecutionDetails(String accountId, Collection<String> jobIds) throws TwitterException;

    BaseAdsListResponse<TwitterEntityStatistics> fetchJobDataAsync(String dataUrl) throws TwitterException;
}