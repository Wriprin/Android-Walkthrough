package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnUI = findViewById(R.id.btn_01);

        View.OnClickListener onClickListener = new OnClickListener();
        mBtnUI.setOnClickListener(onClickListener);
    }

    class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_01:
                    intent = new Intent(MainActivity.this, UiActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}