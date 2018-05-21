
package com.alisonjc.matchchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("full_paths")
    @Expose
    private FullPaths fullPaths;
    @SerializedName("base_path")
    @Expose
    private String basePath;
    @SerializedName("original_size")
    @Expose
    private OriginalSize originalSize;
    @SerializedName("ordinal")
    @Expose
    private Integer ordinal;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("crop_rect")
    @Expose
    private CropRect cropRect;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("thumb_paths")
    @Expose
    private ThumbPaths thumbPaths;

    public FullPaths getFullPaths() {
        return fullPaths;
    }

    public void setFullPaths(FullPaths fullPaths) {
        this.fullPaths = fullPaths;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public OriginalSize getOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(OriginalSize originalSize) {
        this.originalSize = originalSize;
    }

    public Integer getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(Integer ordinal) {
        this.ordinal = ordinal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CropRect getCropRect() {
        return cropRect;
    }

    public void setCropRect(CropRect cropRect) {
        this.cropRect = cropRect;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ThumbPaths getThumbPaths() {
        return thumbPaths;
    }

    public void setThumbPaths(ThumbPaths thumbPaths) {
        this.thumbPaths = thumbPaths;
    }

}
