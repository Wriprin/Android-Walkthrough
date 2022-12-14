package cc.cnix.android_walkthrough.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import cc.cnix.android_walkthrough.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        mRvMain = findViewById(R.id.rv_01);
        // The meaning of "2" is the number of Grid Columns
        mRvMain.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this, 2));

        mRvMain.setAdapter(new MyGridAdapter(GridRecyclerViewActivity.this, new MyGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "当前点击条目：" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}