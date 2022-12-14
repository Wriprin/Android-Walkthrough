package cc.cnix.android_walkthrough.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cc.cnix.android_walkthrough.R;

public class RecyclerViewActivity extends AppCompatActivity {

    private Button mBtnLinear;
    private Button mBtnHori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mBtnLinear = findViewById(R.id.btn_01);
        mBtnHori = findViewById(R.id.btn_02);
        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnHori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecyclerViewActivity.this, HoriRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}