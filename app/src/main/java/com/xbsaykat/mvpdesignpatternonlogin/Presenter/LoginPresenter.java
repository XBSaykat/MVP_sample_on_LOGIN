package com.xbsaykat.mvpdesignpatternonlogin.Presenter;
import com.xbsaykat.mvpdesignpatternonlogin.Model.User;
import com.xbsaykat.mvpdesignpatternonlogin.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user= new User(email,password);
        int loginCode= user.isValidData();

        if(loginCode==0)
            loginView.onLoginError("Email must not Empty");
        else if(loginCode==1)
            loginView.onLoginError("Enter valid email");
        else if(loginCode==2)
            loginView.onLoginError("password length is must be 6 or more");
        else
            loginView.onLoginSuccess("Login Successful");
    }
}
