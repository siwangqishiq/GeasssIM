package com.xinlan.geassim;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.xinlan.geassim.model.Friend;
import com.xinlan.geassim.model.MessageBean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class ChatActivity extends IMBaseActivity {
    private Friend mFriend;
    private List<MessageBean> mMsgList = new ArrayList<MessageBean>();

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
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (mFriend == null) {
            return;
        }
        getSupportActionBar().setTitle(mFriend.name);
    }

}//end class
