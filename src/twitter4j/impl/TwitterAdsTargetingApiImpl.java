package twitter4j.impl;

import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import twitter4j.*;
import twitter4j.api.TwitterAdsTargetingApi;
import twitter4j.models.LocationType;
import twitter4j.models.ads.*;
import twitter4j.models.ads.tags.TwitterApplicationList;
import twitter4j.util.TwitterAdUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

import static twitter4j.TwitterAdsConstants.*;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:16 PM
 */
public class TwitterAdsTargetingApiImpl implements TwitterAdsTargetingApi {

    private static final Integer MAX_REQUEST_PARAMETER_SIZE = 50;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final TwitterAdsClient twitterAdsClient;

    public TwitterAdsTargetingApiImpl(TwitterAdsClient twitterAdsClient) {
        this.twitterAdsClient = twitterAdsClient;
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getTargetingCriterias(String accountId, String lineItemId, boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "accountId");
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(lineItemId)) {
            params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        }
        params.add(new HttpParameter(PARAM_WITH_DELETED, withDeleted));
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TARGETING_CRITERIA;

        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsResponse<TargetingCriteria> getTargetingCriteriaById(String accountId, String targetingId, boolean withDeleted)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(targetingId, "Targeting Id");

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TARGETING_CRITERIA +
                         targetingId;
        HttpParameter[] params = null;

