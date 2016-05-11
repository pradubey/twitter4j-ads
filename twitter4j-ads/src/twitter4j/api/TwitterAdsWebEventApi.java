package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.tags.WebEventTag;
import twitter4j.models.ads.tags.WebEventTagType;

/**
 * User: abhay
 * Date: 4/7/16
 * Time: 12:15 PM
 */
public interface TwitterAdsWebEventApi {

    /**
     * @param accountId   The identifier for the leveraged account. (required)
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @param count       Specifies the number of web event tags to retrieve, up to a maximum of 1000 per distinct request.
     * @return Web Event Tags for the account
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<WebEventTag> getAllWebEventTags(String accountId, boolean withDeleted, Integer count, String cursor)
            throws TwitterException;

    /**
     * @param accountId     The identifier for the leveraged account. (required)
     * @param withDeleted   Include deleted results in your request. Defaults to false.
     * @param webEventTagId The identifier for the web event tag to retrieve
     * @return Queried web event tag
     * @throws TwitterException
     */
    BaseAdsResponse<WebEventTag> getWebEventTag(String accountId, boolean withDeleted, String webEventTagId) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account. (required)
     * @param name               The name of the web tag
     * @param clickWindow        The click window for this web tag. Possible values are 1, 7, 14, 30, 60 or 90.
     * @param viewThroughWindow  The view through window for this web tag. This value must always be less than or equal to the click_window value. Possible values are 0, 1, 7, 14, 30, 60 or 90.
     * @param type               The type of web tag.
     * @param retargetingEnabled Boolean indicating if retargeting should be enabled for this web tag. Possible values are true, 1, false, 0
     * @return created Event Tag
     * @throws TwitterException
     */
    BaseAdsResponse<WebEventTag> createWebEventTag(String accountId, String name, Integer clickWindow, Integer viewThroughWindow,
                                                   WebEventTagType type, boolean retargetingEnabled) throws TwitterException;

    /**
     * @param accountId          The identifier for the leveraged account. (required)
     * @param webEventTagId      The identifier for a web tag on the current account
     * @param name               The name of the web tag
     * @param clickWindow        The click window for this web tag. Possible values are 1, 7, 14, 30, 60 or 90
     * @param viewThroughWindow  The view through window for this web tag. This value must always be less than or equal to the click_window value.
     *                           Possible values are 0, 1, 7, 14, 30, 60 or 90.
     * @param type               The type of web tag
     * @param retargetingEnabled Boolean indicating if retargeting should be enabled for this web tag. Possible values are true, 1, false, 0
     * @return Updated Event Tag
     * @throws TwitterException
     */
    BaseAdsResponse<WebEventTag> updateWebEventTag(String accountId, String webEventTagId, String name, Integer clickWindow,
                                                   Integer viewThroughWindow, WebEventTagType type, boolean retargetingEnabled)
            throws TwitterException;

    /**
     * Delete a specific web event tag associated to the current account.
     *
     * @param accountId     The identifier for the leveraged account. (required)
     * @param webEventTagId The identifier for the web event tag
     * @return Deleted Tag
     * @throws TwitterException
     */
    BaseAdsResponse<WebEventTag> deleteWebEventTag(String accountId, String webEventTagId) throws TwitterException;

}
