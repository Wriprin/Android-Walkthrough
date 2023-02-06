package cc.cnix.android_walkthrough.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cc.cnix.android_walkthrough.R;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AActivity extends AppCompatActivity {

    private Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aactivity);

        mBtn1 = findViewById(R.id.btn_01);

        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * 显示 Intent：启动同一个应用中的 Activity
                 * 隐式 Intent：启动不同应用中的 Activity
                 * 在启动效率上，隐式远远低于显式
                 * 如果系统中有多个 Activity 与意图设置的 Action 匹配，那么在启动 Activity 时，会弹出一个对话框，里面包含所有匹配的 Activity
                 */

                // 显式 1
//                Intent intent = new Intent(AActivity.this, BActivity.class);
//                startActivity(intent);

                // 显式 2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this, BActivity.class);
//                startActivity(intent);

                // 显式 3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this, "cc.cnix.android_walkthrough.jump.BActivity");
//                startActivity(intent);

                // 显式 4
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this, BActivity.class));
//                startActivity(intent);

                // 隐式
//                Intent intent = new Intent();
//                intent.setAction("cc.cnix.jump.B");
//                startActivity(intent);

                // 传递数据
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", "Wriprin");
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            Toast.makeText(AActivity.this, data.getExtras().getString("msg"), Toast.LENGTH_SHORT).show();
        }
    }
}