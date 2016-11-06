package com.acm.njit.acm_tutoring;

/**
 * Created by Jesse on 11/6/2016.
 */

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adapter extends BaseAdapter {

    private Context mContext;
    private TextView mMockTextView;

    public Adapter(Context cnt) {
        mContext = cnt;
        mMockTextView = new TextView(mContext);
        mMockTextView.setText("Test text");
        mMockTextView.setBackgroundColor(Color.CYAN);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return mMockTextView;
    }

    @Override
    public long getItemId(int position) {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return mMockTextView;
    }

}