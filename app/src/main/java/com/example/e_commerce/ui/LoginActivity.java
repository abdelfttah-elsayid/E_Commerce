package com.example.e_commerce.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Toast;

import com.example.e_commerce.R;
import com.example.e_commerce.data.source.local.MyShared;
import com.example.e_commerce.data.source.local.SharedKeys;
import com.example.e_commerce.data.source.network.MyRetrofit;
import com.example.e_commerce.databinding.ActivityLoginBinding;
import com.example.e_commerce.models.response.login.LoginData;
import com.example.e_commerce.models.response.login.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyShared.init(getApplicationContext());
        MyShared.saveString(SharedKeys.apiToken , "asdasasdadasadskjhdsakhdsakhjkhljsdkjaljlj");

        MyShared.getString(SharedKeys.language);


        binding.register.setOnClickListener(v -> navigateToRegisterScreen());
        binding.btnLogin.setOnClickListener(v -> getDataFromUi());




    }

    private void getDataFromUi() {
        String email = binding.etEmail.getText().toString();
        if (email.isEmpty()){
         binding.etEmail.setError(" email required");
        }
        String password = binding.etPassword.getText().toString();
        if (password.isEmpty()){
            binding.etPassword.setError(" password required");
        }
        showProgressDialog();
        login(email , password);
        

    }

    private void login(String email, String password) {
        MyRetrofit.getApis().login(email , password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        dismissProgressDialog();

                        if (response.isSuccessful()) {
                            // code 200 : 299
                            handleResponse(response.body());
                        }
                        else
                        {
                            Toast.makeText(LoginActivity.this, "some thing error , please try again ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        dismissProgressDialog();

                        Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

    }


    private void handleResponse(LoginResponse body) {
        if (body.isStatus()== true)
        {
            saveUserData(body.getData());
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            navigateToMainScreen();

        }
        else
            Toast.makeText(this, "please try again", Toast.LENGTH_SHORT).show();
    }

    private void saveUserData(LoginData data) {
        MyShared.saveString(SharedKeys.email , data.getEmail());
        MyShared.saveString(SharedKeys.userName , data.getName());
        MyShared.saveString(SharedKeys.phone , data.getPhone()) ;
        MyShared.saveString(SharedKeys.apiToken , data.getToken());

    }

    private void navigateToRegisterScreen(){
        Intent intent = new Intent(LoginActivity.this , RegisterActivity.class);
        startActivity(intent);

    }
    private void navigateToMainScreen(){
        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(intent);

    }
    ProgressDialog dialog;
    private void showProgressDialog(){
         dialog = ProgressDialog
                .show(LoginActivity.this,
                        "",
                        "Loading. Please wait...",
                        true);
    }
    private void dismissProgressDialog(){
        if (dialog !=null && dialog.isShowing()) {
            dialog.dismiss();
        }

    }


}