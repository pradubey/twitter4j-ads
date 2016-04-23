package twitter4j.models.ads;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by abhishekanand on 11/03/15.
 */
public class TwitterBehaviorTaxonomy extends TwitterEntity {

    @SerializedName("created_at")
    private Date createdAt;

    @SerializedName("name")
    private String name;

    @SerializedName("parent_id")
    private String parentId;

    @SerializedName("updated_at")
    private Date updatedAt;


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
