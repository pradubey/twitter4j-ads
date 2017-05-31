package twitter4j;

import java.util.concurrent.TimeUnit;

/**
 * User: poly
 * Date: 12/02/14
 * Time: 11:52 AM
 */
public interface TwitterAdsConstants {

    String V1_PREFIX_STATS_ACCOUNTS_URI = "1/stats/accounts/";
    String V1_PREFIX_STATS_JOB_ACCOUNTS_URI = "1/stats/jobs/accounts/";

    String PREFIX_ACCOUNTS_V1 = "1/accounts/";
    String TWEET_PREVIEW_PATH = "/tweet/preview/";
    String UPLOAD_MEDIA_URL = "1.1/media/";
    String UPLOAD_JSON = "upload.json";
    String PREFIX_BATCH_ACCOUNTS_V1 = "1/batch/accounts/";
    String PREFIX_VIDEOS = "/videos";
    String PREFIX_STATS_ACCOUNTS_URI = "1/stats/accounts/";
    String PARAM_WITH_DELETED = "with_deleted";
    String GRANULARITY = "granularity";
    String PARAM_FUNDING_INSTRUMENT_IDS = "funding_instrument_ids";
    String PARAM_CAMPAIGN_IDS = "campaign_ids";
    String PARAM_LINE_ITEM_IDS = "line_item_ids";
    String PARAM_LINE_ITEM_ID = "line_item_id";
    String PARAM_ACCOUNT_MEDIA_ID = "account_media_id";
    String PARAM_MEDIA_IDS = "media_ids";
    String PARAM_LANDING_URL = "landing_url";
    String PARAM_TV_MARKET_LOCALE = "tv_market_locale ";
    String PARAM_COUNT = "count";
    String PARAM_CURSOR = "cursor";
    String PARAM_SORT_BY = "sort_by";
    String PARAM_Q = "q";
    String PARAM_COUNTRY_CODE = "country_code";
    String PARAM_LOCATION_TYPE = "location_type";
    String PARAM_TARGETING_TYPE = "targeting_type";
    String PARAM_TARGETING_VALUE = "targeting_value";
    String PARAM_TAILORED_AUDIENCE_EXPANSION = "tailored_audience_expansion";
    String PARAM_TAILORED_AUDIENCE_TYPE = "tailored_audience_type";
    String PARAM_PROMOTED_ACCOUNTS_IDS = "promoted_account_ids";
    String PARAM_ACCOUNT_ID = "account_id";
    String PARAM_CALL_TO_ACTION = "call_to_action";
    String PARAM_CALL_TO_ACTION_URL = "call_to_action_url";
    String PARAM_CREATIVE_TYPE = "creative_type";
    String PARAM_CURRENCY = "currency";
    String PARAM_TWEET_IDS = "tweet_ids";
    String PARAM_TWEET_ID = "tweet_id";
    String PARAM_USER_ID = "user_id";
    String PARAM_AS_USER_ID = "as_user_id";
    String PARAM_USER_IDS = "user_ids";
    String PARAM_SCOPED_TO = "scoped_to";
    String PARAM_DAILY_BUDGET_AMOUNT_LOCAL_MICRO = "daily_budget_amount_local_micro";
    String PARAM_TOTAL_BUDGET_AMOUNT_LOCAL_MICRO = "total_budget_amount_local_micro";
    String PARAM_STANDARD_DELIVERY = "standard_delivery";
    String PARAM_FREQUENCY_CAP = "frequency_cap";
    String PARAM_DURATION_IN_DAYS = "duration_in_days";
    String PARAM_PAUSED = "paused";
    String PARAM_END_TIME = "end_time";
    String PARAM_START_TIME = "start_time";
    String PARAM_FUNDING_INSTRUMENT_ID = "funding_instrument_id";
    String PARAM_NAME = "name";
    String PARAM_CAMPAIGN_ID = "campaign_id";
    String PARAM_BID_AMOUNT_LOCAL_MICRO = "bid_amount_local_micro";
    String PARAM_BID_TYPE = "bid_type";
    String PARAM_BID_UNIT = "bid_unit";
    String PARAM_CHARGE_BY = "charge_by";
    String AUTOMATICALLY_SELECT_BID = "automatically_select_bid";
    String PARAM_PLACEMENT_TYPE = "placement_type";
    String PARAM_PRODUCT_TYPE = "product_type";
    String PARAM_PLACEMENTS = "placements";
    String PARAM_MATCH_RELEVANT_POPULAR_QUERIES = "match_relevant_popular_queries";
    String PARAM_OBJECTIVE = "objective";
    String CURRENCY = "currency";
    String CAMPAIGN_DAILY_BUDGET_AMOUNT_LOCAL_MICRO = "campaign_daily_budget_amount_local_micro";
    String BID_AMOUNT_LOCAL_MICRO = "bid_amount_local_micro";

