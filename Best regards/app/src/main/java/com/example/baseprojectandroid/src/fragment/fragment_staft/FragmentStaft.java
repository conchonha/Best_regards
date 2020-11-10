package com.example.baseprojectandroid.src.fragment.fragment_staft;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.adapter.menu_adapter.MenuAdapter;
import com.example.baseprojectandroid.src.adapter.staft_adapter.StaftAdapter;
import com.example.baseprojectandroid.src.models.staft_models.StaftModels;
import com.example.baseprojectandroid.src.viewmodel.MenuViewModel;
import com.example.baseprojectandroid.src.viewmodel.StaftViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentStaft extends Fragment {
    private View mView;
    private RecyclerView mRecyclerStaft;
    private StaftViewModel mStaftViewModel;
    private StaftAdapter mAdapterStaft;
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_staft,container,false);
        mStaftViewModel = ViewModelProviders.of(getActivity()).get(StaftViewModel.class);
        mStaftViewModel.initStaft();

        mStaftViewModel.getmArrayBill().observe(getViewLifecycleOwner(), new Observer<List<StaftModels>>() {
            @Override
            public void onChanged(List<StaftModels> staftModels) {
                Log.d("11111", "onChange: "+staftModels.size());
                mAdapterStaft.notifyDataSetChanged();
            }
        });
        
        initViewStaft();
        return mView;
    }

    private void initViewStaft() {
        mRecyclerStaft = mView.findViewById(R.id.recyclerStaft);
        mRecyclerStaft.setHasFixedSize(true);
        mRecyclerStaft.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        mAdapterStaft = new StaftAdapter(mView.getContext(),R.layout.layout_item_staft,(ArrayList) mStaftViewModel.getmArrayBill().getValue());
        mRecyclerStaft.setAdapter(mAdapterStaft);
        mAdapterStaft.notifyDataSetChanged();
    }
}
