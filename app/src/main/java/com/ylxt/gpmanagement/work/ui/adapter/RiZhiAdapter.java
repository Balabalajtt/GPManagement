package com.ylxt.gpmanagement.work.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.work.data.gson.RizhiData;
import com.ylxt.gpmanagement.work.data.gson.XinData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/11.
 */

public class RiZhiAdapter extends RecyclerView.Adapter<RiZhiAdapter.ViewHolder> {

    private Context mContext;
    private List<RizhiData> mDatas;

    public RiZhiAdapter(Context context, List<RizhiData> datas) {
        mContext = context;
        mDatas = datas;
    }

    @NonNull
    @Override
    public RiZhiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_rizhi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RiZhiAdapter.ViewHolder holder, int position) {
        holder.mTvTime.setText(mDatas.get(position).timestamp.substring(0, 16));
        holder.mTvLog.setText(mDatas.get(position).log);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTime;
        public TextView mTvLog;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTime = itemView.findViewById(R.id.tv_time);
            mTvLog = itemView.findViewById(R.id.tv_log);

        }
    }
}
