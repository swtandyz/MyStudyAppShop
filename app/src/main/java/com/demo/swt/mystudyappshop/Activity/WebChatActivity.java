package com.demo.swt.mystudyappshop.Activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.demo.swt.mystudyappshop.Adapter.WebChatAdapter;
import com.demo.swt.mystudyappshop.Interface.OnRecyclerViewItemClickListener;
import com.demo.swt.mystudyappshop.R;
import com.demo.swt.mystudyappshop.Wight.ChatButton;
import com.demo.swt.mystudyappshop.bean.RecordBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 介绍：这里写介绍
 * 作者：sweet
 * 邮箱：sunwentao@imcoming.cn
 * 时间: 2017/1/19
 */

public class WebChatActivity extends FragmentActivity {
    private RecyclerView chatrecycle;
    private List<RecordBean> mlist = new ArrayList<>();
    private ChatButton mChatButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webchat);
        chatrecycle = (RecyclerView) findViewById(R.id.chatrecycle);
        mChatButton = (ChatButton) findViewById(R.id.chatbutton);
        final WebChatAdapter adapter = new WebChatAdapter(this, mlist, R.layout.webchatitem);
        mChatButton.setonAudioFinishRecorderListener(new ChatButton.AudioFinishRecorderListener() {
            @Override
            public void onFinsh(float seconds, String filePath) {
                RecordBean record = new RecordBean(seconds, filePath);
                mlist.add(record);
                adapter.notifyDataSetChanged();
            }
        });
        chatrecycle.setAdapter(adapter);
        chatrecycle.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener<RecordBean>() {
            @Override
            public void onClick(int position, RecordBean recordBean) {
                View animView = findViewById(R.id.record_anim);
                animView.setBackgroundResource(R.drawable.play_anim);
                AnimationDrawable anim = (AnimationDrawable) animView.getBackground();
                anim.start();
            }
        });
    }


}
