package com.ebookreader;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;



public class MainActivity extends AppCompatActivity {
    private GridView gview;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[] icon = {
            R.drawable.act_info, R.drawable.bookstore,
            R.drawable.know, R.drawable.prisonin,
            R.drawable.prisonout, R.drawable.readmin,
            R.drawable.socia, R.drawable.specialedu,
            R.drawable.tech, R.drawable.think
    };
    private String[] iconName = { "活动通知", "凤凰书市", "学历教育", "入监教育", "出监教育", "每日诵读", "社会帮教", "专题教育", "技术教育", "思想教育" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //LoginActivity login=new LoginActivity();
        super.onCreate(savedInstanceState);
        //if(login.check_Islogin())
        setContentView(R.layout.activity_main);

        //else setContentView(R.layout.activity_login);
        gview = (GridView) findViewById(R.id.gview);
        //新建List
        data_list = new ArrayList<Map<String, Object>>();
        //获取数据
        getData();
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.item, from, to);
        //配置适配器
        gview.setAdapter(sim_adapter);

        gview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                intent_GoToDetailActivity(position);
            }
        });

    }



    public void intent_GoToDetailActivity(int pos) {
        Intent intent_toDetail = new Intent();
        intent_toDetail.setClass(this,Detail_Activity.class);
        intent_toDetail.putExtra("first", pos);
        startActivity(intent_toDetail);
    }

    public List<Map<String, Object>> getData(){

        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }



}