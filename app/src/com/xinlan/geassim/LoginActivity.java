package com.xinlan.geassim;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.StatusCode;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.LoginInfo;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mNameText;
    private EditText mPwdText;
    private Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initToolBar();

        initView();

        StatusCode status = NIMClient.getStatus();
//        if (!status.shouldReLogin()) {
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
//        }
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("登录");
    }

    private void initView() {
        mNameText = (EditText) findViewById(R.id.name_text);
        mPwdText = (EditText) findViewById(R.id.pwd_text);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                doLogin();
                break;
        }//end switch
    }

    private void doLogin() {
        final String name = mNameText.getText().toString().toLowerCase().trim();
        final String pwd = mPwdText.getText().toString().toLowerCase().trim();
        LoginInfo info = new LoginInfo(name, pwd);
        RequestCallback<LoginInfo> callback = new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo loginInfo) {
                Toast.makeText(LoginActivity.this, loginInfo.getAccount() + " 登录成功", Toast.LENGTH_SHORT).show();
                handleLoginSuccess(loginInfo);
            }

            @Override
            public void onFailed(int errorCode) {
                Toast.makeText(LoginActivity.this, "登录失败 错误码 = " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onException(Throwable throwable) {
                Toast.makeText(LoginActivity.this, "登录发生异常 exception= " + throwable, Toast.LENGTH_SHORT).show();
            }
        };
        NIMClient.getService(AuthService.class).login(info).setCallback(callback);
    }

    private void handleLoginSuccess(final LoginInfo info) {
        if (info == null)
            return;
        SharedPreferences.Editor ed = this.getSharedPreferences(Constants.APP_NAME, Context.MODE_PRIVATE).edit();
        ed.putString(Constants.USER_NAME_KEY, info.getAccount());
        ed.putString(Constants.USER_TOKEN_KEY, info.getToken());

        startActivity(new Intent(this, MainActivity.class));
        this.finish();
    }

}//end class
