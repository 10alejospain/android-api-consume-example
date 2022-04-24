package example.apiuseexample.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatosOcio {
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("title")
    @Expose
    private Integer title;

    @SerializedName("description")
    @Expose
    private Integer description;

    @SerializedName("longitude")
    @Expose
    private Integer longitude;
    @SerializedName("latitude")
    @Expose
    private Integer latitude;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public void setDescription(Integer description) {
        this.description = description;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public Integer getTitle() {
        return title;
    }

    public Integer getDescription() {
        return description;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }
}
