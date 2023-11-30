package com.example.teachminttask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {


    private ApiService apiService;





    public void getRepoDetails(String owner, String repo, Callback<RepoDetails> callback) {
        Call<RepoDetails> call = apiService.getRepoDetails(owner);
        call.enqueue(callback);
    }

    public void getContributors(String owner, String repo, Callback<List<Contributor>> callback) {
        Call<List<Contributor>> call = apiService.getContributors(owner, repo);
        call.enqueue(callback);
    }


    public Repository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void searchRepos(String query, final OnRepoSearchListener listener) {
        Call<List<Repository>> call = apiService.searchRepos(query);
        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                if (response.isSuccessful()) {
                    List<Repository> repositories = response.body();
                    listener.onSuccess(repositories);
                } else {
                    listener.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                listener.onError("Failed to communicate with the server");
            }
        });
    }

    public void getRepoDetails(String repoName, final OnRepoDetailsListener listener) {
        Call<RepoDetails> call = apiService.getRepoDetails(repoName);
        call.enqueue(new Callback<RepoDetails>() {
            @Override
            public void onResponse(Call<RepoDetails> call, Response<RepoDetails> response) {
                if (response.isSuccessful()) {
                    RepoDetails repoDetails = response.body();
                    listener.onSuccess(repoDetails);
                } else {
                    listener.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<RepoDetails> call, Throwable t) {
                listener.onError("Failed to communicate with the server");
            }
        });
    }

    public String getRepoDetails(String repoName) {

        return repoName;
    }


    public interface OnRepoSearchListener {
        void onSuccess(List<Repository> repositories);

        void onError(String error);
    }

    public interface OnRepoDetailsListener {
        void onSuccess(RepoDetails repoDetails);

        void onError(String error);
    }
}
