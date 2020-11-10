package com.example.baseprojectandroid.src.repositories.bill_repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.baseprojectandroid.models.bill_models.BillModels;

import java.util.ArrayList;
import java.util.List;

public class BillRepositories {
    private static BillRepositories instanceBill;
    private static List<BillModels>mListBill = new ArrayList<>();

    public static BillRepositories getInstance(){
        if (instanceBill == null){
            instanceBill = new BillRepositories();
        }
        return instanceBill;
    }

    public MutableLiveData<List<BillModels>> getListBill(){
        MutableLiveData<List<BillModels>> arrayTmp = new MutableLiveData<>();
        setDataBill();
        arrayTmp.setValue(mListBill);
        return arrayTmp;
    }

    public void setDataBill(){
        mListBill.clear();
        for (int i = 0; i <= 1; i++){
            BillModels models = new BillModels();
            models.setmImageBill("R.drawable.img_bill");
            models.setmBillCode("1230123");
            models.setmDate("09/11/2020");
            models.setmSumBill("25000");
            mListBill.add(models);
        }
    }


}
