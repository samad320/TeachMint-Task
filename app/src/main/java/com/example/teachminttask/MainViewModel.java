package com.example.teachminttask;

import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    LiveData<List<YourDataModel>> repoList;

    private final MutableLiveData<List<YourDataModel>> data = new MutableLiveData<>();

    public LiveData<List<YourDataModel>> getData() {
        return data;
    }

    public void fetchData(String query) {
        new FetchDataTask().execute(query);
    }

    private class FetchDataTask extends AsyncTask<String, Void, List<YourDataModel>> {

        @Override
        protected List<YourDataModel> doInBackground(String... params) {
            String query = params[0];
            try {
                return fetchDataFromRepository(query);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<YourDataModel> result) {
            if (result != null) {
                data.setValue(result);
            }
        }
    }
    public LiveData<List<YourDataModel>> getRepoList() {

        return repoList;
    }

    private List<YourDataModel> fetchDataFromRepository(String query) {
        return new ArrayList<>();
    }

    public void fetchRepoList(String query) {
        new FetchDataTask().execute(query);
    }

}