    String BID_TYPE = "bid_type";
    String PARAM_INCLUDE_SENTIMENT = "include_sentiment";
    String PARAM_AUTOMATICALLY_SELECT_TWEET = "automatically_select_tweets";
    String PARAM_SUGGESTION_TYPE = "suggestion_type";
    String PARAM_IGNORED_VALUES = "ignored_values";
    String PARAM_TARGETING_VALUES = "targeting_values";
    String PARAM_LOCATIONS = "locations";
    String PARAM_FOLLOWERS_OF_USERS = "followers_of_users";
    String PARAM_SIMILAR_TO_FOLLOWERS_OF_USERS = "similar_to_followers_of_users";
    String PARAM_INTERESTS = "interests";
    String PARAM_PLATFORMS = "platforms";
    String PARAM_PLATFORM_VERSIONS = "platform_versions";
    String PARAM_DEVICES = "devices";
    String PARAM_WIFI_ONLY = "wifi_only";
    String PARAM_GENDER = "gender";
    String PARAM_BRAND = "brand";
    String PARAM_TV_SHOWS = "tv_shows";
    String PARAM_TV_CHANNEL = "tv_channels";
    String PARAM_TV_GENRE = "tv_genres";
    String PARAM_NETWORK_OPERATOR = "network_operators";
    String PARAM_TV_MARKET = "tv_market_locale";
    String PARAM_BROAD_KEYWORDS = "broad_keywords";
    String PARAM_EXACT_KEYWORDS = "exact_keywords";
    String PARAM_UNORDERED_KEYWORDS = "unordered_keywords";
    String PARAM_PHRASE_KEYWORDS = "phrase_keywords";
    String PARAM_NEGATIVE_EXACT_KEYWORDS = "negative_exact_keywords";
    String PARAM_NEGATIVE_UNORDERED_KEYWORDS = "negative_unordered_keywords";
    String PARAM_NEGATIVE_PHRASE_KEYWORDS = "negative_phrase_keywords";
    String PARAM_TAILORED_AUDIENCES = "tailored_audiences";
    String PARAM_TAILORED_AUDIENCES_EXPANDED = "tailored_audiences_expanded";
    String PARAM_TAILORED_AUDIENCES_EXCLUDED = "tailored_audiences_excluded";
    String PARAM_LANGUAGES = "languages";
    String PARAM_AGE_RANGE = "age_buckets";
    String PARAM_BEHAVIOR = "behaviors";
    String PARAM_NEGATIVE_BEHAVIOR = "negative_behaviors";
    String PARAM_BEHAVIOR_EXPANDED = "behaviors_expanded";
    String PARAM_CARD_IDS = "card_ids";
    String PARAM_CARD_ID = "card_id";
    String PARAM_APP_COUNTRY_CODE = "app_country_code";
    String PARAM_IPHONE_APP_ID = "iphone_app_id";
    String PARAM_IPAD_APP_ID = "ipad_app_id";
    String PARAM_GOOGLEPLAY_APP_ID = "googleplay_app_id";
    String PARAM_IPHONE_DEEP_LINK = "iphone_deep_link";
    String PARAM_IPAD_DEEP_LINK = "ipad_deep_link";
    String PARAM_GOOGLEPLAY_DEEP_LINK = "googleplay_deep_link";
    String PARAM_CUSTOM_ICON = "custom_icon";
    String PARAM_CUSTOM_ICON_DATA = "custom_icon_data";
    String PARAM_CUSTOM_APP_DESCRIPTION = "custom_app_description";
    String PARAM_WIDE_APP_IMAGE = "wide_app_image";
    String PARAM_WIDE_APP_IMAGE_DATA = "wide_app_image_data";
    String PARAM_WIDE_APP_IMAGE_MEDIA_ID = "wide_app_image_media_id";
    String PARAM_CUSTOM_ICON_MEDIA_ID = "custom_icon_media_id";
    String APP_CTA = "app_cta";
    String PARAM_COUNTRY = "country";
    String PARAM_PLATFORM = "platform";
    String PARAM_PROMOTED_TWEET_IDS="promoted_tweet_ids";
    String PARAM_PRIMARY_WEB_EVENT_TAG = "primary_web_event_tag";
    String PATH_FEATURES = "/features";

