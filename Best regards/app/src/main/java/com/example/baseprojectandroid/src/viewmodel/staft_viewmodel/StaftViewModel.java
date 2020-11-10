package com.example.baseprojectandroid.src.viewmodel.staft_viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.models.staft_models.StaftModels;
import com.example.baseprojectandroid.src.repositories.staft_repositories.StaftRepositories;

import java.util.List;

public class StaftViewModel extends ViewModel {
    private MutableLiveData<List<StaftModels>> mArrayStaft;
    private MutableLiveData<List<String>> mArrayRoles;
    private StaftRepositories mStaftRepositories;

    //set list staff
    public void initStaft() {
        if (mArrayStaft != null) {
            return;
        }
        mStaftRepositories = StaftRepositories.getInstance();
        mArrayStaft = mStaftRepositories.getListStaft();
    }

    //get list staff
    public MutableLiveData<List<StaftModels>> getmArrayStaff() {
        return mArrayStaft;
    }

    //set list roles
    public void initRoles() {
        if (mArrayRoles != null) {
            return;
        }
        mStaftRepositories = new StaftRepositories();
        mArrayRoles = mStaftRepositories.getListRoles();
    }

    //set list roles
    public LiveData<List<String>> getmArrayRoles(){
        return mArrayRoles;
    }

    //insert staff
    public void insertStaff(StaftModels staftModels){
        List<StaftModels>arrayTmt = mArrayStaft.getValue();
        arrayTmt.add(staftModels);
        mArrayStaft.postValue(arrayTmt);
    }


}
