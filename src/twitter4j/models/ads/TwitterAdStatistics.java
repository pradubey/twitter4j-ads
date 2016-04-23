package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;
import twitter4j.models.Granularity;
import twitter4j.models.Segment;

import java.util.Arrays;
import java.util.Date;

/**
 * User: Roota
 * Date: 17/02/14.
 */
public class TwitterAdStatistics extends TwitterEntity {
    public static final String SEGMENT = "segment";
    public static final String GRANULARITY = "granularity";
    public static final String START_TIME = "start_time";
    public static final String END_TIME = "end_time";

    public static final String PROMOTED_ACCOUNT_FOLLOW_RATE = "promoted_account_follow_rate";
    public static final String PROMOTED_ACCOUNT_IMPRESSIONS = "promoted_account_impressions";
    public static final String PROMOTED_ACCOUNT_PROFILE_VISITS = "promoted_account_profile_visits";
    public static final String PROMOTED_ACCOUNT_FOLLOWS = "promoted_account_follows";

    public static final String PROMOTED_TWEET_SEARCH_CLICKS = "promoted_tweet_search_clicks";
    public static final String PROMOTED_TWEET_SEARCH_URL_CLICKS = "promoted_tweet_search_url_clicks";
    public static final String PROMOTED_TWEET_SEARCH_IMPRESSIONS = "promoted_tweet_search_impressions";
    public static final String PROMOTED_TWEET_SEARCH_FOLLOWS = "promoted_tweet_search_follows";
    public static final String PROMOTED_TWEET_SEARCH_ENGAGEMENTS = "promoted_tweet_search_engagements";
    public static final String PROMOTED_TWEET_SEARCH_CARD_ENGAGEMENTS = "promoted_tweet_search_card_engagements";
    public static final String PROMOTED_TWEET_SEARCH_ENGAGEMENT_RATE = "promoted_tweet_search_engagement_rate";
    public static final String PROMOTED_TWEET_SEARCH_REPLIES = "promoted_tweet_search_replies";
    public static final String PROMOTED_TWEET_SEARCH_RETWEETS = "promoted_tweet_search_retweets";
    public static final String PROMOTED_TWEET_SEARCH_FAVOURITES = "promoted_tweet_search_favorites";
    public static final String PROMOTED_TWEET_SEARCH_QUALIFIED_IMPRESSIONS = "promoted_tweet_search_qualified_impressions";

    public static final String PROMOTED_TWEET_TIMELINE_CLICKS = "promoted_tweet_timeline_clicks";
    public static final String PROMOTED_TWEET_TIMELINE_URL_CLICKS = "promoted_tweet_timeline_url_clicks";
    public static final String PROMOTED_TWEET_TIMELINE_IMPRESSIONS = "promoted_tweet_timeline_impressions";
    public static final String PROMOTED_TWEET_TIMELINE_FOLLOWS = "promoted_tweet_timeline_follows";
    public static final String PROMOTED_TWEET_TIMELINE_ENGAGEMENTS = "promoted_tweet_timeline_engagements";
    public static final String PROMOTED_TWEET_TIMELINE_CARD_ENGAGEMENTS = "promoted_tweet_timeline_card_engagements";
    public static final String PROMOTED_TWEET_TIMELINE_ENGAGEMENT_RATE = "promoted_tweet_timeline_engagement_rate";
    public static final String PROMOTED_TWEET_TIMELINE_REPLIES = "promoted_tweet_timeline_replies";
    public static final String PROMOTED_TWEET_TIMELINE_RETWEETS = "promoted_tweet_timeline_retweets";
    public static final String PROMOTED_TWEET_TIMELINE_FAVOURITES = "promoted_tweet_timeline_favorites";
    public static final String PROMOTED_TWEET_TIMELINE_QUALIFIED_IMPRESSIONS = "promoted_tweet_timeline_qualified_impressions";

    public static final String PROMOTED_TWEET_PROFILE_CLICKS = "promoted_tweet_profile_clicks";
    public static final String PROMOTED_TWEET_PROFILE_URL_CLICKS = "promoted_tweet_profile_url_clicks";
    public static final String PROMOTED_TWEET_PROFILE_IMPRESSIONS = "promoted_tweet_profile_impressions";
    public static final String PROMOTED_TWEET_PROFILE_FOLLOWS = "promoted_tweet_profile_follows";
    public static final String PROMOTED_TWEET_PROFILE_ENGAGEMENTS = "promoted_tweet_profile_engagements";
    public static final String PROMOTED_TWEET_PROFILE_CARD_ENGAGEMENTS = "promoted_tweet_profile_card_engagements";
    public static final String PROMOTED_TWEET_PROFILE_ENGAGEMENT_RATE = "promoted_tweet_profile_engagement_rate";
    public static final String PROMOTED_TWEET_PROFILE_REPLIES = "promoted_tweet_profile_replies";
    public static final String PROMOTED_TWEET_PROFILE_RETWEETS = "promoted_tweet_profile_retweets";
    public static final String PROMOTED_TWEET_PROFILE_FAVORITES = "promoted_tweet_profile_favorites";
    public static final String PROMOTED_TWEET_PROFILE_QUALIFIED_IMPRESSIONS = "promoted_tweet_profile_qualified_impressions";

    public static final String PROMOTED_TWEET_TPN_CLICKS = "promoted_tweet_tpn_clicks";
    public static final String PROMOTED_TWEET_TPN_URL_CLICKS = "promoted_tweet_tpn_url_clicks";
    public static final String PROMOTED_TWEET_TPN_ENGAGEMENTS = "promoted_tweet_tpn_engagements";
    public static final String PROMOTED_TWEET_TPN_FOLLOWS = "promoted_tweet_tpn_follows";
    public static final String PROMOTED_TWEET_TPN_IMPRESSIONS = "promoted_tweet_tpn_impressions";
    public static final String PROMOTED_TWEET_TPN_REPLIES = "promoted_tweet_tpn_replies";
    public static final String PROMOTED_TWEET_TPN_RETWEETS = "promoted_tweet_tpn_retweets";
    public static final String PROMOTED_TWEET_TPN_FAVORITES = "promoted_tweet_tpn_favorites";
    public static final String PROMOTED_TWEET_TPN_ENGAGEMENT_RATE = "promoted_tweet_tpn_engagement_rate";
    public static final String PROMOTED_TWEET_TPN_CARD_ENGAGEMENTS = "promoted_tweet_tpn_card_engagements";
    public static final String PROMOTED_TWEET_TPN_QUALIFIED_IMPRESSIONS = "promoted_tweet_tpn_qualified_impressions";

    public static final String PROMOTED_TWEET_TIMELINE_MEDIA_VIEWS = "promoted_tweet_timeline_media_views";
    public static final String PROMOTED_TWEET_SEARCH_MEDIA_VIEWS = "promoted_tweet_search_media_views";
    public static final String PROMOTED_TWEET_PROFILE_MEDIA_VIEWS = "promoted_tweet_profile_media_views";
    public static final String PROMOTED_TWEET_TPN_MEDIA_VIEWS = "promoted_tweet_tpn_media_views";

    public static final String BILLED_FOLLOWS = "billed_follows";
    public static final String BILLED_ENGAGEMENTS = "billed_engagements";
    public static final String ESTIMATED_CHARGE_LOCAL_MICRO = "estimated_charge_local_micro";
    public static final String BILLED_CHARGE_LOCAL_MICRO = "billed_charge_local_micro";

    public static final String CONVERSION_SITE_VISITS = "conversion_site_visits";
    public static final String CONVERSION_DOWNLOADS = "conversion_downloads";
    public static final String CONVERSION_PURCHASES = "conversion_purchases";
    public static final String CONVERSION_SIGN_UPS = "conversion_sign_ups";
    public static final String CONVERSION_CUSTOM = "conversion_custom";
    public static final String CONVERSION_APP_OPEN = "conversion_app_open";
    public static final String CONVERSION_KEY_PAGE_VIEWS = "conversion_key_page_views";
    public static final String CONVERSION_ORDER_QUANTITY = "conversion_order_quantity";
    public static final String CONVERSION_SALE_AMOUNT = "conversion_sale_amount";

    public static final String PROMOTION_CARD_RESPONSES = "promotion_card_responses";
    public static final String PROMOTED_TWEET_APP_INSTALL_ATTEMPTS = "promoted_tweet_app_install_attempts";
    public static final String PROMOTED_TWEET_APP_OPEN_ATTEMPTS = "promoted_tweet_app_open_attempts";
    public static final String PROMOTED_TWEET_APP_OPEN_ATTEMPTS_BREAKDOWN = "promoted_tweet_app_open_attempts_breakdown";
    public static final String PROMOTED_TWEET_APP_INSTALL_ATTEMPTS_BREAKDOWN = "promoted_tweet_app_install_attempts_breakdown";

    public static final String PROMOTED_VIDEO_TOTAL_VIEWS = "promoted_video_total_views";
    public static final String PROMOTED_VIDEO_REPLAYS = "promoted_video_replays";
    public static final String PROMOTED_VIDEO_VIEWS_100 = "promoted_video_views_100";
    public static final String PROMOTED_VIDEO_VIEWS_75 = "promoted_video_views_75";
    public static final String PROMOTED_VIDEO_VIEWS_50 = "promoted_video_views_50";
    public static final String PROMOTED_VIDEO_VIEWS_25 = "promoted_video_views_25";
    public static final String PROMOTED_VIDEO_CTA_CLICKS = "promoted_video_cta_clicks";

