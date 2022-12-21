package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopupWindowActivity extends AppCompatActivity {

    private Button mBtnPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        mBtnPop = findViewById(R.id.btn_Popup);

        mBtnPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View viewPop = getLayoutInflater().inflate(R.layout.layout_popup_window, null);
                // ViewGroup.LayoutParams.WRAP_CONTENT
                // The height of the PopupWindow will be determined by the height of its content.
                // 相当于 控件 的 layout_width="wrap_content"
                PopupWindow popupWindow = new PopupWindow(viewPop, mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);

                // 点击其他位置会关闭 Popup Window
                popupWindow.setOutsideTouchable(true);

                // 避免点击按钮重复 Popup
                popupWindow.setFocusable(true);

                // 绑定下拉显示到指定控件
                popupWindow.showAsDropDown(mBtnPop);

                // 点击第一项，触发点击事件 Toast 弹窗
                TextView textView = viewPop.findViewById(R.id.tv_01);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // 关闭 Popup Window
                        popupWindow.dismiss();
                        Toast.makeText(PopupWindowActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}