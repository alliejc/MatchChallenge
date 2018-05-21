
package com.alisonjc.matchchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CropRect {

    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("y")
    @Expose
    private Integer y;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("x")
    @Expose
    private Integer x;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

}
