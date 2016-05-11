package twitter4j.api;

import twitter4j.BaseAdsListResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.preview.TwitterPreviewInfo;
import twitter4j.models.ads.preview.TwitterPreviewTarget;

import java.util.List;

/**
 * User: abhishekanand
 * Date: 02/05/16 2:57 PM.
 */
public interface TwitterAdsPreviewApi {


    BaseAdsListResponse<TwitterPreviewInfo> getUnpublishedPromotedTweetPreview(String accountId, String status, String userId, List<String> mediaIds, String cardId, TwitterPreviewTarget twitterPreviewTarget) throws TwitterException;


    BaseAdsListResponse<TwitterPreviewInfo> getPromotedTweetPreview(String accountId, String tweetId, String userId, TwitterPreviewTarget twitterPreviewTarget) throws TwitterException;

}
