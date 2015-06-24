package com.dh.congcusonet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DH on 6/24/2015.
 */
public class NavigationDrawerAdapter extends BaseAdapter {

    private Activity context;
    private LayoutInflater inflater;
    private ArrayList<NavBean> arrayList;

    public NavigationDrawerAdapter(Activity context, ArrayList<NavBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.nav_row,null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imgNav);
            holder.textView = (TextView) convertView.findViewById(R.id.tvNav);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        NavBean bean = arrayList.get(position);

        holder.imageView.setImageResource(bean.getImage());
        holder.textView.setText(bean.getTitle());
        return convertView;
    }
}
