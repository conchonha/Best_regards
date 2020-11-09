package com.example.baseprojectandroid.src.viewmodel.menu_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.src.models.menu_models.MenuModels;
import com.example.baseprojectandroid.src.repositories.menu_repositories.MenuRepositories;

import java.util.List;

public class MenuViewModel extends ViewModel {
    private MutableLiveData<List<MenuModels>> mArrayMenu;
    private MenuRepositories mMenuRepositories;

    public void initMenu(){
        if (mArrayMenu != null){
            return;
        }
        mMenuRepositories = MenuRepositories.getInstance();
        mArrayMenu = mMenuRepositories.getListMenu();
    }
    public MutableLiveData<List<MenuModels>> getmArrayMenu(){
        return mArrayMenu;
    }
}
