package com.app.vice.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public abstract class Entity {

    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

}
