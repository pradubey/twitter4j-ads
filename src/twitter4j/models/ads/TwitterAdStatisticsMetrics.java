package twitter4j.models.ads;

import java.util.*;

import atlas.shaded.com.google.common.collect.Sets;
import atlas.shaded.com.google.common.collect.Maps;

import static twitter4j.models.ads.TwitterAdStatistics.*;

/**
 * User: abhay
 * Date: 2/27/16
 * Time: 10:34 AM
 */

public class TwitterAdStatisticsMetrics {

    public static final Set<String> ALL_METRICS;
    public static final Map<String, Set<String>> METRICS_BY_OBJECTIVE;

    static {
        Set<String> adLevelMetrics = Sets.newHashSet();

        for (MetricClass metricClass : MetricClass.values()) {
            adLevelMetrics.addAll(Arrays.asList(metricClass.getMetrics()));
        }

        Map<String, Set<String>> metricsByObjective = Maps.newHashMap();
        for (AdObjective adObjective : AdObjective.values()) {
            Set<String> metrics = Sets.newHashSet();
            for (MetricClass metricClass : adObjective.getMetricClasses()) {
                metrics.addAll(Arrays.asList(metricClass.getMetrics()));
            }
            metricsByObjective.put(adObjective.getObjective().toLowerCase(), metrics);
        }

        ALL_METRICS = Collections.unmodifiableSet(adLevelMetrics);
        METRICS_BY_OBJECTIVE = Collections.unmodifiableMap(metricsByObjective);
    }

    public static Set<String> getMetrics(String objective) {
        if (objective == null) {
            return ALL_METRICS;
        }
        Set<String> toReturn = METRICS_BY_OBJECTIVE.get(objective.toLowerCase());
        if (toReturn == null) {
            return ALL_METRICS;
        }
        return toReturn;
    }

    enum MetricClass {
        ENGAGEMENT(BILLED_ENGAGEMENTS, BILLED_FOLLOWS, PROMOTED_ACCOUNT_FOLLOWS, PROMOTED_TWEET_PROFILE_CARD_ENGAGEMENTS,
                   PROMOTED_TWEET_PROFILE_CLICKS, PROMOTED_TWEET_PROFILE_ENGAGEMENTS, PROMOTED_TWEET_PROFILE_FAVORITES,
                   PROMOTED_TWEET_PROFILE_FOLLOWS, PROMOTED_TWEET_PROFILE_REPLIES, PROMOTED_TWEET_PROFILE_RETWEETS, PROMOTED_TWEET_PROFILE_URL_CLICKS,
                   PROMOTED_TWEET_SEARCH_CARD_ENGAGEMENTS, PROMOTED_TWEET_SEARCH_CLICKS, PROMOTED_TWEET_SEARCH_ENGAGEMENTS,
                   PROMOTED_TWEET_SEARCH_FAVOURITES, PROMOTED_TWEET_SEARCH_FOLLOWS, PROMOTED_TWEET_SEARCH_REPLIES, PROMOTED_TWEET_SEARCH_RETWEETS,
                   PROMOTED_TWEET_SEARCH_URL_CLICKS, PROMOTED_TWEET_TIMELINE_CARD_ENGAGEMENTS, PROMOTED_TWEET_TIMELINE_CLICKS,
                   PROMOTED_TWEET_TIMELINE_ENGAGEMENTS, PROMOTED_TWEET_TIMELINE_FAVOURITES, PROMOTED_TWEET_TIMELINE_FOLLOWS,
                   PROMOTED_TWEET_TIMELINE_REPLIES, PROMOTED_TWEET_TIMELINE_RETWEETS, PROMOTED_TWEET_TIMELINE_URL_CLICKS,
                   PROMOTED_TWEET_SEARCH_QUALIFIED_IMPRESSIONS, PROMOTED_TWEET_TIMELINE_QUALIFIED_IMPRESSIONS),

        CONVERSION(CONVERSION_CUSTOM, CONVERSION_DOWNLOADS, CONVERSION_ORDER_QUANTITY, CONVERSION_PURCHASES, CONVERSION_SALE_AMOUNT,
                   CONVERSION_SIGN_UPS, CONVERSION_SITE_VISITS, CONVERSION_APP_OPEN, CONVERSION_KEY_PAGE_VIEWS),

