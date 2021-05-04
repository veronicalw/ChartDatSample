package com.example.diagramcovid.CovidBar;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Model implements Serializable {
    @SerializedName("attributes")
    private Covid mattributes;

    public Covid getmAttributes() {
        return mattributes;
    }

    public void setmAttributes(Covid mattributes) {
        this.mattributes = mattributes;
    }
}
