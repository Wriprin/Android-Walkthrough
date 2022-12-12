package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        Button mBtn03 = findViewById(R.id.btn_03);
        mBtn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 弹窗消息
                Toast.makeText(ButtonActivity.this, "btn3 has been pressed...", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * btn_04 点击事件，弹出消息
     * @param view
     */
    public void showToast(View view) {
        Toast.makeText(this, "Hello, World.", Toast.LENGTH_SHORT).show();
    }
}