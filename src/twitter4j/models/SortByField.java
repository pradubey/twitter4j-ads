package twitter4j.models;

/**
 * Created by abhishekanand on 11/03/15.
 */
public enum SortByField {
    PARTNER_SOURCE("partner_source"),
    AUDIENCE_SIZE("audience_size"),
    NAME("name"); //only for taxonomy

    private String name;

    SortByField() {
    }

    SortByField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
