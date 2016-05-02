package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.Campaign;
import twitter4j.models.ads.sort.CampaignSortByField;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/7/16
 * Time: 12:25 PM
 */
public interface TwitterAdsCampaignApi {

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param campaignIds          Scope the response to just the desired campaigns by specifying a comma-separated list of identifiers. Up to 50 ids may be provided.
     * @param fundingInstrumentIds Scope the response to just the desired funding instruments by specifying a comma-separated list of identifiers.
     *                             Up to 50 ids may be provided.
     * @param withDeleted          Include deleted results in your request. Defaults to false.
     * @param count                Specifies the number of campaigns to try and retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor               Specifies a cursor to get the next page of campaigns.
     * @return Retrieve details for some or all campaigns associated with the current account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<Campaign> getAllCampaigns(String accountId, Collection<String> campaignIds, Collection<String> fundingInstrumentIds,
                                                       boolean withDeleted, Integer count, String cursor, CampaignSortByField sortByField) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param campaignId  The identifier for a campaign associated with the current account.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve details for a specific campaign associated with the current account.
     * @throws TwitterException
     */
    BaseAdsResponse<Campaign> getCampaignById(String accountId, String campaignId, boolean withDeleted) throws TwitterException;


    /**
     * @return created Campaign
     * @throws TwitterException
     */
    BaseAdsResponse<Campaign> createCampaign(Campaign campaign) throws TwitterException;

    /**
     * @return updated campaign
     * @throws TwitterException
     */
    BaseAdsResponse<Campaign> updateCampaign(String accountId, String campaignId, String name, Long totalBudgetAmountLocalMicro,
                                             Long dailyBudgetAmountLocalMicro, String startTime, String endTime, Boolean paused,
                                             Boolean standardDelivery, int frequencyCap, int durationInDays) throws TwitterException;

    /**
     * @return updated campaign
     * @throws TwitterException
     */
    BaseAdsResponse<Campaign> updateCampaignStatus(String accountId, String campaignId, Boolean paused) throws TwitterException;

    /**
     * @return Campaign to be deleted with deleted field set to true
     * @throws TwitterException
     */
    BaseAdsResponse<Campaign> deleteCampaign(String accountId, String campaignId) throws TwitterException;

}
