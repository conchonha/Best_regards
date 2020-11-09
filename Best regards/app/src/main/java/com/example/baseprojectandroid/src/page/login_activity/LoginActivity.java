package com.example.baseprojectandroid.src.page.login_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.page.bottom_navigator_bar.BottomNavigatorBarActivity;

public class LoginActivity extends AppCompatActivity {
    private CardView mCardLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        listennerOnclicked();
    }

    // lắng nghe sự kiện onclick view
    private void listennerOnclicked() {
        mCardLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BottomNavigatorBarActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
            }
        });
    }

    //ánh xạ view
    private void initView() {
        mCardLogin = findViewById(R.id.btn_login);
    }
}