    String PARAM_METRIC_GROUPS = "metric_groups";
    String PARAM_ENTITY_TYPE = "entity";
    String PARAM_JOB_IDS = "job_ids";
    String PARAM_ENTITY_IDS = "entity_ids";
    String PARAM_PLACEMENT = "placement";
    /**
     * For Twitter Audience Platform
     */
    String PATH_IAB_CATEGORIES = "1/iab_categories/";
    String PATH_APP_LIST = "/app_lists/";
    String PARAM_ADVERTISER_DOMAIN = "advertiser_domain";
    String PARAM_CATEGORIES = "categories";
    String PARAM_APP_STORE_IDENTIFIERS = "app_store_identifiers";
    String PARAM_EXCLUDE_APP_LIST_IDENTIFIER = "exclude_app_list";

    //Added for Tweet engagement retargeting
    String PARAM_ENGAGEMENT_TYPE = "engagement_type";
    String PARAM_USER_ENGAGEMENT = "user_engagement";
    String PARAM_CAMPAIGN_ENGAGEMENT = "campaign_engagement";

    String PARAM_APP_STORE_CATEGORY = "app_store_categories";
    String PARAM_APP_STORE_CATEGORY_LOOKALIKE = "app_store_categories_lookalike";

    String PARAM_EVENT = "event";

    //Added for Network activation targeting
    String PARAM_NETWORK_ACTIVATION_DURATION_LT = "network_activation_duration_lt";
    String PARAM_NETWORK_ACTIVATION_DURATION_GTE = "network_activation_duration_gte";

    /**
     * for website cards
     */
    String PARAM_WEBSITE_URL = "website_url";
    String PARAM_WEBSITE_TITLE = "website_title";
    String PARAM_WEBSITE_CTA = "website_cta";
    String PARAM_IMAGE = "image";
    String PARAM_IMAGE_DATA = "image_data";
    String PARAM_IMAGE_MEDIA_ID = "image_media_id";
    /**
     * for lead generation cards
     */
    String PARAM_TITLE = "title";
    String PARAM_CTA = "cta";
    String PARAM_FALLBACK_URL = "fallback_url";
    String PARAM_PRIVACY_POLICY_URL = "privacy_policy_url";
    String PARAM_SUBMIT_URL = "submit_url";
    String PARAM_SUBMIT_METHOD = "submit_method";
    String PARAM_CUSTOM_KEY_SCREEN_NAME = "custom_key_screen_name";
    String PARAM_CUSTOM_KEY_NAME = "custom_key_name";
    String PARAM_CUSTOM_KEY_EMAIL = "custom_key_email";
    /*
     for video app download card
     */
    String VIDEOS = "videos";
    String PARAM_VIDEO_ID = "video_id";
    String PARAM_VIDEO_MEDIA_ID = "video_media_id";
    String PARAM_VIDEO_IDS = "video_ids";
    String PARAM_COMMAND = "command";
    String PARAM_MEDIA_ID = "media_id";
    String PARAM_MEDIA_DATA = "media_data";
    String PARAM_MEDIA_TYPE = "media_type";
    String PARAM_MEDIA_CATEGORY = "media_category";
    String PARAM_TOTAL_BYTES = "total_bytes";
    String PARAM_SEGMENT_INDEX = "segment_index";
    String STATE_SUCCEEDED = "succeeded";
    String STATE_IN_PROGRESS = "in_progress";

