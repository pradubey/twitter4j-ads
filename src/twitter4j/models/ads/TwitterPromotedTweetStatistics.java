package twitter4j.models.ads;

import com.google.common.collect.Sets;
import com.google.gson.annotations.SerializedName;
import twitter4j.models.Granularity;
import twitter4j.models.Segment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

/*
 * created: ekansh mittal
 * created date: 15/06/2015
 */
public class TwitterPromotedTweetStatistics extends TwitterEntity {
    private static final String SEGMENT = "segment";
    private static final String GRANULARITY = "granularity";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";

    public static final Set<String> PROMOTED_TWEET_METRICS;

    private static final String BILLED_CHARGE_LOCAL_MICRO = "billed_charge_local_micro";

    private static final String PROMOTED_TWEET_SEARCH_CLICKS = "promoted_tweet_search_clicks";
    private static final String PROMOTED_TWEET_SEARCH_URL_CLICKS = "promoted_tweet_search_url_clicks";
    private static final String PROMOTED_TWEET_SEARCH_FOLLOWS = "promoted_tweet_search_follows";
    private static final String PROMOTED_TWEET_SEARCH_IMPRESSIONS = "promoted_tweet_search_impressions";
    private static final String PROMOTED_TWEET_SEARCH_ENGAGEMENTS = "promoted_tweet_search_engagements";
    private static final String PROMOTED_TWEET_SEARCH_CARD_ENGAGEMENTS = "promoted_tweet_search_card_engagements";
    private static final String PROMOTED_TWEET_SEARCH_ENGAGEMENT_RATE = "promoted_tweet_search_engagement_rate";
    private static final String PROMOTED_TWEET_SEARCH_FAVORITES = "promoted_tweet_search_favorites";
    private static final String PROMOTED_TWEET_SEARCH_REPLIES = "promoted_tweet_search_replies";
    private static final String PROMOTED_TWEET_SEARCH_RETWEETS = "promoted_tweet_search_retweets";
    private static final String PROMOTED_TWEET_SEARCH_QUALIFIED_IMPRESSIONS = "promoted_tweet_search_qualified_impressions";

    private static final String PROMOTED_TWEET_TIMELINE_CLICKS = "promoted_tweet_timeline_clicks";
    private static final String PROMOTED_TWEET_TIMELINE_URL_CLICKS = "promoted_tweet_timeline_url_clicks";
    private static final String PROMOTED_TWEET_TIMELINE_FOLLOWS = "promoted_tweet_timeline_follows";
    private static final String PROMOTED_TWEET_TIMELINE_IMPRESSIONS = "promoted_tweet_timeline_impressions";
    private static final String PROMOTED_TWEET_TIMELINE_ENGAGEMENTS = "promoted_tweet_timeline_engagements";
    private static final String PROMOTED_TWEET_TIMELINE_CARD_ENGAGEMENTS = "promoted_tweet_timeline_card_engagements";
    private static final String PROMOTED_TWEET_TIMELINE_ENGAGEMENT_RATE = "promoted_tweet_timeline_engagement_rate";
    private static final String PROMOTED_TWEET_TIMELINE_FAVORITES = "promoted_tweet_timeline_favorites";
    private static final String PROMOTED_TWEET_TIMELINE_REPLIES = "promoted_tweet_timeline_replies";
    private static final String PROMOTED_TWEET_TIMELINE_RETWEETS = "promoted_tweet_timeline_retweets";
    private static final String PROMOTED_TWEET_TIMELINE_QUALIFIED_IMPRESSIONS = "promoted_tweet_timeline_qualified_impressions";

    private static final String PROMOTED_TWEET_PROFILE_CLICKS = "promoted_tweet_profile_clicks";
    private static final String PROMOTED_TWEET_PROFILE_URL_CLICKS = "promoted_tweet_profile_url_clicks";
    private static final String PROMOTED_TWEET_PROFILE_FOLLOWS = "promoted_tweet_profile_follows";
    private static final String PROMOTED_TWEET_PROFILE_IMPRESSIONS = "promoted_tweet_profile_impressions";
    private static final String PROMOTED_TWEET_PROFILE_ENGAGEMENTS = "promoted_tweet_profile_engagements";
    private static final String PROMOTED_TWEET_PROFILE_CARD_ENGAGEMENTS = "promoted_tweet_profile_card_engagements";
    private static final String PROMOTED_TWEET_PROFILE_ENGAGEMENT_RATE = "promoted_tweet_profile_engagement_rate";
    private static final String PROMOTED_TWEET_PROFILE_FAVORITES = "promoted_tweet_profile_favorites";
    private static final String PROMOTED_TWEET_PROFILE_REPLIES = "promoted_tweet_profile_replies";
    private static final String PROMOTED_TWEET_PROFILE_RETWEETS = "promoted_tweet_profile_retweets";
    private static final String PROMOTED_TWEET_PROFILE_QUALIFIED_IMPRESSIONS = "promoted_tweet_profile_qualified_impressions";

