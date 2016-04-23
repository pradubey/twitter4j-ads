package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.cards.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:09 PM
 */
public interface TwitterAdsCardsApi {

    /**
     * @param accountId           The identifier for the leveraged account. (required)
     * @param name                The name identifier for card. Maximum length: 80 characters. (required)
     * @param title               Title (string) of the lead generation card. Maximum length: 255 characters. (required)
     * @param cta                 Call to Action text of the submit button. Maximum length: 20 characters. (required)
     * @param fallbackUrl         The URL to redirect users to when a card cannot be presented. Maximum length: 255 characters. (required)
     * @param privacyPolicyUrl    URL describing privacy policy of this advertiser. Maximum length: 255 characters. (required)
     * @param imageUrl            URL of an image file uploaded and already hosted by Twitter. Maximum length: 255 characters. When image_data is not passed,
     *                            this parameter is required. (sometimes required)
     * @param imageData           The raw or Base64 encoded image file being uploaded. This is a write-only field. In response, the API will provide a Twitter URL for this image, that can be reused.
     *                            When image is not passed, this parameter is required. (sometimes required)
     * @param submitMethod        HTTP method (GET/POST) for the HTTPS endpoint (submit_url). Maximum length: 255 characters. (optional)
     * @param submitUrl           HTTPS endpoint that will accept the leads. Maximum length: 255 characters. (optional)
     * @param customKeyScreenName Override the parameter used for the 'screen_name' field. When not passed,
     *                            will default to 'screen_name'. Maximum length: 255 characters. (optional)
     * @param customKeyName       Override the parameter used for the 'name' field. When not passed, will default to 'name'. Maximum length: 255
     *                            characters. (optional)
     * @param customKeyEmail      Override the parameter used for the 'email' field. When not passed, will default to 'email'. Maximum length: 255
     *                            characters. (optional)
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterLeadGenerationCard> createLeadGenerationCard(String accountId, String name, String title, String cta, String fallbackUrl,
                                                                        String privacyPolicyUrl, String imageUrl, String imageData,
                                                                        String submitMethod, String submitUrl, String customKeyScreenName,
                                                                        String customKeyName, String customKeyEmail,
                                                                        Map<String, String> customParamKeys) throws TwitterException;

    BaseAdsResponse<TwitterLeadGenerationCard> updateLeadGenerationCard(String accountId, String cardId, String name, String title, String cta,
                                                                        String fallbackUrl, String privacyPolicyUrl, String imageUrl,
                                                                        String imageData, String submitMethod, String submitUrl,
                                                                        String customKeyScreenName, String customKeyName, String customKeyEmail,
                                                                        Map<String, String> customParamKeys) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    Lead Generation Card Id to fetch. (required)
     * @return retrieved card details
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterLeadGenerationCard> getLeadGenerationCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account. (required)
     * @param cardIds     Lead Generation Card Ids to fetch (optional). If not provided returns all the lead generation cards.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param count       Specifies the number of lead generation cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of one or more lead generation cards associated with the account
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterLeadGenerationCard> getAllLeadGenerationCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                     Integer count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    The identifier of the card to be deleted. (required)
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterLeadGenerationCard> deleteLeadGenerationCard(String accountId, String cardId) throws TwitterException;

    BaseAdsListResponseIterable<TwitterImageAppDownloadCard> getAllImageAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                         Integer count) throws TwitterException;

    BaseAdsListResponseIterable<TwitterVideoAppDownloadCard> getAllVideoAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                                         Integer count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    The identifier of the card to be deleted. (required)
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> deleteWebsiteCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account. (required)
     * @param cardIds     Website Card Ids to fetch (optional). If not provided returns all the website cards.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param count       Specifies the number of website cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of one or more website cards associated with the account
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterWebsiteCard> getAllWebsiteCards(String accountId, List<String> cardIds, boolean withDeleted, Integer count)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    Website Card Id to fetch. (required)
     * @return retrieved card details
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> getWebsiteCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId        The identifier for the leveraged account. (required)
     * @param name             The name identifier for card. Maximum length: 80 characters. (required)
     * @param cardId           The identifier of the card to be updated. (required)
     * @param websiteTitle     The title of the website card. Maximum length: 70 characters. (required)
     * @param websiteUrl       The URL of the website to redirect a user to. Maximum length: 200 characters. (required)
     * @param channelImage     URL of an image file uploaded and already hosted by Twitter. Maximum length: 255 characters. When image_data is not
     *                         passed, this parameter is required. (required)
     * @param channelImageData The raw or Base64 encoded image file being uploaded. This is a write-only field. In response, the API will provide a Twitter URL for this image, that can be reused.
     *                         When image is not passed, this parameter is required. (sometimes required)
     * @return details of the updated card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> updateWebsiteCard(String accountId, String name, String cardId, String websiteTitle, String websiteUrl,
                                                          String channelImage, String channelImageData) throws TwitterException;


    /**
     * @param accountId        The identifier for the leveraged account. (required)
     * @param name             The name identifier for card. Maximum length: 80 characters. (required)
     * @param websiteTitle     The title of the website card. Maximum length: 70 characters. (required)
     * @param websiteUrl       The URL of the website to redirect a user to. Maximum length: 200 characters. (required)
     * @param channelImage     URL of an image file uploaded and already hosted by Twitter. Maximum length: 255 characters. When image_data is not passed, this parameter is required. (required)
     * @param channelImageData The raw or Base64 encoded image file being uploaded. This is a write-only field. In response,
     *                         the API will provide a Twitter URL for this image, that can be reused. When image is not passed,
     *                         this parameter is required. (sometimes required)
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterWebsiteCard> createWebsiteCard(String accountId, String name, String websiteTitle, String websiteUrl, String channelImage,
                                                          String channelImageData) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account. (required)
     * @param cardIds     App Download Card Ids to fetch (optional). If not provided returns all the app download cards.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param count       Specifies the number of app download cards to try and retrieve, up to a maximum of 1000 per distinct request.
     * @return retrieves details of ome or all app download cards associated with the account
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TwitterMobileAppCard> getAllAppDownloadCards(String accountId, List<String> cardIds, boolean withDeleted,
                                                                             Integer count) throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    App Download Card Id to fetch. (required)
     * @return retrieved card details
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> getAppDownloadCard(String accountId, String cardId) throws TwitterException;

    /**
     * @param accountId            The identifier for the leveraged account. (required)
     * @param name                 The name identifier for card. Maximum length: 80 characters. (required)
     * @param appCountryCode       2 letter ISO code for the country where the App is sold. (required)
     * @param iphoneAppId          This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPHONE_APP_ID>
     * @param ipadAppId            This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPAD_APP_ID>
     * @param googlePlayAppId      This ID is googleplay’s application package name. For example, twitter’s google play app id is com.twitter.android.
     * @param iphoneDeepLink       This is your app's deep link.
     * @param ipadDeepLink         This is your app's deep link.
     * @param googlePlayDeepLink   This is your app's deep link.
     * @param customIcon           An image URL hosted by Twitter which will be used instead of the app store's icon. This is a write-only field.
     *                             This needs to be minimum of 144px wide/height with the aspect ratio 1:1. This param cannot be passed when custom_icon_data is passed.
     * @param customIconData       The raw or Base64 encoded icon image file being uploaded, which will be used instead of the app store's icon.
     *                             This is a write-only field. This needs to be minimum of 144px wide/height with the aspect ratio 1:1. In
     *                             response, the API will provide a Twitter URL for this image, that can be reused. This param cannot be passed when custom_icon is passed.
     * @param customAppDescription This is a custom description of the app. If supplied, it will be used instead of the description from the app store.
     * @return details of the created card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> createAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                String ipadAppId, String googlePlayAppId, String iphoneDeepLink, String ipadDeepLink,
                                                                String googlePlayDeepLink, String customIcon, String customIconData,
                                                                String customAppDescription, String callToAction) throws TwitterException;

    /**
     * @param accountId            The identifier for the leveraged account. (required)
     * @param name                 The name identifier for card. Maximum length: 80 characters. (required)
     * @param cardId               The identifier of the card to be updated
     * @param appCountryCode       2 letter ISO code for the country where the App is sold. (required)
     * @param iphoneAppId          This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPHONE_APP_ID>
     * @param ipadAppId            This is usually numeric and available in your app store URL. For example,
     *                             333903271 is the id for twitter. You can retrieve the id from Apple App Store URL - https://itunes.apple.com/us/app/twitter/id<IPAD_APP_ID>
     * @param googlePlayAppId      This ID is googleplay’s application package name. For example, twitter’s google play app id is com.twitter.android.
     * @param iphoneDeepLink       This is your app's deep link.
     * @param ipadDeepLink         This is your app's deep link.
     * @param googlePlayDeepLink   This is your app's deep link.
     * @param customIcon           An image URL hosted by Twitter which will be used instead of the app store's icon. This is a write-only field.
     *                             This needs to be minimum of 144px wide/height with the aspect ratio 1:1. This param cannot be passed when custom_icon_data is passed.
     * @param customIconData       The raw or Base64 encoded icon image file being uploaded, which will be used instead of the app store's icon.
     *                             This is a write-only field. This needs to be minimum of 144px wide/height with the aspect ratio 1:1. In
     *                             response, the API will provide a Twitter URL for this image, that can be reused. This param cannot be passed when custom_icon is passed.
     * @param customAppDescription This is a custom description of the app. If supplied, it will be used instead of the description from the app store.
     * @return details of the updated card if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> updateAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                String iphoneAppId, String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                String ipadDeepLink, String googlePlayDeepLink, String customIcon,
                                                                String customIconData, String customAppDescription, String callToAction)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    The identifier of the card to be deleted
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException;

    BaseAdsResponse<TwitterImageAppDownloadCard> createImageAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                            String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                            String ipadDeepLink, String googlePlayDeepLink, String wideAppImage,
                                                                            String wideAppImageData, String callToAction) throws TwitterException;

    BaseAdsResponse<TwitterImageAppDownloadCard> updateImageAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                            String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                            String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                            String wideAppImage, String wideAppImageData, String callToAction)
            throws TwitterException;

    BaseAdsResponse<TwitterVideoAppDownloadCard> createVideoAppDownloadCard(String accountId, String name, String appCountryCode, String iphoneAppId,
                                                                            String ipadAppId, String googlePlayAppId, String iphoneDeepLink,
                                                                            String ipadDeepLink, String googlePlayDeepLink, String videoUrl,
                                                                            String imageUrl, String callToAction)
            throws TwitterException, IOException, InterruptedException;

    BaseAdsResponse<TwitterVideoAppDownloadCard> updateVideoAppDownloadCard(String accountId, String name, String cardId, String appCountryCode,
                                                                            String iphoneAppId, String ipadAppId, String googlePlayAppId,
                                                                            String iphoneDeepLink, String ipadDeepLink, String googlePlayDeepLink,
                                                                            String updatedImageUrl, String updatedVideoUrl, String originalImageId,
                                                                            String originalVideoId, String callToActionValue)
            throws TwitterException, IOException, InterruptedException;

    BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException;


    BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException;

    String createVideoCard(String videoId, String posterImageId, String tweetText, Boolean nullCast) throws TwitterException;

    String postVideoCardImage(String imageTonLocation) throws TwitterException;

    // ---  Stats  ---
    BaseAdsResponse<TwitterLeadGenerationStat> getTwitterLeadGenerationStat(String accountId, String cardId, String startTime, String endTime,
                                                                            String granularity, String metric, Boolean withDeleted)
            throws TwitterException;
}
