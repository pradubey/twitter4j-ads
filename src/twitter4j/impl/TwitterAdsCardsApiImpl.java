package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.collections.MapUtils;
import twitter4j.*;
import twitter4j.api.TwitterAdsCardsApi;
import twitter4j.internal.http.HttpParameter;
import twitter4j.models.ads.HttpVerb;
import twitter4j.models.ads.cards.*;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public BaseAdsResponse<TwitterLeadGenerationCard> createLeadGenerationCard(String accountId, String name, String title, String cta,
                                                                               String fallbackUrl, String privacyPolicyUrl, String imageUrl,
                                                                               String imageData, String submitMethod, String submitUrl,
                                                                               String customKeyScreenName, String customKeyName,
                                                                               String customKeyEmail, Map<String, String> customParamKeys)
            throws TwitterException {
        String mediaId = uploadImageForCards(imageUrl, imageData);

        final List<HttpParameter> params =
                validateAndCreateParamsForCreateLeadGenerationCard(accountId, name, title, cta, fallbackUrl, privacyPolicyUrl, submitMethod,
                                                                   submitUrl, customKeyScreenName, customKeyName, customKeyEmail, customParamKeys,
                                                                   mediaId);

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_LEAD_GENERATION_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> updateLeadGenerationCard(String accountId, String cardId, String name, String title, String cta,
                                                                               String fallbackUrl, String privacyPolicyUrl, String imageUrl,
                                                                               String imageData, String submitMethod, String submitUrl,
                                                                               String customKeyScreenName, String customKeyName,
                                                                               String customKeyEmail, Map<String, String> customParamKeys)
            throws TwitterException {
        String mediaId = uploadImageForCards(imageUrl, imageData);

        final List<HttpParameter> params =
                validateAndCreateParamsForCreateLeadGenerationCard(accountId, name, title, cta, fallbackUrl, privacyPolicyUrl, submitMethod,
                                                                   submitUrl, customKeyScreenName, customKeyName, customKeyEmail, customParamKeys,
                                                                   mediaId);

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {}.getType();
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_LEAD_GENERATION_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterLeadGenerationCard>>() {}.getType();
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterImageAppDownloadCard>>() {}.getType();
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterVideoAppDownloadCard>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_LEAD_GENERATION_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterLeadGenerationCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException {

        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_WEBSITE_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<VideoObjectResponseData>>() {}.getType();
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

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_WEBSITE_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterWebsiteCard>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> updateWebsiteCard(String accountId, String name, String cardId, String websiteTitle, String websiteUrl,
                                                                 String channelImage, String channelImageData) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        String mediaId = uploadImageForCards(channelImage, channelImageData);

        List<HttpParameter> params = validateAndCreateParamsForCreateWebsiteCard(accountId, name, websiteTitle, websiteUrl, mediaId);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_WEBSITE_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterWebsiteCard> createWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl,
                                                                 String channelImage, String nonTwitterImageUrl) throws TwitterException {
        String mediaId = uploadImageForCards(channelImage, nonTwitterImageUrl);

        final List<HttpParameter> params = validateAndCreateParamsForCreateWebsiteCard(accountId, name, websiteTitle, websiteUrl, mediaId);

        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_WEBSITE_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterWebsiteCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
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
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_APP_DOWNLOAD_CARDS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterMobileAppCard>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(url, params, type);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(cardId, "CardId");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> createAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                       String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                       String ipadDeepLink, String googlePlayDeepLink, String customIcon,
                                                                       String nonTwitterImageUrl, String customAppDescription, String callToAction)
            throws TwitterException {

        String mediaId = uploadImageForCards(customIcon, nonTwitterImageUrl);
        List<HttpParameter> params =
                validateAndCreateParamsForCreateAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                                                                iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, customAppDescription, mediaId,
                                                                callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_APP_DOWNLOAD_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);

    }


    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> createVideoAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                   String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                   String iphoneDeepLink, String ipadDeepLink,
                                                                                   String googlePlayDeepLink, String videoUrl, String imageUrl,
                                                                                   String callToAction)
            throws TwitterException, IOException, InterruptedException {
        String imageMediaId = uploadImageForCards(null, imageUrl);

        VideoObjectResponseData videoObjectResponseData = twitterAdsClient.uploadAndCreateVideoObject(videoUrl, accountId);
        String videoMediaId = videoObjectResponseData.getId();

        List<HttpParameter> params =
                validateAndCreateParamsForCreateVideoAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                                                                     iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, imageMediaId, videoMediaId,
                                                                     callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {}.getType();


        BaseAdsResponse<TwitterVideoAppDownloadCard> twitterVideoAppDownloadResponse =
                twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);
        TwitterVideoAppDownloadCard videoAppDownloadCard = twitterVideoAppDownloadResponse.getData();
        if (videoObjectResponseData.getId() != null) {
            videoAppDownloadCard.setChannelVideoId(videoObjectResponseData.getId());
        }
        if (videoObjectResponseData.getPreviewUrl() != null) {
            videoAppDownloadCard.setChannelVideoUrl(videoObjectResponseData.getPreviewUrl());
        }
        if (videoObjectResponseData.getDuration() != null) {
            videoAppDownloadCard.setChannelVideoLength(videoObjectResponseData.getDuration());
        }
        videoAppDownloadCard.setChannelImageId(imageMediaId);

        return twitterVideoAppDownloadResponse;
    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> updateVideoAppDownloadCard(String accountId, String name, String cardId,
                                                                                   String appCountryCode, String iphoneAppId, String ipadAppId,
                                                                                   String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink,
                                                                                   String googlePlayDeepLink, String updatedImageUrl,
                                                                                   String updatedVideoUrl, String originalImageId,
                                                                                   String originalVideoId, String callToActionValue)
            throws TwitterException, IOException, InterruptedException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");

        String imageMediaId;
        String videoMediaId;
        VideoObjectResponseData videoObjectResponseData;

        if (updatedImageUrl != null) {
            imageMediaId = uploadImageForCards(null, updatedImageUrl);
        } else {
            imageMediaId = originalImageId;
        }

        if (updatedVideoUrl != null) {
            videoObjectResponseData = twitterAdsClient.uploadAndCreateVideoObject(updatedVideoUrl, accountId);
            videoMediaId = videoObjectResponseData.getId();
        } else {
            videoObjectResponseData = twitterAdsClient.waitForVideoProcessing(accountId, originalVideoId, TimeUnit.MINUTES.toMillis(2));
            videoMediaId = originalVideoId;
        }

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateVideoAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                                                                     iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, imageMediaId, videoMediaId,
                                                                     callToActionValue);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {}.getType();
        BaseAdsResponse<TwitterVideoAppDownloadCard> twitterVideoAppDownloadResponse =
                twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);

        TwitterVideoAppDownloadCard videoAppDownloadCard = twitterVideoAppDownloadResponse.getData();
        if (videoObjectResponseData != null) {
            if (videoObjectResponseData.getId() != null) {
                videoAppDownloadCard.setChannelVideoId(videoObjectResponseData.getId());
            }
            if (videoObjectResponseData.getPreviewUrl() != null) {
                videoAppDownloadCard.setChannelVideoUrl(videoObjectResponseData.getPreviewUrl());
            }
            if (videoObjectResponseData.getDuration() != null) {
                videoAppDownloadCard.setChannelVideoLength(videoObjectResponseData.getDuration());
            }
        }
        videoAppDownloadCard.setChannelImageId(imageMediaId);

        return twitterVideoAppDownloadResponse;

    }

    @Override
    public BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_VIDEO_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterVideoAppDownloadCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> createImageAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                   String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                   String iphoneDeepLink, String ipadDeepLink,
                                                                                   String googlePlayDeepLink, String wideAppImage,
                                                                                   String wideAppImageData, String callToAction)
            throws TwitterException {
        String mediaId = uploadImageForCards(wideAppImage, wideAppImageData);

        List<HttpParameter> params =
                validateAndCreateParamsForCreateImageAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                                                                     iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, mediaId, callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.POST);

    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> updateImageAppDownloadCard(String accountId, String name, String cardId,
                                                                                   String appCountryCode, String iphoneAppId, String ipadAppId,
                                                                                   String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink,
                                                                                   String googlePlayDeepLink, String wideAppImage,
                                                                                   String wideAppImageData, String callToAction)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        String mediaId = uploadImageForCards(wideAppImage, wideAppImageData);

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateImageAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                                                                     iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, mediaId, callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> updateAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                       String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                       String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                       String customIcon, String customIconData, String customAppDescription,
                                                                       String callToAction) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        String mediaId = uploadImageForCards(customIcon, customIconData);

        List<HttpParameter> params =
                validateAndCreateParamsForUpdateAppDownloadCard(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId,
                                                                iphoneDeepLink, ipadDeepLink, googlePlayDeepLink, customAppDescription, mediaId,
                                                                callToAction);
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        HttpParameter[] parameters = params.toArray(new HttpParameter[params.size()]);
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, type, HttpVerb.PUT);
    }

    @Override
    public BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterMobileAppCard>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(cardId, "Card Id");
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_URI_0 + accountId + PATH_IMAGE_APP_DOWNLOAD_CARDS + cardId;
        Type type = new TypeToken<BaseAdsResponse<TwitterImageAppDownloadCard>>() {}.getType();
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
        Type typeToken = new TypeToken<BaseAdsResponse<TwitterLeadGenerationStat>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, parameters, typeToken, HttpVerb.GET);
    }

    @Override
    public String createVideoCard(String videoId, String posterImageId, String tweetText, Boolean nullCast) throws TwitterException {
        TwitterAdUtil.ensureNotNull(videoId, "videoId");
        TwitterAdUtil.ensureNotNull(posterImageId, "posterImageId");
        TwitterAdUtil.ensureNotNull(tweetText, "tweetText");
        List<HttpParameter> params = Lists.newArrayList();
        params.add(new HttpParameter("video_id", videoId));
        params.add(new HttpParameter("tweet_text", tweetText));
        params.add(new HttpParameter("poster_image_id", posterImageId));
        params.add(new HttpParameter("title", "Sprinklr ti"));
        params.add(new HttpParameter("description", "Sprinklr Des"));
        if (nullCast != null && nullCast) {
            params.add(new HttpParameter("nullcast", "true"));
        }
        twitterAdsClient.executeHttpRequest(VIDEO_CARD_URL, params.toArray(new HttpParameter[params.size()]), null, HttpVerb.POST);
        return null;
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

    private List<HttpParameter> validateAndCreateParamsForCreateLeadGenerationCard(String accountId, String name, String title, String cta,
                                                                                   String fallbackUrl, String privacyPolicyUrl, String submitMethod,
                                                                                   String submitUrl, String customKeyScreenName, String customKeyName,
                                                                                   String customKeyEmail, Map<String, String> customParamKeys,
                                                                                   String mediaId) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "Name");
        TwitterAdUtil.ensureNotNull(title, "Title");
        TwitterAdUtil.ensureNotNull(cta, "Cta");
        TwitterAdUtil.ensureNotNull(fallbackUrl, "Fallback Url");
        TwitterAdUtil.ensureNotNull(privacyPolicyUrl, "Privacy Policy Url");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_TITLE, title));
        params.add(new HttpParameter(PARAM_CTA, cta));
        params.add(new HttpParameter(PARAM_FALLBACK_URL, fallbackUrl));
        params.add(new HttpParameter(PARAM_PRIVACY_POLICY_URL, privacyPolicyUrl));

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(submitMethod)) {
            params.add(new HttpParameter(PARAM_SUBMIT_METHOD, submitMethod));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(submitUrl)) {
            params.add(new HttpParameter(PARAM_SUBMIT_URL, submitUrl));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(customKeyScreenName)) {
            params.add(new HttpParameter(PARAM_CUSTOM_KEY_SCREEN_NAME, customKeyScreenName));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(customKeyName)) {
            params.add(new HttpParameter(PARAM_CUSTOM_KEY_NAME, customKeyName));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(customKeyEmail)) {
            params.add(new HttpParameter(PARAM_CUSTOM_KEY_EMAIL, customKeyEmail));
        }
        if (MapUtils.isNotEmpty(customParamKeys)) {
            for (Map.Entry<String, String> paramEntry : customParamKeys.entrySet()) {
                params.add(new HttpParameter(paramEntry.getKey(), paramEntry.getValue()));
            }
        }
        return params;
    }

    private String uploadImageForCards(String channelImage, String nonTwitterImageUrl) {
        String image = null;
        if (TwitterAdUtil.isNotNullOrEmpty(nonTwitterImageUrl)) {
            image = nonTwitterImageUrl;
        } else if (TwitterAdUtil.isNotNullOrEmpty(channelImage)) {
            image = channelImage;
        }
        if (image == null) {
            return null;
        }
        return getMediaId(image);
    }

    private String getMediaId(String image) {
        Media media;
        try {
            TwitterAdUtil.ensureNotNull(image, "image");
            InputStream fileBody = new URL(image).openStream();
            media = twitterAdsClient.upload(new MediaUpload(fileBody));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (media != null) {
            return media.getMediaIdString();
        }
        return null;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl,
                                                                            String mediaId) throws TwitterException {
        List<HttpParameter> params = Lists.newArrayList();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(name, "Name");
        TwitterAdUtil.ensureNotNull(websiteTitle, "WebsiteTitle");
        TwitterAdUtil.ensureNotNull(websiteUrl, "WebsiteUrl");
        params.add(new HttpParameter(PARAM_NAME, name));
        params.add(new HttpParameter(PARAM_WEBSITE_TITLE, websiteTitle));
        params.add(new HttpParameter(PARAM_WEBSITE_URL, websiteUrl));

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, mediaId));
        }

        return params;
    }

    private List<HttpParameter> validateAndCreateParamsForCreateImageAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParameters(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                                      googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_WIDE_APP_IMAGE_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }
        return params;

    }

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

    private List<HttpParameter> validateAndCreateParamsForUpdateImageAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParametersForUpdate(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                                               googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(mediaId)) {
            params.add(new HttpParameter(PARAM_WIDE_APP_IMAGE_MEDIA_ID, mediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }
        return params;

    }


    private List<HttpParameter> validateAndCreateParamsForCreateAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                                String customAppDescription, String mediaId, String callToAction)
            throws TwitterException {
        List<HttpParameter> params =
                getCardHttpParameters(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
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

    private List<HttpParameter> validateAndCreateParamsForCreateVideoAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String posterMediaId,
                                                                                     String videoMediaId, String callToAction)
            throws TwitterException {

        List<HttpParameter> params =
                getCardHttpParameters(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink, ipadDeepLink,
                                      googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(videoMediaId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(posterMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, posterMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }

        return params;

    }

    private List<HttpParameter> validateAndCreateParamsForUpdateVideoAppDownloadCard(String accountId, String name, String appCountryCode,
                                                                                     String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                                     String iphoneDeepLink, String ipadDeepLink,
                                                                                     String googlePlayDeepLink, String imageMediaId,
                                                                                     String videoMediaId, String callToAction)
            throws TwitterException {

        List<HttpParameter> params =
                getVideoCardHttpParametersForUpdate(accountId, name, appCountryCode, iphoneAppId, ipadAppId, googlePlayAppId, iphoneDeepLink,
                                                    ipadDeepLink, googlePlayDeepLink);

        if (TwitterAdUtil.isNotNullOrEmpty(imageMediaId)) {
            params.add(new HttpParameter(PARAM_IMAGE_MEDIA_ID, imageMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(videoMediaId)) {
            params.add(new HttpParameter(PARAM_VIDEO_ID, videoMediaId));
        }

        if (TwitterAdUtil.isNotNullOrEmpty(callToAction)) {
            params.add(new HttpParameter(APP_CTA, callToAction));
        }
        return params;

    }

    private List<HttpParameter> getVideoCardHttpParametersForUpdate(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                    String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                    String ipadDeepLink, String googlePlayDeepLink) throws TwitterException {
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

        if (TwitterAdUtil.isNotNull(iphoneAppId)) {
            params.add(new HttpParameter(PARAM_IPHONE_APP_ID, iphoneAppId));
            if (TwitterAdUtil.isNotNull(iphoneDeepLink)) {
                params.add(new HttpParameter(PARAM_IPHONE_DEEP_LINK, iphoneDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNull(ipadAppId)) {
            params.add(new HttpParameter(PARAM_IPAD_APP_ID, ipadAppId));
            if (TwitterAdUtil.isNotNull(ipadDeepLink)) {
                params.add(new HttpParameter(PARAM_IPAD_DEEP_LINK, ipadDeepLink));
            }
        }
        if (TwitterAdUtil.isNotNull(googlePlayAppId)) {
            params.add(new HttpParameter(PARAM_GOOGLEPLAY_APP_ID, googlePlayAppId));
            if (TwitterAdUtil.isNotNull(googlePlayDeepLink)) {
                params.add(new HttpParameter(PARAM_GOOGLEPLAY_DEEP_LINK, googlePlayDeepLink));
            }
        }
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
