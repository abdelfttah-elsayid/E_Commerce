package com.example.e_commerce.ui.fragments;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeechService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e_commerce.data.source.local.MyShared;
import com.example.e_commerce.data.source.local.SharedKeys;
import com.example.e_commerce.data.source.network.MyRetrofit;
import com.example.e_commerce.databinding.FragmentSettingsBinding;
import com.example.e_commerce.models.request.UpdateProfileRequest;
import com.example.e_commerce.models.response.settings.SettingsResponse;
import com.example.e_commerce.models.response.settings.UserData;
import com.example.e_commerce.ui.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SettingsFragment extends Fragment {

    FragmentSettingsBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater , container , false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.etEmail.setText(MyShared.getString(SharedKeys.email));
        binding.etPhone.setText(MyShared.getString(SharedKeys.phone));
        binding.etName.setText(MyShared.getString(SharedKeys.userName));
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromUi();
            }
        });
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });


    }

    private void logout() {
        // Create an AlertDialog.Builder instance
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Confirm Logout");
        builder.setMessage("Are you sure you want to log out?");

        // Set positive button click listener
        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked the logout button in the dialog
                // Perform logout actions
                // ...

                // Redirect the user to the login screen
                Intent intent = new Intent(requireContext(), LoginActivity.class);
                startActivity(intent);

                // Close the current activity
            }
        });

        // Set negative button click listener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User clicked the cancel button in the dialog
                // Dismiss the dialog and do nothing
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void getDataFromUi() {
        String email = binding.etEmail.getText().toString();
        if (email.isEmpty()){
            Toast.makeText(requireContext(), "Email required", Toast.LENGTH_SHORT).show();
           // binding.etEmail.setError("Email required");
        }

        String phone= binding.etPhone.getText().toString();
        if (phone.isEmpty()){
            Toast.makeText(requireContext(), "phone required", Toast.LENGTH_SHORT).show();

          //  binding.etPhone.setError("Phone required");
        } String name = binding.etName.getText().toString();
        if (name.isEmpty()){
            Toast.makeText(requireContext(), "name required", Toast.LENGTH_SHORT).show();

          //  binding.etName.setError("User Name required");
        }

        showProgressDialog();

        UpdateProfileRequest request = new UpdateProfileRequest(email , phone , name );
        updateProfile(request);
    }

    private void updateProfile(UpdateProfileRequest request) {
        MyRetrofit.getApis().updateProfile(request , MyShared.getString(SharedKeys.apiToken))
                .enqueue(new Callback<SettingsResponse>() {
            @Override
            public void onResponse(Call<SettingsResponse> call, Response<SettingsResponse> response) {
                dismissProgressDialog();
                if (response.isSuccessful()){
                    handleResponse(response.body());
                    }
                else
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();
                }


            @Override
            public void onFailure(Call<SettingsResponse> call, Throwable t) {
                dismissProgressDialog();
                Toast.makeText(requireContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void handleResponse(SettingsResponse body) {
        if (body.isStatus() == true ){
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show();
            updateUserData(body.getData());
                    }
        else
            Toast.makeText(requireContext(),body.getMessage(), Toast.LENGTH_SHORT).show();

    }

    private void updateUserData(UserData data) {
        MyShared.saveString(SharedKeys.email , data.getEmail());
        MyShared.saveString(SharedKeys.phone , data.getPhone());
        MyShared.saveString(SharedKeys.userName , data.getName());
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
    ProgressDialog dialog;
    private void showProgressDialog(){
        dialog = ProgressDialog
                .show(requireContext(),
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