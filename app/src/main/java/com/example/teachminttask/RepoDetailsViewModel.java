package com.example.teachminttask;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class RepoDetailsViewModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<String> repoDetails = new MutableLiveData<String>();

    public RepoDetailsViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<String> getRepoDetails() {
        return repoDetails;
    }

    public void fetchRepoDetails(String repoName) {
        new FetchRepoDetailsTask().execute(repoName);
    }

    public LiveData<Object> getContributors() {

        return null;
    }

    private class FetchRepoDetailsTask extends AsyncTask<String, Void, String> {

        @Override
        public String doInBackground(String... params) {
            String repoName = params[0];
            return repository.getRepoDetails(repoName);
        }

        @Override
        protected void onPostExecute(String result) {
            repoDetails.postValue(result);
        }
    }
}
