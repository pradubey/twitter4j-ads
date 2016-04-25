package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gaganjain
 * Date: 10/14/13
 * Time: 12:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TargetingLocations implements Serializable {

    @SerializedName("data_type")
    private String dataType;

    @SerializedName("data")
    private List<TargetingLocation> targetingLocations;

    public List<TargetingLocation> getTargetingLocations() {
        return targetingLocations;
    }

    public void setTargetingLocations(List<TargetingLocation> targetingLocations) {
        this.targetingLocations = targetingLocations;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
