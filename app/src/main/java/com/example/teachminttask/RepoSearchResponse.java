package com.example.teachminttask;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RepoSearchResponse {
    @SerializedName("total_count")
    private int totalCount;

    @SerializedName("items")
    private List<RepoDetails> repoDetailsList;

    public int getTotalCount() {
        return totalCount;
    }

    public List<RepoDetails> getRepoDetailsList() {
        return repoDetailsList;
    }
}
