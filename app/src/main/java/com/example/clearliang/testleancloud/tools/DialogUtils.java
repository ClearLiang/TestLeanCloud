package com.example.clearliang.testleancloud.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clearliang.testleancloud.R;
import com.example.clearliang.testleancloud.base.GlobalVariable;

import java.util.ArrayList;

/**
 * Created by ClearLiang on 2018/1/5.
 *
 * Dialog工具类，包括
 */

public abstract class DialogUtils implements GlobalVariable{

    /**
     * 普通对话框，包括“确认”，“取消”，“关闭”
     * @param tag 输入2或者3，代表有几个按钮
     * */
    public static void showNormalDialog(Context context, String message, int tag,String btnPositive,String btnNegative,
                                        DialogInterface.OnClickListener PositiveListener,DialogInterface.OnClickListener NegativeListener){
        final AlertDialog.Builder normalDialog = new AlertDialog.Builder(context);
        normalDialog.setIcon(R.drawable.qmui_icon_tip_new);
        normalDialog.setTitle("通知");
        normalDialog.setMessage(message);
        if(tag == 2){
            normalDialog.setPositiveButton(btnPositive, PositiveListener);
            normalDialog.setNegativeButton(btnNegative,NegativeListener);
        }else if(tag == 3){
            normalDialog.setPositiveButton(btnPositive,PositiveListener);
            normalDialog.setNeutralButton(btnNegative,NegativeListener);
            normalDialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // ...To-do
                    dialog.dismiss();
                }
            });
        }else {
            normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    normalDialog.setMessage("tag设置错误");
                }
            });
        }
        // 显示
        normalDialog.show();
    }
    /**
     *列表对话框，内容为传入的列表
     * */
    public static void showListDialog(final Context context, String title, String message, final String[] items) {
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(context);
        listDialog.setTitle("我是一个列表Dialog");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                switch (which){
                    case 0:
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
                Toast.makeText(context, "你点击了" + items[which], Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }
    /**
     *单选对话框
     * */
    int yourSingleChoice;
    private void showSingleChoiceDialog(final Context context, String title, String message, final String[] items){
        yourSingleChoice = -1;
        AlertDialog.Builder singleChoiceDialog = new AlertDialog.Builder(context);
        singleChoiceDialog.setTitle(title);
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourSingleChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourSingleChoice != -1) {
                            Toast.makeText(context, "你选择了" + items[yourSingleChoice], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        singleChoiceDialog.show();
    }
    /**
     *多选对话框
     * */
    ArrayList<Integer> yourMulitChoices = new ArrayList<>();
    private void showMultiChoiceDialog(final Context context, String title, String message, final String[] items) {
        // 设置默认选中的选项，全为false默认均未选中
        final boolean initChoiceSets[]={};

        for(int i=0;i<items.length;i++){
            initChoiceSets[i] = false;
        }
        yourMulitChoices.clear();
        AlertDialog.Builder multiChoiceDialog = new AlertDialog.Builder(context);
        multiChoiceDialog.setTitle(title);
        multiChoiceDialog.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                        if (isChecked) {
                            yourMulitChoices.add(which);
                        } else {
                            yourMulitChoices.remove(which);
                        }
                    }
                });
        multiChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = yourMulitChoices.size();
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str += items[yourMulitChoices.get(i)] + " ";
                        }
                        Toast.makeText(context, "你选中了" + str, Toast.LENGTH_SHORT).show();
                    }
                });
        multiChoiceDialog.show();
    }
    /**
     *等待对话框
     * */
    ProgressDialog waitingDialog;
    private void showWaitingDialog(final Context context, String title, String message) {
    /* 等待Dialog具有屏蔽其他控件的交互能力
     * @setCancelable 为使屏幕不可点击，设置为不可取消(false)
     * 下载等事件完成后，主动调用函数关闭该Dialog
     */
        waitingDialog = new ProgressDialog(context);
        waitingDialog.setTitle(title);
        waitingDialog.setMessage(message);
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(false);
        waitingDialog.show();
    }
    private void hideWaitingDialog() {
        waitingDialog.dismiss();
    }
    /**
     * 进度条对话框
     * 模拟进度增加的过程
     * 新开一个线程，每个100ms，进度增加1
     * */
    private void showProgressDialog(final Context context, String title) {
    /* @setProgress 设置初始进度
     * @setProgressStyle 设置样式（水平进度条）
     * @setMax 设置进度最大值
     */
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgress(0);
        progressDialog.setTitle(title);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
    /* 模拟进度增加的过程
     * 新开一个线程，每个100ms，进度增加1
     */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress= 0;
                while (progress < MAX_PROGRESS){
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }
    /**
     * 编辑对话框
     * */
    private void showInputDialog(final Context context, String title) {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(context);
        AlertDialog.Builder inputDialog = new AlertDialog.Builder(context){
            @Override
            public AlertDialog create() {
                Log.i(TAG,"对话框创建成功");
                return super.create();
            }

            @Override
            public AlertDialog show() {

                return super.show();
            }
        };
        inputDialog.setTitle(title).setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "编辑框内容为："+editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        inputDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(context, "Dialog被销毁了", Toast.LENGTH_SHORT).show();
            }
        });
        inputDialog.show();
    }
    /**
     * 自定义对话框
     * */
    private void showCustomizeDialog(final Context context, String title,Integer layoutId) {
    /* @setView 装入自定义View ==> R.layout.dialog_customize
     * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
     * dialog_customize.xml可自定义更复杂的View
     */
        AlertDialog.Builder customizeDialog = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(layoutId,null);
        customizeDialog.setTitle(title);
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 获取EditView中的输入内容
                        //EditText edit_text = dialogView.findViewById(R.id.edit_text);
                        Toast.makeText(context, "创建成功", Toast.LENGTH_SHORT).show();
                    }
                });
        customizeDialog.show();
    }
}
