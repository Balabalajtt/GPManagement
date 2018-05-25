package com.ylxt.gpmanagement.work.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.work.data.gson.SubjectData;
import com.ylxt.gpmanagement.work.data.gson.Xin;
import com.ylxt.gpmanagement.work.data.gson.XinData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/11.
 */

public class RecyclerViewXinAdapter extends RecyclerView.Adapter<RecyclerViewXinAdapter.ViewHolder> {

    private Context mContext;
    private List<XinData> mDatas;
    private int type;

    public RecyclerViewXinAdapter(Context context, List<XinData> datas, int type) {
        mContext = context;
        mDatas = datas;
        this.type = type;
    }

    @NonNull
    @Override
    public RecyclerViewXinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_xin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewXinAdapter.ViewHolder holder, int position) {
        if (type == 0) {
            holder.mTvFaxinren.setText(mDatas.get(position).username);
        } else {
            holder.mTvFaxinren.setText(mDatas.get(position).targetName);
        }
        holder.mTvTime.setText(mDatas.get(position).timestamp.substring(0, 16));
        holder.mTvContent.setText(mDatas.get(position).message);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvFaxinren;
        public TextView mTvTime;
        public TextView mTvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvFaxinren = itemView.findViewById(R.id.tv_faxinren);
            mTvTime = itemView.findViewById(R.id.tv_time);
            mTvContent = itemView.findViewById(R.id.tv_content);

        }
    }
}
