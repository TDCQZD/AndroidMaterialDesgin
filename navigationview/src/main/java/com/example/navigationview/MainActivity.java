package com.example.navigationview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

/**
 *  Design Support库提供，使用需依赖库com.android.support:design
 * Android新特性——NavigationView,滑动菜单的使用
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("Title");//设置主标题
        toolbar.setTitleTextColor(Color.RED);
        toolbar.setSubtitle("Subtitle");//设置子标题
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);//设置导航栏图标
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_lauout);
        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);//默认选择菜单项
        navigationView.setNavigationItemSelectedListener(this);

    }

    /**
     * 自定义Toolbar菜单的监听
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
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
     * 显示自定义Toolbar菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return true;

    }

    /**
     * 滑动菜单的监听
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        String msg = "";
        switch (item.getItemId()) {
            case R.id.nav_call:
                msg += "电话";
                break;
            case R.id.nav_friends:
                msg += "联系人";
                break;
            case R.id.nav_location:
                msg += "地址";
                break;
            case R.id.nav_mail:
                msg +="邮箱";
                break;
            case R.id.nav_task:
                msg += "日程";
                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawers();//关闭滑动菜单
        return true;
    }
}
