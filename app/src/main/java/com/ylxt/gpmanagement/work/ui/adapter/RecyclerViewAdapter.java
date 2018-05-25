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

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/11.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<SubjectData> mSubjects;
    private BtOnClickListener mBtOnClickListener;

    public void setBtOnClickListener(BtOnClickListener btOnClickListener) {
        mBtOnClickListener = btOnClickListener;
    }

    @Override
    public void onClick(View v) {
        if (mBtOnClickListener != null) {
            mBtOnClickListener.onBtClick((Integer) v.getTag());
        }
    }

    public interface BtOnClickListener {
        void onBtClick(int position);
    }

    public RecyclerViewAdapter(Context context, List<SubjectData> subjects) {
        mContext = context;
        mSubjects = subjects;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_xuanti, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTvTitle.setText("课题名称：" + mSubjects.get(position).subjectName);
        holder.mTvType.setText("课题类型：" + mSubjects.get(position).subjectType);
        holder.mTvTeacher.setText("指导老师：" + mSubjects.get(position).guideTeacher);
        holder.mBtChoose.setOnClickListener(this);
        holder.mBtChoose.setTag(position);
    }


    @Override
    public int getItemCount() {
        return mSubjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;
        public TextView mTvType;
        public TextView mTvDiff;
        public TextView mTvTeacher;
        public Button mBtChoose;

        public ViewHolder(View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_title);
            mTvType = itemView.findViewById(R.id.tv_type);
            mTvDiff = itemView.findViewById(R.id.tv_difficult);
            mTvTeacher = itemView.findViewById(R.id.tv_teacher);
            mBtChoose = itemView.findViewById(R.id.bt_choose);
        }
    }
}
