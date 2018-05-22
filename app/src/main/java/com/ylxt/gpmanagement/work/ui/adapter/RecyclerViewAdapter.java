package com.ylxt.gpmanagement.work.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.work.data.NoticeBean;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/11.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private List<NoticeBean> mNoticeBeans;

    public RecyclerViewAdapter(Context context, List<NoticeBean> noticeBeans) {
        mContext = context;
        mNoticeBeans = noticeBeans;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_notice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTvTitle.setText(mNoticeBeans.get(position).title);
        holder.mTvTime.setText(mNoticeBeans.get(position).time);
    }

    @Override
    public int getItemCount() {
        return mNoticeBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvTitle;
        public TextView mTvTime;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvTime = itemView.findViewById(R.id.tv_time);
        }
    }
}
