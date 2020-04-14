package cn.edu.sdwu.android.classroom.sn170507180222;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ch8Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //使用编码方式直接实现布局

        FrameLayout frameLayout=new FrameLayout(this);
        //设置布局大小：使用默认属性宽和高
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

        ImageView imageView=new ImageView(this);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
       //插入图片引入资源和铺满屏幕
        imageView.setImageResource(R.drawable.img);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        frameLayout.addView(imageView);

        //设置文本
        TextView textView=new TextView(this);
        textView.setText("test");
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(70);
        //设置宽高和位置
        textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER));
        frameLayout.addView(textView);

        setContentView(frameLayout);
    }
}
