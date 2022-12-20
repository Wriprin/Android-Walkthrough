package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cc.cnix.android_walkthrough.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);

        mBtnDialog = findViewById(R.id.btn_01);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(CustomDialogActivity.this, R.style.customDialog);
                customDialog.setCancelable(false);
                customDialog.setTitle("对话框")
                        .setMsg("这是一个自定义的 Dialog")
                        .setConfirm("确定", new CustomDialog.IOnConfirmListener() {
                            @Override
                            public void onConfirm(CustomDialog customDialog) {
                                Toast.makeText(CustomDialogActivity.this, "已确定...", Toast.LENGTH_SHORT).show();
                            }
                        }).setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog customDialog) {
                        Toast.makeText(CustomDialogActivity.this, "已取消...", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }
}