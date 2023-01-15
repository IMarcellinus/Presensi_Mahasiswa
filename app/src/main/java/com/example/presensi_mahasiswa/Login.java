package com.example.presensi_mahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class Login extends AppCompatActivity{
//    String username ="43320030";
//    String password ="Polines*2020";

    String username ="p";
    String password ="p";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText txtusername = findViewById(R.id.txtusername);
        final EditText txtpassword = findViewById(R.id.txtpassword);
        Button btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtusername.getText().toString().equalsIgnoreCase(username)&& txtpassword.getText().toString().equalsIgnoreCase(password)){
                    SharedPreferences accounts = PreferenceManager.getDefaultSharedPreferences(Login.this);
                    SharedPreferences.Editor editor = accounts.edit();
                    boolean isLogin = true;
                    editor.putBoolean("isLogin", isLogin);
                    editor.apply();

                    startActivity(new Intent(Login.this, MainActivity.class));
                }else{
                    Toast.makeText(Login.this, "Username/Password Salah",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


}
