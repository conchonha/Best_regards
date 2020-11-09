package com.example.baseprojectandroid.src.page.login_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.page.bottom_navigator_bar.BottomNavigatorBarActivity;
import com.example.baseprojectandroid.utils.Validations;

public class LoginActivity extends AppCompatActivity {
    private CardView mCardLogin;
    private EditText mEdtEmail,mEdtPassword;
    private Boolean mCheckSaveLogin = false;

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
                if(checkVaidation()){
                    startActivity(new Intent(getApplicationContext(), BottomNavigatorBarActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                }
            }
        });
    }

    private boolean checkVaidation() {
        if(!Validations.isEmailValid(mEdtEmail.getText().toString())){
            mEdtEmail.setError(getResources().getString(R.string.lbl_err_invalid_email));
            return false;
        }

        if(! Validations.isPasswordValid(mEdtPassword.getText().toString())){
            mEdtPassword.setError(getResources().getString(R.string.lbl_err_invalid_password));
            return false;
        }
        return true;

    }

    //ánh xạ view
    private void initView() {
        mCardLogin = findViewById(R.id.btn_login);
        mEdtPassword = findViewById(R.id.edt_pass);
        mEdtEmail = findViewById(R.id.edt_email);
    }
}