package cn.edu.sdwu.android.classroom.sn170507180222;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;

public class ch9Activity1 extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch9_1);

        //实现自动提示功能

        //实例化数组适配器
        Resources resources=getResources();
        String[] countries=resources.getStringArray(R.array.countries);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,countries);
        AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.ch9_1_act);
        autoCompleteTextView.setAdapter(arrayAdapter);

        //进度条
        progressBar=(ProgressBar)findViewById(R.id.ch9_1_pb);
    }

    //实现显示进度条功能

    public void progressStart(View view){
        Thread thread=new Thread(){
            @Override
            public void run() {
              int i=0;
               while (i<=100){
                   //刷新进度
                   progressBar.setProgress(i);
                   try {
                       //暂停一秒执行程序
                       Thread.sleep(1000);
                   } catch (Exception e) {
                       //e.printStackTrace();
                   }
                   i+=25;
               }
            }
        };
        thread.start();


    }
}
