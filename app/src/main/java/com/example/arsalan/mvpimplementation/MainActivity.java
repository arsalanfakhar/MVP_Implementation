package com.example.arsalan.mvpimplementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arsalan.mvpimplementation.model.SignInPresentorImplementation;
import com.example.arsalan.mvpimplementation.presenter.SignInPresenter;
import com.example.arsalan.mvpimplementation.view.SignInView;

public class MainActivity extends AppCompatActivity implements SignInView {

    private SignInPresenter signInPresenter;
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.pass);
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this,"Either username or password is empty",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInSucess() {
        Toast.makeText(this,"Congrats u are signed in",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInError() {
        Toast.makeText(this,"Ooh no signin failed",Toast.LENGTH_SHORT).show();
    }

    public void Check(View view){
        signInPresenter=new SignInPresentorImplementation(MainActivity.this);
        signInPresenter.signIn(username.getText().toString(),password.getText().toString());
    }
}