        params = new HttpParameter[]{new HttpParameter(PARAM_WITH_DELETED, withDeleted)};
        Type type = new TypeToken<BaseAdsResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params, type, HttpVerb.GET);

    }

    @Override
    public BaseAdsResponse<TargetingCriteria> deleteTargetingCriteria(String accountId, String targetingCriteriaId) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(targetingCriteriaId, "Targeting Id");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TARGETING_CRITERIA +
                         targetingCriteriaId;
        Type type = new TypeToken<BaseAdsResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, type, HttpVerb.DELETE);
    }

    @Override
    public BaseAdsListResponseIterable<twitter4j.models.ads.TargetingLocation> getAllTargetingLocations(LocationType locationType, String q,
                                                                                                        String countryCode, Integer count)
            throws TwitterException {
        List<HttpParameter> params = validateTargetingLocationParameters(locationType, q, countryCode, count);
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TARGETING_CRITERIA_LOCATION;

        Type type = new TypeToken<BaseAdsListResponse<twitter4j.models.ads.TargetingLocation>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingEvents(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_TARGETING_CRITERIA_EVENT);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingInterests(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_TARGETING_CRITERIA_INTERESTS);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingPlatforms(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_TARGETING_CRITERIA_PLATFORMS);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingNetworkOperators(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_TARGETING_CRITERIA_NETWORK_OPERATORS);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingLocales(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_TARGETING_LANGUAGES);
    }

    @Override
    public List<TargetingCriteria> createTargetingCriterias(String accountId, String lineItemId, List<TargetingCriteria> targetingCriteriaValues)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "Account Id");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item");
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TARGETING_CRITERIA;
        List<HttpParameter> params = validateAndCreateTargetingParameters(targetingCriteriaValues);
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        HttpResponse httpResponse = twitterAdsClient.putRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();

            BaseAdsListResponse<TargetingCriteria> baseAdsListResponse =
                    TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
            return baseAdsListResponse == null ? Collections.<TargetingCriteria>emptyList() : baseAdsListResponse.getData();
        } catch (IOException e) {
            throw new TwitterException("Failed to parse targeting criterias.");
        }
    }

    @Override
    public BaseAdsResponse<TargetingCriteria> createTargetingCriteria(String accountId, String lineItemId, TargetingType targetingType,
                                                                      String targetingValue, boolean tailoredAudienceExpansion,
                                                                      TailoredAudienceType tailoredAudienceType) throws TwitterException {
        List<HttpParameter> params = new ArrayList<>();
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(lineItemId, "Line Item Id");
        TwitterAdUtil.ensureNotNull(targetingType, "Targeting Type");
        TwitterAdUtil.ensureNotNull(targetingValue, "Targeting Value");
        params.add(new HttpParameter(PARAM_LINE_ITEM_ID, lineItemId));
        params.add(new HttpParameter(PARAM_TARGETING_TYPE, targetingType.name()));
        params.add(new HttpParameter(PARAM_TARGETING_VALUE, targetingValue));
        params.add(new HttpParameter(PARAM_TAILORED_AUDIENCE_EXPANSION, tailoredAudienceExpansion));

        if (TwitterAdUtil.isNotNull(tailoredAudienceType)) {
            params.add(new HttpParameter(PARAM_TAILORED_AUDIENCE_TYPE, tailoredAudienceType.name()));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TARGETING_CRITERIA;
        Type type = new TypeToken<BaseAdsResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.POST);
    }

    @Override
    public BaseAdsListResponseIterable<PlatformVersions> getAllTargetingPlatformVersions() throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TARGETING_CRITERIA_PLATFORM_VERSIONS;

        Type type = new TypeToken<BaseAdsListResponse<PlatformVersions>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, null, type);
    }

    @Override
    public BaseAdsListResponseIterable<Devices> getAllTargetingDevices(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_TARGETING_CRITERIA_DEVICES);
    }

    @Override
    public BaseAdsResponse<TwitterReachEstimate> getReachEstimate(String accountId, ProductType productType, String promotableUserId,
                                                                  List<TargetingCriteria> targetingCriterias) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(productType, "Product Type");
        TwitterAdUtil.ensureNotNull(promotableUserId, "User Id");

        List<HttpParameter> params = validateAndCreateTargetingParameters(targetingCriterias);
        params.add(new HttpParameter(PARAM_PRODUCT_TYPE, productType.name()));
        params.add(new HttpParameter(PARAM_USER_ID, promotableUserId));
        String url = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_REACH_ESTIMATE;
        Type type = new TypeToken<BaseAdsResponse<TwitterReachEstimate>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(url, params.toArray(new HttpParameter[params.size()]), type, HttpVerb.GET);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVChannels(String tvMarketLocale, Integer count, String cursor)
            throws TwitterException {
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(tvMarketLocale)) {
            params.add(new HttpParameter(PARAM_TV_MARKET_LOCALE, tvMarketLocale));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TV_CHANNELS;
        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public TargetingLocations getTargetingLocations(String query, LocationType locationType) throws TwitterException {

        List<HttpParameter> params = new ArrayList<HttpParameter>(2);
        if (StringUtils.isNotBlank(query)) {
            params.add(new HttpParameter("q", query.trim()));
        }
        params.add(new HttpParameter("location_type", locationType.name()));
        HttpResponse response = twitterAdsClient
                .getRequest(twitterAdsClient.getBaseAdsAPIUrl() + "0/targeting_criteria/locations", params.toArray(new HttpParameter[params.size()
                                                                                                                            ]));
        String responseString = response.asString();
        try {
            return OBJECT_MAPPER.readValue(responseString, TargetingLocations.class);
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response", e);
        }
    }

    @Override
    public BaseAdsListResponseIterable<IabCategory> getAllIabCategories(String q) throws TwitterException {
        return hitQueryForPath(q, PATH_IAB_CATEGORIES);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTVShows(String tvMarket, String q, Integer count, String cursor)
            throws TwitterException {
        TwitterAdUtil.ensureNotNull(tvMarket, "tvMarket");

        List<HttpParameter> params = validateTvShowsParameters(tvMarket, q, count, cursor);
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TV_SHOWS;

        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllEvents() throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TARGETING_CRITERIA_EVENT;
        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, null, type);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTVMarkets() throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TV_MARKETS;
        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, null, type);
    }

    @Override
    public BaseAdsListResponseIterable<TargetingCriteria> getAllTargetingTVGenres() throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TV_GENRES;
        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, null, type);
    }

    @Override
    public List<TargetingSuggestion> getTargetingSuggestion(String accountId, SuggestionType suggestionType, List<String> targetingValues,
                                                            Integer count, List<String> ignoredValues) throws TwitterException {
        TwitterAdUtil.ensureNotNull(accountId, "AccountId");
        TwitterAdUtil.ensureNotNull(suggestionType, "Suggestion Type");
        TwitterAdUtil.ensureNotEmpty(targetingValues, "Targeting Values");
        List<HttpParameter> params = new ArrayList<>();
        params.add(new HttpParameter(PARAM_SUGGESTION_TYPE, suggestionType.name()));
        params.add(new HttpParameter(PARAM_TARGETING_VALUES, TwitterAdUtil.getCsv(targetingValues)));
        if (TwitterAdUtil.isNotEmpty(ignoredValues)) {
            params.add(new HttpParameter(PARAM_IGNORED_VALUES, TwitterAdUtil.getCsv(ignoredValues)));
        }
        if (count != null) {
            count = count > MAX_REQUEST_PARAMETER_SIZE ? MAX_REQUEST_PARAMETER_SIZE : count;
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_TARGETING_SUGGESTIONS;
        HttpResponse httpResponse = twitterAdsClient.getRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsListResponse<TargetingSuggestion>>() {}.getType();
            BaseAdsListResponse<TargetingSuggestion> baseAdsListResponse =
                    TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
            return baseAdsListResponse == null ? Collections.<TargetingSuggestion>emptyList() : baseAdsListResponse.getData();
        } catch (IOException e) {
            throw new TwitterException("Failed to parse promoted tweets.");
        }
    }

    @Override
    public List<TwitterAppStore> searchAppStoreCategories(String q, AppStoreSearchType appStoreSearchType) throws TwitterException {
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(q)) {
            params.add(new HttpParameter("q", q));
        }
        if (TwitterAdUtil.isNotNull(appStoreSearchType)) {
            params.add(new HttpParameter("store", appStoreSearchType.name()));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_TARGETING_CRITERIA_APP_STORE_CATEGORIES;
        HttpResponse httpResponse = twitterAdsClient.getRequest(baseUrl, params.toArray(new HttpParameter[params.size()]));
        try {
            Type type = new TypeToken<BaseAdsListResponse<TwitterAppStore>>() {}.getType();
            BaseAdsListResponse<TwitterAppStore> baseAdsListResponse =
                    TwitterAdUtil.constructBaseAdsListResponse(httpResponse, httpResponse.asString(), type);
            return baseAdsListResponse == null ? Collections.<TwitterAppStore>emptyList() : baseAdsListResponse.getData();
        } catch (IOException e) {
            throw new TwitterException("Failed to parse response for app store categories");
        }
    }

    @Override
    public BaseAdsListResponseIterable<TwitterBehavior> getBehaviors(Integer count, String cursor, List<String> behaviorIds)
            throws TwitterException {
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter("count", count));
        }
        if (TwitterAdUtil.isNotNull(cursor)) {
            params.add(new HttpParameter("cursor", cursor));
        }
        if (TwitterAdUtil.isNotEmpty(behaviorIds)) {
            params.add(new HttpParameter("behavior_ids", TwitterAdUtil.getCsv(behaviorIds)));
        }

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_BEHAVIORS;
        Type type = new TypeToken<BaseAdsListResponse<TwitterBehavior>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterBehaviorTaxonomy> getBehaviorTaxonomy(List<String> behaviorTaxonomyIds,
                                                                                    List<String> parentBehaviorTaxonomyIds, Integer count,
                                                                                    String cursor) throws TwitterException {
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotEmpty(behaviorTaxonomyIds)) {
            params.add(new HttpParameter("behavior_taxonomy_ids", TwitterAdUtil.getCsv(behaviorTaxonomyIds)));
        }

        if (TwitterAdUtil.isNotEmpty(parentBehaviorTaxonomyIds)) {
            params.add(new HttpParameter("parent_behavior_taxonomy_ids", TwitterAdUtil.getCsv(parentBehaviorTaxonomyIds)));
        }

        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter("count", count));
        }

        if (TwitterAdUtil.isNotNull(cursor)) {
            params.add(new HttpParameter("cursor", cursor));
        }

        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PATH_BEHAVIORS_TAXONOMY;
        Type type = new TypeToken<BaseAdsListResponse<TwitterBehaviorTaxonomy>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    @Override
    public BaseAdsListResponseIterable<TwitterApplicationList> getAllAppLists(String accountId) throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_LIST;
        Type type = new TypeToken<BaseAdsListResponse<TwitterApplicationList>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, null, type);
    }

    @Override
    public BaseAdsResponse<TwitterApplicationList> getAllAppsListsById(String accountId, String listId) throws TwitterException {
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_LIST + listId;
        Type typeToken = new TypeToken<BaseAdsResponse<TwitterApplicationList>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, null, typeToken, HttpVerb.GET);
    }

    @Override
    public BaseAdsResponse<TwitterApplicationList> createNewApplicationList(String accountId, TwitterApplicationList twitterApplicationList)
            throws TwitterException {
        List<HttpParameter> params = validateAndCreateApplicationListParameters(twitterApplicationList);
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + PREFIX_ACCOUNTS_V1 + accountId + PATH_APP_LIST;
        Type typeToken = new TypeToken<BaseAdsResponse<TwitterApplicationList>>() {}.getType();
        return twitterAdsClient.executeHttpRequest(baseUrl, params.toArray(new HttpParameter[params.size()]), typeToken, HttpVerb.POST);
    }


    // ---------------------------------------- Private Methods --------------------------------------------------

    private <T> BaseAdsListResponseIterable<T> hitQueryForPath(String q, String queryPath) throws TwitterException {
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(q)) {
            params.add(new HttpParameter("q", q));
        }
        String baseUrl = twitterAdsClient.getBaseAdsAPIUrl() + queryPath;
        Type type = new TypeToken<BaseAdsListResponse<TargetingCriteria>>() {}.getType();
        return twitterAdsClient.executeHttpListRequest(baseUrl, params, type);
    }

    private List<HttpParameter> validateAndCreateTargetingParameters(List<TargetingCriteria> targetingValues) {
        List<HttpParameter> params = new ArrayList<>();
        Map<TargetingType, List<String>> targeting = new HashMap<>();
        for (TargetingCriteria targetingCriteria : targetingValues) {
            if (targeting.containsKey(targetingCriteria.getTargetingType())) {
                targeting.get(targetingCriteria.getTargetingType()).add(targetingCriteria.getTargetingValue());
            } else {
                targeting.put(targetingCriteria.getTargetingType(), Lists.newArrayList(targetingCriteria.getTargetingValue()));
            }
        }
        for (Map.Entry<TargetingType, List<String>> entry : targeting.entrySet()) {
            //noinspection EnumSwitchStatementWhichMissesCases
            switch (entry.getKey()) {
                case LOCATION:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 250);
                    params.add(new HttpParameter(PARAM_LOCATIONS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case FOLLOWERS_OF_USER:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 100);
                    params.add(new HttpParameter(PARAM_FOLLOWERS_OF_USERS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case SIMILAR_TO_FOLLOWERS_OF_USER:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 100);
                    params.add(new HttpParameter(PARAM_SIMILAR_TO_FOLLOWERS_OF_USERS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case INTEREST:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_INTERESTS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case PLATFORM:
                    params.add(new HttpParameter(PARAM_PLATFORMS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case PLATFORM_VERSION:
                    params.add(new HttpParameter(PARAM_PLATFORM_VERSIONS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case DEVICE:
                    params.add(new HttpParameter(PARAM_DEVICES, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case WIFI_ONLY:
                    params.add(new HttpParameter(PARAM_WIFI_ONLY, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case GENDER:
                    params.add(new HttpParameter(PARAM_GENDER, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TV_SHOW:
                    params.add(new HttpParameter(PARAM_TV_SHOWS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TV_CHANNEL:
                    params.add(new HttpParameter(PARAM_TV_CHANNEL, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TV_GENRE:
                    params.add(new HttpParameter(PARAM_TV_GENRE, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TV_MARKET:
                    break;
                case NETWORK_OPERATOR:
                    params.add(new HttpParameter(PARAM_NETWORK_OPERATOR, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case BROAD_KEYWORD:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_BROAD_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case UNORDERED_KEYWORD:
                    params.add(new HttpParameter(PARAM_UNORDERED_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case PHRASE_KEYWORD:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_PHRASE_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case EXACT_KEYWORD:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_EXACT_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case NEGATIVE_PHRASE_KEYWORD:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_NEGATIVE_PHRASE_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case NEGATIVE_UNORDERED_KEYWORD:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_NEGATIVE_UNORDERED_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case NEGATIVE_EXACT_KEYWORD:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1000);
                    params.add(new HttpParameter(PARAM_NEGATIVE_EXACT_KEYWORDS, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TAILORED_AUDIENCE:
                    params.add(new HttpParameter(PARAM_TAILORED_AUDIENCES, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TAILORED_AUDIENCES_EXCLUDED:
                    params.add(new HttpParameter(PARAM_TAILORED_AUDIENCES_EXCLUDED, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case TAILORED_AUDIENCES_EXPANDED:
                    params.add(new HttpParameter(PARAM_TAILORED_AUDIENCES_EXPANDED, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case LANGUAGE:
                    params.add(new HttpParameter(PARAM_LANGUAGES, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case RTB_APP_CATEGORY:
                    break;
                case NETWORK_ACTIVATION_DURATION_LT:
                    params.add(new HttpParameter(PARAM_NETWORK_ACTIVATION_DURATION_LT, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case NETWORK_ACTIVATION_DURATION_GTE:
                    params.add(new HttpParameter(PARAM_NETWORK_ACTIVATION_DURATION_GTE, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case AGE:
                    params.add(new HttpParameter(PARAM_AGE_RANGE, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case BEHAVIOR:
                    params.add(new HttpParameter(PARAM_BEHAVIOR, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case NEGATIVE_BEHAVIOR:
                    params.add(new HttpParameter(PARAM_NEGATIVE_BEHAVIOR, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case BEHAVIOR_EXPANDED:
                    params.add(new HttpParameter(PARAM_BEHAVIOR_EXPANDED, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case ENGAGEMENT_TYPE:
                    params.add(new HttpParameter(PARAM_ENGAGEMENT_TYPE, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case USER_ENGAGEMENT:
                    params.add(new HttpParameter(PARAM_USER_ENGAGEMENT, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case CAMPAIGN_ENGAGEMENT:
                    params.add(new HttpParameter(PARAM_CAMPAIGN_ENGAGEMENT, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case EXCLUDE_APP_LIST:
                    params.add(new HttpParameter(PARAM_EXCLUDE_APP_LIST_IDENTIFIER, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case EVENT:
                    TwitterAdUtil.ensureMaxSize(entry.getValue(), 1);
                    params.add(new HttpParameter(PARAM_EVENT, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
                case APP_STORE_CATEGORY:
                    params.add(new HttpParameter(PARAM_APP_STORE_CATEGORY, TwitterAdUtil.getCsv(entry.getValue())));
                    break;
            }
        }
        return params;
    }

    private List<HttpParameter> validateTargetingLocationParameters(final LocationType locationType, final String q, final String countryCode,
                                                                    final Integer count) {

        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNull(locationType)) {
            params.add(new HttpParameter(PARAM_LOCATION_TYPE, locationType.name()));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(q)) {
            params.add(new HttpParameter(PARAM_Q, q));
        }
        if (TwitterAdUtil.isNotNullOrEmpty(countryCode)) {
            params.add(new HttpParameter(PARAM_COUNTRY_CODE, countryCode));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        return params;
    }

    private List<HttpParameter> validateTvShowsParameters(String tvMarket, String q, Integer count, String cursor) {
        TwitterAdUtil.ensureNotNull(tvMarket, "tvMarket");
        List<HttpParameter> params = new ArrayList<>();
        if (StringUtils.isNotBlank(tvMarket)) {
            params.add(new HttpParameter(PARAM_TV_MARKET, tvMarket));
        }
        if (StringUtils.isNotBlank(q)) {
            params.add(new HttpParameter(PARAM_Q, q));
        }
        if (TwitterAdUtil.isNotNull(count)) {
            params.add(new HttpParameter(PARAM_COUNT, count));
        }
        if (TwitterAdUtil.isNotNull(cursor)) {
            params.add(new HttpParameter(PARAM_CURSOR, cursor));
        }
        return params;
    }

    private List<HttpParameter> validateAndCreateApplicationListParameters(TwitterApplicationList twitterApplicationList) {
        List<HttpParameter> params = new ArrayList<>();
        if (TwitterAdUtil.isNotNullOrEmpty(twitterApplicationList.getName())) {
            params.add(new HttpParameter(PARAM_NAME, twitterApplicationList.getName()));
        }
        if (TwitterAdUtil.isNotEmpty(twitterApplicationList.getApps())) {
            List<TwitterApplicationDetails> apps = twitterApplicationList.getApps();
            List<String> appIdentifiers = Lists.newArrayList();
            for (TwitterApplicationDetails twitterApplicationDetails : apps) {
                if (TwitterAdUtil.isNotNullOrEmpty(twitterApplicationDetails.getAppIdentifier())) {
                    appIdentifiers.add(twitterApplicationDetails.getAppIdentifier());
                }
            }
            if (TwitterAdUtil.isNotEmpty(appIdentifiers)) {
                params.add(new HttpParameter(PARAM_APP_STORE_IDENTIFIERS, TwitterAdUtil.getCsv(appIdentifiers)));
            }
        }
        return params;
    }
}
