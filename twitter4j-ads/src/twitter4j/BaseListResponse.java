package twitter4j;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Use this only, if any data needs to be pulled using regular twitter domain objects
 * @param <T> domain object class
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseListResponse<T> extends BaseAdsListResponse<T> {

}
