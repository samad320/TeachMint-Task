package com.example.teachminttask;

import com.google.gson.annotations.SerializedName;

import java.security.acl.Owner;

public class RepoDetails {
    @SerializedName("name")
    private String name;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("description")
    private String description;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("owner")
    private Owner owner;


    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public Owner getOwner() {
        return owner;
    }


}
