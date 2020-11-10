package com.example.baseprojectandroid.src.repositories.menu_repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.baseprojectandroid.src.models.menu_models.MenuModels;

import java.util.ArrayList;
import java.util.List;

public class MenuRepositories {
    private static  MenuRepositories instanceMenu;
    private static List<MenuModels>mListMenu = new ArrayList<>();

    public static MenuRepositories getInstance(){
        if (instanceMenu == null){
            instanceMenu = new MenuRepositories();
        }
        return instanceMenu;
    }

    public MutableLiveData<List<MenuModels>> getListMenu(){
        MutableLiveData<List<MenuModels>> arrayTmp = new MutableLiveData<>();
        setDataMenu();
        arrayTmp.setValue(mListMenu);
        return arrayTmp;
    }
    public void setDataMenu(){
        for (int i = 0; i < 3; i++){
            MenuModels models = new MenuModels();
            models.setmImage("https://images.media-allrecipes.com/userphotos/453291.jpg");
            models.setmName("Ice Cream");
            models.setmMoney("25000");
            mListMenu.add(models);
        }
    }
}