    private static final String PROMOTED_TWEET_APP_INSTALL_ATTEMPTS = "promoted_tweet_app_install_attempts";
    private static final String PROMOTED_TWEET_APP_OPEN_ATTEMPTS = "promoted_tweet_app_open_attempts";

    private static final String PROMOTED_TWEET_TPN_CLICKS = "promoted_tweet_tpn_clicks";
    private static final String PROMOTED_TWEET_TPN_URL_CLICKS = "promoted_tweet_tpn_url_clicks";
    private static final String PROMOTED_TWEET_TPN_ENGAGEMENTS = "promoted_tweet_tpn_engagements";
    private static final String PROMOTED_TWEET_TPN_FOLLOWS = "promoted_tweet_tpn_follows";
    private static final String PROMOTED_TWEET_TPN_IMPRESSIONS = "promoted_tweet_tpn_impressions";
    private static final String PROMOTED_TWEET_TPN_REPLIES = "promoted_tweet_tpn_replies";
    private static final String PROMOTED_TWEET_TPN_RETWEETS = "promoted_tweet_tpn_retweets";
    private static final String PROMOTED_TWEET_TPN_FAVORITES = "promoted_tweet_tpn_favorites";
    private static final String PROMOTED_TWEET_TPN_ENGAGEMENT_RATE = "promoted_tweet_tpn_engagement_rate";
    private static final String PROMOTED_TWEET_TPN_CARD_ENGAGEMENTS = "promoted_tweet_tpn_card_engagements";
    private static final String PROMOTED_TWEET_TPN_QUALIFIED_IMPRESSIONS = "promoted_tweet_tpn_qualified_impressions";

    private static final String MOBILE_CONVERSION_INSTALLS = "mobile_conversion_installs";
    private static final String MOBILE_CONVERSION_TUTORIAL_COMPLETED = "mobile_conversion_tutorial_completes";
    private static final String MOBILE_CONVERSION_RESERVATIONS = "mobile_conversion_reservations";
    private static final String MOBILE_CONVERSION_ADD_TO_CART = "mobile_conversion_add_to_cart";
    private static final String MOBILE_CONVERSION_ADD_TO_WISHLIST = "mobile_conversion_add_to_wishlist";
    private static final String MOBILE_CONVERSION_CHECKOUT_INITIATED = "mobile_conversion_checkout_initiated";
    private static final String MOBILE_CONVERSION_SEARCHES = "mobile_conversion_searches";
    private static final String MOBILE_CONVERSION_LEVEL_ACHIEVED = "mobile_conversion_level_achieved";
    private static final String MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED = "mobile_conversion_achievement_unlocked";
    private static final String MOBILE_CONVERSION_CONTENT_VIEWS = "mobile_conversion_content_views";
    private static final String MOBILE_CONVERSION_SHARES = "mobile_conversion_shares";
    private static final String MOBILE_CONVERSION_INVITES = "mobile_conversion_invites";
    private static final String MOBILE_CONVERSION_ADDED_PAYMENT_INFOS = "mobile_conversion_added_payment_infos";
    private static final String MOBILE_CONVERSION_SPENT_CREDITS = "mobile_conversion_spent_credits";
    private static final String MOBILE_CONVERSION_SPENT_RATED = "mobile_conversion_rated";
    private static final String MOBILE_CONVERSION_LOGINS = "mobile_conversion_logins";
    private static final String MOBILE_CONVERSION_RE_ENGAGES = "mobile_conversion_re_engages";
    private static final String MOBILE_CONVERSION_SIGN_UPS = "mobile_conversion_sign_ups";
    private static final String MOBILE_CONVERSION_PURCHASES = "mobile_conversion_purchases";
    private static final String MOBILE_CONVERSION_UPDATES = "mobile_conversion_updates";

