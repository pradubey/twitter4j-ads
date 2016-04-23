package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.BidType;
import twitter4j.models.ads.LineItem;
import twitter4j.models.ads.PromotedAccount;
import twitter4j.models.ads.Sentiments;
import twitter4j.models.video.AssociateMediaCreativeResponse;
import twitter4j.models.video.PreRollCallToActionResponse;
import twitter4j.models.video.TwitterCallToActionType;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 8:00 PM
 */
public interface TwitterAdsLineItemApi {


    /**
     * @param accountId            The identifier for the leveraged account.
     * @param campaignIds          Scope the response to just the desired campaigns by specifying a comma-separated list of identifiers. Up to 50 ids may be provided.
     * @param lineItemIds          Scope the response to just the desired line items by specifying a comma-separated list of identifiers. Up to 50 ids may be provided.
     * @param fundingInstrumentIds Scope the response to just the desired funding instruments by specifying a comma-separated list of identifiers. Up to 50 ids may be provided.
     * @param count                Specifies the number of campaigns to try and retrieve, up to a maximum of 1000 per distinct request.
     * @param withDeleted          Include deleted results in your request. Defaults to false.
     * @return Retrieve the line items associated with a specific campaign belonging to the current account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<LineItem> getLineItems(String accountId, Collection<String> campaignIds, Collection<String> lineItemIds,
                                                       Collection<String> fundingInstrumentIds, Integer count, boolean withDeleted, String cursor)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param lineItemId  A reference to the line item you are operating with in the request.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve a specific line item associated with a campaign belonging to the current account.
     * @throws TwitterException
     */
    BaseAdsResponse<LineItem> getLineItemById(String accountId, String lineItemId, boolean withDeleted) throws TwitterException;


    /**
     * @return created line item
     * @throws TwitterException
     */
    BaseAdsResponse<LineItem> createLineItem(LineItem lineItem) throws TwitterException;

    /**
     * @return updated line item
     * @throws TwitterException
     */
    BaseAdsResponse<LineItem> updateLineItem(String accountId, String lineItemId, BidType bidType, boolean automaticallySelectBid,
                                             Long bidAmountLocalMicro, Boolean paused, Sentiments includeSentiment,
                                             Boolean matchRelevantPopularQueries, String chargeBy, String bidUnit, String advertiserDomain,
                                             String[] iabCategories) throws TwitterException;

    /**
     * @return line item to be deleted with deleted field set to true
     * @throws TwitterException
     */
    BaseAdsResponse<LineItem> deleteLineItem(String accountId, String lineItemId) throws TwitterException;

    /**
     * @param accountId  The identifier for the leveraged account.
     * @param lineItemId Scope the response to just the desired line item
     * @param userId     Id of the user of the account to be promoted
     * @return created promoted account
     * @throws TwitterException
     */
    BaseAdsResponse<PromotedAccount> createPromotedAccounts(String accountId, String lineItemId, String userId) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account.
     * @param promotedAccountIds Scope the response to the specified comma-separated list of promoted account IDs. These identifiers refer to a associated Promoted Account with a line item.
     * @param lineItemId         A reference to the line item you are operating with in the request. Omitting the lineItemId will return all
     *                           promoted tweets across all campaigns.
     * @param withDeleted        Include deleted results in your request. Defaults to false.
     * @return Retrieve references to the Promoted Accounts associated with one or more line items.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<PromotedAccount> getPromotedAccounts(String accountId, Collection<String> promotedAccountIds, String lineItemId,
                                                                     boolean withDeleted) throws TwitterException;

    BaseAdsResponse<PreRollCallToActionResponse> createCallToActionDetailsForPreRollViews(String accountId, String lineItemId,
                                                                                          TwitterCallToActionType twitterCallToActionType,
                                                                                          String callToActionUrl) throws TwitterException;

    //landing url is the url of the media creative
    BaseAdsResponse<AssociateMediaCreativeResponse> associateMediaCreativeWithAccount(String accountId, String lineItemId, String accountMediaId,
                                                                                      String landingUrl) throws TwitterException;

}
