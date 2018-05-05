package com.lvjianet.greendaodemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<User> users = new ArrayList<>();
    private LayoutInflater inflater;

    public MyAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void addData(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item, null);
            holder = new ViewHolder();
            holder.idTv = view.findViewById(R.id.id);
            holder.nameTv = view.findViewById(R.id.name);
            holder.ageTv = view.findViewById(R.id.age);
            holder.sexTv = view.findViewById(R.id.sex);
            holder.salaryTv = view.findViewById(R.id.salary);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        User user = users.get(i);
        holder.idTv.setText(user.getId() + "");
        holder.ageTv.setText(user.getAge());
        holder.nameTv.setText(user.getName());
        holder.salaryTv.setText(user.getSalary());
        holder.sexTv.setText(user.getSex());
        return view;
    }

    class ViewHolder {
        TextView idTv;
        TextView nameTv;
        TextView sexTv;
        TextView ageTv;
        TextView salaryTv;
    }
}
