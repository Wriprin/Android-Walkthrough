package cc.cnix.android_walkthrough.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cc.cnix.android_walkthrough.R;

public class RecyclerViewActivity extends AppCompatActivity {

    // 声明对象
    private Button mBtnLinear;
    private Button mBtnHori;
    private Button mBtnGrid;
    private Button mBtnWaterFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // 获取控件
        mBtnLinear = findViewById(R.id.btn_01);
        mBtnHori = findViewById(R.id.btn_02);
        mBtnGrid = findViewById(R.id.btn_03);
        mBtnWaterFall = findViewById(R.id.btn_04);

        // 监听事件
        setOnClickListener();
    }

    private void setOnClickListener() {
        onClickListener onClickListener = new onClickListener();

        mBtnLinear.setOnClickListener(onClickListener);
        mBtnHori.setOnClickListener(onClickListener);
        mBtnGrid.setOnClickListener(onClickListener);
        mBtnWaterFall.setOnClickListener(onClickListener);
    }

    class onClickListener implements View.OnClickListener {
        private Intent intent;
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_01:
                    intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                    break;
                case R.id.btn_02:
                    intent = new Intent(RecyclerViewActivity.this, HoriRecyclerViewActivity.class);
                    break;
                case R.id.btn_03:
                    intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                    break;
                case R.id.btn_04:
                    intent = new Intent(RecyclerViewActivity.this, WaterFallRecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}