package com.idjmao.easypic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.idjmao.easypiclib.showlist.ShowPics;

import java.util.List;

/**
 * Created by 1djmao on 2017/7/7.
 */

public class ImgListAdapter extends RecyclerView.Adapter<ImgListAdapter.MyViewHolder> {
    List<String> mList;
    Context mContext;
    LayoutInflater mInflater;

    public ImgListAdapter(List<String> list, Context context) {
        mList=list;
        mContext = context;
        mInflater= LayoutInflater. from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.img_lay,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Glide.with( mContext )
             .load(mList.get(position))
             .thumbnail( 0.1f )
             .into( holder.mImageView );
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogShow(position);
            }
        });
        
        
    }

    private void dialogShow(int position) {
        ShowPics.show(mContext,mList,position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView= (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