        MEDIA(PROMOTED_TWEET_PROFILE_MEDIA_VIEWS, PROMOTED_TWEET_SEARCH_MEDIA_VIEWS, PROMOTED_TWEET_TIMELINE_MEDIA_VIEWS,
              PROMOTED_TWEET_TPN_MEDIA_VIEWS),

//        MOBILE_LIFETIME_VALUE(MOBILE_LIFETIME_VALUE_CONVERSION_BREAKDOWN, MOBILE_LIFETIME_VALUE_CONVERSION_SALE_AMOUNT_LOCAL_MICRO_BREAKDOWN,
//                MOBILE_LIFETIME_VALUE_CONVERSION_ORDER_QUANTITY_BREAKDOWN),

        MOBILE_APP_PROMOTION(MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED, MOBILE_CONVERSION_ACHIEVEMENT_UNLOCKED_BREAKDOWN, MOBILE_CONVERSION_ADD_TO_CART,
                             MOBILE_CONVERSION_ADD_TO_CART_BREAKDOWN, MOBILE_CONVERSION_ADD_TO_WISHLIST, MOBILE_CONVERSION_ADD_TO_WISHLIST_BREAKDOWN,
                             MOBILE_CONVERSION_ADDED_PAYMENT_INFOS, MOBILE_CONVERSION_ADDED_PAYMENT_INFOS_BREAKDOWN,
                             MOBILE_CONVERSION_CHECKOUT_INITIATED, MOBILE_CONVERSION_CHECKOUT_INITIATED_BREAKDOWN, MOBILE_CONVERSION_CONTENT_VIEWS,
                             MOBILE_CONVERSION_CONTENT_VIEWS_BREAKDOWN, MOBILE_CONVERSION_INSTALLS, MOBILE_CONVERSION_INSTALLS_BREAKDOWN,
                             MOBILE_CONVERSION_INVITES, MOBILE_CONVERSION_INVITES_BREAKDOWN, MOBILE_CONVERSION_LEVEL_ACHIEVED,
                             MOBILE_CONVERSION_LEVEL_ACHIEVED_BREAKDOWN, MOBILE_CONVERSION_LOGINS, MOBILE_CONVERSION_LOGINS_BREAKDOWN,
                             MOBILE_CONVERSION_ORDER_QUANTITY, MOBILE_CONVERSION_PURCHASES, MOBILE_CONVERSION_PURCHASES_BREAKDOWN,
                             MOBILE_CONVERSION_RATED, MOBILE_CONVERSION_RATED_BREAKDOWN, MOBILE_CONVERSION_RE_ENGAGES,
                             MOBILE_CONVERSION_RE_ENGAGES_BREAKDOWN, MOBILE_CONVERSION_RESERVATIONS, MOBILE_CONVERSION_RESERVATIONS_BREAKDOWN,
                             MOBILE_CONVERSION_SALE_AMOUNT_LOCAL_MICRO, MOBILE_CONVERSION_SEARCHES, MOBILE_CONVERSION_SEARCHES_BREAKDOWN,
                             MOBILE_CONVERSION_SHARES, MOBILE_CONVERSION_SHARES_BREAKDOWN, MOBILE_CONVERSION_SIGN_UPS,
                             MOBILE_CONVERSION_SIGN_UPS_BREAKDOWN, MOBILE_CONVERSION_SPENT_CREDITS, MOBILE_CONVERSION_SPENT_CREDITS_BREAKDOWN,
                             MOBILE_CONVERSION_TUTORIAL_COMPLETED, MOBILE_CONVERSION_TUTORIAL_COMPLETES_BREAKDOWN, MOBILE_CONVERSION_UPDATES,
                             MOBILE_CONVERSION_UPDATES_BREAKDOWN, PROMOTED_TWEET_APP_INSTALL_ATTEMPTS, PROMOTED_TWEET_APP_OPEN_ATTEMPTS,
                             PROMOTED_TWEET_APP_INSTALL_ATTEMPTS_BREAKDOWN, PROMOTED_TWEET_APP_OPEN_ATTEMPTS_BREAKDOWN),

        SPEND(BILLED_CHARGE_LOCAL_MICRO),

