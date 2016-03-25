package com.xinlan.geassim;

import android.content.Intent;
import android.database.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.StatusCode;
import com.netease.nimlib.sdk.auth.AuthServiceObserver;

/**
 * Created by panyi on 2016/3/22.
 */
public abstract class IMBaseActivity extends AppCompatActivity {
    protected Observer<StatusCode> mStatusObserver = new Observer<StatusCode>() {
        @Override
        public void onEvent(StatusCode statusCode) {
            if (statusCode.shouldReLogin() || statusCode == StatusCode.KICKOUT) {
                IMBaseActivity.this.finish();
                Intent it = new Intent(IMBaseActivity.this, LoginActivity.class);
                IMBaseActivity.this.startActivity(it);
                IMBaseActivity.this.finish();
            }//end if
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NIMClient.getService(AuthServiceObserver.class).observeOnlineStatus(mStatusObserver, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NIMClient.getService(AuthServiceObserver.class).observeOnlineStatus(mStatusObserver, false);
    }
}//end class
