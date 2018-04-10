package com.idjmao.easypic;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ShowPicActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pic);
        mContext=this;
        mRecyclerView= (RecyclerView) findViewById(R.id.lv_img);

        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera");
        File[] files=file.listFiles();
        final List<String> list=new ArrayList<>();
        for (File f:files) {
            if (f.getName().contains("jpg")){
                list.add(f.getAbsolutePath());
            }
        }
        ImgListAdapter adapter=new ImgListAdapter(list,this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

    }
}
