package com.example.floatingactionbutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Design Support库提供，使用需依赖库com.android.support:design
 * Android新特性——FloatingActionButton,悬浮按钮使用
 * Android新特性——Snackbar,悬浮按钮使用.
 * Snackbar与Toast区别，Toast只提示用户，Snackbar可以与用户交互
 */
public class MainActivity extends AppCompatActivity {
private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }
}
