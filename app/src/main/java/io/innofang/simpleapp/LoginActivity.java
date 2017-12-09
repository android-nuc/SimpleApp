package io.innofang.simpleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Author: Inno Fang
 * Time: 2017/12/9 09:28
 * Description:
 */


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsernameEditText = findViewById(R.id.username_edit_text);
        mPasswordEditText = findViewById(R.id.password_edit_text);
        mLoginButton = findViewById(R.id.login_button);

        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
            String username = mUsernameEditText.getText().toString();
            String password = mPasswordEditText.getText().toString();

            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                if (username.equals(password)) {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}
