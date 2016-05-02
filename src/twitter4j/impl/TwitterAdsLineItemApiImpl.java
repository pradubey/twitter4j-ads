package twitter4j.impl;

import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import twitter4j.*;
import twitter4j.api.TwitterAdsLineItemApi;
import twitter4j.models.ads.*;
import twitter4j.models.ads.sort.LineItemsSortByField;
import twitter4j.models.ads.sort.PromotedAccountsSortByField;
import twitter4j.models.video.AssociateMediaCreativeResponse;
import twitter4j.models.video.PreRollCallToActionResponse;
import twitter4j.models.video.TwitterCallToActionType;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:01 PM
 */
public class TwitterAdsLineItemApiImpl implements TwitterAdsLineItemApi {

    private static final Integer MAX_REQUEST_PARAMETER_SIZE = 50;

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsLineItemApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsResponse<LineItem> createLineItem(LineItem lineItem) throws TwitterException {
        String accountId = lineItem.getAccountId();
        String campaignId = lineItem.getCampaignId();
        boolean automaticallySelectBid = lineItem.isAutomaticallySelectBid();
        Long bidAmountLocalMicro = null;
        BidType bidType;
        if (!automaticallySelectBid) {
            bidAmountLocalMicro = lineItem.getBidAmtInMicro();
            bidType = lineItem.getBidType();
        } else {
            bidType = BidType.AUTO;
        }

        Boolean paused = lineItem.getPaused();
        Sentiments includeSentiment = lineItem.getSentiment();
        Boolean matchRelevantPopularQueries = lineItem.getMatchRelevantPopularQueries();
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params =
                validateCreateLineItemParameters(campaignId, bidType, bidAmountLocalMicro, automaticallySelectBid, lineItem.getProductType(),
                        lineItem.getPlacements(), paused, includeSentiment, matchRelevantPopularQueries,
                        lineItem.getObjective(), lineItem.getChargeBy(), lineItem.getBidUnit(),
                        lineItem.getAdvertiserDomain(), lineItem.getCategories(), lineItem.getWebEventTag());
        HttpParameter[] parameters = null;
        if (!params.isEmpty()) {
            parameters = params.toArray(new HttpParameter[params.size()]);
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LINE_ITEMS;
        HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, parameters);
        try {
            Type type = new TypeToken<BaseAdsResponse<LineItem>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse line item.");
        }
    }

