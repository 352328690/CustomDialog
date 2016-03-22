package com.example.dialogtoasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button dialogButton;
    private Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogButton = (Button)findViewById(R.id.alertdialog);
        toastButton = (Button)findViewById(R.id.toast);

        dialogButton.setOnClickListener(buttonListener);
        toastButton.setOnClickListener(buttonListener);
    }
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.alertdialog:
                    CustomDialog customDialog = new CustomDialog(MainActivity.this);
                    customDialog.createDialog("小提示", "Dialog测试信息！", new CustomDialog.CallBack() {
                        @Override
                        public void isConfirm(boolean flag) {
                            if (flag){
                                Toast.makeText(MainActivity.this, "你点击了确定", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(MainActivity.this, "你点击了取消", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
                case R.id.toast:

                    break;
                default:
                    break;
            }
        }
    };
}
