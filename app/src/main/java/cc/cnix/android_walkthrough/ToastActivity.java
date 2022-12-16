package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cc.cnix.android_walkthrough.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast;
    private Button mBtnCenter;
    private Button mBtnCustom;
    private Button mBtnUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mBtnToast = findViewById(R.id.btn_01);
        mBtnCenter = findViewById(R.id.btn_02);
        mBtnCustom = findViewById(R.id.btn_03);
        mBtnUtil = findViewById(R.id.btn_04);

        View.OnClickListener onClickListener = new OnClickListener();
        mBtnToast.setOnClickListener(onClickListener);
        mBtnCenter.setOnClickListener(onClickListener);
        mBtnCustom.setOnClickListener(onClickListener);
        mBtnUtil.setOnClickListener(onClickListener);
    }

    private class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_01:
                    Toast.makeText(ToastActivity.this, "这是一条默认消息", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_02:
                    // 设置 Toast 位置居中显示
                    Toast toastCenter = Toast.makeText(ToastActivity.this, "这是一条设置了位置为居中的消息", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;
                case R.id.btn_03:
                    // 实例化 layoutInflater
                    LayoutInflater layoutInflater = LayoutInflater.from(ToastActivity.this);
                    // layout 转 View 对象
                    View toastView = layoutInflater.inflate(R.layout.layout_toast, null);
                    // 获取控件，配置属性
                    ImageView imageView = toastView.findViewById(R.id.iv_01);
                    imageView.setImageResource(R.drawable.icon_headshot);
                    TextView textView = toastView.findViewById(R.id.tv_01);
                    textView.setText("这是一条自定义样式的消息");

                    // 将 View 传入 Toast
                    Toast customToast = Toast.makeText(ToastActivity.this, null, Toast.LENGTH_SHORT);
                    customToast.setView(toastView);
                    customToast.setGravity(Gravity.CENTER, 0, 0);
                    customToast.show();
                    break;
                case R.id.btn_04:
                    ToastUtil.showMsg(getApplicationContext(), "这是一条封装后的消息", Toast.LENGTH_SHORT);
                    break;
            }
        }
    }
}