    /*
    for promoted video tweet
     */
    String PARAM_STATUS = "status";
    String TWEET_PREVIEW_TARGET = "preview_target";
    String PARAM_VIDEO_TITLE = "video_title";
    String PARAM_VIDEO_DESCRIPTION = "video_description";
    String PARAM_VIDEO_CTA = "video_cta";
    String PARAM_VIDEO_CTA_VALUE = "video_cta_value";


    Long MAX_VIDEO_SIZE_IN_BYTES = (long) 524277511; // 500 MB.
    Long MAX_CHUNK_SIZE_IN_BYTES = (long) 5242880;
    int CHUNK_SIZE_IN_BYTES = 4000000;
    int SUCCESSFULL_CALL_BEGIN_CODE = 200;
    int SUCCESSFULL_CALL_END_CODE = 299;
    long MAX_WAIT_TIME_TRANSCODING = TimeUnit.MINUTES.toMillis(1);
    long WAIT_INTERVAL_TRANSCODING = TimeUnit.SECONDS.toMillis(5);
    long MAX_WAIT_TIME = TimeUnit.MINUTES.toMillis(10);
    long WAIT_INTERVAL = TimeUnit.MINUTES.toMillis(1);
    long WAIT_INTERVAL_MEDIA_UPLOAD = TimeUnit.MINUTES.toMillis(5);
    long SIXTY_FOUR_MB = 64 * 1024 * 1024;

    /**
     * for lead generation card stat
     */

    String PARAM_GRANULARITY = "granularity";
    String PARAM_METRICS = "metrics";

    String PARAM_SEGMENTATION_TYPE = "segmentation_type";

    String SEGMENTATION_TYPE_PLATFORMS = "PLATFORMS";
    String SEGMENTATION_TYPE_LOCATIONS = "LOCATIONS";
    String SEGMENTATION_TYPE_GENDER = "GENDER";
    String SEGMENTATION_TYPE_INTERESTS = "INTERESTS";
    String SEGMENTATION_TYPE_KEYWORDS = "KEYWORDS";
    String SEGMENTATION_TYPE_CITIES = "CITIES";
    String SEGMENTATION_TYPE_REGIONS = "REGIONS";
    String SEGMENTATION_TYPE_POSTAL_CODES = "POSTAL_CODES";
    String SEGMENTATION_TYPE_DEVICES = "DEVICES";
    String SEGMENTATION_TYPE_PLATFORM_VERSIONS = "PLATFORM_VERSIONS";