    public static final String MOBILE_CONVERSION_INSTALLS = "mobile_conversion_installs";
    public static final String MOBILE_CONVERSION_TUTORIAL_COMPLETED = "mobile_conversion_tutorial_completes";
    public static final String MOBILE_CONVERSION_RESERVATIONS = "mobile_conversion_reservations";
    public static final String MOBILE_CONVERSION_ADD_TO_CART = "mobile_conversion_add_to_cart";
    public static final String MOBILE_CONVERSION_ADD_TO_WISHLIST = "mobile_conversion_add_to_wishlist";
    public static final String MOBILE_CONVERSION_CHECKOUT_INITIATED = "mobile_conversion_checkout_initiated";
    public static final String MOBILE_CONVERSION_SEARCHES = "mobile_conversion_searches";
    public static final String MOBILE_CONVERSION_LEVEL_ACHIEVED = "mobile_conversion_level_achieved";
    public static final String MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED = "mobile_conversion_achievement_unlocked";
    public static final String MOBILE_CONVERSION_CONTENT_VIEWS = "mobile_conversion_content_views";
    public static final String MOBILE_CONVERSION_SHARES = "mobile_conversion_shares";
    public static final String MOBILE_CONVERSION_INVITES = "mobile_conversion_invites";
    public static final String MOBILE_CONVERSION_ADDED_PAYMENT_INFOS = "mobile_conversion_added_payment_infos";
    public static final String MOBILE_CONVERSION_SPENT_CREDITS = "mobile_conversion_spent_credits";
    public static final String MOBILE_CONVERSION_RATED = "mobile_conversion_rated";
    public static final String MOBILE_CONVERSION_LOGINS = "mobile_conversion_logins";
    public static final String MOBILE_CONVERSION_RE_ENGAGES = "mobile_conversion_re_engages";
    public static final String MOBILE_CONVERSION_SIGN_UPS = "mobile_conversion_sign_ups";
    public static final String MOBILE_CONVERSION_PURCHASES = "mobile_conversion_purchases";
    public static final String MOBILE_CONVERSION_UPDATES = "mobile_conversion_updates";
    public static final String MOBILE_CONVERSION_SALE_AMOUNT_LOCAL_MICRO = "mobile_conversion_sale_amount_local_micro";
    public static final String MOBILE_CONVERSION_ORDER_QUANTITY = "mobile_conversion_order_quantity";

    public static final String MOBILE_LIFETIME_VALUE_CONVERSION_BREAKDOWN = "mobile_lifetime_value_conversion_breakdown";
    public static final String MOBILE_LIFETIME_VALUE_CONVERSION_SALE_AMOUNT_LOCAL_MICRO_BREAKDOWN = "mobile_lifetime_value_conversion_sale_amount_local_micro_breakdown";
    public static final String MOBILE_LIFETIME_VALUE_CONVERSION_ORDER_QUANTITY_BREAKDOWN = "mobile_lifetime_value_conversion_order_quantity_breakdown";

    public static final String MOBILE_CONVERSION_INVITES_BREAKDOWN = "mobile_conversion_invites_breakdown";
    public static final String MOBILE_CONVERSION_RE_ENGAGES_BREAKDOWN = "mobile_conversion_re_engages_breakdown";
    public static final String MOBILE_CONVERSION_ADD_TO_CART_BREAKDOWN = "mobile_conversion_add_to_cart_breakdown";
    public static final String MOBILE_CONVERSION_CONTENT_VIEWS_BREAKDOWN = "mobile_conversion_content_views_breakdown";
    public static final String MOBILE_CONVERSION_SPENT_CREDITS_BREAKDOWN = "mobile_conversion_spent_credits_breakdown";
    public static final String MOBILE_CONVERSION_SHARES_BREAKDOWN = "mobile_conversion_shares_breakdown";
    public static final String MOBILE_CONVERSION_SEARCHES_BREAKDOWN = "mobile_conversion_searches_breakdown";
    public static final String MOBILE_CONVERSION_ADDED_PAYMENT_INFOS_BREAKDOWN = "mobile_conversion_added_payment_infos_breakdown";
    public static final String MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED_BREAKDOWN = "mobile_conversion_achievement_unlocked_breakdown";
    public static final String MOBILE_CONVERSION_ADD_TO_WISHLIST_BREAKDOWN = "mobile_conversion_add_to_wishlist_breakdown";
    public static final String MOBILE_CONVERSION_LEVEL_ACHIEVED_BREAKDOWN = "mobile_conversion_level_achieved_breakdown";
    public static final String MOBILE_CONVERSION_RESERVATIONS_BREAKDOWN = "mobile_conversion_reservations_breakdown";
    public static final String MOBILE_CONVERSION_SIGN_UPS_BREAKDOWN = "mobile_conversion_sign_ups_breakdown";
    public static final String MOBILE_CONVERSION_LOGINS_BREAKDOWN = "mobile_conversion_logins_breakdown";
    public static final String MOBILE_CONVERSION_RATED_BREAKDOWN = "mobile_conversion_rated_breakdown";
    public static final String MOBILE_CONVERSION_UPDATES_BREAKDOWN = "mobile_conversion_updates_breakdown";
    public static final String MOBILE_CONVERSION_CHECKOUT_INITIATED_BREAKDOWN = "mobile_conversion_checkout_initiated_breakdown";
    public static final String MOBILE_CONVERSION_INSTALLS_BREAKDOWN = "mobile_conversion_installs_breakdown";
    public static final String MOBILE_CONVERSION_PURCHASES_BREAKDOWN = "mobile_conversion_purchases_breakdown";
    public static final String MOBILE_CONVERSION_TUTORIAL_COMPLETES_BREAKDOWN = "mobile_conversion_tutorial_completes_breakdown";

    public static final String CAMPAIGN_TOTAL_AUDIENCE_REACH = "total_audience_reach";
    public static final String CAMPAIGN_AVERAGE_FREQUENCY = "average_frequency";

    @SerializedName(SEGMENT)
    private Segment segment;

    @SerializedName(GRANULARITY)
    private Granularity granularity;

    @SerializedName(START_TIME)
    private Date startTime;

    @SerializedName(END_TIME)
    private Date endTime;

    @SerializedName(MOBILE_CONVERSION_TUTORIAL_COMPLETED)
    private String[] mobileConversionTutorialsCompleted;

    @SerializedName(MOBILE_CONVERSION_RESERVATIONS)
    private String[] mobileConversionReservations;

    @SerializedName(MOBILE_CONVERSION_ADD_TO_CART)
    private String[] mobileConversionAddToCart;

    @SerializedName(MOBILE_CONVERSION_ADD_TO_WISHLIST)
    private String[] mobileConversionAddToWishList;

    @SerializedName(MOBILE_CONVERSION_CHECKOUT_INITIATED)
    private String[] mobileConversionCheckoutInitiated;

    @SerializedName(MOBILE_CONVERSION_SEARCHES)
    private String[] mobileConversionSearches;

    @SerializedName(CONVERSION_SALE_AMOUNT)
    private String[] conversionSaleAmount;

    @SerializedName(CONVERSION_ORDER_QUANTITY)
    private String[] conversionOrderQuantity;

    @SerializedName(CONVERSION_KEY_PAGE_VIEWS)
    private String[] conversionKeyPageViews;

    @SerializedName(MOBILE_CONVERSION_LEVEL_ACHIEVED)
    private String[] mobileConversionLevelAchieved;

    @SerializedName(MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED)
    private String[] mobileConversionAchievementUnlocked;

    @SerializedName(MOBILE_CONVERSION_CONTENT_VIEWS)
    private String[] mobileConversionContentViews;

    @SerializedName(MOBILE_CONVERSION_SHARES)
    private String[] mobileConversionShares;

    @SerializedName(MOBILE_CONVERSION_INVITES)
    private String[] mobileConversionInvites;

    @SerializedName(MOBILE_CONVERSION_ADDED_PAYMENT_INFOS)
    private String[] mobileConversionAddedPaymentInfos;

    @SerializedName(MOBILE_CONVERSION_SPENT_CREDITS)
    private String[] mobileConversionSpentCredits;

    @SerializedName(MOBILE_CONVERSION_RATED)
    private String[] mobileConversionSpentRated;

    @SerializedName(MOBILE_CONVERSION_INSTALLS)
    private String[] mobileConversionInstalls;

    @SerializedName(MOBILE_CONVERSION_LOGINS)
    private String[] mobileConversionLogins;

    @SerializedName(MOBILE_CONVERSION_RE_ENGAGES)
    private String[] mobileConversionReEngages;

    @SerializedName(MOBILE_CONVERSION_SIGN_UPS)
    private String[] mobileConversionSignUps;

    @SerializedName(MOBILE_CONVERSION_PURCHASES)
    private String[] mobileConversionPurchases;

    @SerializedName(PROMOTED_TWEET_APP_INSTALL_ATTEMPTS)
    private String[] promotedTweetAppInstallAttempts;

    @SerializedName(PROMOTED_TWEET_APP_OPEN_ATTEMPTS)
    private String[] promotedTweetAppOpenAttempts;

    @SerializedName(PROMOTED_TWEET_SEARCH_CARD_ENGAGEMENTS)
    private String[] promotedTweetSearchCardEngagements;

