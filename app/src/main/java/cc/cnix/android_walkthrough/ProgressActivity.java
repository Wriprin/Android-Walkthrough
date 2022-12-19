package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPb01;
    private ProgressBar mPb02;
    private ProgressBar mPb03;
    private Button mBtn01;
    private Button mBtn02;
    private Button mBtn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        mPb01 = findViewById(R.id.pb_01);
        mPb02 = findViewById(R.id.pb_02);
        mPb03 = findViewById(R.id.pb_03);
        mBtn01 = findViewById(R.id.btn_01);
        mBtn02 = findViewById(R.id.btn_02);
        mBtn03 = findViewById(R.id.btn_03);

        // 1. 创建 handler 对象，关联主线程(Looper)
        Handler mHandler = new Handler(Looper.getMainLooper());

        mBtn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 当点击按钮后，handler post 到队列中，延时 20 ms 等待处理，并在主线程（UI）执行
                // P.S. 20 ms 由 system clock 决定，而不是 新开 Thread 完成计时
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mPb02.getProgress() < 100) {
                            mPb02.setProgress(mPb02.getProgress() + 2);
                            mHandler.postDelayed(this, 20);
                        } else {
                            Toast.makeText(ProgressActivity.this, "加载已完成", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        // Speed up the Circle ProgressBar
        Handler handlerCircle = new Handler(Looper.myLooper());
        handlerCircle.post(new Runnable() {
            @Override
            public void run() {
                mPb03.setRotation(mPb03.getRotation() + 10);
                handlerCircle.postDelayed(this, 5);
            }
        });


        // ProgressDialog 实例 1
        mBtn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("下载页面");
                progressDialog.setMessage("文件下载中...");
                // 禁止点击 Dialog 以外区域，以关闭当前 Dialog
//                progressDialog.setCancelable(false);
                // 取消后的触发事件
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Toast.makeText(ProgressActivity.this, "已取消", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.show();
            }
        });

        // ProgressDialog 实例 2
        Handler handlerTrade = new Handler(Looper.myLooper());
        mBtn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog2 = new ProgressDialog(ProgressActivity.this);
                progressDialog2.setTitle("交易页面");
                progressDialog2.setMessage("正在交易...");
                progressDialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog2.setMax(100);
                progressDialog2.setCancelable(false);
                progressDialog2.show();

                handlerTrade.post(new Runnable() {
                    @Override
                    public void run() {
                        if (progressDialog2.getProgress() < 100) {
                            progressDialog2.setProgress(progressDialog2.getProgress() + 5);
                            handlerTrade.postDelayed(this, 100);
                        } else {
                            // 关闭当前 Dialog
                            if (progressDialog2.isShowing()) {
                                progressDialog2.dismiss();
                                Toast.makeText(ProgressActivity.this, "交易完成", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}