    private static final String CONVERSION_SITE_VISITS = "conversion_site_visits";
    private static final String CONVERSION_DOWNLOADS = "conversion_downloads";
    private static final String CONVERSION_PURCHASES = "conversion_purchases";
    private static final String CONVERSION_SIGN_UPS = "conversion_sign_ups";
    private static final String CONVERSION_CUSTOM = "conversion_custom";
    private static final String CONVERSION_APP_OPEN = "conversion_app_open";

    public static final String CONVERSION_KEY_PAGE_VIEWS = "conversion_key_page_views";
    public static final String CONVERSION_ORDER_QUANTITY = "conversion_order_quantity";
    public static final String CONVERSION_SALE_AMOUNT = "conversion_sale_amount";

    private static final String PROMOTED_VIDEO_VIEWS_25 = "promoted_video_views_25";
    private static final String PROMOTED_VIDEO_VIEWS_50 = "promoted_video_views_50";
    private static final String PROMOTED_VIDEO_VIEWS_75 = "promoted_video_views_75";
    private static final String PROMOTED_VIDEO_VIEWS_100 = "promoted_video_views_100";
    private static final String PROMOTED_VIDEO_CTA_CLICKS = "promoted_video_cta_clicks";
    private static final String PROMOTED_VIDEO_TOTAL_VIEWS = "promoted_video_total_views";
    private static final String PROMOTED_VIDEO_REPLAYS = "promoted_video_replays";

    private static final String PROMOTED_TWEET_TIMELINE_MEDIA_VIEWS = "promoted_tweet_timeline_media_views";
    private static final String PROMOTED_TWEET_SEARCH_MEDIA_VIEWS = "promoted_tweet_search_media_views";
    private static final String PROMOTED_TWEET_PROFILE_MEDIA_VIEWS = "promoted_tweet_profile_media_views";
    private static final String PROMOTED_TWEET_TPN_MEDIA_VIEWS = "promoted_tweet_tpn_media_views";

