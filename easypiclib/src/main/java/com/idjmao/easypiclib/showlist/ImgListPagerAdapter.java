package com.idjmao.easypiclib.showlist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1djmao on 2017/9/11.
 */

public class ImgListPagerAdapter extends PagerAdapter {
    List<String> mList;
    Context mContext;
    List<View> mViewList;

    public ImgListPagerAdapter(Context context, List<String> list) {
        mList = list;
        mContext = context;
        mViewList=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            PhotoView view = new PhotoView(context);
            mViewList.add(view);
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

//        int i = position % 4;
//        PhotoView imageView = (PhotoView) mViewList.get(i);

        PhotoView imageView = new PhotoView(mContext);

        Glide.with( mContext )
             .load(mList.get(position))
             .into( imageView );
        imageView.enable();
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);

    }
}
