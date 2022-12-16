package cc.cnix.android_walkthrough.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @Author: wriprin
 * @Date: 2022/12/16 10:39
 * @Version 1.0
 */
public class ToastUtil {
    public static Toast mToast;

    /**
     * 解决 Toast 多次的问题，只显示最后一次
     * @param context
     * @param msg
     * @param duration
     */
    public static void showMsg(Context context, String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, duration);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