    @SerializedName(PROMOTED_TWEET_TIMELINE_CARD_ENGAGEMENTS)
    private String[] promotedTweetTimelineCardEngagements;

    @SerializedName(PROMOTED_TWEET_PROFILE_CARD_ENGAGEMENTS)
    private String[] promotedTweetProfileCardEngagements;

    @SerializedName(CONVERSION_SIGN_UPS)
    private String[] conversionSignUps;

    @SerializedName(CONVERSION_PURCHASES)
    private String[] conversionPurchases;

    @SerializedName(PROMOTED_ACCOUNT_FOLLOW_RATE)
    private String[] promotedAccountFollowRate;

    @SerializedName(BILLED_CHARGE_LOCAL_MICRO)
    private String[] billedChargeMicro;

    @SerializedName(ESTIMATED_CHARGE_LOCAL_MICRO)
    private String[] estimatedChargeMicro;

    @SerializedName(PROMOTED_TWEET_SEARCH_CLICKS)
    private String[] promotedTweetSearchClicks;

    @SerializedName(PROMOTED_TWEET_SEARCH_ENGAGEMENT_RATE)
    private String[] promotedTweetSearchEngagementRate;

    @SerializedName(PROMOTED_TWEET_SEARCH_RETWEETS)
    private String[] promotedTweetSearchRetweets;

    @SerializedName(PROMOTED_ACCOUNT_IMPRESSIONS)
    private String[] promotedAccountImpressions;

    @SerializedName(PROMOTED_TWEET_SEARCH_REPLIES)
    private String[] promotedTweetSearchReplies;

    @SerializedName(PROMOTED_TWEET_SEARCH_FOLLOWS)
    private String[] promotedTweetSearchFollows;

    @SerializedName(PROMOTED_ACCOUNT_PROFILE_VISITS)
    private String[] promotedAccountProfileVisits;

    @SerializedName(PROMOTED_TWEET_TIMELINE_CLICKS)
    private String[] promotedTweetTimelineClicks;

    @SerializedName(PROMOTED_TWEET_TIMELINE_IMPRESSIONS)
    private String[] promotedTweetTimelineImpressions;

    @SerializedName(PROMOTED_ACCOUNT_FOLLOWS)
    private String[] promotedAccountFollows;

    @SerializedName(CONVERSION_SITE_VISITS)
    private String[] conversionSiteVisits;

    @SerializedName(PROMOTED_TWEET_TIMELINE_ENGAGEMENT_RATE)
    private String[] promotedTweetTimelineEngagementRate;

    @SerializedName(PROMOTED_TWEET_PROFILE_ENGAGEMENT_RATE)
    private String[] promotedTweetProfileEngagementRate;

    @SerializedName(PROMOTED_TWEET_SEARCH_FAVOURITES)
    private String[] promotedTweetSearchFavourites;

