package com.example.sudo.zadaca3;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sudo on 12.4.2017..
 */

public class TaskAdapter extends BaseAdapter {


    private ArrayList<Task> mTasks;
    private Activity activity;
    private DBHelper DBHelper;


    public TaskAdapter(ArrayList<Task> mTasks, Activity activity, DBHelper DBHelper) {
        this.mTasks = mTasks;
        this.activity = activity;
        this.DBHelper = DBHelper;
    }

    public TaskAdapter(ArrayList<Task> tasks) {
        mTasks = tasks;
    }


    public  void deleteTask(int position) {
        this.mTasks.remove(position);
        this.notifyDataSetChanged();
    }


    static private class TaskViewHolder {
        TextView tvNaslov;
        TextView tvOpis;
        TextView tvPrioritet;

        TaskViewHolder(View view) {
            tvNaslov = (TextView) view.findViewById(R.id.tvNaslov);
            tvOpis = (TextView) view.findViewById(R.id.tvOpis);
            tvPrioritet = (TextView) view.findViewById(R.id.tvPrioritet);
        }
    }

    @Override
    public int getCount() {
        return this.mTasks.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mTasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TaskViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_task, parent, false);
            holder = new TaskViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder = (TaskViewHolder) convertView.getTag();
        }
        Task task = this.mTasks.get(position);
        holder.tvNaslov.setText(task.getNaslov());
        holder.tvOpis.setText(task.getOpis());
        holder.tvPrioritet.setText(String.valueOf(task.getPrioritet()));
        return convertView;
    }

}

