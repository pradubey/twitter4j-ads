package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import twitter4j.*;
import twitter4j.api.TwitterAdsCardsApi;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.TwitterUUIDResponse;
import twitter4j.models.ads.cards.*;
import twitter4j.util.TwitterAdUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:10 PM
 */
public class TwitterAdsCardsApiImpl implements TwitterAdsCardsApi {

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsCardsApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterLeadGenerationCard> getAllLeadGenerationCards(String accountId, List<String> cardIds,
                                                                                            boolean withDeleted, Integer count)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LEAD_GENERATION_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterImageAppDownloadCard> getAllImageAppDownloadCards(String accountId, List<String> cardIds,
                                                                                                boolean withDeleted, Integer count)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterImageAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterVideoAppDownloadCard> getAllVideoAppDownloadCards(String accountId, List<String> cardIds,
                                                                                                boolean withDeleted, Integer count)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException {

        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<VideoObjectResponseData>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterWebsiteCard> getAllWebsiteCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                              Integer count) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_WEBSITE_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterWebsiteCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterMobileAppCard> getAllAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                    Integer count) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        if (TwitterAdUtil.isNotEmpty(cardIds)) {
            params.add(new HttpParameter(PARAM_CARD_IDS, TwitterAdUtil.getCsv(cardIds)));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationStat> getTwitterLeadGenerationStat(String accountId, String cardId, String startTime, String endTime,
                                                                                   String granularity, String metric, Boolean withDeleted)
            throws TwitterException {

        final List<HttpParameter> params =
                validateAndCreateParamsForLeadGenerationCardStat(accountId, cardId, startTime, endTime, granularity, metric, withDeleted);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_STATS_ACCOUNTS_URI + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type typeToken = new TypeToken<BaseAdsResponse<TwitterLeadGenerationStat>>() {
        }.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, typeToken, HttpVerb.GET);
    }

    @Override
    public String postVideoCardImage(String imageTonLocation) throws TwitterException {
        TwitterAdUtil.ensureNotNull(imageTonLocation, "imageTonLocation");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter("location", imageTonLocation));
        TwitterUUIDResponse twitterUUIDResponse = twitterAdsClient
                .executeRequest(UPLOAD_VIDEO_CARD_IMAGE_URL, params.toArray(new HttpParameter[params.size()]), TwitterUUIDResponse.class,
                        HttpVerb.POST);
        return twitterUUIDResponse.getuUID();
    }

    // --------------------------------------- Private Methods ---------------------------------------------

    private List<HttpParameter> getCardHttpParameters(String accountId, String name, String appCountryCode, String iphoneAppId, String ipadAppId,
                                                      String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink)
            throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(appCountryCode, "App Country Code");
        TwitterAdUtil.ensureNotNull(name, "Name");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_APP_COUNTRY_CODE, appCountryCode));

        // This is done in order to satisfy the condition: atleast one of the app ids is provided
        if (!(TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId) || TwitterAdUtil.isNotNullOrEmpty(ipadAppId) ||
                TwitterAdUtil.isNotNullOrEmpty(iphoneAppId))) {
            throw new TwitterException(
                    new UnsupportedOperationException("Please provide atleast one valid store app id to create an app download card"));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(iphoneAppId)) {
            params.add(new HttpParameter(PARAM_IPHONE_APP_ID, iphoneAppId));
            if (TwitterAdUtil.isNotNullOrEmpty(iphoneDeepLink)) {
                params.add(new HttpParameter(PARAM_IPHONE_DEEP_LINK, iphoneDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNullOrEmpty(ipadAppId)) {
            params.add(new HttpParameter(PARAM_IPAD_APP_ID, ipadAppId));
            if (TwitterAdUtil.isNotNullOrEmpty(ipadDeepLink)) {
                params.add(new HttpParameter(PARAM_IPAD_DEEP_LINK, ipadDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId)) {
            params.add(new HttpParameter(PARAM_GOOGLEPLAY_APP_ID, googlePlayAppId));
            if (TwitterAdUtil.isNotNullOrEmpty(googlePlayDeepLink)) {
                params.add(new HttpParameter(PARAM_GOOGLEPLAY_DEEP_LINK, googlePlayDeepLink));
            }
        }
        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForUpdateAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                                String customAppDescription, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParametersForUpdate(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                        googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_CUSTOM_ICON_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(customAppDescription)) {
            params.add(new HttpParameter(PARAM_CUSTOM_APP_DESCRIPTION, customAppDescription));
        }
        return params;
    }

    private List<HttpParameter> getCardHttpParametersForUpdate(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                               String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink,
                                                               String googlePlayDeepLink) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(appCountryCode, "App Country Code");
        TwitterAdUtil.ensureNotNull(name, "Name");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_APP_COUNTRY_CODE, appCountryCode));

        // This is done in order to satisfy the condition: atleast one of the app ids is provided
        if (!(TwitterAdUtil.isNotNullOrEmpty(googlePlayAppId) || TwitterAdUtil.isNotNullOrEmpty(ipadAppId) ||
                TwitterAdUtil.isNotNullOrEmpty(iphoneAppId))) {
            throw new TwitterException(
                    new UnsupportedOperationException("Please provide atleast one valid store app id to create an app download card"));
        }

        iphoneAppId = iphoneAppId == null ? "" : iphoneAppId;
        iphoneDeepLink = iphoneDeepLink == null ? "" : iphoneDeepLink;
        ipadAppId = ipadAppId == null ? "" : ipadAppId;
        ipadDeepLink = ipadDeepLink == null ? "" : ipadDeepLink;
        googlePlayAppId = googlePlayAppId == null ? "" : googlePlayAppId;
        googlePlayDeepLink = googlePlayDeepLink == null ? "" : googlePlayDeepLink;

        params.add(new HttpParameter(PARAM_IPHONE_APP_ID, iphoneAppId));
        params.add(new HttpParameter(PARAM_IPHONE_DEEP_LINK, iphoneDeepLink));
        params.add(new HttpParameter(PARAM_IPAD_APP_ID, ipadAppId));
        params.add(new HttpParameter(PARAM_IPAD_DEEP_LINK, ipadDeepLink));
        params.add(new HttpParameter(PARAM_GOOGLEPLAY_APP_ID, googlePlayAppId));
        params.add(new HttpParameter(PARAM_GOOGLEPLAY_DEEP_LINK, googlePlayDeepLink));

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForLeadGenerationCardStat(String accountId, String cardId, String startTime, String endTime,
                                                                                 String granularity, String metric, Boolean withDeleted) {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        TwitterAdUtil.ensureNotNull(startTime, "StartTime");

        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_START_TIME, startTime));

        if (TwitterAdUtil.isNotNull(endTime)) {
            params.add(new HttpParameter(PARAM_END_TIME, endTime));
        }
        if (TwitterAdUtil.isNotNull(granularity)) {
            params.add(new HttpParameter(PARAM_GRANULARITY, granularity));
        }
        if (TwitterAdUtil.isNotNull(metric)) {
            params.add(new HttpParameter(PARAM_METRICS, metric));
        }
        if (TwitterAdUtil.isNotNull(withDeleted)) {
            params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        }

        return params;
    }
}
