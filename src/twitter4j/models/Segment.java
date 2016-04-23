package twitter4j.models;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * User: Roota
 * Date: 17/02/14.
 */
public class Segment {
    @JsonProperty("segmentation_type")
    private TwitterSegmentationType segmentationType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("segmentation_value")
    private String segmentationValue;

    public TwitterSegmentationType getSegmentationType() {
        return segmentationType;
    }

    public String getName() {
        return name;
    }

    public String getSegmentationValue() {
        return segmentationValue;
    }
}
