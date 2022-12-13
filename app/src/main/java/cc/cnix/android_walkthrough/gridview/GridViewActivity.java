package cc.cnix.android_walkthrough.gridview;

import androidx.appcompat.app.AppCompatActivity;
import cc.cnix.android_walkthrough.R;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    private GridView mGvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        mGvMain = findViewById(R.id.gv_01);
        mGvMain.setAdapter(new MyGridAdapter(GridViewActivity.this));
    }
}