    String PATH_CAMPAIGN = "/campaigns/";
    String PATH_FUNDING_INSTRUMENTS = "/funding_instruments/";
    String PATH_BIDDING_RULES = "1/bidding_rules";
    String PATH_PROMOTED_TWEETS = "/promoted_tweets/";
    String PATH_PROMOTED_ACCOUNTS = "/promoted_accounts/";
    String PATH_PROMOTABLE_USERS = "/promotable_users/";
    String PATH_REACH_ESTIMATE = "/reach_estimate/";
    String PATH_LINE_ITEMS = "/line_items/";
    String PATH_TARGETING_CRITERIA = "/targeting_criteria/";
    String PATH_TARGETING_CRITERIA_LOCATION = "1/targeting_criteria/locations";
    String PATH_TARGETING_CRITERIA_INTERESTS = "1/targeting_criteria/interests";
    String PATH_TARGETING_CRITERIA_PLATFORMS = "1/targeting_criteria/platforms";
    String PATH_TARGETING_CRITERIA_PLATFORM_VERSIONS = "1/targeting_criteria/platform_versions";
    String PATH_TARGETING_CRITERIA_DEVICES = "1/targeting_criteria/devices";
    String PATH_TARGETING_CRITERIA_APP_STORE_CATEGORIES = "1/targeting_criteria/app_store_categories";
    String PATH_TARGETING_CRITERIA_NETWORK_OPERATORS = "1/targeting_criteria/network_operators/";
    String PATH_TARGETING_CRITERIA_EVENT = "1/targeting_criteria/events";
    String PATH_TARGETING_LANGUAGES = "1/targeting_criteria/languages";
    String PATH_TAILORED_AUDIENCES = "/tailored_audiences";
    String PATH_TARGETING_SUGGESTIONS = "/targeting_suggestions/";
    String PATH_TV_SHOWS = "1/targeting_criteria/tv_shows/";
    String PATH_TV_MARKETS = "1/targeting_criteria/tv_markets/";
    String PATH_TV_CHANNELS = "1/targeting_criteria/tv_channels/";
    String PATH_TV_GENRES = "1/targeting_criteria/tv_genres/";
    String PATH_BEHAVIORS = "1/targeting_criteria/behaviors/";
    String PATH_BEHAVIORS_TAXONOMY = "1/targeting_criteria/behavior_taxonomies/";
    String PATH_APP_DOWNLOAD_CARDS = "/cards/app_download/";
    String PATH_IMAGE_APP_DOWNLOAD_CARDS = "/cards/image_app_download/";
    String PATH_VIDEO_APP_DOWNLOAD_CARDS = "/cards/video_app_download/";
    String PATH_WEBSITE_CARDS = "/cards/website/";
    String PATH_LEAD_GENERATION_CARDS = "/cards/lead_gen/";
    String PATH_SCOPED_TIMELINE = "/scoped_timeline/";
    String PATH_ACCOUNT_MEDIA = "/account_media";
    String PATH_MEDIA_CREATIVES = "/media_creatives";
    String PRE_ROLL_CALL_TO_ACTION = "/preroll_call_to_actions";

    String PATH_PROMOTED_VIDEO_TWEET = "/tweet";
    String PATH_ACCOUNTS = "accounts/";
    String PATH_TAILORED_AUDIENCE = "/tailored_audiences/";
    String PATH_TAILORED_AUDIENCE_CHANGES = "/tailored_audience_changes/";
    String PATH_TAILORED_AUDIENCE_GLOBAL_OPT_OUT = "/tailored_audiences/global_opt_out";

    String POST_TON_DATA = "https://ton.twitter.com/1.1/ton/bucket/ta_partner";
    String POST_TON_DATA_VIDEO = "https://ton.twitter.com/1.1/ton/bucket/pro_video_api";
    String VIDEO_CARD_URL = "https://video.twitter.com/api/v1/video_tweets";
    String UPLOAD_VIDEO_CARD_IMAGE_URL = "https://video.twitter.com/api/v1/images";
    String UPLOAD_VIDEO_FOR_VIDEO_CARD = "https://video.twitter.com/api/v1/videos";
    String TON_URL = "https://ton.twitter.com";

    String DEMO = "/tweet_box/create_tweet";


    String PARAM_MEDIA = "media";
    String PARAM_MEDIA_VIDEO_ID = "video_media_id";
    String PARAM_DESCRIPTION = "description";

    /**
     * for web event tags
     */

    String PARAM_CLICK_WINDOW = "click_window";
    String PARAM_VIEW_THROUGH_WINDOW = "view_through_window";
    String PARAM_TYPE = "type";
    String PARAM_RETARGETING_ENABLED = "retargeting_enabled";

    String PATH_WEB_EVENT_TAGS = "/web_event_tags/";

    String PATH_ORGANIC_TWEETS_STATS ="/organic_tweets";

    String PATH_REACH_STATS = "/reach/campaigns/";

    /**
     * for Twitter preview
     */

    String TWEET_PATH_PREVIEW = "/tweet/preview/";
    String PARAM_PREVIEW_TARGET = "preview_target";
}
