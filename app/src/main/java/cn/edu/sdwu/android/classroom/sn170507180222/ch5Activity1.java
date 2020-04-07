package cn.edu.sdwu.android.classroom.sn170507180222;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ch5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch5_1);
    }
    //第五章：提示信息
    public  void toast1(View view){
        //三个参数分别是：界面；提示文本信息；提示时间长度；
        Toast.makeText(this,"toast1",Toast.LENGTH_LONG).show();
    }
    public void toast2(View view){
       Toast toast= Toast.makeText(this,"toast2",Toast.LENGTH_LONG);
        //默认提示信息的位置
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    //图片以及提示信息
    public void toast3(View view){
        //加载自定义布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater=getLayoutInflater();
        //加载指定页面
        View view1=layoutInflater.inflate(R.layout.layout_toast,null);

        //提示
        TextView textView=(TextView) view1.findViewById(R.id.toast_tv);//设置文本
        textView.setText("toast3");//设置文本
        Toast toast=new Toast(this);
        toast.setView(view1);//设置界面
        toast.setDuration(Toast.LENGTH_LONG);//设置时长
        toast.setGravity(Gravity.CENTER,0,0);//设置位置
        toast.show();
}
        public void notification(View view){
            Notification.Builder builder=new Notification.Builder(this);
            //在构造器中，完成通知的各种属性
            builder.setContentTitle("title");//标题
            builder.setContentText("message");//内容
            builder.setWhen(System.currentTimeMillis());//时间
            builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统资源的图标
            //调用build方法完成构造
            Notification notification=builder.build();
            //使用NotificationManager发送通知
            NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(101,notification);//两个参数分别是：编号和实例
       }
       public void cancel_notification(View view){
           //使用NotificationManager取消通知
           NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
           notificationManager.cancel(101);//根据编号取消
       }
       //alert_dialog提示信息
       public void alert_dialog(View view){
           AlertDialog.Builder builder=new AlertDialog.Builder(this);
           //在构造器中设置对护框属性
           builder.setTitle("title");
           builder.setMessage("message");
           builder.setIcon(android.R.drawable.ic_dialog_email);
           builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   //添加点击按钮后的处理
                   Toast.makeText(ch5Activity1.this,"confirm",Toast.LENGTH_SHORT).show();
               }
           });
           builder.setNegativeButton("exit", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(ch5Activity1.this,"exit",Toast.LENGTH_SHORT).show();
               }
           });
           builder.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   Toast.makeText(ch5Activity1.this,"cancel",Toast.LENGTH_SHORT).show();
               }
           });
           builder.create().show();
       }
}
