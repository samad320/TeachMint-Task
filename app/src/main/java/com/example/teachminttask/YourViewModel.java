package com.example.teachminttask;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import androidx.lifecycle.LiveData;


public class YourViewModel extends ViewModel {

    private final MutableLiveData<List<YourDataModel>> data = new MutableLiveData<>();

    public LiveData<List<YourDataModel>> getData() {
        return data;
    }

    public void fetchData() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                List<YourDataModel> result = fetchDataFromRepository();

                data.postValue(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private List<YourDataModel> fetchDataFromRepository() {
        return new ArrayList<>();
    }
}
