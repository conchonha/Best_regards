package com.example.baseprojectandroid.src.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.src.models.bill_models.BillModels;
import com.example.baseprojectandroid.src.repositories.BillRepositories;

import java.util.List;

public class BillViewModel extends ViewModel {
    private MutableLiveData<List<BillModels>>mArrayBill;
    private BillRepositories mBillRepositories;

    public void initBill(){
        if (mArrayBill != null){
            return;
        }
        mBillRepositories = BillRepositories.getInstance();
        mArrayBill = mBillRepositories.getListBill();
    }
    public MutableLiveData<List<BillModels>> getmArrayBill(){
        return mArrayBill;
    }
}
