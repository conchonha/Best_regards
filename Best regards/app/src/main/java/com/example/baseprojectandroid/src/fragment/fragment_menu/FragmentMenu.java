package com.example.baseprojectandroid.src.fragment.fragment_menu;

import android.os.Bundle;
import android.util.Log;
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
import com.example.baseprojectandroid.src.adapter.menu_adapter.MenuAdapter;
import com.example.baseprojectandroid.src.adapter.table_adapter.TableAdapter;
import com.example.baseprojectandroid.src.models.menu_models.MenuModels;
import com.example.baseprojectandroid.src.viewmodel.MenuViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentMenu extends Fragment {
    private View mView;
    private RecyclerView mRecyclerMenu;
    private MenuViewModel mMenuViewModel;
    private MenuAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_menu,container,false);
        mMenuViewModel = ViewModelProviders.of(getActivity()).get(MenuViewModel.class);
        mMenuViewModel.initMenu();
        mMenuViewModel.getmArrayMenu().observe(getViewLifecycleOwner(), new Observer<List<MenuModels>>() {
            @Override
            public void onChanged(List<MenuModels> menuModels) {
//                Log.d("11111", "onChange: "+menuModels.size());
                mAdapter.notifyDataSetChanged();
            }
        });
        initViewMenu();
        return mView;
    }

    private void initViewMenu() {
        mRecyclerMenu = mView.findViewById(R.id.recyclerMenu);
        mRecyclerMenu.setHasFixedSize(true);
        mRecyclerMenu.setLayoutManager(new GridLayoutManager(mView.getContext(),2));
        mAdapter = new MenuAdapter((ArrayList) mMenuViewModel.getmArrayMenu().getValue(), mView.getContext(), R.layout.layout_item_menu);
        mRecyclerMenu.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
