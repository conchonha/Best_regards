package com.example.baseprojectandroid.compoments.toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baseprojectandroid.R;

public class Toolbar extends Fragment {
    private View mView;
    private String mTitle;
    private TextView mTxtTitle;

    public Toolbar(String title){
        this.mTitle = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.layout_toolbar,container,false);
        initView();
        init();
        return mView;
    }

    private void init() {
        mTxtTitle.setText(mTitle+"");
    }

    // ánh xạ view
    private void initView() {
        mTxtTitle = mView.findViewById(R.id.txt_title_appbar);
    }
}
