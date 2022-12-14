package cc.cnix.android_walkthrough.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import cc.cnix.android_walkthrough.R;

public class HoriRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hori_recycler_view);

        mRvMain = findViewById(R.id.rv_01);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HoriRecyclerViewActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRvMain.setLayoutManager(linearLayoutManager);

        // 绘制分隔线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(HoriRecyclerViewActivity.this, DividerItemDecoration.HORIZONTAL);
        DividerItemDecoration dividerItemDecorationVertial = new DividerItemDecoration(HoriRecyclerViewActivity.this, DividerItemDecoration.VERTICAL);
        mRvMain.addItemDecoration(dividerItemDecoration);
        mRvMain.addItemDecoration(dividerItemDecorationVertial);

        mRvMain.setAdapter(new MyHoriAdapter(HoriRecyclerViewActivity.this, new MyHoriAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HoriRecyclerViewActivity.this, "当前点击条目：" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}