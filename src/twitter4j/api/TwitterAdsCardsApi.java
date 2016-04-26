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
     * @param accountId The identifier for the leveraged account. (required)
     * @param cardId    The identifier of the card to be deleted
     * @return Details of the deleted card with deleted true, if successful
     * @throws TwitterException
     */
    BaseAdsResponse<TwitterMobileAppCard> deleteAppDownloadCard(String accountId, String cardId) throws TwitterException;

    BaseAdsResponse<TwitterVideoAppDownloadCard> deleteVideoAppDownloadCard(String accountId, String cardId) throws TwitterException;


    BaseAdsResponse<TwitterImageAppDownloadCard> deleteImageAppDownloadCard(String accountId, String cardId) throws TwitterException;

    String postVideoCardImage(String imageTonLocation) throws TwitterException;

    // ---  Stats  ---
    BaseAdsResponse<TwitterLeadGenerationStat> getTwitterLeadGenerationStat(String accountId, String cardId, String startTime, String endTime,
                                                                            String granularity, String metric, Boolean withDeleted)
            throws TwitterException;
}
