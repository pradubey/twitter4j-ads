package twitter4j;

/**
 * User: gaganjain
 * Date: 28/09/14
 * Time: 2:23 AM
 */
public enum AdScopeTimelineScope {

    FOLLOWERS("followers"),
    PLACE_IDS("place_ids"),
    NONE("none");

    private final String scope;

    AdScopeTimelineScope(String scope) {
        this.scope = scope;
    }

    private String getScope() {
        return scope;
    }

    public static String getScopeValue(AdScopeTimelineScope value) {
        if (value == null) {
            value = FOLLOWERS;
        }
        return value.getScope();
    }

}
