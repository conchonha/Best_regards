package com.example.baseprojectandroid.src.fragment.fragment_table;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.adapter.table_adapter.TableAdapter;
import com.example.baseprojectandroid.src.models.table_models.TableModels;
import com.example.baseprojectandroid.src.viewmodel.TableViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentTable extends Fragment {
    private View mView;
    private RecyclerView mRecyclerView;
    private TableViewModel mTableViewModel;
    private TableAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_table, container, false);
        mTableViewModel = ViewModelProviders.of(getActivity()).get(TableViewModel.class);
        mTableViewModel.initTable();

        mTableViewModel.getmArrayTable().observe(getViewLifecycleOwner(), new Observer<List<TableModels>>() {
            @Override
            public void onChanged(List<TableModels> tableModels) {
                    mAdapter.notifyDataSetChanged();
//                Log.d("11111", "onChange: "+tableModels.size());

            }
        });
        initView();

        return mView;
    }

    //ánh xạ view
    private void initView() {
        mRecyclerView = mView.findViewById(R.id.recyclerTable);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mView.getContext(),2));
        mAdapter = new TableAdapter((ArrayList) mTableViewModel.getmArrayTable().getValue(), mView.getContext(), R.layout.layout_item_listtable);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }
}
