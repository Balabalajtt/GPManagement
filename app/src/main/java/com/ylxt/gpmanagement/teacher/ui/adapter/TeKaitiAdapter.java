package com.ylxt.gpmanagement.teacher.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.work.data.gson.KaitiData;
import com.ylxt.gpmanagement.work.data.gson.SubjectData;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/11.
 */

public class TeKaitiAdapter extends RecyclerView.Adapter<TeKaitiAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<KaitiData> mDatas;
    private OnItemClickedListener mItemClickedListener;
    public interface OnItemClickedListener {
        void onItemClicked(int position);
    }

    public void setItemClickedListener(OnItemClickedListener itemClickedListener) {
        mItemClickedListener = itemClickedListener;
    }

    @Override
    public void onClick(View v) {
        if (mItemClickedListener != null) {
            mItemClickedListener.onItemClicked((Integer) v.getTag());
        }
    }

    public TeKaitiAdapter(Context context, List<KaitiData> datas) {
        mContext = context;
        mDatas = datas;
    }

    @NonNull
    @Override
    public TeKaitiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_te_shenbao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeKaitiAdapter.ViewHolder holder, int position) {
        holder.mTvName.setText("学生姓名：" + mDatas.get(position).studentName);
        holder.mTvTitle.setText("课题名称：" + mDatas.get(position).subjectName);
        holder.mTvType.setVisibility(View.GONE);
        holder.itemView.setOnClickListener(this);
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvName;
        public TextView mTvTitle;
        public TextView mTvType;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_student_name);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvType = itemView.findViewById(R.id.tv_type);

        }
    }
}
