package twitter4j.api;

import twitter4j.BaseAdsListResponse;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.PromotedTweets;
import twitter4j.models.ads.sort.PromotedTweetsSortByField;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/22/16
 * Time: 1:04 PM
 */
public interface TwitterAdsPromotedTweetApi {

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param lineItemId  A reference to the line item you are operating with in the request. Omitting the lineItemId will return all promoted
     *                    tweets across all campaigns.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param sortByField Sorts by supported attribute in ascending or descending order.
     * @param count       Specifies the number of Promoted Tweets to try to retrieve, up to a maximum of 1000 per distinct request.
     * @param cursor      Specifies a cursor to get the next page of Promoted Tweets.
     * @return Retrieve references to the Promoted Tweets associated with one or more line items.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<PromotedTweets> getAllPromotedTweets(String accountId, String lineItemId, boolean withDeleted,
                                                                     Integer count, String cursor, PromotedTweetsSortByField sortByField) throws TwitterException;


    /**
     * @param accountId       The identifier for the leveraged account.
     * @param promotedTweetId A reference to the promoted tweet you are operating with in the request.
     * @return Retrieve references to the Promoted Tweets associated with the promotedTweetId.
     * @throws TwitterException
     */
    BaseAdsResponse<PromotedTweets> getPromotedTweetsById(String accountId, String promotedTweetId) throws TwitterException;

    /**
     * @param accountId  The identifier for the leveraged account.
     * @param lineItemId Scope the response to just the desired line item
     * @param tweetIds   tweet ids to promote
     * @return created promoted tweet details
     * @throws TwitterException
     */
    BaseAdsListResponse<PromotedTweets> createPromotedTweets(String accountId, String lineItemId, Collection<String> tweetIds)
            throws TwitterException;

    /**
     * @param accountId The identifier for the leveraged account.
     * @param tweetId   Tweet Id to be deleted
     * @return Promoted tweet with deleted field set to true
     * @throws TwitterException
     */
    BaseAdsResponse<PromotedTweets> deletePromotedTweets(String accountId, String tweetId) throws TwitterException;

}
