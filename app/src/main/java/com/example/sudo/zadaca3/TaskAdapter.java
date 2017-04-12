package com.example.sudo.zadaca3;

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


        ArrayList<Task> mTasks;

        public TaskAdapter(ArrayList<Task> tasks) { mTasks = tasks; }

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
        TaskViewHolder taskViewHolder;
        TaskViewHolder holder = null;
        Context parentContext = parent.getContext();

        if(null==convertView)
        {
            convertView = View.inflate(parentContext, R.layout.item_task,null);

            taskViewHolder = new TaskViewHolder();

            holder.tvNaslov =
                    (TextView) convertView.findViewById(R.id.tvNaslov);
            holder.tvOpis =
                    (TextView) convertView.findViewById(R.id.tvOpis);
            holder.tvPrioritet =
                    (TextView) convertView.findViewById(R.id.tvPrioritet);

            convertView.setTag(taskViewHolder);
        }
        else
        {
            taskViewHolder = (TaskViewHolder) convertView.getTag();
        }
        return convertView;
    }

    public static class ViewHolder  extends RecyclerView.ViewHolder  {
            public TextView tvNaslov, tvOpis, tvPrioritet;
            public ViewHolder(View itemView) {
                super(itemView);
                this.tvNaslov = (TextView) itemView.findViewById(R.id.tvNaslov);
                this.tvOpis = (TextView) itemView.findViewById(R.id.tvOpis);
                this.tvPrioritet = (TextView) itemView.findViewById(R.id.tvPrioritet);
            }
        }
    public void remove(int position) {
        this.mTasks.remove(position);
        this.notifyDataSetChanged();
    }
    static class TaskViewHolder
    {
        private TextView tvNaslov;
        private TextView tvOpis;
        private TextView tvPrioritet;
    }
    }