    @SerializedName(PROMOTED_TWEET_SEARCH_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetSearchQualifiedImpressions;

    @SerializedName(PROMOTED_TWEET_TIMELINE_FAVOURITES)
    private String[] promotedTweetTimelineFavourites;

    @SerializedName(PROMOTED_TWEET_TIMELINE_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetTimelineQualifiedImpressions;

    @SerializedName(PROMOTED_TWEET_SEARCH_URL_CLICKS)
    private String[] promotedTweetSearchUrlClicks;

    @SerializedName(PROMOTED_TWEET_TIMELINE_URL_CLICKS)
    private String[] promotedTweetTimelineUrlClicks;

    @SerializedName(BILLED_FOLLOWS)
    private String[] billedFollows;

    @SerializedName(CONVERSION_CUSTOM)
    private String[] conversionCustom;

    @SerializedName(CONVERSION_APP_OPEN)
    private String[] conversionAppOpen;

    @SerializedName(PROMOTED_TWEET_TIMELINE_RETWEETS)
    private String[] promotedTweetTimelineRetweets;

    @SerializedName(PROMOTED_TWEET_TIMELINE_REPLIES)
    private String[] promotedTweetTimelineReplies;

    @SerializedName(BILLED_ENGAGEMENTS)
    private String[] billedEngagements;

    @SerializedName(CONVERSION_DOWNLOADS)
    private String[] conversionDownloads;

    @SerializedName(PROMOTED_TWEET_TIMELINE_FOLLOWS)
    private String[] promotedTweetTimelineFollows;

    @SerializedName(PROMOTED_TWEET_SEARCH_ENGAGEMENTS)
    private String[] promotedTweetSearchEngagements;

    @SerializedName(PROMOTED_TWEET_TIMELINE_ENGAGEMENTS)
    private String[] promotedTweetTimelineEngagements;

    @SerializedName(PROMOTED_TWEET_SEARCH_IMPRESSIONS)
    private String[] promotedTweetSearchImpressions;

    @SerializedName(PROMOTED_TWEET_PROFILE_CLICKS)
    private String[] promotedTweetProfileClicks;

    @SerializedName(PROMOTED_TWEET_PROFILE_ENGAGEMENTS)
    private String[] promotedTweetProfileEngagements;

    @SerializedName(PROMOTED_TWEET_PROFILE_FAVORITES)
    private String[] promotedTweetProfileFavorites;

    @SerializedName(PROMOTED_TWEET_PROFILE_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetProfileQualifiedImpressions;

    @SerializedName(PROMOTED_TWEET_PROFILE_FOLLOWS)
    private String[] promotedTweetProfileFollows;

    @SerializedName(PROMOTED_TWEET_PROFILE_REPLIES)
    private String[] promotedTweetProfileReplies;

    @SerializedName(PROMOTED_TWEET_PROFILE_RETWEETS)
    private String[] promotedTweetProfileRetweets;

    @SerializedName(PROMOTED_TWEET_PROFILE_URL_CLICKS)
    private String[] promotedTweetProfileUrlClicks;

    @SerializedName(PROMOTED_TWEET_PROFILE_IMPRESSIONS)
    private String[] promotedTweetProfileImpressions;

    @SerializedName(PROMOTED_TWEET_TPN_CLICKS)
    private String[] promotedTweetTpnClicks;

    @SerializedName(PROMOTED_TWEET_TPN_ENGAGEMENTS)
    private String[] promotedTweetTpnEngagements;

    @SerializedName(PROMOTED_TWEET_TPN_FOLLOWS)
    private String[] promotedTweetTpnFollows;

    @SerializedName(PROMOTED_TWEET_TPN_IMPRESSIONS)
    private String[] promotedTweetTpnImpressions;

    @SerializedName(PROMOTED_TWEET_TPN_REPLIES)
    private String[] promotedTweetTpnReplies;

    @SerializedName(PROMOTED_TWEET_TPN_RETWEETS)
    private String[] promotedTweetTpnRetweets;

    @SerializedName(PROMOTED_TWEET_TPN_URL_CLICKS)
    private String[] promotedTweetTpnUrlClicks;

    @SerializedName(PROMOTED_TWEET_TPN_FAVORITES)
    private String[] promotedTweetTpnFavorites;

    @SerializedName(PROMOTED_TWEET_TPN_ENGAGEMENT_RATE)
    private String[] promotedTweetTpnEngagementRate;

    @SerializedName(PROMOTED_TWEET_TPN_CARD_ENGAGEMENTS)
    private String[] promotedTweetTpnCardEngagements;

    @SerializedName(PROMOTED_TWEET_TPN_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetTpnQualifiedImpressions;

    @SerializedName(PROMOTED_VIDEO_TOTAL_VIEWS)
    private String[] promotedVideoTotalViews;

    @SerializedName(PROMOTED_VIDEO_REPLAYS)
    private String[] promotedVideoReplays;

    @SerializedName(PROMOTION_CARD_RESPONSES)
    private String[] promotionCardResponses;

    @SerializedName(PROMOTED_VIDEO_VIEWS_25)
    private String[] promotedVideoViews25;

    @SerializedName(PROMOTED_VIDEO_VIEWS_50)
    private String[] promotedVideoViews50;

    @SerializedName(PROMOTED_VIDEO_VIEWS_75)
    private String[] promotedVideoViews75;

    @SerializedName(PROMOTED_VIDEO_VIEWS_100)
    private String[] promotedVideoViews100;

    @SerializedName(PROMOTED_VIDEO_CTA_CLICKS)
    private String[] promotedVideoCtaClicks;

    @SerializedName(MOBILE_CONVERSION_INVITES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionInvitesBreakdown;

    @SerializedName(MOBILE_CONVERSION_RE_ENGAGES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionReEngagesBreakdown;

    @SerializedName(MOBILE_CONVERSION_ADD_TO_CART_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionAddToCartBreakdown;

    @SerializedName(MOBILE_CONVERSION_CONTENT_VIEWS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionContentViewsBreakdown;

    @SerializedName(MOBILE_CONVERSION_SPENT_CREDITS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionSpentCreditsBreakdown;

    @SerializedName(MOBILE_CONVERSION_UPDATES)
    private String[] mobileConversionUpdates;

    @SerializedName(MOBILE_CONVERSION_SHARES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionSharesBreakdown;

    @SerializedName(MOBILE_CONVERSION_SEARCHES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionSearchesBreakdown;

    @SerializedName(MOBILE_CONVERSION_ADDED_PAYMENT_INFOS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionAddedPaymentInfosBreakdown;

    @SerializedName(PROMOTED_TWEET_APP_INSTALL_ATTEMPTS_BREAKDOWN)
    private TwitterAdStatsBreakdown promotedTweetAppInstallAttemptsBreakdown;

    @SerializedName(MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionAchievementUnlockedBreakdown;

    @SerializedName(MOBILE_CONVERSION_ADD_TO_WISHLIST_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionAddToWishlistBreakdown;

    @SerializedName(MOBILE_CONVERSION_LEVEL_ACHIEVED_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionLevelAchievedBreakdown;

    @SerializedName(MOBILE_CONVERSION_RESERVATIONS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionReservationsBreakdown;

    @SerializedName(MOBILE_CONVERSION_SIGN_UPS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionSignUpsBreakdown;

    @SerializedName(PROMOTED_TWEET_APP_OPEN_ATTEMPTS_BREAKDOWN)
    private TwitterAdStatsBreakdown promotedTweetAppOpenAttemptsBreakdown;

    @SerializedName(MOBILE_CONVERSION_LOGINS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionLoginsBreakdown;

    @SerializedName(MOBILE_CONVERSION_RATED_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionRatedBreakdown;

    @SerializedName(MOBILE_CONVERSION_UPDATES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionUpdatesBreakdown;

    @SerializedName(MOBILE_CONVERSION_CHECKOUT_INITIATED_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionCheckoutInitiatedBreakdown;

    @SerializedName(MOBILE_CONVERSION_INSTALLS_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionInstallsBreakdown;

    @SerializedName(MOBILE_CONVERSION_PURCHASES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionPurchasesBreakdown;

    @SerializedName(MOBILE_CONVERSION_TUTORIAL_COMPLETES_BREAKDOWN)
    private TwitterAdStatsBreakdown mobileConversionTutorialCompletesBreakdown;

    @SerializedName(PROMOTED_TWEET_TIMELINE_MEDIA_VIEWS)
    private String[] promotedTweetTimelineMediaViews;

    @SerializedName(PROMOTED_TWEET_SEARCH_MEDIA_VIEWS)
    private String[] promotedTweetSearchMediaViews;

    @SerializedName(PROMOTED_TWEET_PROFILE_MEDIA_VIEWS)
    private String[] promotedTweetProfileMediaViews;

    @SerializedName(PROMOTED_TWEET_TPN_MEDIA_VIEWS)
    private String[] promotedTweetTpnMediaViews;

    @SerializedName(CAMPAIGN_TOTAL_AUDIENCE_REACH)
    private String totalAudienceReach;

    @SerializedName(CAMPAIGN_AVERAGE_FREQUENCY)
    private String averageFrequency;

    //todo this needs to be fixed for
//    @SerializedName(MOBILE_LIFETIME_VALUE_CONVERSION_BREAKDOWN)
//    private TwitterAdStatsBreakdown mobileLifetimeValueConversionBreakdown;
//
//    @SerializedName(MOBILE_LIFETIME_VALUE_CONVERSION_SALE_AMOUNT_LOCAL_MICRO_BREAKDOWN)
//    private TwitterAdStatsBreakdown mobileLifetimeValueConversionSaleAmountLocalMicroBreakdown;
//
//    @SerializedName(MOBILE_LIFETIME_VALUE_CONVERSION_ORDER_QUANTITY_BREAKDOWN)
//    private TwitterAdStatsBreakdown mobileLifetimeValueConversionOrderQuantityBreakdown;

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Granularity getGranularity() {
        return granularity;
    }

    public void setGranularity(Granularity granularity) {
        this.granularity = granularity;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String[] getMobileConversionTutorialsCompleted() {
        return mobileConversionTutorialsCompleted;
    }

    public void setMobileConversionTutorialsCompleted(String[] mobileConversionTutorialsCompleted) {
        this.mobileConversionTutorialsCompleted = mobileConversionTutorialsCompleted;
    }

    public String[] getMobileConversionReservations() {
        return mobileConversionReservations;
    }

    public void setMobileConversionReservations(String[] mobileConversionReservations) {
        this.mobileConversionReservations = mobileConversionReservations;
    }

    public String[] getMobileConversionAddToCart() {
        return mobileConversionAddToCart;
    }

    public void setMobileConversionAddToCart(String[] mobileConversionAddToCart) {
        this.mobileConversionAddToCart = mobileConversionAddToCart;
    }

    public String[] getMobileConversionAddToWishList() {
        return mobileConversionAddToWishList;
    }

    public void setMobileConversionAddToWishList(String[] mobileConversionAddToWishList) {
        this.mobileConversionAddToWishList = mobileConversionAddToWishList;
    }

    public String[] getMobileConversionCheckoutInitiated() {
        return mobileConversionCheckoutInitiated;
    }

    public void setMobileConversionCheckoutInitiated(String[] mobileConversionCheckoutInitiated) {
        this.mobileConversionCheckoutInitiated = mobileConversionCheckoutInitiated;
    }

    public String[] getMobileConversionSearches() {
        return mobileConversionSearches;
    }

    public void setMobileConversionSearches(String[] mobileConversionSearches) {
        this.mobileConversionSearches = mobileConversionSearches;
    }

    public String[] getConversionSaleAmount() {
        return conversionSaleAmount;
    }

    public void setConversionSaleAmount(String[] conversionSaleAmount) {
        this.conversionSaleAmount = conversionSaleAmount;
    }

    public String[] getConversionOrderQuantity() {
        return conversionOrderQuantity;
    }

    public void setConversionOrderQuantity(String[] conversionOrderQuantity) {
        this.conversionOrderQuantity = conversionOrderQuantity;
    }

    public String[] getConversionKeyPageViews() {
        return conversionKeyPageViews;
    }

    public void setConversionKeyPageViews(String[] conversionKeyPageViews) {
        this.conversionKeyPageViews = conversionKeyPageViews;
    }

    public String[] getMobileConversionLevelAchieved() {
        return mobileConversionLevelAchieved;
    }

    public void setMobileConversionLevelAchieved(String[] mobileConversionLevelAchieved) {
        this.mobileConversionLevelAchieved = mobileConversionLevelAchieved;
    }

    public String[] getMobileConversionAchievementUnlocked() {
        return mobileConversionAchievementUnlocked;
    }

    public void setMobileConversionAchievementUnlocked(String[] mobileConversionAchievementUnlocked) {
        this.mobileConversionAchievementUnlocked = mobileConversionAchievementUnlocked;
    }

    public String[] getMobileConversionContentViews() {
        return mobileConversionContentViews;
    }

    public void setMobileConversionContentViews(String[] mobileConversionContentViews) {
        this.mobileConversionContentViews = mobileConversionContentViews;
    }

    public String[] getMobileConversionShares() {
        return mobileConversionShares;
    }

    public void setMobileConversionShares(String[] mobileConversionShares) {
        this.mobileConversionShares = mobileConversionShares;
    }

    public String[] getMobileConversionInvites() {
        return mobileConversionInvites;
    }

    public void setMobileConversionInvites(String[] mobileConversionInvites) {
        this.mobileConversionInvites = mobileConversionInvites;
    }

    public String[] getMobileConversionAddedPaymentInfos() {
        return mobileConversionAddedPaymentInfos;
    }

    public void setMobileConversionAddedPaymentInfos(String[] mobileConversionAddedPaymentInfos) {
        this.mobileConversionAddedPaymentInfos = mobileConversionAddedPaymentInfos;
    }

    public String[] getMobileConversionSpentCredits() {
        return mobileConversionSpentCredits;
    }

    public void setMobileConversionSpentCredits(String[] mobileConversionSpentCredits) {
        this.mobileConversionSpentCredits = mobileConversionSpentCredits;
    }

    public String[] getMobileConversionSpentRated() {
        return mobileConversionSpentRated;
    }

    public void setMobileConversionSpentRated(String[] mobileConversionSpentRated) {
        this.mobileConversionSpentRated = mobileConversionSpentRated;
    }

    public String[] getMobileConversionInstalls() {
        return mobileConversionInstalls;
    }

    public void setMobileConversionInstalls(String[] mobileConversionInstalls) {
        this.mobileConversionInstalls = mobileConversionInstalls;
    }

    public String[] getMobileConversionLogins() {
        return mobileConversionLogins;
    }

    public void setMobileConversionLogins(String[] mobileConversionLogins) {
        this.mobileConversionLogins = mobileConversionLogins;
    }

    public String[] getMobileConversionReEngages() {
        return mobileConversionReEngages;
    }

    public void setMobileConversionReEngages(String[] mobileConversionReEngages) {
        this.mobileConversionReEngages = mobileConversionReEngages;
    }

    public String[] getMobileConversionSignUps() {
        return mobileConversionSignUps;
    }

    public void setMobileConversionSignUps(String[] mobileConversionSignUps) {
        this.mobileConversionSignUps = mobileConversionSignUps;
    }

    public String[] getMobileConversionPurchases() {
        return mobileConversionPurchases;
    }

    public void setMobileConversionPurchases(String[] mobileConversionPurchases) {
        this.mobileConversionPurchases = mobileConversionPurchases;
    }

    public String[] getPromotedTweetAppInstallAttempts() {
        return promotedTweetAppInstallAttempts;
    }

    public void setPromotedTweetAppInstallAttempts(String[] promotedTweetAppInstallAttempts) {
        this.promotedTweetAppInstallAttempts = promotedTweetAppInstallAttempts;
    }

    public String[] getPromotedTweetAppOpenAttempts() {
        return promotedTweetAppOpenAttempts;
    }

    public void setPromotedTweetAppOpenAttempts(String[] promotedTweetAppOpenAttempts) {
        this.promotedTweetAppOpenAttempts = promotedTweetAppOpenAttempts;
    }

    public String[] getPromotedTweetSearchCardEngagements() {
        return promotedTweetSearchCardEngagements;
    }

    public void setPromotedTweetSearchCardEngagements(String[] promotedTweetSearchCardEngagements) {
        this.promotedTweetSearchCardEngagements = promotedTweetSearchCardEngagements;
    }

    public String[] getPromotedTweetTimelineCardEngagements() {
        return promotedTweetTimelineCardEngagements;
    }

    public void setPromotedTweetTimelineCardEngagements(String[] promotedTweetTimelineCardEngagements) {
        this.promotedTweetTimelineCardEngagements = promotedTweetTimelineCardEngagements;
    }

    public String[] getPromotedTweetProfileCardEngagements() {
        return promotedTweetProfileCardEngagements;
    }

    public void setPromotedTweetProfileCardEngagements(String[] promotedTweetProfileCardEngagements) {
        this.promotedTweetProfileCardEngagements = promotedTweetProfileCardEngagements;
    }

    public String[] getConversionSignUps() {
        return conversionSignUps;
    }

    public void setConversionSignUps(String[] conversionSignUps) {
        this.conversionSignUps = conversionSignUps;
    }

    public String[] getConversionPurchases() {
        return conversionPurchases;
    }

    public void setConversionPurchases(String[] conversionPurchases) {
        this.conversionPurchases = conversionPurchases;
    }

    public String[] getPromotedAccountFollowRate() {
        return promotedAccountFollowRate;
    }

    public void setPromotedAccountFollowRate(String[] promotedAccountFollowRate) {
        this.promotedAccountFollowRate = promotedAccountFollowRate;
    }

    public String[] getBilledChargeMicro() {
        return billedChargeMicro;
    }

    public void setBilledChargeMicro(String[] billedChargeMicro) {
        this.billedChargeMicro = billedChargeMicro;
    }

    public String[] getEstimatedChargeMicro() {
        return estimatedChargeMicro;
    }

    public void setEstimatedChargeMicro(String[] estimatedChargeMicro) {
        this.estimatedChargeMicro = estimatedChargeMicro;
    }

    public String[] getPromotedTweetSearchClicks() {
        return promotedTweetSearchClicks;
    }

    public void setPromotedTweetSearchClicks(String[] promotedTweetSearchClicks) {
        this.promotedTweetSearchClicks = promotedTweetSearchClicks;
    }

    public String[] getPromotedTweetSearchEngagementRate() {
        return promotedTweetSearchEngagementRate;
    }

    public void setPromotedTweetSearchEngagementRate(String[] promotedTweetSearchEngagementRate) {
        this.promotedTweetSearchEngagementRate = promotedTweetSearchEngagementRate;
    }

    public String[] getPromotedTweetSearchRetweets() {
        return promotedTweetSearchRetweets;
    }

    public void setPromotedTweetSearchRetweets(String[] promotedTweetSearchRetweets) {
        this.promotedTweetSearchRetweets = promotedTweetSearchRetweets;
    }

    public String[] getPromotedAccountImpressions() {
        return promotedAccountImpressions;
    }

    public void setPromotedAccountImpressions(String[] promotedAccountImpressions) {
        this.promotedAccountImpressions = promotedAccountImpressions;
    }

    public String[] getPromotedTweetSearchReplies() {
        return promotedTweetSearchReplies;
    }

    public void setPromotedTweetSearchReplies(String[] promotedTweetSearchReplies) {
        this.promotedTweetSearchReplies = promotedTweetSearchReplies;
    }

    public String[] getPromotedTweetSearchFollows() {
        return promotedTweetSearchFollows;
    }

    public void setPromotedTweetSearchFollows(String[] promotedTweetSearchFollows) {
        this.promotedTweetSearchFollows = promotedTweetSearchFollows;
    }

    public String[] getPromotedAccountProfileVisits() {
        return promotedAccountProfileVisits;
    }

    public void setPromotedAccountProfileVisits(String[] promotedAccountProfileVisits) {
        this.promotedAccountProfileVisits = promotedAccountProfileVisits;
    }

    public String[] getPromotedTweetTimelineClicks() {
        return promotedTweetTimelineClicks;
    }

    public void setPromotedTweetTimelineClicks(String[] promotedTweetTimelineClicks) {
        this.promotedTweetTimelineClicks = promotedTweetTimelineClicks;
    }

    public String[] getPromotedTweetTimelineImpressions() {
        return promotedTweetTimelineImpressions;
    }

    public void setPromotedTweetTimelineImpressions(String[] promotedTweetTimelineImpressions) {
        this.promotedTweetTimelineImpressions = promotedTweetTimelineImpressions;
    }

    public String[] getPromotedAccountFollows() {
        return promotedAccountFollows;
    }

    public void setPromotedAccountFollows(String[] promotedAccountFollows) {
        this.promotedAccountFollows = promotedAccountFollows;
    }

    public String[] getConversionSiteVisits() {
        return conversionSiteVisits;
    }

    public void setConversionSiteVisits(String[] conversionSiteVisits) {
        this.conversionSiteVisits = conversionSiteVisits;
    }

    public String[] getPromotedTweetTimelineEngagementRate() {
        return promotedTweetTimelineEngagementRate;
    }

    public void setPromotedTweetTimelineEngagementRate(String[] promotedTweetTimelineEngagementRate) {
        this.promotedTweetTimelineEngagementRate = promotedTweetTimelineEngagementRate;
    }

    public String[] getPromotedTweetProfileEngagementRate() {
        return promotedTweetProfileEngagementRate;
    }

    public void setPromotedTweetProfileEngagementRate(String[] promotedTweetProfileEngagementRate) {
        this.promotedTweetProfileEngagementRate = promotedTweetProfileEngagementRate;
    }

    public String[] getPromotedTweetSearchFavourites() {
        return promotedTweetSearchFavourites;
    }

    public void setPromotedTweetSearchFavourites(String[] promotedTweetSearchFavourites) {
        this.promotedTweetSearchFavourites = promotedTweetSearchFavourites;
    }

    public String[] getPromotedTweetTimelineFavourites() {
        return promotedTweetTimelineFavourites;
    }

    public void setPromotedTweetTimelineFavourites(String[] promotedTweetTimelineFavourites) {
        this.promotedTweetTimelineFavourites = promotedTweetTimelineFavourites;
    }

    public String[] getPromotedTweetSearchUrlClicks() {
        return promotedTweetSearchUrlClicks;
    }

    public void setPromotedTweetSearchUrlClicks(String[] promotedTweetSearchUrlClicks) {
        this.promotedTweetSearchUrlClicks = promotedTweetSearchUrlClicks;
    }

    public String[] getPromotedTweetTimelineUrlClicks() {
        return promotedTweetTimelineUrlClicks;
    }

    public void setPromotedTweetTimelineUrlClicks(String[] promotedTweetTimelineUrlClicks) {
        this.promotedTweetTimelineUrlClicks = promotedTweetTimelineUrlClicks;
    }

    public String[] getPromotedTweetProfileClicks() {
        return promotedTweetProfileClicks;
    }

    public void setPromotedTweetProfileClicks(String[] promotedTweetProfileClicks) {
        this.promotedTweetProfileClicks = promotedTweetProfileClicks;
    }

    public String[] getPromotedTweetProfileEngagements() {
        return promotedTweetProfileEngagements;
    }

    public void setPromotedTweetProfileEngagements(String[] promotedTweetProfileEngagements) {
        this.promotedTweetProfileEngagements = promotedTweetProfileEngagements;
    }

    public String[] getPromotedTweetProfileFavorites() {
        return promotedTweetProfileFavorites;
    }

    public void setPromotedTweetProfileFavorites(String[] promotedTweetProfileFavorites) {
        this.promotedTweetProfileFavorites = promotedTweetProfileFavorites;
    }

    public String[] getPromotedTweetProfileFollows() {
        return promotedTweetProfileFollows;
    }

    public void setPromotedTweetProfileFollows(String[] promotedTweetProfileFollows) {
        this.promotedTweetProfileFollows = promotedTweetProfileFollows;
    }

    public String[] getPromotedTweetProfileReplies() {
        return promotedTweetProfileReplies;
    }

    public void setPromotedTweetProfileReplies(String[] promotedTweetProfileReplies) {
        this.promotedTweetProfileReplies = promotedTweetProfileReplies;
    }

    public String[] getPromotedTweetProfileRetweets() {
        return promotedTweetProfileRetweets;
    }

    public void setPromotedTweetProfileRetweets(String[] promotedTweetProfileRetweets) {
        this.promotedTweetProfileRetweets = promotedTweetProfileRetweets;
    }

    public String[] getPromotedTweetProfileUrlClicks() {
        return promotedTweetProfileUrlClicks;
    }

    public void setPromotedTweetProfileUrlClicks(String[] promotedTweetProfileUrlClicks) {
        this.promotedTweetProfileUrlClicks = promotedTweetProfileUrlClicks;
    }

    public String[] getPromotedTweetProfileImpressions() {
        return promotedTweetProfileImpressions;
    }

    public void setPromotedTweetProfileImpressions(String[] promotedTweetProfileImpressions) {
        this.promotedTweetProfileImpressions = promotedTweetProfileImpressions;
    }

    public String[] getPromotedTweetTpnClicks() {
        return promotedTweetTpnClicks;
    }

    public void setPromotedTweetTpnClicks(String[] promotedTweetTpnClicks) {
        this.promotedTweetTpnClicks = promotedTweetTpnClicks;
    }

    public String[] getPromotedTweetTpnEngagements() {
        return promotedTweetTpnEngagements;
    }

    public void setPromotedTweetTpnEngagements(String[] promotedTweetTpnEngagements) {
        this.promotedTweetTpnEngagements = promotedTweetTpnEngagements;
    }

    public String[] getPromotedTweetTpnFollows() {
        return promotedTweetTpnFollows;
    }

    public void setPromotedTweetTpnFollows(String[] promotedTweetTpnFollows) {
        this.promotedTweetTpnFollows = promotedTweetTpnFollows;
    }

    public String[] getPromotedTweetTpnImpressions() {
        return promotedTweetTpnImpressions;
    }

    public void setPromotedTweetTpnImpressions(String[] promotedTweetTpnImpressions) {
        this.promotedTweetTpnImpressions = promotedTweetTpnImpressions;
    }

    public String[] getPromotedTweetTpnReplies() {
        return promotedTweetTpnReplies;
    }

    public void setPromotedTweetTpnReplies(String[] promotedTweetTpnReplies) {
        this.promotedTweetTpnReplies = promotedTweetTpnReplies;
    }

    public String[] getPromotedTweetTpnRetweets() {
        return promotedTweetTpnRetweets;
    }

    public void setPromotedTweetTpnRetweets(String[] promotedTweetTpnRetweets) {
        this.promotedTweetTpnRetweets = promotedTweetTpnRetweets;
    }

    public String[] getPromotedTweetTpnUrlClicks() {
        return promotedTweetTpnUrlClicks;
    }

    public void setPromotedTweetTpnUrlClicks(String[] promotedTweetTpnUrlClicks) {
        this.promotedTweetTpnUrlClicks = promotedTweetTpnUrlClicks;
    }

    public String[] getPromotedTweetTpnFavorites() {
        return promotedTweetTpnFavorites;
    }

    public void setPromotedTweetTpnFavorites(String[] promotedTweetTpnFavorites) {
        this.promotedTweetTpnFavorites = promotedTweetTpnFavorites;
    }

    public String[] getPromotedTweetTpnEngagementRate() {
        return promotedTweetTpnEngagementRate;
    }

    public void setPromotedTweetTpnEngagementRate(String[] promotedTweetTpnEngagementRate) {
        this.promotedTweetTpnEngagementRate = promotedTweetTpnEngagementRate;
    }

    public String[] getPromotedTweetTpnCardEngagements() {
        return promotedTweetTpnCardEngagements;
    }

    public void setPromotedTweetTpnCardEngagements(String[] promotedTweetTpnCardEngagements) {
        this.promotedTweetTpnCardEngagements = promotedTweetTpnCardEngagements;
    }

    public String[] getBilledFollows() {
        return billedFollows;
    }

    public void setBilledFollows(String[] billedFollows) {
        this.billedFollows = billedFollows;
    }

    public String[] getConversionCustom() {
        return conversionCustom;
    }

    public void setConversionCustom(String[] conversionCustom) {
        this.conversionCustom = conversionCustom;
    }

    public String[] getConversionAppOpen() {
        return conversionAppOpen;
    }

    public void setConversionAppOpen(String[] conversionAppOpen) {
        this.conversionAppOpen = conversionAppOpen;
    }

    public String[] getPromotedTweetTimelineRetweets() {
        return promotedTweetTimelineRetweets;
    }

    public void setPromotedTweetTimelineRetweets(String[] promotedTweetTimelineRetweets) {
        this.promotedTweetTimelineRetweets = promotedTweetTimelineRetweets;
    }

    public String[] getPromotedTweetTimelineReplies() {
        return promotedTweetTimelineReplies;
    }

    public void setPromotedTweetTimelineReplies(String[] promotedTweetTimelineReplies) {
        this.promotedTweetTimelineReplies = promotedTweetTimelineReplies;
    }

    public String[] getBilledEngagements() {
        return billedEngagements;
    }

    public void setBilledEngagements(String[] billedEngagements) {
        this.billedEngagements = billedEngagements;
    }

    public String[] getConversionDownloads() {
        return conversionDownloads;
    }

    public void setConversionDownloads(String[] conversionDownloads) {
        this.conversionDownloads = conversionDownloads;
    }

    public String[] getPromotedTweetTimelineFollows() {
        return promotedTweetTimelineFollows;
    }

    public void setPromotedTweetTimelineFollows(String[] promotedTweetTimelineFollows) {
        this.promotedTweetTimelineFollows = promotedTweetTimelineFollows;
    }

    public String[] getPromotedTweetSearchEngagements() {
        return promotedTweetSearchEngagements;
    }

    public void setPromotedTweetSearchEngagements(String[] promotedTweetSearchEngagements) {
        this.promotedTweetSearchEngagements = promotedTweetSearchEngagements;
    }

    public String[] getPromotedTweetTimelineEngagements() {
        return promotedTweetTimelineEngagements;
    }

    public void setPromotedTweetTimelineEngagements(String[] promotedTweetTimelineEngagements) {
        this.promotedTweetTimelineEngagements = promotedTweetTimelineEngagements;
    }

    public String[] getPromotedTweetSearchImpressions() {
        return promotedTweetSearchImpressions;
    }

    public void setPromotedTweetSearchImpressions(String[] promotedTweetSearchImpressions) {
        this.promotedTweetSearchImpressions = promotedTweetSearchImpressions;
    }

    public String[] getPromotedVideoTotalViews() {
        return promotedVideoTotalViews;
    }

    public void setPromotedVideoTotalViews(String[] promotedVideoTotalViews) {
        this.promotedVideoTotalViews = promotedVideoTotalViews;
    }

    public String[] getPromotedVideoReplays() {
        return promotedVideoReplays;
    }

    public void setPromotedVideoReplays(String[] promotedVideoReplays) {
        this.promotedVideoReplays = promotedVideoReplays;
    }

    public String[] getPromotionCardResponses() {
        return promotionCardResponses;
    }

    public void setPromotionCardResponses(String[] promotionCardResponses) {
        this.promotionCardResponses = promotionCardResponses;
    }

    public String[] getPromotedVideoViews25() {
        return promotedVideoViews25;
    }

    public void setPromotedVideoViews25(String[] promotedVideoViews25) {
        this.promotedVideoViews25 = promotedVideoViews25;
    }

    public String[] getPromotedVideoViews50() {
        return promotedVideoViews50;
    }

    public void setPromotedVideoViews50(String[] promotedVideoViews50) {
        this.promotedVideoViews50 = promotedVideoViews50;
    }

    public String[] getPromotedVideoViews75() {
        return promotedVideoViews75;
    }

    public void setPromotedVideoViews75(String[] promotedVideoViews75) {
        this.promotedVideoViews75 = promotedVideoViews75;
    }

    public String[] getPromotedVideoViews100() {
        return promotedVideoViews100;
    }

    public void setPromotedVideoViews100(String[] promotedVideoViews100) {
        this.promotedVideoViews100 = promotedVideoViews100;
    }

    public String[] getPromotedVideoCtaClicks() {
        return promotedVideoCtaClicks;
    }

    public void setPromotedVideoCtaClicks(String[] promotedVideoCtaClicks) {
        this.promotedVideoCtaClicks = promotedVideoCtaClicks;
    }

    public TwitterAdStatsBreakdown getMobileConversionInvitesBreakdown() {
        return mobileConversionInvitesBreakdown;
    }

    public void setMobileConversionInvitesBreakdown(TwitterAdStatsBreakdown mobileConversionInvitesBreakdown) {
        this.mobileConversionInvitesBreakdown = mobileConversionInvitesBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionReEngagesBreakdown() {
        return mobileConversionReEngagesBreakdown;
    }

    public void setMobileConversionReEngagesBreakdown(TwitterAdStatsBreakdown mobileConversionReEngagesBreakdown) {
        this.mobileConversionReEngagesBreakdown = mobileConversionReEngagesBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionAddToCartBreakdown() {
        return mobileConversionAddToCartBreakdown;
    }

    public void setMobileConversionAddToCartBreakdown(TwitterAdStatsBreakdown mobileConversionAddToCartBreakdown) {
        this.mobileConversionAddToCartBreakdown = mobileConversionAddToCartBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionContentViewsBreakdown() {
        return mobileConversionContentViewsBreakdown;
    }

    public void setMobileConversionContentViewsBreakdown(TwitterAdStatsBreakdown mobileConversionContentViewsBreakdown) {
        this.mobileConversionContentViewsBreakdown = mobileConversionContentViewsBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionSpentCreditsBreakdown() {
        return mobileConversionSpentCreditsBreakdown;
    }

    public void setMobileConversionSpentCreditsBreakdown(TwitterAdStatsBreakdown mobileConversionSpentCreditsBreakdown) {
        this.mobileConversionSpentCreditsBreakdown = mobileConversionSpentCreditsBreakdown;
    }

    public String[] getMobileConversionUpdates() {
        return mobileConversionUpdates;
    }

    public void setMobileConversionUpdates(String[] mobileConversionUpdates) {
        this.mobileConversionUpdates = mobileConversionUpdates;
    }

    public TwitterAdStatsBreakdown getMobileConversionSharesBreakdown() {
        return mobileConversionSharesBreakdown;
    }

    public void setMobileConversionSharesBreakdown(TwitterAdStatsBreakdown mobileConversionSharesBreakdown) {
        this.mobileConversionSharesBreakdown = mobileConversionSharesBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionSearchesBreakdown() {
        return mobileConversionSearchesBreakdown;
    }

    public void setMobileConversionSearchesBreakdown(TwitterAdStatsBreakdown mobileConversionSearchesBreakdown) {
        this.mobileConversionSearchesBreakdown = mobileConversionSearchesBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionAddedPaymentInfosBreakdown() {
        return mobileConversionAddedPaymentInfosBreakdown;
    }

    public void setMobileConversionAddedPaymentInfosBreakdown(TwitterAdStatsBreakdown mobileConversionAddedPaymentInfosBreakdown) {
        this.mobileConversionAddedPaymentInfosBreakdown = mobileConversionAddedPaymentInfosBreakdown;
    }

    public TwitterAdStatsBreakdown getPromotedTweetAppInstallAttemptsBreakdown() {
        return promotedTweetAppInstallAttemptsBreakdown;
    }

    public void setPromotedTweetAppInstallAttemptsBreakdown(TwitterAdStatsBreakdown promotedTweetAppInstallAttemptsBreakdown) {
        this.promotedTweetAppInstallAttemptsBreakdown = promotedTweetAppInstallAttemptsBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionAchievementUnlockedBreakdown() {
        return mobileConversionAchievementUnlockedBreakdown;
    }

    public void setMobileConversionAchievementUnlockedBreakdown(TwitterAdStatsBreakdown mobileConversionAchievementUnlockedBreakdown) {
        this.mobileConversionAchievementUnlockedBreakdown = mobileConversionAchievementUnlockedBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionAddToWishlistBreakdown() {
        return mobileConversionAddToWishlistBreakdown;
    }

    public void setMobileConversionAddToWishlistBreakdown(TwitterAdStatsBreakdown mobileConversionAddToWishlistBreakdown) {
        this.mobileConversionAddToWishlistBreakdown = mobileConversionAddToWishlistBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionLevelAchievedBreakdown() {
        return mobileConversionLevelAchievedBreakdown;
    }

    public void setMobileConversionLevelAchievedBreakdown(TwitterAdStatsBreakdown mobileConversionLevelAchievedBreakdown) {
        this.mobileConversionLevelAchievedBreakdown = mobileConversionLevelAchievedBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionReservationsBreakdown() {
        return mobileConversionReservationsBreakdown;
    }

    public void setMobileConversionReservationsBreakdown(TwitterAdStatsBreakdown mobileConversionReservationsBreakdown) {
        this.mobileConversionReservationsBreakdown = mobileConversionReservationsBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionSignUpsBreakdown() {
        return mobileConversionSignUpsBreakdown;
    }

    public void setMobileConversionSignUpsBreakdown(TwitterAdStatsBreakdown mobileConversionSignUpsBreakdown) {
        this.mobileConversionSignUpsBreakdown = mobileConversionSignUpsBreakdown;
    }

    public TwitterAdStatsBreakdown getPromotedTweetAppOpenAttemptsBreakdown() {
        return promotedTweetAppOpenAttemptsBreakdown;
    }

    public void setPromotedTweetAppOpenAttemptsBreakdown(TwitterAdStatsBreakdown promotedTweetAppOpenAttemptsBreakdown) {
        this.promotedTweetAppOpenAttemptsBreakdown = promotedTweetAppOpenAttemptsBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionLoginsBreakdown() {
        return mobileConversionLoginsBreakdown;
    }

    public void setMobileConversionLoginsBreakdown(TwitterAdStatsBreakdown mobileConversionLoginsBreakdown) {
        this.mobileConversionLoginsBreakdown = mobileConversionLoginsBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionRatedBreakdown() {
        return mobileConversionRatedBreakdown;
    }

    public void setMobileConversionRatedBreakdown(TwitterAdStatsBreakdown mobileConversionRatedBreakdown) {
        this.mobileConversionRatedBreakdown = mobileConversionRatedBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionUpdatesBreakdown() {
        return mobileConversionUpdatesBreakdown;
    }

    public void setMobileConversionUpdatesBreakdown(TwitterAdStatsBreakdown mobileConversionUpdatesBreakdown) {
        this.mobileConversionUpdatesBreakdown = mobileConversionUpdatesBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionCheckoutInitiatedBreakdown() {
        return mobileConversionCheckoutInitiatedBreakdown;
    }

    public void setMobileConversionCheckoutInitiatedBreakdown(TwitterAdStatsBreakdown mobileConversionCheckoutInitiatedBreakdown) {
        this.mobileConversionCheckoutInitiatedBreakdown = mobileConversionCheckoutInitiatedBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionInstallsBreakdown() {
        return mobileConversionInstallsBreakdown;
    }

    public void setMobileConversionInstallsBreakdown(TwitterAdStatsBreakdown mobileConversionInstallsBreakdown) {
        this.mobileConversionInstallsBreakdown = mobileConversionInstallsBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionPurchasesBreakdown() {
        return mobileConversionPurchasesBreakdown;
    }

    public void setMobileConversionPurchasesBreakdown(TwitterAdStatsBreakdown mobileConversionPurchasesBreakdown) {
        this.mobileConversionPurchasesBreakdown = mobileConversionPurchasesBreakdown;
    }

    public TwitterAdStatsBreakdown getMobileConversionTutorialCompletesBreakdown() {
        return mobileConversionTutorialCompletesBreakdown;
    }

    public void setMobileConversionTutorialCompletesBreakdown(TwitterAdStatsBreakdown mobileConversionTutorialCompletesBreakdown) {
        this.mobileConversionTutorialCompletesBreakdown = mobileConversionTutorialCompletesBreakdown;
    }

    public String[] getPromotedTweetTimelineMediaViews() {
        return promotedTweetTimelineMediaViews;
    }

    public void setPromotedTweetTimelineMediaViews(String[] promotedTweetTimelineMediaViews) {
        this.promotedTweetTimelineMediaViews = promotedTweetTimelineMediaViews;
    }

    public String[] getPromotedTweetSearchMediaViews() {
        return promotedTweetSearchMediaViews;
    }

    public void setPromotedTweetSearchMediaViews(String[] promotedTweetSearchMediaViews) {
        this.promotedTweetSearchMediaViews = promotedTweetSearchMediaViews;
    }

    public String[] getPromotedTweetProfileMediaViews() {
        return promotedTweetProfileMediaViews;
    }

    public void setPromotedTweetProfileMediaViews(String[] promotedTweetProfileMediaViews) {
        this.promotedTweetProfileMediaViews = promotedTweetProfileMediaViews;
    }

    public String[] getPromotedTweetTpnMediaViews() {
        return promotedTweetTpnMediaViews;
    }

    public void setPromotedTweetTpnMediaViews(String[] promotedTweetTpnMediaViews) {
        this.promotedTweetTpnMediaViews = promotedTweetTpnMediaViews;
    }

    public String[] getPromotedTweetSearchQualifiedImpressions() {
        return promotedTweetSearchQualifiedImpressions;
    }

    public void setPromotedTweetSearchQualifiedImpressions(String[] promotedTweetSearchQualifiedImpressions) {
        this.promotedTweetSearchQualifiedImpressions = promotedTweetSearchQualifiedImpressions;
    }

    public String[] getPromotedTweetTimelineQualifiedImpressions() {
        return promotedTweetTimelineQualifiedImpressions;
    }

    public void setPromotedTweetTimelineQualifiedImpressions(String[] promotedTweetTimelineQualifiedImpressions) {
        this.promotedTweetTimelineQualifiedImpressions = promotedTweetTimelineQualifiedImpressions;
    }

    public String[] getPromotedTweetProfileQualifiedImpressions() {
        return promotedTweetProfileQualifiedImpressions;
    }

    public void setPromotedTweetProfileQualifiedImpressions(String[] promotedTweetProfileQualifiedImpressions) {
        this.promotedTweetProfileQualifiedImpressions = promotedTweetProfileQualifiedImpressions;
    }

    public String[] getPromotedTweetTpnQualifiedImpressions() {
        return promotedTweetTpnQualifiedImpressions;
    }

    public void setPromotedTweetTpnQualifiedImpressions(String[] promotedTweetTpnQualifiedImpressions) {
        this.promotedTweetTpnQualifiedImpressions = promotedTweetTpnQualifiedImpressions;
    }

    public String getTotalAudienceReach() {
        return totalAudienceReach;
    }

    public void setTotalAudienceReach(String totalAudienceReach) {
        this.totalAudienceReach = totalAudienceReach;
    }

    public String getAverageFrequency() {
        return averageFrequency;
    }

    public void setAverageFrequency(String averageFrequency) {
        this.averageFrequency = averageFrequency;
    }

    @Override
    public String toString() {
        return "TwitterAdStatistics{" +
                "segment=" + segment +
                ", granularity=" + granularity +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", mobileConversionTutorialsCompleted=" + Arrays.toString(mobileConversionTutorialsCompleted) +
                ", mobileConversionReservations=" + Arrays.toString(mobileConversionReservations) +
                ", mobileConversionAddToCart=" + Arrays.toString(mobileConversionAddToCart) +
                ", mobileConversionAddToWishList=" + Arrays.toString(mobileConversionAddToWishList) +
                ", mobileConversionCheckoutInitiated=" + Arrays.toString(mobileConversionCheckoutInitiated) +
                ", mobileConversionSearches=" + Arrays.toString(mobileConversionSearches) +
                ", conversionSaleAmount=" + Arrays.toString(conversionSaleAmount) +
                ", conversionOrderQuantity=" + Arrays.toString(conversionOrderQuantity) +
                ", conversionKeyPageViews=" + Arrays.toString(conversionKeyPageViews) +
                ", mobileConversionLevelAchieved=" + Arrays.toString(mobileConversionLevelAchieved) +
                ", mobileConversionAchievementUnlocked=" + Arrays.toString(mobileConversionAchievementUnlocked) +
                ", mobileConversionContentViews=" + Arrays.toString(mobileConversionContentViews) +
                ", mobileConversionShares=" + Arrays.toString(mobileConversionShares) +
                ", mobileConversionInvites=" + Arrays.toString(mobileConversionInvites) +
                ", mobileConversionAddedPaymentInfos=" + Arrays.toString(mobileConversionAddedPaymentInfos) +
                ", mobileConversionSpentCredits=" + Arrays.toString(mobileConversionSpentCredits) +
                ", mobileConversionSpentRated=" + Arrays.toString(mobileConversionSpentRated) +
                ", mobileConversionInstalls=" + Arrays.toString(mobileConversionInstalls) +
                ", mobileConversionLogins=" + Arrays.toString(mobileConversionLogins) +
                ", mobileConversionReEngages=" + Arrays.toString(mobileConversionReEngages) +
                ", mobileConversionSignUps=" + Arrays.toString(mobileConversionSignUps) +
                ", mobileConversionPurchases=" + Arrays.toString(mobileConversionPurchases) +
                ", promotedTweetAppInstallAttempts=" + Arrays.toString(promotedTweetAppInstallAttempts) +
                ", promotedTweetAppOpenAttempts=" + Arrays.toString(promotedTweetAppOpenAttempts) +
                ", promotedTweetSearchCardEngagements=" + Arrays.toString(promotedTweetSearchCardEngagements) +
                ", promotedTweetTimelineCardEngagements=" + Arrays.toString(promotedTweetTimelineCardEngagements) +
                ", conversionSignUps=" + Arrays.toString(conversionSignUps) +
                ", conversionPurchases=" + Arrays.toString(conversionPurchases) +
                ", promotedAccountFollowRate=" + Arrays.toString(promotedAccountFollowRate) +
                ", billedChargeMicro=" + Arrays.toString(billedChargeMicro) +
                ", estimatedChargeMicro=" + Arrays.toString(estimatedChargeMicro) +
                ", promotedTweetSearchClicks=" + Arrays.toString(promotedTweetSearchClicks) +
                ", promotedTweetSearchEngagementRate=" + Arrays.toString(promotedTweetSearchEngagementRate) +
                ", promotedTweetSearchRetweets=" + Arrays.toString(promotedTweetSearchRetweets) +
                ", promotedAccountImpressions=" + Arrays.toString(promotedAccountImpressions) +
                ", promotedTweetSearchReplies=" + Arrays.toString(promotedTweetSearchReplies) +
                ", promotedTweetSearchFollows=" + Arrays.toString(promotedTweetSearchFollows) +
                ", promotedAccountProfileVisits=" + Arrays.toString(promotedAccountProfileVisits) +
                ", promotedTweetTimelineClicks=" + Arrays.toString(promotedTweetTimelineClicks) +
                ", promotedTweetTimelineImpressions=" + Arrays.toString(promotedTweetTimelineImpressions) +
                ", promotedAccountFollows=" + Arrays.toString(promotedAccountFollows) +
                ", conversionSiteVisits=" + Arrays.toString(conversionSiteVisits) +
                ", promotedTweetTimelineEngagementRate=" + Arrays.toString(promotedTweetTimelineEngagementRate) +
                ", promotedTweetSearchFavourites=" + Arrays.toString(promotedTweetSearchFavourites) +
                ", promotedTweetSearchQualifiedImpressions=" + Arrays.toString(promotedTweetSearchQualifiedImpressions) +
                ", promotedTweetTimelineFavourites=" + Arrays.toString(promotedTweetTimelineFavourites) +
                ", promotedTweetTimelineQualifiedImpressions=" + Arrays.toString(promotedTweetTimelineQualifiedImpressions) +
                ", promotedTweetSearchUrlClicks=" + Arrays.toString(promotedTweetSearchUrlClicks) +
                ", promotedTweetTimelineUrlClicks=" + Arrays.toString(promotedTweetTimelineUrlClicks) +
                ", billedFollows=" + Arrays.toString(billedFollows) +
                ", conversionCustom=" + Arrays.toString(conversionCustom) +
                ", conversionAppOpen=" + Arrays.toString(conversionAppOpen) +
                ", promotedTweetTimelineRetweets=" + Arrays.toString(promotedTweetTimelineRetweets) +
                ", promotedTweetTimelineReplies=" + Arrays.toString(promotedTweetTimelineReplies) +
                ", billedEngagements=" + Arrays.toString(billedEngagements) +
                ", conversionDownloads=" + Arrays.toString(conversionDownloads) +
                ", promotedTweetTimelineFollows=" + Arrays.toString(promotedTweetTimelineFollows) +
                ", promotedTweetSearchEngagements=" + Arrays.toString(promotedTweetSearchEngagements) +
                ", promotedTweetTimelineEngagements=" + Arrays.toString(promotedTweetTimelineEngagements) +
                ", promotedTweetSearchImpressions=" + Arrays.toString(promotedTweetSearchImpressions) +
                ", promotedVideoTotalViews=" + Arrays.toString(promotedVideoTotalViews) +
                ", promotedVideoReplays=" + Arrays.toString(promotedVideoReplays) +
                ", promotionCardResponses=" + Arrays.toString(promotionCardResponses) +
                ", promotedVideoViews25=" + Arrays.toString(promotedVideoViews25) +
                ", promotedVideoViews50=" + Arrays.toString(promotedVideoViews50) +
                ", promotedVideoViews75=" + Arrays.toString(promotedVideoViews75) +
                ", promotedVideoViews100=" + Arrays.toString(promotedVideoViews100) +
                ", promotedVideoCtaClicks=" + Arrays.toString(promotedVideoCtaClicks) +
                ", mobileConversionInvitesBreakdown=" + mobileConversionInvitesBreakdown +
                ", mobileConversionReEngagesBreakdown=" + mobileConversionReEngagesBreakdown +
                ", mobileConversionAddToCartBreakdown=" + mobileConversionAddToCartBreakdown +
                ", mobileConversionContentViewsBreakdown=" + mobileConversionContentViewsBreakdown +
                ", mobileConversionSpentCreditsBreakdown=" + mobileConversionSpentCreditsBreakdown +
                ", mobileConversionUpdates=" + Arrays.toString(mobileConversionUpdates) +
                ", mobileConversionSharesBreakdown=" + mobileConversionSharesBreakdown +
                ", mobileConversionSearchesBreakdown=" + mobileConversionSearchesBreakdown +
                ", mobileConversionAddedPaymentInfosBreakdown=" + mobileConversionAddedPaymentInfosBreakdown +
                ", promotedTweetAppInstallAttemptsBreakdown=" + promotedTweetAppInstallAttemptsBreakdown +
                ", mobileConversionAchievementUnlockedBreakdown=" + mobileConversionAchievementUnlockedBreakdown +
                ", mobileConversionAddToWishlistBreakdown=" + mobileConversionAddToWishlistBreakdown +
                ", mobileConversionLevelAchievedBreakdown=" + mobileConversionLevelAchievedBreakdown +
                ", mobileConversionReservationsBreakdown=" + mobileConversionReservationsBreakdown +
                ", mobileConversionSignUpsBreakdown=" + mobileConversionSignUpsBreakdown +
                ", promotedTweetAppOpenAttemptsBreakdown=" + promotedTweetAppOpenAttemptsBreakdown +
                ", mobileConversionLoginsBreakdown=" + mobileConversionLoginsBreakdown +
                ", mobileConversionRatedBreakdown=" + mobileConversionRatedBreakdown +
                ", mobileConversionUpdatesBreakdown=" + mobileConversionUpdatesBreakdown +
                ", mobileConversionCheckoutInitiatedBreakdown=" + mobileConversionCheckoutInitiatedBreakdown +
                ", mobileConversionInstallsBreakdown=" + mobileConversionInstallsBreakdown +
                ", mobileConversionPurchasesBreakdown=" + mobileConversionPurchasesBreakdown +
                ", mobileConversionTutorialCompletesBreakdown=" + mobileConversionTutorialCompletesBreakdown +
                ", totalAudienceReach=" + totalAudienceReach +
                ", averageFrequency=" + averageFrequency +
                '}';
    }
}
