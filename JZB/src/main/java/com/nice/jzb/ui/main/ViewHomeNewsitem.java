package com.nice.jzb.ui.main;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.core.widget.image.SFImageView;
import com.nice.jzb.R;
import com.nice.jzb.ui.news.NewsListItemBean;

/**
 * Created by ${nice} on ${2016年04月29日14:09:09}.
 */
public class ViewHomeNewsitem extends LinearLayout {


    private SFImageView image;
    private TextView content;
    private TextView source;
    private TextView like;
    private TextView heart;

    public ViewHomeNewsitem(Context context) {
        super(context);
        initView(context);
    }

    public ViewHomeNewsitem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_home_news_item, this, true);
        image  = (SFImageView) findViewById(R.id.image);
        content = (TextView) findViewById(R.id.content);
        source = (TextView) findViewById(R.id.source);
        like = (TextView) findViewById(R.id.like);
        heart = (TextView) findViewById(R.id.heart);
    }

    public void setData(NewsListItemBean bean){
        image.SFSetImageUrl(bean.getImg());
        content.setText(bean.getContent());
        source.setText(bean.getSource());
        like.setText(bean.getLike_count()+"");
        heart.setText(bean.getHeart_count()+"");
    }
}
