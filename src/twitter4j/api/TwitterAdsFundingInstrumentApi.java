package twitter4j.api;

import twitter4j.BaseAdsListResponseIterable;
import twitter4j.BaseAdsResponse;
import twitter4j.TwitterException;
import twitter4j.models.ads.FundingInstrument;
import twitter4j.models.ads.sort.FundingInstrumentSortByField;

import java.util.Collection;

/**
 * User: abhay
 * Date: 4/5/16
 * Time: 10:36 AM
 */
public interface TwitterAdsFundingInstrumentApi {

    /**
     * @param accountId            The identifier for the leveraged account.
     * @param fundingInstrumentIds Scope the response to just the desired funding instruments by specifying a comma-separated list of identifiers. Up to 50 ids may be provided.
     * @param withDeleted          Include deleted results in your request. Defaults to false.
     * @return Retrieve some or all funding instruments associated with the account.
     * @throws TwitterException
     */
    BaseAdsListResponseIterable<FundingInstrument> getAllFundingInstruments(String accountId, Collection<String> fundingInstrumentIds,
                                                                            boolean withDeleted, FundingInstrumentSortByField sortByField) throws TwitterException;

    /**
     * @param accountId           The identifier for the leveraged account.
     * @param fundingInstrumentId The identifier for a funding instrument associated with the current account.
     * @param withDeleted         Include deleted results in your request. Defaults to false.
     * @return Retrieve a specific funding instrument associated with the account.
     * @throws TwitterException
     */
    BaseAdsResponse<FundingInstrument> getFundingInstrumentById(String accountId, String fundingInstrumentId, boolean withDeleted)
            throws TwitterException;
}