        TWITTER_AUDIENCE_PLATFORM(PROMOTED_TWEET_TPN_CARD_ENGAGEMENTS, PROMOTED_TWEET_TPN_ENGAGEMENT_RATE, PROMOTED_TWEET_TPN_ENGAGEMENTS,
                                  PROMOTED_TWEET_TPN_CLICKS, PROMOTED_TWEET_TPN_FAVORITES, PROMOTED_TWEET_TPN_FOLLOWS, PROMOTED_TWEET_TPN_IMPRESSIONS,
                                  PROMOTED_TWEET_TPN_REPLIES, PROMOTED_TWEET_TPN_RETWEETS, PROMOTED_TWEET_TPN_URL_CLICKS,
                                  PROMOTED_TWEET_TPN_QUALIFIED_IMPRESSIONS),

        VIDEO(PROMOTED_VIDEO_CTA_CLICKS, PROMOTED_VIDEO_REPLAYS, PROMOTED_VIDEO_TOTAL_VIEWS, PROMOTED_VIDEO_VIEWS_100, PROMOTED_VIDEO_VIEWS_25,
              PROMOTED_VIDEO_VIEWS_50, PROMOTED_VIDEO_VIEWS_75),

        OTHER(PROMOTED_ACCOUNT_FOLLOW_RATE, PROMOTED_ACCOUNT_IMPRESSIONS, PROMOTED_ACCOUNT_PROFILE_VISITS, PROMOTED_TWEET_PROFILE_IMPRESSIONS,
              PROMOTED_TWEET_SEARCH_ENGAGEMENT_RATE, PROMOTED_TWEET_SEARCH_IMPRESSIONS, PROMOTED_TWEET_TIMELINE_ENGAGEMENT_RATE,
              PROMOTED_TWEET_TIMELINE_IMPRESSIONS, PROMOTED_TWEET_PROFILE_QUALIFIED_IMPRESSIONS, PROMOTED_TWEET_PROFILE_ENGAGEMENT_RATE);

        private String[] metrics;

        MetricClass(String... metrics) {
            this.metrics = metrics;
        }

        public String[] getMetrics() {
            return this.metrics;
        }
    }

    enum AdObjective {
        APP_ENGAGEMENTS("app_engagements", MetricClass.ENGAGEMENT, MetricClass.MOBILE_APP_PROMOTION, MetricClass.SPEND,
                        MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO, MetricClass.OTHER),

        APP_INSTALLS("app_installs", MetricClass.ENGAGEMENT, MetricClass.MOBILE_APP_PROMOTION, //MetricClass.MOBILE_LIFETIME_VALUE,
                     MetricClass.OTHER, MetricClass.SPEND, MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO),

        BRAND_ENGAGEMENTS("brand_engagements", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.SPEND,
                          MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO, MetricClass.OTHER),

        CUSTOM("custom", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.MOBILE_APP_PROMOTION,
               // MetricClass.MOBILE_LIFETIME_VALUE,
               MetricClass.SPEND, MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO, MetricClass.OTHER),

        FOLLOWERS("followers", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.MOBILE_APP_PROMOTION, MetricClass.SPEND,
                  MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO, MetricClass.OTHER),

        LEAD_GENERATION("lead_generation", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.SPEND, MetricClass.TWITTER_AUDIENCE_PLATFORM,
                        MetricClass.OTHER),

        PREROLL_VIEWS("preroll_views", MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.MOBILE_APP_PROMOTION, MetricClass.SPEND,
                      MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO, MetricClass.OTHER),

        TWEET_ENGAGEMENTS("tweet_engagements", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.SPEND,
                          MetricClass.VIDEO, MetricClass.OTHER),

        QUALIFIED_VIEWS("qualified_views", MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.SPEND, MetricClass.VIDEO, MetricClass.OTHER),

        VIDEO_VIEWS("video_views", MetricClass.ENGAGEMENT, MetricClass.SPEND, MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.VIDEO,
                    MetricClass.OTHER),

        WEBSITE_CLICKS("website_clicks", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.SPEND,
                       MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.OTHER),

        WEBSITE_CONVERSIONS("website_conversions", MetricClass.CONVERSION, MetricClass.ENGAGEMENT, MetricClass.MEDIA, MetricClass.SPEND,
                            MetricClass.TWITTER_AUDIENCE_PLATFORM, MetricClass.OTHER);

        private MetricClass[] metricClasses;
        private String objective;

        AdObjective(String objective, MetricClass... metricClasses) {
            this.metricClasses = metricClasses;
            this.objective = objective;
        }

        public MetricClass[] getMetricClasses() {
            return metricClasses;
        }

        public String getObjective() {
            return objective;
        }
    }
}
