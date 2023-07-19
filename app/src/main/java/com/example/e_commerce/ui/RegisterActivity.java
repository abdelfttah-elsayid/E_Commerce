package com.example.e_commerce.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.e_commerce.R;
import com.example.e_commerce.data.source.network.MyRetrofit;
import com.example.e_commerce.databinding.ActivityRegisterBinding;
import com.example.e_commerce.models.response.register.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button button = findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromUi();
            }
        });
        //binding.btnRegister.setOnClickListener(v -> getDataFromUi());
    }

    private void getDataFromUi() {
        String name = binding.etUserName.getText().toString();
        if (name.isEmpty()) {
            binding.etUserName.setError("User Name required");
            return;
        }
        String email = binding.etEmail.getText().toString();
        if (email.isEmpty()) {
            binding.etEmail.setError("Email required");
            return;
        }

        String password = binding.etPassword.getText().toString();
        if (password.isEmpty()) {
            binding.etPassword.setError("Password required");
            return;
        }

        String phone = binding.etPhone.getText().toString();
        if (phone.isEmpty()) {
            binding.etPhone.setError("Phone required");
            return;
        }


        showProgressDialog();
        register(name, email, password, phone);


    }

    private void register(String name, String email, String password, String phone) {

        MyRetrofit.getApis().register(name, email, password, phone).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                dismissProgressDialog();
                if (response.isSuccessful()) {
                    handleResponse(response.body());
                } else {
                    Toast.makeText(RegisterActivity.this,  response
                            .message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                dismissProgressDialog();
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleResponse(RegisterResponse body) {
        if (body.isStatus()) {
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            navigateToLoginScreen();
        } else {
            Toast.makeText(this, body.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToLoginScreen() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void showProgressDialog() {
        dialog = ProgressDialog.show(RegisterActivity.this, "", "Loading. Please wait...", true);
    }

    private void dismissProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}