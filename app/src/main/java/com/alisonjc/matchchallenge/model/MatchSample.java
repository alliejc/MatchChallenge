
package com.alisonjc.matchchallenge.model;

import java.util.List;

import com.alisonjc.matchchallenge.model.Datum;
import com.alisonjc.matchchallenge.model.Paging;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchSample {

    @SerializedName("total_matches")
    @Expose
    private Integer totalMatches;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("paging")
    @Expose
    private Paging paging;

    public Integer getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(Integer totalMatches) {
        this.totalMatches = totalMatches;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

}
