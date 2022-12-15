package cc.cnix.android_walkthrough.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import cc.cnix.android_walkthrough.R;

public class WaterFallRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall_recycler_view);

        mRvMain = findViewById(R.id.rv_01);
        // param 1: spanCount 代表指定方向的 列（垂直） / 行数（水平）
        // param 2: 代表瀑布流的方向
        mRvMain.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        // 绘制分隔线
        mRvMain.addItemDecoration(new DividerItemDecoration(WaterFallRecyclerViewActivity.this, DividerItemDecoration.VERTICAL));
        mRvMain.addItemDecoration(new DividerItemDecoration(WaterFallRecyclerViewActivity.this, DividerItemDecoration.HORIZONTAL));

        mRvMain.setAdapter(new MyStaggerAdapter(WaterFallRecyclerViewActivity.this, new MyStaggerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(WaterFallRecyclerViewActivity.this, "当前点击图片序号：" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}