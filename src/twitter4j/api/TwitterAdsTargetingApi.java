package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.LocationType;
import twitter4j.models.SortByField;
import twitter4j.models.ads.*;
import twitter4j.models.ads.tags.TwitterApplicationList;

import java.util.List;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:15 PM
 */
public interface TwitterAdsTargetingApi {

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param lineItemId  Scope targeting criteria to a specific line item by providing its identifier.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve details for some or all TargetingCriterias associated with the current account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingCriteria> getTargetingCriterias(String accountId, String lineItemId, boolean withDeleted)
            throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param targetingId A reference to the targeting criteria you are operating with in the request.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return Retrieve detailed information on a targeting criterion associated with a specific line item.
     * @throws TwitterException
     */
    BaseAdsResponse<TargetingCriteria> getTargetingCriteriaById(String accountId, String targetingId, boolean withDeleted) throws TwitterException;

    /**
     * @return created targeting criteria
     * @throws TwitterException
     */
    BaseAdsResponse<TargetingCriteria> createTargetingCriteria(String accountId, String lineItemId, TargetingType targetingType, String targetingValue,
                                                               boolean tailoredAudienceExpansion, TailoredAudienceType tailoredAudienceType)
            throws TwitterException;

    /**
     * @return created targeting criterias
     * @throws TwitterException
     */
    List<TargetingCriteria> createTargetingCriterias(String accountId, String lineItemId, List<TargetingCriteria> targetingCriteriaValues)
            throws TwitterException;

    /**
     * @return deleted targeting criteria with deleted field set to true
     * @throws TwitterException
     */
    BaseAdsResponse<TargetingCriteria> deleteTargetingCriteria(String accountId, String targetingCriteriaId) throws TwitterException;

    /**
     * @return all possible targeting locations to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingLocation> getAllTargetingLocations(LocationType locationType, String q, String countryCode,
                                                                            Integer count) throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingEvents(String q) throws TwitterException;


    /**
     * @return all possible targeting interests to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingInterests(String q) throws TwitterException;

    /**
     * @return all possible targeting platforms to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingPlatforms(String q) throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingNetworkOperators(String q) throws TwitterException;

    /**
     * @return all possible targeting platform versions to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<PlatformVersions> getAllTargetingPlatformVersions() throws TwitterException;

    /**
     * @return all possible targeting devices to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<Devices> getAllTargetingDevices(String q) throws TwitterException;

    /**
     * @return all possible twitter targeting languages to choose from
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingLocales(String q) throws TwitterException;

    /**
     * @return reach_estimate of the ad
     */
    BaseAdsResponse<TwitterReachEstimate> getReachEstimate(String accountId, ProductType productType, String promotableUserId,
                                                           List<TargetingCriteria> targetingCriterias) throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVChannels(String tvMarketLocale, Integer count, String cursor)
            throws TwitterException;

    TargetingLocations getTargetingLocations(String query, LocationType locationType) throws TwitterException;

    BaseAdsListResponseIterable<IabCategory> fetchIabCategories(String q) throws TwitterException;

    /**
     * @return all the TVShows(matching q if provided) that can be targeted
     * @throws TwitterException
     */

    BaseAdsListResponseIterable<TargetingCriteria> fetchTVShows(String tvMarket, String q, Integer count, String cursor) throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> fetchEvents() throws TwitterException;

    /**
     * @return All the TV Markets that can be targeted
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingCriteria> fetchTVMarkets() throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVGenres() throws TwitterException;

    /**
     * @return get targeting suggestions for keywords and userids
     * @throws TwitterException
     */
    List<TargetingSuggestion> getTargetingSuggestion(String accountId, SuggestionType suggestionType, List<String> targetingValues, Integer count,
                                                     List<String> ignoredValues) throws TwitterException;

    BaseAdsListResponseIterable<TwitterBehavior> getBehaviors(Integer count, String cursor, SortByField sortBy, List<String> behaviorIds)
            throws TwitterException;

    BaseAdsListResponseIterable<TwitterBehaviorTaxonomy> getBehaviorTaxonomy(List<String> behaviorTaxonomyIds, List<String> parentBehaviorTaxonomyIds,
                                                                             Integer count, String cursor, SortByField sortByField)
            throws TwitterException;

    List<TwitterAppStore> searchAppStoreCategories(String q, AppStoreSearchType appStoreSearchType) throws TwitterException;

    BaseAdsListResponseIterable<TwitterApplicationList> fetchAppList(String accountId) throws TwitterException;

    BaseAdsResponse<TwitterApplicationList> fetchApps(String accountId, String listId) throws TwitterException;

    BaseAdsResponse<TwitterApplicationList> createNewApplicationList(String accountId, TwitterApplicationList twitterApplicationList)
            throws TwitterException;


}
