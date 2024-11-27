package com.uday.playstation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class RegistrationActivity extends AppCompatActivity {

    TextView tv_1, tv_2,tv_3;

    Button btn,btn_1;

    ImageView  img_logo_1, img_logo_2;

    CheckBox chk;

    EditText et_name,et_email,et_mobile,et_username,et_password;
    CheckBox chk_showpass;
    Button btn_register;
    boolean hasNumber = false , hasUpperCase = false , hasLowerCase = false , hasSymbol =
            false;
    @SuppressLint("MissingInflatedId")



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        tv_1 = findViewById(R.id.tv_signup_tittle);
        tv_2 = findViewById(R.id.tv_info1);
        btn = findViewById(R.id.btn_sign);
        btn_1 = findViewById(R.id.btn_login_page);
        chk = findViewById(R.id.chk_registration);
        et_name = findViewById(R.id.et_name);
        et_email = findViewById(R.id.et_email);
        et_mobile = findViewById(R.id.et_mobile_no);
        et_username= findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });
        String s1 = et_email.getText().toString();


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler h=new Handler();
                h.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(RegistrationActivity.this,FourthProcess.class));
                    }
                },1000);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_name.getText().toString().isEmpty())
                {
                    et_name.setError("Enter the name");
                }
                else if(et_email.getText().toString().isEmpty())
                {
                    et_email.setError("enter the email");
                }
                else if( Patterns.EMAIL_ADDRESS.matcher(s1).matches())
                {
                    et_email.setError("enter the valid email");
                }
                else if(et_mobile.getText().toString().isEmpty())
                {
                    et_mobile.setError("enter th e mobile no");
                }
                else if(et_mobile.getText().toString().length()<9)
                {
                    et_mobile.setError("number should be 10 digit");
                }
                else if (et_username.getText().toString().isEmpty())
                {
                    et_username.setError("enter the username");
                }
                else if(et_username.getText().toString().length()<8)
                {
                    et_username.setError("username must be greater than 8 character");
                }
                else if(et_password.getText().toString().isEmpty())
                {
                    et_password.setError("enter the password");
                }
                else if(et_password.getText().toString().length()<8)
                {
                    et_password.setError("password must be greater than 8 character");
                }
                else if (et_password.getText().toString().isEmpty() ||
                        et_password.getText().toString().length()<8)
                {
                    et_password.setError("Please enter password having greater than 8 characters");
                }
                else if(!et_password.getText().toString().matches("(.*[A-Z].*)"))
                {
                    et_password.setError("Please eneter at least 1 Uppercase character ");
                }
                else if (!et_password.getText().toString().matches("(.*[0-9].*)"))
                {
                    et_password.setError("1 Numerical Value please ");
                }
                else if(!et_password.getText().toString().matches("^(?=.*[_.()]).*$"))
                {
                    et_password.setError(" 1 symbol character Need");
                }
                else if(!et_password.getText().toString().matches("(.*[a-z].*)"))
                {
                    et_password.setError(" lowercase Charater  1 please");
                }
                else
                {
                    hasLowerCase = true;
                    hasSymbol = true;
                    hasUpperCase = true;
                    hasNumber = true;
                }
                if((hasUpperCase == true) && (hasLowerCase == true) && (hasNumber == true) &&
                        (hasSymbol == true))
                {
                    Toast.makeText(RegistrationActivity.this,"Registration Sucess GO For Login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
