package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cc.cnix.android_walkthrough.gridview.GridViewActivity;
import cc.cnix.android_walkthrough.listview.ListViewActivity;
import cc.cnix.android_walkthrough.recyclerview.RecyclerViewActivity;

public class UiActivity extends AppCompatActivity {

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
    private Button mBtnToast;
    private Button mBtnAlertDialog;
    private Button mBtnProgress;
    private Button mBtnCustomDialog;
    private Button mBtnPopupWindow;
    private Button mBtnManual;
    private Button mBtnLifeCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

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
        mBtnToast = findViewById(R.id.btn_12);
        mBtnAlertDialog = findViewById(R.id.btn_13);
        mBtnProgress = findViewById(R.id.btn_14);
        mBtnCustomDialog = findViewById(R.id.btn_15);
        mBtnPopupWindow = findViewById(R.id.btn_16);
        mBtnManual = findViewById(R.id.btn_17);
        mBtnLifeCycle = findViewById(R.id.btn_18);

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
        mBtnToast.setOnClickListener(onClick);
        mBtnAlertDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
        mBtnCustomDialog.setOnClickListener(onClick);
        mBtnPopupWindow.setOnClickListener(onClick);
        mBtnManual.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
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
                    intent = new Intent(UiActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_02:
                    intent = new Intent(UiActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_03:
                    intent = new Intent(UiActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_04:
                    intent = new Intent(UiActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_05:
                    intent = new Intent(UiActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_06:
                    intent = new Intent(UiActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_07:
                    intent = new Intent(UiActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_08:
                    intent = new Intent(UiActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_10:
                    intent = new Intent(UiActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_11:
                    intent = new Intent(UiActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_12:
                    intent = new Intent(UiActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_13:
                    intent = new Intent(UiActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.btn_14:
                    intent = new Intent(UiActivity.this, ProgressActivity.class);
                    break;
                case R.id.btn_15:
                    intent = new Intent(UiActivity.this, CustomDialogActivity.class);
                    break;
                case R.id.btn_16:
                    intent = new Intent(UiActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_17:
                    intent = new Intent(UiActivity.this, ManualActivity.class);
                    break;
                case R.id.btn_18:
                    intent = new Intent(UiActivity.this, LifeCycleActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}