package com.nhan.hrm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhan.hrm.R;
import com.nhan.hrm.Model.MenuModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {

    private ArrayList<MenuModel> menuModelArrayList;

    public MenuAdapter(ArrayList<MenuModel> menuModelArrayList, Context context) {
        this.menuModelArrayList = menuModelArrayList;
        this.context = context;
    }

    private Context context;


    @Override
    public int getCount() {
        return menuModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return menuModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.menu_listview, null);
            //gan id cho cac thuoc tinh ben trong layout
            viewHolder.txtChucNang = convertView.findViewById(R.id.txtMenu);
            viewHolder.hinhAnh = convertView.findViewById(R.id.hinhAnh);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MenuModel menuModel = (MenuModel) getItem(position);
        viewHolder.txtChucNang.setText(menuModel.getTenChucNang());
        Picasso.with(context).load(menuModel.getHinhAnh())
                .placeholder(R.drawable.noimage)
                .placeholder(R.drawable.error)
                .into(viewHolder.hinhAnh);

        return convertView;
    }

    public ArrayList<MenuModel> getMenuModelArrayList() {
        return menuModelArrayList;
    }

    public void setMenuModelArrayList(ArrayList<MenuModel> menuModelArrayList) {
        this.menuModelArrayList = menuModelArrayList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public class ViewHolder{
        TextView txtChucNang;
        ImageView hinhAnh;
    }

}
