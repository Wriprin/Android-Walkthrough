package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCbVSCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCbVSCode = findViewById(R.id.cb_06);

        mCbVSCode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // 选中指定 CheckBox，弹出消息文本
                Toast.makeText(CheckBoxActivity.this, b?"VS Code 被选中了...":"VS Code 被取消选中...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}