package com.example.baseprojectandroid.src.viewmodel.bill_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.models.bill_models.BillModels;
import com.example.baseprojectandroid.src.repositories.bill_repositories.BillRepositories;

import java.util.List;

public class BillViewModel extends ViewModel {
    private MutableLiveData<List<BillModels>> mArrayBill;
    private BillRepositories mBillRepositories;

    public void initBill() {
        if (mArrayBill != null) {
            return;
        }
        mBillRepositories = BillRepositories.getInstance();
        mArrayBill = mBillRepositories.getListBill();
    }

    public MutableLiveData<List<BillModels>> getmArrayBill() {
        return mArrayBill;
    }
}
