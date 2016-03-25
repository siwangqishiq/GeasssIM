package com.xinlan.geassim.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xinlan.geassim.MainActivity;
import com.xinlan.geassim.R;
import com.xinlan.geassim.model.Friend;
import com.xinlan.geassim.view.CircleTransform;

import java.util.List;

/**
 * Created by panyi on 2016/3/25.
 */
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private MainActivity mContext;
    private List<Friend> mDataList;

    public FriendAdapter(MainActivity context, List<Friend> dataList) {
        this.mContext = context;
        this.mDataList = dataList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_friend_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (mDataList == null)
            return;
        holder.mNameText.setText(mDataList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.talkToFriend(mDataList.get(position));
            }
        });
        Picasso.with(mContext).load(mDataList.get(position).headImage).transform(new CircleTransform()).
                placeholder(R.drawable.ic_launcher).into(holder.mHeadImage);
    }

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameText;
        public ImageView mHeadImage;

        public ViewHolder(View v) {
            super(v);
            mNameText = (TextView) v.findViewById(R.id.friend_name);
            mHeadImage = (ImageView) v.findViewById(R.id.head_img);
        }
    }//end inner class
}//end class
