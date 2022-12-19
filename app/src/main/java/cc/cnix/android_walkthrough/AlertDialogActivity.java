package cc.cnix.android_walkthrough;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    private Button mBtn01;
    private Button mBtn02;
    private Button mBtn03;
    private Button mBtn04;
    private Button mBtn05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        mBtn01 = findViewById(R.id.btn_01);
        mBtn02 = findViewById(R.id.btn_02);
        mBtn03 = findViewById(R.id.btn_03);
        mBtn04 = findViewById(R.id.btn_04);
        mBtn05 = findViewById(R.id.btn_05);

        View.OnClickListener onClickListener = new OnClickListener();
        mBtn01.setOnClickListener(onClickListener);
        mBtn02.setOnClickListener(onClickListener);
        mBtn03.setOnClickListener(onClickListener);
        mBtn04.setOnClickListener(onClickListener);
        mBtn05.setOnClickListener(onClickListener);
    }

    class OnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_01:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder1.setTitle("用户评价").setMessage("表单已提交，您的评价是？").setIcon(R.drawable.icon_user)
                            .setPositiveButton("不错", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(AlertDialogActivity.this, "★★★★★", Toast.LENGTH_SHORT).show();
                                }
                            }).setNeutralButton("一般", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(AlertDialogActivity.this, "★★★☆☆", Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("差评", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(AlertDialogActivity.this, "☆☆☆☆☆", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_02:
                    final String[] arrayGender = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("请选择性别").setItems(arrayGender, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(AlertDialogActivity.this, "您选择的性别：" + arrayGender[i], Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_03:
                    final String[] arrayAnswer = new String[]{"A", "B", "C"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("请选择答案").setSingleChoiceItems(arrayAnswer, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(AlertDialogActivity.this, "您选择的答案是：" + arrayAnswer[i], Toast.LENGTH_SHORT).show();
                            dialogInterface.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case R.id.btn_04:
                    final String[] arrayLang = new String[]{"Java", "PHP", "C#"};
                    final boolean[] arrayChecked = new boolean[]{true, false, false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("请选择感兴趣的语言：").setMultiChoiceItems(arrayLang, arrayChecked, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            Toast.makeText(AlertDialogActivity.this, arrayLang[i] + " - " + arrayChecked[i], Toast.LENGTH_SHORT).show();
                        }
                    }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(AlertDialogActivity.this, "已选择完毕", Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_05:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    // layout -> view
                    View alertView = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_alert_dialog, null);

                    // 获取对应控件
                    EditText mEtUserName = alertView.findViewById(R.id.et_username);
                    EditText mEtPassWord = alertView.findViewById(R.id.et_password);
                    Button mBtnConfirm = alertView.findViewById(R.id.btn_confirm);

                    // 拿到 AlertDialog 对象，后续调用 dismiss() 关闭对话框
                    AlertDialog dialog = builder5.setTitle("用户校验").setView(alertView).show();

                    mBtnConfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(AlertDialogActivity.this, "校验完成", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                    break;
            }
        }
    }
}