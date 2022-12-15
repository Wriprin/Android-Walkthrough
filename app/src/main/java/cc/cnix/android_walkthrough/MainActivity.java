package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import cc.cnix.android_walkthrough.gridview.GridViewActivity;
import cc.cnix.android_walkthrough.listview.ListViewActivity;
import cc.cnix.android_walkthrough.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    // 声明对象
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnRecyclerView;
    private Button mBtnWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取控件对象
        mBtnTextView = findViewById(R.id.btn_01);
        mBtnButton = findViewById(R.id.btn_02);
        mBtnEditText = findViewById(R.id.btn_03);
        mBtnRadioButton = findViewById(R.id.btn_04);
        mBtnCheckBox = findViewById(R.id.btn_05);
        mBtnImageView = findViewById(R.id.btn_06);
        mBtnListView = findViewById(R.id.btn_07);
        mBtnGridView = findViewById(R.id.btn_08);
        mBtnRecyclerView = findViewById(R.id.btn_10);
        mBtnWebView = findViewById(R.id.btn_11);

        // 注册监听器
        setListeners();
    }

    public void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        private Intent intent;

        /**
         * 监听器处理逻辑
         *
         * @param view
         */
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_01:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_02:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_03:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_04:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_05:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_06:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_07:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_08:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_10:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_11:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}