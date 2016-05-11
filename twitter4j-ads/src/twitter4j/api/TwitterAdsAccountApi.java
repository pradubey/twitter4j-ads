package twitter4j.api;

import com.google.common.base.Optional;
import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.AdAccount;
import twitter4j.models.ads.PromotableUser;
import twitter4j.models.ads.TwitterAccountPermissions;
import twitter4j.models.ads.sort.AccountsSortByField;

import java.util.List;

/**
 * User: abhay
 * Date: 4/4/16
 * Time: 7:52 PM
 */
public interface TwitterAdsAccountApi {
    /**
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return all the advertising-enabled accounts the authenticating user has access to.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<AdAccount> getAllAccounts(boolean withDeleted, Optional<AccountsSortByField> accountsSortByField) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return detailed information on the specified account that the authenticating user has access to.
     * @throws TwitterException
     */
    BaseAdsResponse<AdAccount> getAdAccountById(String accountId, boolean withDeleted) throws TwitterException;


    List<TwitterAccountPermissions> getAccountPermissions(String accountId) throws TwitterException;

    /**
     * @param accountId   The identifier for the leveraged account.
     * @param withDeleted Include deleted results in your request. Defaults to false.
     * @return the collection of promotable_users associated with an account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<PromotableUser> getPromotableUsers(String accountId, boolean withDeleted) throws TwitterException;

}
