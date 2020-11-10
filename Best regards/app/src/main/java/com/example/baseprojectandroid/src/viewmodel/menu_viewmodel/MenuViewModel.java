package com.example.baseprojectandroid.src.viewmodel.menu_viewmodel;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.models.menu_models.MenuModels;
import com.example.baseprojectandroid.src.dialog.fragment_dialog_add.FragmentDialogAddMenu;
import com.example.baseprojectandroid.src.repositories.menu_repositories.MenuRepositories;
import com.example.baseprojectandroid.utils.Constain;
import com.example.baseprojectandroid.utils.Helpers;

import java.util.List;

public class MenuViewModel extends ViewModel {
    private MutableLiveData<List<MenuModels>> mArrayMenu;
    private MenuRepositories mMenuRepositories;
    private MutableLiveData<List<String>>mArrayListTitle;

    //khởi tạo và get data menu
    public void initMenu() {
        if (mArrayMenu != null) {
            return;
        }
        mMenuRepositories = MenuRepositories.getInstance();
        mArrayMenu = mMenuRepositories.getListMenu();
    }

    public MutableLiveData<List<MenuModels>> getmArrayMenu() {
        return mArrayMenu;
    }

    //khởi tạo + get data spiner + insert data menu
    public void insertMenu(MenuModels menuModels,Fragment fragment){
        List<MenuModels> list = mArrayMenu.getValue();
        list.add(menuModels);
        mArrayMenu.postValue(list);

        // colse dialog
        Helpers.hideFragmentDialog(fragment,Constain.dialogMenuAdd);
    }

    public void initAddMenu(){
        if(mArrayListTitle != null){
            return;
        }
        mMenuRepositories = new MenuRepositories();
        mArrayListTitle = mMenuRepositories.getListTitle();
    }

    public MutableLiveData<List<String>>getArayListTile(){
        return mArrayListTitle;
    }
}
