package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(login);
            }
        });
    }

    /*
    Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()) // 使用 Gson 解析
            .baseUrl("https://web.nutc-imac.com:6789/api")
            .build();
            Api apiService = retrofit.create(ApiService.class);
            Call<User> call = apiService.getUser("123");
    */
}
