package twitter4j;

import twitter4j.api.*;
import twitter4j.models.video.TwitterCallToActionType;

/**
 * Created by poly on 29/01/14.
 */
public interface TwitterAds extends java.io.Serializable {

    TwitterAdsCampaignApi getCampaignApi();

    TwitterAdsCardsApi getCardsApi();

    TwitterAdsFundingInstrumentApi getFundingInstrumentApi();

    TwitterAdsLineItemApi getLineItemApi();

    TwitterAdsVideoApi getPromotedApi();

    TwitterAdsStatApi getStatApi();

    TwitterAdsAudienceApi getTailoredAudienceApi();

    TwitterAdsTargetingApi getTargetingApi();

    TwitterAdsWebEventApi getWebEventApi();

    TwitterAdsAccountApi getAccountApi();

    TwitterAdsPromotedTweetApi getPromotedTweetApi();

    TwitterAdsBiddingApi getBiddingApi();

    TwitterAdsClient getTwitterAdsClient();

    TwitterCallToActionApi getCallToActionApi();

    TwitterAdsPreviewApi getPreviewApi();
}