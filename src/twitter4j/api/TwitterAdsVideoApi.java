package twitter4j.api;

import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.video.AssociateVideoToAccountResponse;
import twitter4j.models.video.TwitterAccountMediaResponse;
import twitter4j.models.video.TwitterCreativeType;
import twitter4j.models.video.UploadMediaObjectResponse;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:40 AM
 */
public interface TwitterAdsVideoApi {


    BaseAdsResponse<TwitterAccountMediaResponse> transformMediaInAccount(String accountId, String mediaId, String videoId,
                                                                         TwitterCreativeType twitterCreativeType) throws TwitterException;

    BaseAdsResponse<AssociateVideoToAccountResponse> associateVideoWithAccount(String accountId, String mediaId, String title, String description)
            throws TwitterException;
}
