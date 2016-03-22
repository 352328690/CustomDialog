package com.example.dialogtoasttest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by lenovo on 2016/3/22.
 */
public class CustomDialog {
    private AlertDialog.Builder builder;
    private Context context;

    public CustomDialog(Context context) {
        this.context = context;
    }

    public void createDialog(String title, String message, final CallBack callBack){
        builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        //setPositiveButton为设置确定按钮的相关属性。
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callBack.isConfirm(true);
            }
        });
        //setNegativeButton为设置取消按钮的相关属性。
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callBack.isConfirm(false);
            }
        });
        builder.create().show();
    }

    public interface CallBack{
        public void isConfirm(boolean flag);
    }
}
