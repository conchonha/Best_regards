package com.example.baseprojectandroid.src.fragment.fragment_bill;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.adapter.bill_adapter.BillAdapter;
import com.example.baseprojectandroid.src.models.bill_models.BillModels;
import com.example.baseprojectandroid.src.viewmodel.BillViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentBill extends Fragment {
    private View mView;
    private RecyclerView mRecyclerView;
    private BillViewModel mBillViewModel;
    private BillAdapter mAdapterBill;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_bill,container,false);
        mBillViewModel = ViewModelProviders.of(getActivity()).get(BillViewModel.class);
        mBillViewModel.initBill();

        mBillViewModel.getmArrayBill().observe(getViewLifecycleOwner(), new Observer<List<BillModels>>() {
            @Override
            public void onChanged(List<BillModels> billModels) {
//                Log.d("11111", "onChange: "+billModels.size());
                mAdapterBill.notifyDataSetChanged();
            }
        });
        
        initView();
        return mView;
    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.recyclerBill);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        mAdapterBill = new BillAdapter((ArrayList) mBillViewModel.getmArrayBill().getValue(),mView.getContext(),R.layout.layout_item_bill);
        mRecyclerView.setAdapter(mAdapterBill);
        mAdapterBill.notifyDataSetChanged();
    }
}
