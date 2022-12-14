package cc.cnix.android_walkthrough.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cc.cnix.android_walkthrough.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        mRvMain = findViewById(R.id.rv_01);

        // 用来设置一个 RecyclerView 的布局管理器 RecyclerView 是一个用于展示大量数据的控件，布局管理器负责决定这些数据项的排列方式
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));

        // 绘制分隔线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(LinearRecyclerViewActivity.this, DividerItemDecoration.VERTICAL);
        mRvMain.addItemDecoration(dividerItemDecoration);

        mRvMain.setAdapter(new MyLinearAdapter(LinearRecyclerViewActivity.this, new MyLinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this, "当前点击条目：" + pos, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}