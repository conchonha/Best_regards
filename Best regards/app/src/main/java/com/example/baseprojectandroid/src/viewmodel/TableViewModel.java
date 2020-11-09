package com.example.baseprojectandroid.src.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.src.models.table_models.TableModels;
import com.example.baseprojectandroid.src.repositories.TableRepositories;

import java.util.List;

public class TableViewModel extends ViewModel {
    private MutableLiveData<List<TableModels>> mArrayTable;

    private TableRepositories tableRepositories;

    public void initTable(){
        if (mArrayTable != null){
            return;
        }
        tableRepositories = TableRepositories.getInstance();
        mArrayTable = tableRepositories.getListTable();
    }
    public MutableLiveData<List<TableModels>> getmArrayTable(){
        return mArrayTable;
    }

}
