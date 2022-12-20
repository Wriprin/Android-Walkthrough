package cc.cnix.android_walkthrough.widget;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import cc.cnix.android_walkthrough.R;

public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle;
    private TextView mTvMsg;
    private TextView mTvConfirm;
    private TextView mTvCancel;

    private String title, msg, confirm, cancel;

    private IOnConfirmListener confirmListener;
    private IOnCancelListener cancelListener;

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnConfirmListener iOnConfirmListener) {
        this.confirm = confirm;
        this.confirmListener = iOnConfirmListener;
        return this;
    }

    public CustomDialog setCancel(String cancel, IOnCancelListener iOnCancelListener) {
        this.cancel = cancel;
        this.cancelListener = iOnCancelListener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);

        // 外层透明化处理，使得圆角可见
        this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        mTvTitle = findViewById(R.id.tv_title);
        mTvMsg = findViewById(R.id.tv_msg);
        mTvConfirm = findViewById(R.id.tv_confirm);
        mTvCancel = findViewById(R.id.tv_cancel);

        // 判断 赋值变量 非空情况下，则赋值给 控件对象
        if (!TextUtils.isEmpty(title)) {
            mTvTitle.setText(title);
        }
        if (!TextUtils.isEmpty(msg)) {
            mTvMsg.setText(msg);
        }
        if (!TextUtils.isEmpty(confirm)) {
            mTvConfirm.setText(confirm);
        }
        if (!TextUtils.isEmpty(cancel)) {
            mTvCancel.setText(cancel);
        }

        mTvConfirm.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm:
                if (confirmListener != null) {
                    confirmListener.onConfirm(this);
                }
                dismiss();
                break;
            case R.id.tv_cancel:
                if (cancelListener != null) {
                    cancelListener.onCancel(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOnConfirmListener {
        void onConfirm(CustomDialog customDialog);
    }

    public interface IOnCancelListener {
        void onCancel(CustomDialog customDialog);
    }
}
