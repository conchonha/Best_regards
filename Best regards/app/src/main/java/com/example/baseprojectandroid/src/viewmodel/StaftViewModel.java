package com.example.baseprojectandroid.src.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.src.models.staft_models.StaftModels;
import com.example.baseprojectandroid.src.repositories.StaftRepositories;

import java.util.List;

public class StaftViewModel extends ViewModel {
    private MutableLiveData<List<StaftModels>>mArrayStaft;
    private StaftRepositories mStaftRepositories;
    public void initStaft(){
        if (mArrayStaft != null){
            return;
        }
        mStaftRepositories = StaftRepositories.getInstance();
        mArrayStaft = mStaftRepositories.getListStaft();
    }
    public MutableLiveData<List<StaftModels>> getmArrayBill(){
        return mArrayStaft;
    }
}