    static {
        Set<String> promotedTweetMetrics = Sets.newHashSet(BILLED_CHARGE_LOCAL_MICRO, PROMOTED_TWEET_SEARCH_CLICKS, PROMOTED_TWEET_SEARCH_ENGAGEMENTS,
                                                           PROMOTED_TWEET_SEARCH_FOLLOWS, PROMOTED_TWEET_SEARCH_REPLIES,
                                                           PROMOTED_TWEET_SEARCH_RETWEETS, PROMOTED_TWEET_SEARCH_QUALIFIED_IMPRESSIONS,
                                                           PROMOTED_TWEET_TIMELINE_CLICKS, PROMOTED_TWEET_TIMELINE_ENGAGEMENTS,
                                                           PROMOTED_TWEET_TIMELINE_FOLLOWS, PROMOTED_TWEET_TIMELINE_REPLIES,
                                                           PROMOTED_TWEET_TIMELINE_RETWEETS, PROMOTED_TWEET_SEARCH_URL_CLICKS,
                                                           PROMOTED_TWEET_TIMELINE_URL_CLICKS, PROMOTED_TWEET_TIMELINE_QUALIFIED_IMPRESSIONS,
                                                           PROMOTED_TWEET_SEARCH_FAVORITES, PROMOTED_TWEET_TIMELINE_FAVORITES,
                                                           PROMOTED_TWEET_APP_INSTALL_ATTEMPTS, PROMOTED_TWEET_APP_OPEN_ATTEMPTS,
                                                           PROMOTED_TWEET_SEARCH_ENGAGEMENT_RATE, PROMOTED_TWEET_SEARCH_IMPRESSIONS,
                                                           PROMOTED_TWEET_TIMELINE_ENGAGEMENT_RATE, PROMOTED_TWEET_TIMELINE_IMPRESSIONS,
                                                           PROMOTED_TWEET_TPN_CLICKS, PROMOTED_TWEET_TPN_ENGAGEMENTS, PROMOTED_TWEET_TPN_FOLLOWS,
                                                           PROMOTED_TWEET_TPN_IMPRESSIONS, PROMOTED_TWEET_TPN_REPLIES, PROMOTED_TWEET_TPN_RETWEETS,
                                                           PROMOTED_TWEET_TPN_URL_CLICKS, PROMOTED_TWEET_TPN_FAVORITES,
                                                           PROMOTED_TWEET_TPN_ENGAGEMENT_RATE, PROMOTED_TWEET_TPN_CARD_ENGAGEMENTS,
                                                           PROMOTED_TWEET_TPN_QUALIFIED_IMPRESSIONS, CONVERSION_SITE_VISITS, CONVERSION_DOWNLOADS,
                                                           CONVERSION_PURCHASES, CONVERSION_SIGN_UPS, CONVERSION_CUSTOM, CONVERSION_APP_OPEN,
                                                           CONVERSION_KEY_PAGE_VIEWS, CONVERSION_ORDER_QUANTITY, CONVERSION_SALE_AMOUNT,
                                                           PROMOTED_VIDEO_VIEWS_25, PROMOTED_VIDEO_VIEWS_50, PROMOTED_VIDEO_VIEWS_75,
                                                           PROMOTED_VIDEO_VIEWS_100, PROMOTED_VIDEO_CTA_CLICKS, PROMOTED_VIDEO_TOTAL_VIEWS,
                                                           PROMOTED_VIDEO_REPLAYS, PROMOTED_TWEET_PROFILE_CLICKS, PROMOTED_TWEET_PROFILE_ENGAGEMENTS,
                                                           PROMOTED_TWEET_PROFILE_FAVORITES, PROMOTED_TWEET_PROFILE_FOLLOWS,
                                                           PROMOTED_TWEET_PROFILE_REPLIES, PROMOTED_TWEET_PROFILE_RETWEETS,
                                                           PROMOTED_TWEET_PROFILE_URL_CLICKS, PROMOTED_TWEET_PROFILE_IMPRESSIONS,
                                                           PROMOTED_TWEET_PROFILE_ENGAGEMENT_RATE, PROMOTED_TWEET_PROFILE_QUALIFIED_IMPRESSIONS,
                                                           PROMOTED_TWEET_SEARCH_CARD_ENGAGEMENTS, PROMOTED_TWEET_TIMELINE_CARD_ENGAGEMENTS,
                                                           PROMOTED_TWEET_PROFILE_CARD_ENGAGEMENTS, PROMOTED_TWEET_TIMELINE_MEDIA_VIEWS,
                                                           PROMOTED_TWEET_SEARCH_MEDIA_VIEWS, PROMOTED_TWEET_PROFILE_MEDIA_VIEWS,
                                                           PROMOTED_TWEET_TPN_MEDIA_VIEWS, MOBILE_CONVERSION_INSTALLS,
                                                           MOBILE_CONVERSION_TUTORIAL_COMPLETED, MOBILE_CONVERSION_RESERVATIONS,
                                                           MOBILE_CONVERSION_ADD_TO_CART, MOBILE_CONVERSION_ADD_TO_WISHLIST,
                                                           MOBILE_CONVERSION_CHECKOUT_INITIATED, MOBILE_CONVERSION_SEARCHES,
                                                           MOBILE_CONVERSION_LEVEL_ACHIEVED, MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED,
                                                           MOBILE_CONVERSION_CONTENT_VIEWS, MOBILE_CONVERSION_SHARES, MOBILE_CONVERSION_INVITES,
                                                           MOBILE_CONVERSION_ADDED_PAYMENT_INFOS, MOBILE_CONVERSION_SPENT_CREDITS,
                                                           MOBILE_CONVERSION_SPENT_RATED, MOBILE_CONVERSION_LOGINS, MOBILE_CONVERSION_RE_ENGAGES,
                                                           MOBILE_CONVERSION_SIGN_UPS, MOBILE_CONVERSION_PURCHASES, MOBILE_CONVERSION_UPDATES);
        PROMOTED_TWEET_METRICS = Collections.unmodifiableSet(promotedTweetMetrics);
    }

    @SerializedName(SEGMENT)
    private Segment segment;

    @SerializedName(GRANULARITY)
    private Granularity granularity;

    @SerializedName(START_TIME)
    private Date startTime;

    @SerializedName(END_TIME)
    private Date endTime;

    @SerializedName(BILLED_CHARGE_LOCAL_MICRO)
    private String[] billedChargeLocalMicro;

    @SerializedName(PROMOTED_TWEET_SEARCH_CLICKS)
    private String[] promotedTweetSearchClicks;

    @SerializedName(PROMOTED_TWEET_SEARCH_ENGAGEMENTS)
    private String[] promotedTweetSearchEngagements;

    @SerializedName(PROMOTED_TWEET_SEARCH_CARD_ENGAGEMENTS)
    private String[] promotedTweetSearchCardEngagements;

    @SerializedName(PROMOTED_TWEET_SEARCH_FOLLOWS)
    private String[] promotedTweetSearchFollows;

    @SerializedName(PROMOTED_TWEET_SEARCH_REPLIES)
    private String[] promotedTweetSearchReplies;

