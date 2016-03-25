package com.xinlan.geassim;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.StatusCode;
import com.netease.nimlib.sdk.auth.AuthService;
import com.netease.nimlib.sdk.auth.AuthServiceObserver;
import com.xinlan.geassim.adapter.FriendAdapter;
import com.xinlan.geassim.model.Friend;

public class MainActivity extends IMBaseActivity implements View.OnClickListener {
    private OnlineObserver mOnlineObserver = new OnlineObserver();

    private RecyclerView mFriendListView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FriendAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        NIMClient.getService(AuthServiceObserver.class).observeOnlineStatus(mOnlineObserver, true);
    }

    /**
     * 状态监听器
     */
    private final class OnlineObserver implements Observer<StatusCode> {
        @Override
        public void onEvent(StatusCode statusCode) {
            getSupportActionBar().setTitle(statusCode.toString());
        }
    }//end inner class

    private void initView() {
        StatusCode status = NIMClient.getStatus();
        getSupportActionBar().setTitle(status.toString());

        mFriendListView = (RecyclerView) findViewById(R.id.friend_list);
        mFriendListView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mFriendListView.setLayoutManager(mLayoutManager);
        mFriendListView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new FriendAdapter(this, Friend.createFriendList());
        mFriendListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {//注销用户
            loginOut();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }//end switch
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NIMClient.getService(AuthServiceObserver.class).observeOnlineStatus(mOnlineObserver, false);
    }

    /**
     * 注销操作
     */
    private void loginOut() {
        NIMClient.getService(AuthService.class).logout();
        SharedPreferences.Editor ed = this.getSharedPreferences(Constants.APP_NAME, Context.MODE_PRIVATE).edit();
        ed.putString(Constants.USER_NAME_KEY, "");
        ed.putString(Constants.USER_TOKEN_KEY, "");
        CoreApplication.getInstance().loginOut();
    }

    public void talkToFriend(Friend friend) {
        Intent it = new Intent(this, ChatActivity.class);
        it.putExtra("friend", friend);
        startActivity(it);
    }
}//end class
