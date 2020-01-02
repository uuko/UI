package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ui.Shareperference.PreferencesHelperImp;
import com.example.ui.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private LoginViewModel loginViewModel;
    private EditText passwd,username;
    private String account,pw;
    public static PreferencesHelperImp preferencesHelperImp;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        preferencesHelperImp = new PreferencesHelperImp(getApplicationContext());
        //創建viewmodel (一對一綁定)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        //訂閱livedata  livedata會感測生命週期 ，當發生變化訂閱者會收到更新
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwd=findViewById(R.id.userpw);
                username=findViewById(R.id.username);

                account=username.getText().toString();
                pw=passwd.getText().toString();
                Log.d("123", "onClick: "+account+pw);
                if (account.equals("") && pw.equals("")){
                    Toast.makeText(getApplicationContext(), "123", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "go to next page", Toast.LENGTH_SHORT).show();

                    loginViewModel.getLoginTokens(account,pw);

                    new Handler().postDelayed(new Runnable(){
                        public void run(){
                            //處理少量資訊或UI
                            Toast.makeText(LoginActivity.this, "account", Toast.LENGTH_SHORT).show();
                            loginViewModel.getLoginAccounts(preferencesHelperImp.getStringData());
                        }
                    }, 5000);

                    Intent login=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(login);
                }


            }
        });








/*
 noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                Toast.makeText(MainActivity.this, "ONchanged", Toast.LENGTH_SHORT).show();
                noteAdapter.setNotes(notes);
            }
        });
 */

    }


}
