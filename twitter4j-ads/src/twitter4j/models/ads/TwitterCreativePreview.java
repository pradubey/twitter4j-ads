package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abhishek.chatrath on 15/06/16.
 */
public class TwitterCreativePreview {

    @SerializedName("platform")
    private String platform;

    @SerializedName("preview")
    private String preview;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

}
