package com.example.tablayoutviewpager.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Tab下的Fragment
 *
 * @author ZD
 *         created at 2017/6/30 9:15
 *         description：
 */

public class MyFragment extends android.support.v4.app.Fragment {

    /**
     * 标题
     */
    private final String title;
    /**
     * 内容
     */
    private final String content;
    Context mContext;
    TextView textView;

    /**
     * 得到内容
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 得到标题
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    public MyFragment(String title, String content) {
        super();
        this.title = title;
        this.content = content;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //上下文
        mContext = getActivity();
    }

    /**
     * 创建视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //创建视图
        textView = new TextView(mContext);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    /**
     * 绑定数据
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //设置内容
        textView.setText(content);
    }
}
