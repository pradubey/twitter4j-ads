package twitter4j.models.ads;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: abhishekanand
 * Date: 08/02/15
 * Time: 2:57 AM
 */
public class TwitterUUIDResponse {


    @JsonProperty("uuid")
    private String uUID;


    public String getuUID() {
        return uUID;
    }

    public void setuUID(String uUID) {
        this.uUID = uUID;
    }
}
