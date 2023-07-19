package com.example.e_commerce.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.e_commerce.R;
import com.example.e_commerce.models.response.Home.ProductsItem;

public class ProductsDetailsActivity extends AppCompatActivity {

    private ProductsItem product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_derails_actitvty);

        // Retrieve the product object from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("product")) {
            product = (ProductsItem) intent.getSerializableExtra("product");
            // Use the product object as needed in your activity
            if (product != null) {
                String productName = product.getName();
                // ... other fields of the ProductsItem class
            }
        }
    }

    // Rest of the code
}
