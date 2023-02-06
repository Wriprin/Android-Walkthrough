package cc.cnix.android_walkthrough.jump;

import androidx.appcompat.app.AppCompatActivity;

import cc.cnix.android_walkthrough.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BActivity extends AppCompatActivity {

    private TextView mTv01;
    private Button mBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        // 获取 AActivity 传递数据
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        mTv01 = findViewById(R.id.tv_01);
        mTv01.setText(name);

        // 返回消息提示 Hello, World
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle1 = new Bundle();
                bundle1.putString("msg", "Hello, World!");
                Intent intent = new Intent();
                intent.putExtras(bundle1);
                setResult(0, intent);
                // 结束当前 Activity
                finish();
            }
        });
    }
}