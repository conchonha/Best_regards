package com.example.baseprojectandroid.src.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.baseprojectandroid.src.models.menu_models.MenuModels;
import com.example.baseprojectandroid.src.models.staft_models.StaftModels;

import java.util.ArrayList;
import java.util.List;

public class StaftRepositories {
    private static  StaftRepositories instanceStarft;
    private static List<StaftModels> mListStaft = new ArrayList<>();

    public static StaftRepositories getInstance(){
        if (instanceStarft == null){
            instanceStarft = new StaftRepositories();
        }
        return instanceStarft;
    }
    

    public MutableLiveData<List<StaftModels>> getListStaft(){
        MutableLiveData<List<StaftModels>> arrayTmp = new MutableLiveData<>();
        setDataMenu();
        arrayTmp.setValue(mListStaft);
        return arrayTmp;
    }
    public void setDataMenu(){
        mListStaft.clear();
        for (int i = 0; i <= 2; i++){
            StaftModels models = new StaftModels();
            models.setmNameStaft("Account Demo");
            models.setmRole("Role");
            mListStaft.add(models);
        }
    }
}
