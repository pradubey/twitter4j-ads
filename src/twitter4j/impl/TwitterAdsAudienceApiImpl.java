package twitter4j.impl;

import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsAudienceApi;
import twitter4j.models.ads.*;
import twitter4j.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:54 AM
 */
public class TwitterAdsAudienceApiImpl implements TwitterAdsAudienceApi {

    private static final long SIXTY_FOUR_MB = 64 * 1024 * 1024;

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsAudienceApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, Integer count, Boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCES;
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNull(count) && count < 1000) {
            params.add(new HttpParameter("count", count));
        }
        if (TwitterAdUtil.isNotNull(withDeleted)) {
            params.add(new HttpParameter("with_deleted", withDeleted));
        }
        Type type = new TypeToken<BaseAdsListResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TailoredAudience> getAllTailoredAudiences(String accountId, int batchSize, String cursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCES;
        List<HttpParameter> params = new ArrayList<>();
        if (batchSize < 1000) {
            params.add(new HttpParameter(PARAM_COUNT, batchSize));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        Type type = new TypeToken<BaseAdsListResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    public BaseAdsResponse<TailoredAudience> getTailoredAudienceForId(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> deleteTailoredAudience(String accountId, String tailoredAudienceId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCE + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TailoredAudience> createTailoredAudience(String accountId, String name, TailoredAudienceDataType tailoredAudienceDataType)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "name");
        TwitterAdUtil.ensureNotNull(tailoredAudienceDataType, "tailoredAudienceDataType");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCE;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("name", name));
        params.add(new HttpParameter("list_type", tailoredAudienceDataType.name()));
        Type type = new TypeToken<BaseAdsResponse<TailoredAudience>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForTailoredAudienceById(String accountId, String tailoredAudienceId)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        String baseUrl =
                twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCE_CHANGES + tailoredAudienceId;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> editUsersInTailoredAudience(String accountId, String tailoredAudienceId, String bucketLocation,
                                                                                   TailoredAudienceOperation tailoredAudienceOperation)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(tailoredAudienceId, "tailoredAudienceId");
        TwitterAdUtil.ensureNotNull(bucketLocation, "bucketLocation");
        TwitterAdUtil.ensureNotNull(tailoredAudienceOperation, "tailoredAudienceOperation");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter("account_id", accountId));
        params.add(new HttpParameter("tailored_audience_id", tailoredAudienceId));
        params.add(new HttpParameter("input_file_path", bucketLocation));
        params.add(new HttpParameter("operation", tailoredAudienceOperation.name()));
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TailoredAudienceChangeInfo> getChangeRecordsForAllTailoredAudiences(String accountId, Integer count, String nextCursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNull(count) && count < 1000) {
            params.add(new HttpParameter("count", count));

        }
        if (TwitterAdUtil.isNotNull(nextCursor)) {
            params.add(new HttpParameter("cursor", nextCursor));

        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_TAILORED_AUDIENCE_CHANGES;
        Type type = new TypeToken<BaseAdsResponse<TailoredAudienceChangeInfo>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }
}
