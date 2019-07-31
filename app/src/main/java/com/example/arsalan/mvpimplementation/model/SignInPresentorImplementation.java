package com.example.arsalan.mvpimplementation.model;

import android.text.TextUtils;

import com.example.arsalan.mvpimplementation.presenter.SignInPresenter;
import com.example.arsalan.mvpimplementation.view.SignInView;

public class SignInPresentorImplementation implements SignInPresenter {

    private SignInView signInView;
    public SignInPresentorImplementation(SignInView signInView){
        this.signInView=signInView;
    }
    @Override
    public void signIn(String username, String password) {
        if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            signInView.showValidationError();
        }
        else {
            if(username.equalsIgnoreCase("arsalan")&& password.equalsIgnoreCase("123456")){
                signInView.signInSucess();
            }
            else {
                signInView.signInError();
            }
        }
    }
}
