package cc.cnix.android_walkthrough.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import cc.cnix.android_walkthrough.R;

/**
 * @Author: wriprin
 * @Date: 2022/12/13 13:47
 * @Version 1.0
 */
public class ListViewActivity extends Activity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listview);

            ListView mLvMainView = findViewById(R.id.lv_01);
            mLvMainView.setAdapter(new MyListAdapter(ListViewActivity.this));

            // 行项目点击触发事件
            mLvMainView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(ListViewActivity.this, "当前点击条目序号：" + i, Toast.LENGTH_SHORT).show();
                }
            });

            // 行项目长按触发事件
            mLvMainView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(ListViewActivity.this, "当前长按条目序号：" + i, Toast.LENGTH_SHORT).show();
                    // 长按触发后结束
                    return true;
                }
            });
    }
}
