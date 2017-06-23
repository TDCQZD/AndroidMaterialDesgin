package com.example.toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

/**
 * Android新特性——ToolBar,标题栏使用
 */
public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏掉系统原先的导航栏，继承AppCompatActivity时使用
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏掉系统原先的导航栏,继承Activity时使用
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("Title");//设置主标题
        toolbar.setTitleTextColor(Color.RED);
        toolbar.setSubtitle("Subtitle");//设置子标题
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);//设置导航栏图标

//        toolbar.inflateMenu(R.menu.base_toolbar_menu);
//        toolbar.setOnMenuItemClickListener(this);


    }
    /**
     * 自定义菜单的监听1
     * 推荐
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_search:
                msg += "查找";
                break;
            case R.id.action_notification:
                msg += "通知";
                break;
            case R.id.action_item1:
                msg +="Item 1";
                break;
            case R.id.action_item2:
                msg += "Item 2";
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * 自定义菜单的监听2
     * onCreate中写监听
     * @param item
     * @return
     */
    @Override
    public boolean onMenuItemClick(MenuItem item) {

        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_search:
                msg += "查找";
                break;
            case R.id.action_notification:
                msg += "通知";
                break;
            case R.id.action_item1:
                msg +="Item 1";
                break;
            case R.id.action_item2:
                msg += "Item 2";
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * 显示自定义菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return true;

    }
}
