package com.example.baseprojectandroid.src.fragment.fragment_menu;

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
import com.example.baseprojectandroid.compoments.toolbar.Toolbar;
import com.example.baseprojectandroid.src.adapter.menu_adapter.MenuAdapter;
import com.example.baseprojectandroid.src.models.menu_models.MenuModels;
import com.example.baseprojectandroid.src.viewmodel.menu_viewmodel.MenuViewModel;

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
        initViewModel();
        initView();
        init();
        return mView;
    }

    //create viewmodel
    private void initViewModel() {
        mMenuViewModel = ViewModelProviders.of(getActivity()).get(MenuViewModel.class);
        mMenuViewModel.initMenu();

        // lắng nghe quan sát sự thay đổi của dữ liệu
        mMenuViewModel.getmArrayMenu().observe(getViewLifecycleOwner(), new Observer<List<MenuModels>>() {
            @Override
            public void onChanged(List<MenuModels> menuModels) {
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        //set recyclerview
        mRecyclerMenu.setHasFixedSize(true);
        mRecyclerMenu.setLayoutManager(new GridLayoutManager(mView.getContext(),2));
        mAdapter = new MenuAdapter((ArrayList) mMenuViewModel.getmArrayMenu().getValue(), mView.getContext(), R.layout.layout_item_menu);
        mRecyclerMenu.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        // add toolbar
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.relative_layout_menu,new Toolbar(getResources().getString(R.string.lbl_menu)),"toolbar menu").commit();
    }

    // ánh xạ view
    private void initView() {
        mRecyclerMenu = mView.findViewById(R.id.recyclerMenu);
    }
}