    @SerializedName(PROMOTED_TWEET_SEARCH_RETWEETS)
    private String[] promotedTweetSearchRetweets;

    @SerializedName(PROMOTED_TWEET_SEARCH_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetSearchQualifiedImpressions;

    @SerializedName(PROMOTED_TWEET_TIMELINE_CLICKS)
    private String[] promotedTweetTimelineClicks;

    @SerializedName(PROMOTED_TWEET_TIMELINE_ENGAGEMENTS)
    private String[] promotedTweetTimelineEngagements;

    @SerializedName(PROMOTED_TWEET_TIMELINE_CARD_ENGAGEMENTS)
    private String[] promotedTweetTimelineCardEngagements;

    @SerializedName(PROMOTED_TWEET_TIMELINE_FOLLOWS)
    private String[] promotedTweetTimelineFollows;

    @SerializedName(PROMOTED_TWEET_TIMELINE_REPLIES)
    private String[] promotedTweetTimelineReplies;

    @SerializedName(PROMOTED_TWEET_TIMELINE_RETWEETS)
    private String[] promotedTweetTimelineRetweets;

    @SerializedName(PROMOTED_TWEET_SEARCH_URL_CLICKS)
    private String[] promotedTweetSearchUrlClicks;

    @SerializedName(PROMOTED_TWEET_TIMELINE_URL_CLICKS)
    private String[] promotedTweetTimelineUrlClicks;

    @SerializedName(PROMOTED_TWEET_SEARCH_FAVORITES)
    private String[] promotedTweetSearchFavorites;

    @SerializedName(PROMOTED_TWEET_TIMELINE_FAVORITES)
    private String[] promotedTweetTimelineFavorites;

    @SerializedName(PROMOTED_TWEET_TIMELINE_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetTimelineQualifiedImpressions;

    @SerializedName(PROMOTED_TWEET_APP_INSTALL_ATTEMPTS)
    private String[] promotedTweetAppInstallAttempts;

    @SerializedName(PROMOTED_TWEET_APP_OPEN_ATTEMPTS)
    private String[] promotedTweetAppOpenAttempts;

    @SerializedName(PROMOTED_TWEET_SEARCH_ENGAGEMENT_RATE)
    private String[] promotedTweetSearchEngagementRate;

    @SerializedName(PROMOTED_TWEET_SEARCH_IMPRESSIONS)
    private String[] promotedTweetSearchImpressions;

    @SerializedName(PROMOTED_TWEET_TIMELINE_ENGAGEMENT_RATE)
    private String[] promotedTweetTimelineEngagementRate;

    @SerializedName(PROMOTED_TWEET_TIMELINE_IMPRESSIONS)
    private String[] promotedTweetTimelineImpressions;

    @SerializedName(PROMOTED_TWEET_PROFILE_CLICKS)
    private String[] promotedTweetProfileClicks;

    @SerializedName(PROMOTED_TWEET_PROFILE_ENGAGEMENTS)
    private String[] promotedTweetProfileEngagements;

    @SerializedName(PROMOTED_TWEET_PROFILE_CARD_ENGAGEMENTS)
    private String[] promotedTweetProfileCardEngagements;

    @SerializedName(PROMOTED_TWEET_PROFILE_ENGAGEMENT_RATE)
    private String[] promotedTweetProfileEngagementRate;

    @SerializedName(PROMOTED_TWEET_PROFILE_FAVORITES)
    private String[] promotedTweetProfileFavorites;

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

    @SerializedName(PROMOTED_TWEET_PROFILE_QUALIFIED_IMPRESSIONS)
    private String[] promotedTweetProfileQualifiedImpressions;

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

    @SerializedName(CONVERSION_SITE_VISITS)
    private String[] conversionSiteVisits;

    @SerializedName(CONVERSION_DOWNLOADS)
    private String[] conversionDownloads;

    @SerializedName(CONVERSION_PURCHASES)
    private String[] conversionPurchases;

    @SerializedName(CONVERSION_SIGN_UPS)
    private String[] conversionSignUps;

    @SerializedName(CONVERSION_CUSTOM)
    private String[] conversionCustom;

    @SerializedName(CONVERSION_APP_OPEN)
    private String[] conversionAppOpen;

    @SerializedName(CONVERSION_KEY_PAGE_VIEWS)
    private String[] conversionKeyPageViews;

    @SerializedName(CONVERSION_ORDER_QUANTITY)
    private String[] conversionOrderQuantity;

    @SerializedName(CONVERSION_SALE_AMOUNT)
    private String[] conversionSaleAmount;

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

    @SerializedName(PROMOTED_VIDEO_TOTAL_VIEWS)
    private String[] promotedVideoTotalViews;

    @SerializedName(PROMOTED_VIDEO_REPLAYS)
    private String[] promotedVideoReplays;

    @SerializedName(PROMOTED_TWEET_TIMELINE_MEDIA_VIEWS)
    private String[] promotedTweetTimelineMediaViews;

    @SerializedName(PROMOTED_TWEET_SEARCH_MEDIA_VIEWS)
    private String[] promotedTweetSearchMediaViews;

    @SerializedName(PROMOTED_TWEET_PROFILE_MEDIA_VIEWS)
    private String[] promotedTweetProfileMediaViews;

    @SerializedName(PROMOTED_TWEET_TPN_MEDIA_VIEWS)
    private String[] promotedTweetTpnMediaViews;

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

    @SerializedName(MOBILE_CONVERSION_SPENT_RATED)
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

    @SerializedName(MOBILE_CONVERSION_UPDATES)
    private String[] mobileConversionUpdates;

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

    public String[] getBilledChargeLocalMicro() {
        return billedChargeLocalMicro;
    }

    public void setBilledChargeLocalMicro(String[] billedChargeLocalMicro) {
        this.billedChargeLocalMicro = billedChargeLocalMicro;
    }

    public String[] getPromotedTweetSearchClicks() {
        return promotedTweetSearchClicks;
    }

    public void setPromotedTweetSearchClicks(String[] promotedTweetSearchClicks) {
        this.promotedTweetSearchClicks = promotedTweetSearchClicks;
    }

    public String[] getPromotedTweetSearchEngagements() {
        return promotedTweetSearchEngagements;
    }

    public void setPromotedTweetSearchEngagements(String[] promotedTweetSearchEngagements) {
        this.promotedTweetSearchEngagements = promotedTweetSearchEngagements;
    }

    public String[] getPromotedTweetSearchCardEngagements() {
        return promotedTweetSearchCardEngagements;
    }

    public void setPromotedTweetSearchCardEngagements(String[] promotedTweetSearchCardEngagements) {
        this.promotedTweetSearchCardEngagements = promotedTweetSearchCardEngagements;
    }

    public String[] getPromotedTweetSearchFollows() {
        return promotedTweetSearchFollows;
    }

    public void setPromotedTweetSearchFollows(String[] promotedTweetSearchFollows) {
        this.promotedTweetSearchFollows = promotedTweetSearchFollows;
    }

    public String[] getPromotedTweetSearchReplies() {
        return promotedTweetSearchReplies;
    }

    public void setPromotedTweetSearchReplies(String[] promotedTweetSearchReplies) {
        this.promotedTweetSearchReplies = promotedTweetSearchReplies;
    }

    public String[] getPromotedTweetSearchRetweets() {
        return promotedTweetSearchRetweets;
    }

    public void setPromotedTweetSearchRetweets(String[] promotedTweetSearchRetweets) {
        this.promotedTweetSearchRetweets = promotedTweetSearchRetweets;
    }

    public String[] getPromotedTweetTimelineClicks() {
        return promotedTweetTimelineClicks;
    }

    public void setPromotedTweetTimelineClicks(String[] promotedTweetTimelineClicks) {
        this.promotedTweetTimelineClicks = promotedTweetTimelineClicks;
    }

    public String[] getPromotedTweetTimelineEngagements() {
        return promotedTweetTimelineEngagements;
    }

    public void setPromotedTweetTimelineEngagements(String[] promotedTweetTimelineEngagements) {
        this.promotedTweetTimelineEngagements = promotedTweetTimelineEngagements;
    }

    public String[] getPromotedTweetTimelineCardEngagements() {
        return promotedTweetTimelineCardEngagements;
    }

    public void setPromotedTweetTimelineCardEngagements(String[] promotedTweetTimelineCardEngagements) {
        this.promotedTweetTimelineCardEngagements = promotedTweetTimelineCardEngagements;
    }

    public String[] getPromotedTweetTimelineFollows() {
        return promotedTweetTimelineFollows;
    }

    public void setPromotedTweetTimelineFollows(String[] promotedTweetTimelineFollows) {
        this.promotedTweetTimelineFollows = promotedTweetTimelineFollows;
    }

    public String[] getPromotedTweetTimelineReplies() {
        return promotedTweetTimelineReplies;
    }

    public void setPromotedTweetTimelineReplies(String[] promotedTweetTimelineReplies) {
        this.promotedTweetTimelineReplies = promotedTweetTimelineReplies;
    }

    public String[] getPromotedTweetTimelineRetweets() {
        return promotedTweetTimelineRetweets;
    }

    public void setPromotedTweetTimelineRetweets(String[] promotedTweetTimelineRetweets) {
        this.promotedTweetTimelineRetweets = promotedTweetTimelineRetweets;
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

    public String[] getPromotedTweetSearchFavorites() {
        return promotedTweetSearchFavorites;
    }

    public void setPromotedTweetSearchFavorites(String[] promotedTweetSearchFavorites) {
        this.promotedTweetSearchFavorites = promotedTweetSearchFavorites;
    }

    public String[] getPromotedTweetTimelineFavorites() {
        return promotedTweetTimelineFavorites;
    }

    public void setPromotedTweetTimelineFavorites(String[] promotedTweetTimelineFavorites) {
        this.promotedTweetTimelineFavorites = promotedTweetTimelineFavorites;
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

    public String[] getPromotedTweetSearchEngagementRate() {
        return promotedTweetSearchEngagementRate;
    }

    public void setPromotedTweetSearchEngagementRate(String[] promotedTweetSearchEngagementRate) {
        this.promotedTweetSearchEngagementRate = promotedTweetSearchEngagementRate;
    }

    public String[] getPromotedTweetSearchImpressions() {
        return promotedTweetSearchImpressions;
    }

    public void setPromotedTweetSearchImpressions(String[] promotedTweetSearchImpressions) {
        this.promotedTweetSearchImpressions = promotedTweetSearchImpressions;
    }

    public String[] getPromotedTweetTimelineEngagementRate() {
        return promotedTweetTimelineEngagementRate;
    }

    public void setPromotedTweetTimelineEngagementRate(String[] promotedTweetTimelineEngagementRate) {
        this.promotedTweetTimelineEngagementRate = promotedTweetTimelineEngagementRate;
    }

    public String[] getPromotedTweetTimelineImpressions() {
        return promotedTweetTimelineImpressions;
    }

    public void setPromotedTweetTimelineImpressions(String[] promotedTweetTimelineImpressions) {
        this.promotedTweetTimelineImpressions = promotedTweetTimelineImpressions;
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

    public String[] getPromotedTweetProfileCardEngagements() {
        return promotedTweetProfileCardEngagements;
    }

    public void setPromotedTweetProfileCardEngagements(String[] promotedTweetProfileCardEngagements) {
        this.promotedTweetProfileCardEngagements = promotedTweetProfileCardEngagements;
    }

    public String[] getPromotedTweetProfileEngagementRate() {
        return promotedTweetProfileEngagementRate;
    }

    public void setPromotedTweetProfileEngagementRate(String[] promotedTweetProfileEngagementRate) {
        this.promotedTweetProfileEngagementRate = promotedTweetProfileEngagementRate;
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

    public String[] getConversionSiteVisits() {
        return conversionSiteVisits;
    }

    public void setConversionSiteVisits(String[] conversionSiteVisits) {
        this.conversionSiteVisits = conversionSiteVisits;
    }

    public String[] getConversionDownloads() {
        return conversionDownloads;
    }

    public void setConversionDownloads(String[] conversionDownloads) {
        this.conversionDownloads = conversionDownloads;
    }

    public String[] getConversionPurchases() {
        return conversionPurchases;
    }

    public void setConversionPurchases(String[] conversionPurchases) {
        this.conversionPurchases = conversionPurchases;
    }

    public String[] getConversionSignUps() {
        return conversionSignUps;
    }

    public void setConversionSignUps(String[] conversionSignUps) {
        this.conversionSignUps = conversionSignUps;
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

    public String[] getConversionKeyPageViews() {
        return conversionKeyPageViews;
    }

    public void setConversionKeyPageViews(String[] conversionKeyPageViews) {
        this.conversionKeyPageViews = conversionKeyPageViews;
    }

    public String[] getConversionOrderQuantity() {
        return conversionOrderQuantity;
    }

    public void setConversionOrderQuantity(String[] conversionOrderQuantity) {
        this.conversionOrderQuantity = conversionOrderQuantity;
    }

    public String[] getConversionSaleAmount() {
        return conversionSaleAmount;
    }

    public void setConversionSaleAmount(String[] conversionSaleAmount) {
        this.conversionSaleAmount = conversionSaleAmount;
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

    public String[] getMobileConversionUpdates() {
        return mobileConversionUpdates;
    }

    public void setMobileConversionUpdates(String[] mobileConversionUpdates) {
        this.mobileConversionUpdates = mobileConversionUpdates;
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

    @Override
    public String toString() {
        return "TwitterPromotedTweetStatistics{" +
               "segment=" + segment +
               ", startTime=" + startTime +
               ", granularity=" + granularity +
               ", endTime=" + endTime +
               ", promotedTweetSearchClicks=" + Arrays.toString(promotedTweetSearchClicks) +
               ", promotedTweetSearchEngagements=" + Arrays.toString(promotedTweetSearchEngagements) +
               ", promotedTweetSearchFollows=" + Arrays.toString(promotedTweetSearchFollows) +
               ", promotedTweetSearchReplies=" + Arrays.toString(promotedTweetSearchReplies) +
               ", promotedTweetSearchRetweets=" + Arrays.toString(promotedTweetSearchRetweets) +
               ", promotedTweetSearchQualifiedImpressions=" + Arrays.toString(promotedTweetSearchQualifiedImpressions) +
               ", promotedTweetTimelineClicks=" + Arrays.toString(promotedTweetTimelineClicks) +
               ", promotedTweetTimelineEngagements=" + Arrays.toString(promotedTweetTimelineEngagements) +
               ", promotedTweetTimelineFollows=" + Arrays.toString(promotedTweetTimelineFollows) +
               ", promotedTweetTimelineReplies=" + Arrays.toString(promotedTweetTimelineReplies) +
               ", promotedTweetTimelineRetweets=" + Arrays.toString(promotedTweetTimelineRetweets) +
               ", promotedTweetTimelineQualifiedImpressions=" + Arrays.toString(promotedTweetTimelineQualifiedImpressions) +
               ", promotedTweetSearchUrlClicks=" + Arrays.toString(promotedTweetSearchUrlClicks) +
               ", promotedTweetTimelineUrlClicks=" + Arrays.toString(promotedTweetTimelineUrlClicks) +
               ", promotedTweetSearchFavorites=" + Arrays.toString(promotedTweetSearchFavorites) +
               ", promotedTweetTimelineFavorites=" + Arrays.toString(promotedTweetTimelineFavorites) +
               ", promotedTweetAppInstallAttempts=" + Arrays.toString(promotedTweetAppInstallAttempts) +
               ", promotedTweetAppOpenAttempts=" + Arrays.toString(promotedTweetAppOpenAttempts) +
               ", promotedTweetSearchEngagementRate=" + Arrays.toString(promotedTweetSearchEngagementRate) +
               ", promotedTweetSearchImpressions=" + Arrays.toString(promotedTweetSearchImpressions) +
               ", promotedTweetTimelineEngagementRate=" + Arrays.toString(promotedTweetTimelineEngagementRate) +
               ", promotedTweetTimelineImpressions=" + Arrays.toString(promotedTweetTimelineImpressions) +
               ", promotedTweetProfileQualifiedImpressions=" + Arrays.toString(promotedTweetProfileQualifiedImpressions) +
               ", promotedTweetTpnClicks=" + Arrays.toString(promotedTweetTpnClicks) +
               ", promotedTweetTpnEngagements=" + Arrays.toString(promotedTweetTpnEngagements) +
               ", promotedTweetTpnFollows=" + Arrays.toString(promotedTweetTpnFollows) +
               ", promotedTweetTpnImpressions=" + Arrays.toString(promotedTweetTpnImpressions) +
               ", promotedTweetTpnReplies=" + Arrays.toString(promotedTweetTpnReplies) +
               ", promotedTweetTpnRetweets=" + Arrays.toString(promotedTweetTpnRetweets) +
               ", promotedTweetTpnUrlClicks=" + Arrays.toString(promotedTweetTpnUrlClicks) +
               ", promotedTweetTpnFavorites=" + Arrays.toString(promotedTweetTpnFavorites) +
               ", promotedTweetTpnEngagementRate=" + Arrays.toString(promotedTweetTpnEngagementRate) +
               ", promotedTweetTpnCardEngagements=" + Arrays.toString(promotedTweetTpnCardEngagements) +
               ", promotedTweetTpnQualifiedImpressions=" + Arrays.toString(promotedTweetTpnQualifiedImpressions) +
               "}";
    }
}
