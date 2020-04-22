package cn.edu.sdwu.android.classroom.sn170507180222;

import android.app.NotificationManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

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

        //获取数组资源
        Resources resources= getResources();
        //整型数据
        int[] intArr=resources.getIntArray(R.array.intArr);
        for(int i=0;i<intArr.length;i++){
            Log.i(ch6Activity1.this.toString(),intArr[i]+"");
        }
        //字符串数组
        String[] strArr=resources.getStringArray(R.array.strArr);
        for(int i=0;i<strArr.length;i++){
            Log.i(ch6Activity1.this.toString(),strArr[i]+"");
        }
        //普通类型数组
        TypedArray typedArray=resources.obtainTypedArray(R.array.commanArr);
        ImageView imageView=(ImageView)findViewById(R.id.ch6_1_iv);
        int resId=typedArray.getResourceId(0,0);
        imageView.setImageResource(resId);

        String str=typedArray.getString(1);
        Log.i(ch6Activity1.this.toString(),str);

        //注册上下文菜单
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch6_1_11);
        registerForContextMenu(linearLayout);
        XmlPullParser xmlPullParser=resources.getXml(R.xml.words);
        try{
            while (xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT){
                if(xmlPullParser.getEventType()==XmlPullParser.START_TAG){
                    //判断是否是word（words）元素如果是word，直接跳过。
                    if(xmlPullParser.getName().equals("word")){
                        String word=xmlPullParser.getAttributeValue(0);
                        Log.i(ch6Activity1.class.toString(),word);
                    }

                }

            }
        }catch (Exception e){
            Log.e(ch6Activity1.class.toString(),e.toString());
        }
       //和ch5Activity1通知关联（实现通知跳转)
        NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);//根据编号取消

        }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //加载自定义菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item3:
                Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //基于回调的事件处理
        //根据菜单选项的ID进行区分
        switch (item.getItemId()){
            case R.id.mymenu_item1:
                Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
            case R.id.mymenu_item3:
                Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
        }

        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载自定义的菜单资源
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.mymenu1,menu);
        return  true;
    }
}
