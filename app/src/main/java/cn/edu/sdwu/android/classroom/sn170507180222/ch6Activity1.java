package cn.edu.sdwu.android.classroom.sn170507180222;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ch6Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在Java中获取配置的字符串资源
        setContentView(R.layout.layout_ch6_1);

        String content=getString(R.string.ok);
        Log.i(ch6Activity1.this.toString(),content);

        String sms=getString(R.string.sms);
        String.format(sms,100,"张三");
        Log.i(ch6Activity1.this.toString(),sms);
    }
}
