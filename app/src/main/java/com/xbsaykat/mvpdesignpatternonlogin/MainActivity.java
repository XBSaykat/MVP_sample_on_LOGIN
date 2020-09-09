package com.xbsaykat.mvpdesignpatternonlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.xbsaykat.mvpdesignpatternonlogin.Presenter.ILoginPresenter;
import com.xbsaykat.mvpdesignpatternonlogin.Presenter.LoginPresenter;
import com.xbsaykat.mvpdesignpatternonlogin.View.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText edt_email,edt_password;
    TextView txt_login;
    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_login=findViewById(R.id.txt_login);
        edt_password=findViewById(R.id.edt_password);
        edt_email=findViewById(R.id.edt_email);

        loginPresenter=new LoginPresenter(this);

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}