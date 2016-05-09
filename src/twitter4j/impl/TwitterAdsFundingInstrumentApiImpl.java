package twitter4j.impl;

import com.google.common.base.Optional;
import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsFundingInstrumentApi;
import twitter4j.models.ads.FundingInstrument;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.sort.FundingInstrumentSortByField;
import twitter4j.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:37 AM
 */
public class TwitterAdsFundingInstrumentApiImpl implements TwitterAdsFundingInstrumentApi {

    private static final Integer MAX_REQUEST_PARAMETER_SIZE = 50;

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsFundingInstrumentApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<FundingInstrument> getAllFundingInstruments(String accountId,boolean withDeleted, Optional<Collection<String>> fundingInstrumentIds,
                                                                                   Optional<FundingInstrumentSortByField> sortByField) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        String fundingInstrumentIdsAsString = null;
        if (fundingInstrumentIds != null && fundingInstrumentIds.isPresent()) {
            TwitterAdUtil.ensureMaxSize(fundingInstrumentIds.get(), MAX_REQUEST_PARAMETER_SIZE);
            fundingInstrumentIdsAsString = TwitterAdUtil.getCsv(fundingInstrumentIds.get());
        }
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotNullOrEmpty(fundingInstrumentIdsAsString)) {
            params.add(new HttpParameter(PARAM_FUNDING_INSTRUMENT_IDS, fundingInstrumentIdsAsString));
        }
        if(sortByField != null && sortByField.isPresent()) {
            params.add(new HttpParameter(PARAM_SORT_BY, sortByField.get().getField()));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_FUNDING_INSTRUMENTS;
        Type type = new TypeToken<BaseAdsListResponse<FundingInstrument>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<FundingInstrument> getFundingInstrumentById(String accountId, String fundingInstrumentId, boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(fundingInstrumentId, "fundingInstrumentId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_FUNDING_INSTRUMENTS + fundingInstrumentId;
        HttpParameter[] param  = new HttpParameter[]{new HttpParameter(PARAM_WITH_DELETED, withDeleted)};
        Type type = new TypeToken<BaseAdsResponse<FundingInstrument>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, param, type, HttpVerb.GET);
    }
}
