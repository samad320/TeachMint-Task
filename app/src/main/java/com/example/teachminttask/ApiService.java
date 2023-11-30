package com.example.teachminttask;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search/repositories")
    Call<RepoSearchResponse> searchRepos(
            @Query("q") String query,
            @Query("page") int page,
            @Query("per_page") int perPage
    );

    @GET("repos/{owner}/{repo}")
    Call<RepoDetails> getRepoDetails(
           @Path("owner") String owner
    );

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> getContributors(
            @Path("owner") String owner,
            @Path("repo") String repo
    );

    Call<List<Repository>> searchRepos(String query);
}
