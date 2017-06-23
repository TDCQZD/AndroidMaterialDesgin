package com.example.administrator.androidmaterialdesgin;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.administrator.androidmaterialdesgin.adapter.FruitAdapter;
import com.example.administrator.androidmaterialdesgin.bean.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *AndroidMaterialDesgin 特性整合
 * ToolBar:标题栏
 * DrawerLayout：可侧滑的布局，v4库支持
 * NavigationView：滑动菜单 ，Design Support库
 * Recyclerview：不解释
 * CardView :卡片式布局,v7库支持
 * AppBarLayout ：实质是一个垂直方向的LinearLayout,用于解决布局中Recyclerview遮挡Toolbar，Design Support库
 * Coordinatorlayout : 布局文件加强版的Fragment
 * FloatingActionButton:悬浮按钮
 * Snackbar：可交互的信息提示
 * swipeRefreshLayout：刷新框架
 * Glide：图片处理框架
 * CollapsingToolbarLayout:可折叠式标题栏
 * NestedScrollView:功能比ScrollView强大,增加嵌套响应滚动事件的功能。
 * 注：CollapsingToolbarLayout不能独立存在，只能作为AppBarLayout的子布局来使用；AppBarLayout有必须是Coordinatorlayout 的子布局。
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton fab;
    private Fruit[] fruits = {new Fruit("Apple", R.drawable.apple), new Fruit("Banana", R.drawable.banana),
            new Fruit("Orange", R.drawable.orange), new Fruit("Watermelon", R.drawable.watermelon),
            new Fruit("Pear", R.drawable.pear), new Fruit("Grape", R.drawable.grape),
            new Fruit("Pineapple", R.drawable.pineapple), new Fruit("Strawberry", R.drawable.strawberry),
            new Fruit("Cherry", R.drawable.cherry), new Fruit("Mango", R.drawable.mango)};

    private List<Fruit> fruitList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefresh;
    private FruitAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//去掉原标题
        setContentView(R.layout.activity_main);
        /*
        可侧滑的布局
         */
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        /*
        toolbar：标题栏设置
         */
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
        toolbar.setTitle("MaterialDesgin");//设置主标题
        toolbar.setTitleTextColor(Color.RED);
        toolbar.setSubtitle("组合的Demo");//设置子标题
        toolbar.setNavigationIcon(R.drawable.ic_menu);//设置导航栏图标
        setSupportActionBar(toolbar);
        /*
       NavigationView:侧边栏菜单设置
         */
        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);//默认选择菜单项
        navigationView.setNavigationItemSelectedListener(this);

        /*
        悬浮按钮+可交互提示
         */
        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"悬浮按钮点击",Toast.LENGTH_SHORT).show();
                Snackbar.make(view,"Data Deleted",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"Data restored",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

        initFruits();//初始化Fruit
        /*
        CardView布局
         */
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        /*
        swipeRefreshLayout刷新Recyclerview
         */
        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        //刷新监听
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
    }

    /**
     * 下拉刷新具体操作
     */
    private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    /**
     * 初始化Fruit
     */
    private void initFruits() {
        fruitList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
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
            case R.id.settings:
                msg += "设置";
                break;
            case R.id.delete:
                msg += "删除";
                break;
            case R.id.backup:
                msg +="传输";
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
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;

    }

    /**
     * NavigationView侧边栏菜单的监听
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
