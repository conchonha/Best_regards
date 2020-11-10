package com.example.baseprojectandroid.src.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.baseprojectandroid.src.models.table_models.TableModels;

import java.util.ArrayList;
import java.util.List;

public class TableRepositories {

    private static TableRepositories instance;
    public static List<TableModels>mListTable = new ArrayList<>();


    public static TableRepositories getInstance(){
        if (instance == null){
            instance = new TableRepositories();
        }
        return instance;
    }
        //quan sát, lắng nghe dữ liệu
    public MutableLiveData<List<TableModels>> getListTable(){
        MutableLiveData<List<TableModels>> arrayTmp = new MutableLiveData<>();
        setDataTable();
        arrayTmp.setValue(mListTable);
        return arrayTmp;
    }

    private void setDataTable(){
        mListTable.clear();
        for (int i = 0; i <= 5; i++){
            TableModels models = new TableModels();
            models.setmNumber("");
            mListTable.add(models);
        }
    }

}
