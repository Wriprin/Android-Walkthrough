package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class TextViewActivity extends AppCompatActivity {

    private TextView mtv_01;
    private TextView mtv_02;
    private TextView mtv_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        mtv_01 = findViewById(R.id.tv_01);
        // 中划线
        mtv_01.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mtv_01.getPaint().setAntiAlias(true); // 去除锯齿

        mtv_02 = findViewById(R.id.tv_02);
        // 下划线
        mtv_02.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        mtv_04 = findViewById(R.id.tv_04);
        // 写入 html 代码 - 加粗下划线
        mtv_04.setText(Html.fromHtml("<b><u>Hello, World.</u></b>"));

        TextView mtv_05 = findViewById(R.id.tv_05);
        // 选中该视图
        mtv_05.setSelected(true);
    }
}