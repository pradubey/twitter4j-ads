package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.LocationType;
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
    BaseAdsResponse<TargetingCriteria> createTargetingCriteria(String accountId, String lineItemId, TargetingType targetingType,
                                                               String targetingValue, boolean tailoredAudienceExpansion,
                                                               Optional<TailoredAudienceType> tailoredAudienceType)
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
    BaseAdsListResponseIterable<TargetingLocation> getAllTargetingLocations(Optional<LocationType> locationType, String q,
                                                                            String countryCode, Optional<Integer> count) throws TwitterException;

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

    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVChannels(String tvMarketLocale, Optional<Integer> count, Optional<String> cursor)
            throws TwitterException;

    BaseAdsListResponseIterable<TargetingLocation> getTargetingLocations(String query, LocationType locationType) throws TwitterException;

    BaseAdsListResponseIterable<IabCategory> getAllIabCategories(String q) throws TwitterException;

    /**
     * @return all the TVShows(matching q if provided) that can be targeted
     * @throws TwitterException
     */

    BaseAdsListResponseIterable<TargetingCriteria> getAllTVShows(String tvMarket, String q, Optional<Integer> count, Optional<String> cursor) throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> getAllEvents() throws TwitterException;

    /**
     * @return All the TV Markets that can be targeted
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<TargetingCriteria> getAllTVMarkets() throws TwitterException;

    BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVGenres() throws TwitterException;

    /**
     * @return get targeting suggestions for keywords and userids
     * @throws TwitterException
     */
    List<TargetingSuggestion> getTargetingSuggestion(String accountId, SuggestionType suggestionType, List<String> targetingValues,
                                                     Optional<Integer> count, List<String> ignoredValues) throws TwitterException;

    BaseAdsListResponseIterable<TwitterBehavior> getBehaviors(Optional<Integer> count, Optional<String> cursor, List<String> behaviorIds)
            throws TwitterException;

    BaseAdsListResponseIterable<TwitterBehaviorTaxonomy> getBehaviorTaxonomy(List<String> behaviorTaxonomyIds,
                                                                             List<String> parentBehaviorTaxonomyIds, Optional<Integer> count,
                                                                             Optional<String> cursor)
            throws TwitterException;

    List<TwitterAppStore> searchAppStoreCategories(String q, Optional<AppStoreSearchType> appStoreSearchType) throws TwitterException;

    BaseAdsListResponseIterable<TwitterApplicationList> getAllAppLists(String accountId) throws TwitterException;

    BaseAdsResponse<TwitterApplicationList> getAllAppsListsById(String accountId, String listId) throws TwitterException;

    BaseAdsResponse<TwitterApplicationList> createNewApplicationList(String accountId, TwitterApplicationList twitterApplicationList)
            throws TwitterException;


}
