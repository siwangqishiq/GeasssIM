package com.xinlan.geassim;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.xinlan.geassim.model.Friend;


public class ChatActivity extends IMBaseActivity {
    private Friend mFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mFriend = (Friend) getIntent().getSerializableExtra("friend");
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (mFriend == null) {
            return;
        }
        getSupportActionBar().setTitle(mFriend.name);
    }

}//end class
