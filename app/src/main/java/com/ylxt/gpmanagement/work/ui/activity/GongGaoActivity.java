package com.ylxt.gpmanagement.work.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ylxt.gpmanagement.R;
import com.ylxt.gpmanagement.base.ui.activity.BaseActivity;

public class GongGaoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gong_gao);

        ImageView back = findViewById(R.id.im_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView title = findViewById(R.id.tv_title);
        TextView time = findViewById(R.id.tv_time);
        TextView content = findViewById(R.id.tv_content);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        time.setText(intent.getStringExtra("time"));
        content.setText(intent.getStringExtra("content"));

    }
}
