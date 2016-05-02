package twitter4j.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4j.*;
import twitter4j.api.TwitterAdsStatApi;
import twitter4j.models.Granularity;
import twitter4j.models.TwitterSegmentationType;
import twitter4j.models.ads.*;
import twitter4j.util.TwitterAdUtil;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.zip.GZIPInputStream;

import static twitter4j.TwitterAdsConstants.*;
import static twitter4j.TwitterAdsConstants.V1_PREFIX_STATS_JOB_ACCOUNTS_URI;

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

    public BaseAdsListResponseIterable<TwitterEntityStatistics> fetchStatsSync(String accountId, TwitterEntityType twitterEntity,
                                                                               Collection<String> entityIds, long startTime, long endTime,
                                                                               boolean withDeleted, Granularity granularity,
                                                                               TwitterAdObjective objective, Placement placement)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(entityIds, "entityIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + V1_PREFIX_STATS_ACCOUNTS_URI + accountId;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_ENTITY_TYPE, twitterEntity.name()));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        String metrics = StringUtils.join(TwitterAdStatisticsMetrics.getMetricGroups(objective), ",");
        params.add(new HttpParameter(PARAM_METRICS_GROUPS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_ENTITY_IDS, TwitterAdUtil.getCsv(entityIds)));
        params.add(new HttpParameter(PARAMS_PLACEMENT, placement.name()));

        Type type = new TypeToken<BaseAdsListResponse<TwitterEntityStatistics>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<JobDetails> createAsyncJob(String accountId, TwitterEntityType twitterEntityType, Collection<String> ids, long startTime,
                                                      long endTime, boolean withDeleted, Granularity granularity,
                                                      TwitterAdObjective twitterAdObjective, Placement placement,
                                                      TwitterSegmentationType twitterSegmentationType) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(startTime, "startTime");
        TwitterAdUtil.ensureNotNull(ids, "entityIds");
        TwitterAdUtil.ensureNotNull(placement, "placement");

        String startTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(startTime);
        String endTimeAsString = TwitterAdUtil.convertTimeToZuluFormatAndToUTC(endTime);

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + V1_PREFIX_STATS_JOB_ACCOUNTS_URI + accountId;

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(GRANULARITY, granularity.toString()));
        params.add(new HttpParameter(PARAM_START_TIME, startTimeAsString));
        params.add(new HttpParameter(PARAM_ENTITY_TYPE, twitterEntityType.name()));

        if (TwitterAdUtil.isNotNullOrEmpty(endTimeAsString)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTimeAsString));
        }

        if (TwitterAdUtil.isNotNull(twitterSegmentationType)) {
            params.add(new HttpParameter(PARAM_SEGMENTATION_TYPE, twitterSegmentationType.name()));
        }

        String metrics = StringUtils.join(TwitterAdStatisticsMetrics.getMetricGroups(twitterAdObjective), ",");
        params.add(new HttpParameter(PARAM_METRICS_GROUPS, metrics));
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        params.add(new HttpParameter(PARAM_ENTITY_IDS, TwitterAdUtil.getCsv(ids)));
        params.add(new HttpParameter(PARAMS_PLACEMENT, placement.name()));

        Type type = new TypeToken<BaseAdsResponse<JobDetails>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsListResponseIterable<JobDetails> getJobExecutionDetails(String accountId, Collection<String> jobIds) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_JOB_IDS, TwitterAdUtil.getCsv(jobIds)));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + V1_PREFIX_STATS_JOB_ACCOUNTS_URI + accountId;

        Type type = new TypeToken<BaseAdsListResponse<JobDetails>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponse<TwitterEntityStatistics> fetchJobDataAsync(String dataUrl) throws TwitterException {
        // TODO: Use executeHttpListRequest once the bug from twitter is resolved (encoding in headers)
        String responseAsString = getResponseFromGZipStream(dataUrl);
        Type type = new TypeToken<BaseAdsListResponse<TwitterEntityStatistics>>() {}.getType();
        return new Gson().fromJson(responseAsString, type);
    }

    // ----------------------------------------- Private Methods -------------------------------------------------

    private String getResponseFromGZipStream(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Accept-Encoding", "gzip");
            Reader reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()));

            String response = "";
            while (true) {
                int ch = reader.read();
                if (ch == -1) {
                    break;
                }
                response = response + (char) ch;
            }
            return response;
        } catch (Exception e) {
            // Throw Execption
        }
        return null;
    }
}