    @Override
    public BaseAdsResponse<LineItem> updateLineItem(String accountId, String lineItemId, BidType bidType, boolean automaticallySelectBid,
                                                    Long bidAmountLocalMicro, Boolean paused, Sentiments includeSentiment,
                                                    Boolean matchRelevantPopularQueries, String chargeBy, String bidUnit, String advertiserDomain,
                                                    String[] iabCategories) throws TwitterException {
        if (automaticallySelectBid) {
            bidAmountLocalMicro = null;
            bidType = BidType.AUTO;
        }

        List<HttpParameter> params =
                validateUpdateLineItemParameters(accountId, lineItemId, bidType, automaticallySelectBid, bidAmountLocalMicro, paused,
                        includeSentiment, matchRelevantPopularQueries, chargeBy, bidUnit, advertiserDomain, iabCategories);
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LINE_ITEMS +
                lineItemId;
        Type type = new TypeToken<BaseAdsResponse<LineItem>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.PUT);

    }

    @Override
    public BaseAdsResponse<LineItem> deleteLineItem(String accountId, String lineItemId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "LineItem Id");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LINE_ITEMS + lineItemId;
        Type type = new TypeToken<BaseAdsResponse<LineItem>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsListResponseIterable<LineItem> getAllLineItems(String accountId, Collection<String> campaignIds, Collection<String> lineItemIds,
                                                                 Collection<String> fundingInstrumentIds, Integer count, boolean withDeleted,
                                                                 String cursor, LineItemsSortByField sortByField) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        String campaignIdsAsString = null;
        String lineItemIdsAsString = null;
        String fundingInstrumentIdsAsString = null;
        if (TwitterAdUtil.isNotNull(campaignIds)) {
            TwitterAdUtil.ensureMaxSize(campaignIds, MAX_REQUEST_PARAMETER_SIZE);
            campaignIdsAsString = TwitterAdUtil.getCsv(campaignIds);
        }
        if (TwitterAdUtil.isNotNull(lineItemIds)) {
            TwitterAdUtil.ensureMaxSize(lineItemIds, MAX_REQUEST_PARAMETER_SIZE);
            lineItemIdsAsString = TwitterAdUtil.getCsv(lineItemIds);
        }
        if (TwitterAdUtil.isNotNull(fundingInstrumentIds)) {
            TwitterAdUtil.ensureMaxSize(fundingInstrumentIds, MAX_REQUEST_PARAMETER_SIZE);
            fundingInstrumentIdsAsString = TwitterAdUtil.getCsv(fundingInstrumentIds);
        }
        List<HttpParameter> params =
                validateLineItemParameters(accountId, campaignIdsAsString, lineItemIdsAsString, fundingInstrumentIdsAsString, count, withDeleted,
                        cursor);
        if(sortByField != null) {
            params.add(new HttpParameter(PARAM_SORT_BY, sortByField.getField()));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LINE_ITEMS;
        Type type = new TypeToken<BaseAdsListResponse<LineItem>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<LineItem> getLineItemById(String accountId, String lineItemId, boolean withDeleted) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        TwitterAdUtil.ensureNotNull(lineItemId, "lineItemId");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LINE_ITEMS + lineItemId;
        HttpParameter[] params = null;
        params = new HttpParameter[]{new HttpParameter(PARAM_WITH_DELETED, withDeleted)};
        Type type = new TypeToken<BaseAdsResponse<LineItem>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<PromotedAccount> createPromotedAccounts(String accountId, String lineItemId, String userId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(userId, "User Id");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_USER_ID, userId));
        HttpResponse httpResponse;
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_PROMOTED_ACCOUNTS;
        httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<PromotedAccount>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse promoted accounts.");
        }
    }

    @Override
    public BaseAdsListResponseIterable<PromotedAccount> getPromotedAccounts(String accountId, Collection<String> promotedAccountIds,
                                                                            String lineItemId, boolean withDeleted,
                                                                            PromotedAccountsSortByField sortByField) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        String promotedAccountsIdsAsString = null;
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotNull(promotedAccountIds)) {
            TwitterAdUtil.ensureMaxSize(promotedAccountIds, MAX_REQUEST_PARAMETER_SIZE);
            promotedAccountsIdsAsString = TwitterAdUtil.getCsv(promotedAccountIds);
        }
        if (TwitterAdUtil.isNotNullOrEmpty(lineItemId)) {
            params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(promotedAccountsIdsAsString)) {
            params.add(new HttpParameter(PARAM_PROMOTED_ACCOUNTS_IDS, promotedAccountsIdsAsString));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_PROMOTED_ACCOUNTS;
        Type type = new TypeToken<BaseAdsListResponse<PromotedAccount>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<PreRollCallToActionResponse> createCallToActionDetailsForPreRollViews(String accountId, String lineItemId,
                                                                                                 TwitterCallToActionType twitterCallToActionType,
                                                                                                 String callToActionUrl) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(callToActionUrl, "Call To Action Url");
        TwitterAdUtil.ensureNotNull(twitterCallToActionType, "Call To Action Type");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_CALL_TO_ACTION, twitterCallToActionType.name()));
        params.add(new HttpParameter(PARAM_CALL_TO_ACTION_URL, callToActionUrl));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PRE_ROLL_CALL_TO_ACTION;
        HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<PreRollCallToActionResponse>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse call to action response.");
        }
    }

    //landing url is the url of the media creative
    @Override
    public BaseAdsResponse<AssociateMediaCreativeResponse> associateMediaCreativeWithAccount(String accountId, String lineItemId,
                                                                                             String accountMediaId, String landingUrl)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(accountMediaId, "Account Media Id");
        TwitterAdUtil.ensureNotNull(landingUrl, " Landing Url");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_ACCOUNT_ID, accountId));
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_ACCOUNT_MEDIA_ID, accountMediaId));
        params.add(new HttpParameter(PARAM_LANDING_URL, landingUrl));

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_MEDIA_CREATIVES;
        HttpResponse httpResponse = twitterAdsClient.postRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsResponse<AssociateMediaCreativeResponse>>() {
            }.getType();
            return TwitterAdUtil.constructBaseAdsResponse(httpResponse, httpResponse.asString(), type);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response for associate media to account", e);
        }
    }

    // -------------------------------------- Private Methods ------------------------------------------

    private List<HttpParameter> validateCreateLineItemParameters(String campaignId, BidType bidType, Long bidAmountLocalMicro,
                                                                 boolean automaticallySelectBid, ProductType productType, List<Placement> placements,
                                                                 Boolean paused, Sentiments includeSentiment, Boolean matchRelevantPopularQueries,
                                                                 String objective, String chargeBy, String bidUnit, String advertiserDomain,
                                                                 String[] categories, String webEventTag) {
        if (bidType == BidType.TARGET || bidType == BidType.MAX) {
            TwitterAdUtil.ensureNotNull(bidAmountLocalMicro, "Bid amount cannot be null for TARGET or MAX Bid Type");
        }

        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(campaignId)) {
            params.add(new HttpParameter(PARAM_CAMPAIGN_ID, campaignId));
        }
        if (automaticallySelectBid) {
            params.add(new HttpParameter(AUTOMATICALLY_SELECT_BID, true));
        } else if (TwitterAdUtil.isNotNull(bidAmountLocalMicro)) {
            params.add(new HttpParameter(PARAM_BID_AMOUNT_LOCAL_MICRO, bidAmountLocalMicro));
            if (bidType != null) {
                params.add(new HttpParameter(PARAM_BID_TYPE, bidType.name()));
            }
        }

        if (TwitterAdUtil.isNotNullOrEmpty(chargeBy)) {
            params.add(new HttpParameter(PARAM_CHARGE_BY, chargeBy));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(bidUnit)) {
            params.add(new HttpParameter(PARAM_BID_UNIT, bidUnit));
        }

        if (StringUtils.isNotEmpty(webEventTag)) {
            params.add(new HttpParameter(PARAM_PRIMARY_WEB_EVENT_TAG, webEventTag));
        }

        if (TwitterAdUtil.isNotNull(paused)) {
            params.add(new HttpParameter(PARAM_PAUSED, paused));
        }
        if (TwitterAdUtil.isNotNull(includeSentiment)) {
            params.add(new HttpParameter(PARAM_INCLUDE_SENTIMENT, includeSentiment.name()));
        }
        if (TwitterAdUtil.isNotNull(matchRelevantPopularQueries)) {
            params.add(new HttpParameter(PARAM_MATCH_RELEVANT_POPULAR_QUERIES, matchRelevantPopularQueries));
        }
        if (TwitterAdUtil.isNotNull(objective)) {
            params.add(new HttpParameter(PARAM_OBJECTIVE, objective));

            // Twitter Audience Platform is supported for these objectives only
            if (TwitterAdUtil.TWEET_ENGAGEMENTS.equals(objective) || TwitterAdUtil.VIDEO_VIEWS.equals(objective) ||
                    TwitterAdUtil.WEBSITE_CLICKS.equals(objective)) {
                if (TwitterAdUtil.isNotNullOrEmpty(advertiserDomain)) {
                    params.add(new HttpParameter(PARAM_ADVERTISER_DOMAIN, advertiserDomain));
                }
                if (categories != null && TwitterAdUtil.isNotEmpty(Arrays.asList(categories))) {
                    params.add(new HttpParameter(PARAM_CATEGORIES, TwitterAdUtil.getCsv(Arrays.asList(categories))));
                }
            }
        }

        if (TwitterAdUtil.isNotNull(productType)) {
            params.add(new HttpParameter(PARAM_PRODUCT_TYPE, productType.name()));
        }

        if (TwitterAdUtil.isNotEmpty(placements)) {
            params.add(new HttpParameter(PARAM_PLACEMENTS, TwitterAdUtil.getCsv(placements)));
        }

        return params;
    }

    private List<HttpParameter> validateUpdateLineItemParameters(String accountId, String lineItemId, BidType bidType, boolean automaticallySelectBid,
                                                                 Long bidAmountLocalMicro, Boolean paused, Sentiments includeSentiment,
                                                                 Boolean matchRelevantPopularQueries, String chargeBy, String bidUnit,
                                                                 String advertiserDomain, String[] iabCategories) {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");

        if (bidType == BidType.TARGET || bidType == BidType.MAX) {
            TwitterAdUtil.ensureNotNull(bidAmountLocalMicro, "Bid amount cannot be null for TARGET or MAX Bid Type");
        }

        List<HttpParameter> params = new ArrayList<>();
        if (automaticallySelectBid) {
            params.add(new HttpParameter(AUTOMATICALLY_SELECT_BID, true));
            params.add(new HttpParameter(PARAM_BID_AMOUNT_LOCAL_MICRO, ""));
        } else if (TwitterAdUtil.isNotNull(bidAmountLocalMicro)) {
            if (bidType != BidType.TARGET) {
                params.add(new HttpParameter(AUTOMATICALLY_SELECT_BID, false));
            }
            params.add(new HttpParameter(PARAM_BID_AMOUNT_LOCAL_MICRO, bidAmountLocalMicro));
        }
        if (!automaticallySelectBid && bidType != null) {
            params.add(new HttpParameter(PARAM_BID_TYPE, bidType.name()));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(chargeBy)) {
            params.add(new HttpParameter(PARAM_CHARGE_BY, chargeBy));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(bidUnit)) {
            params.add(new HttpParameter(PARAM_BID_UNIT, bidUnit));
        }

        if (TwitterAdUtil.isNotNull(paused)) {
            params.add(new HttpParameter(PARAM_PAUSED, paused));
        }
        if (TwitterAdUtil.isNotNull(includeSentiment)) {
            params.add(new HttpParameter(PARAM_INCLUDE_SENTIMENT, includeSentiment.name()));
        }
        if (TwitterAdUtil.isNotNull(matchRelevantPopularQueries)) {
            params.add(new HttpParameter(PARAM_MATCH_RELEVANT_POPULAR_QUERIES, matchRelevantPopularQueries));
        }

        // Twitter Audience Platform is supported for these objectives only

        if (TwitterAdUtil.isNotNullOrEmpty(advertiserDomain)) {
            params.add(new HttpParameter(PARAM_ADVERTISER_DOMAIN, advertiserDomain));
        }
        if (iabCategories != null && TwitterAdUtil.isNotEmpty(Arrays.asList(iabCategories))) {
            params.add(new HttpParameter(PARAM_CATEGORIES, TwitterAdUtil.getCsv(Arrays.asList(iabCategories))));
        }
        return params;
    }

    private List<HttpParameter> validateLineItemParameters(String accountId, String campaignIds, String lineItemIds, String fundingInstrumentIds,
                                                           Integer count, boolean withDeleted, String cursor) {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();
        if (StringUtils.isNotBlank(campaignIds)) {
            params.add(new HttpParameter(PARAM_CAMPAIGN_IDS, campaignIds));
        }
        if (StringUtils.isNotBlank(lineItemIds)) {
            params.add(new HttpParameter(PARAM_LINE_ITEM_IDS, lineItemIds));
        }
        if (StringUtils.isNotBlank(fundingInstrumentIds)) {
            params.add(new HttpParameter(PARAM_FUNDING_INSTRUMENT_IDS, fundingInstrumentIds));
        }
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        if (StringUtils.isNotBlank(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        return params;
    }
}
