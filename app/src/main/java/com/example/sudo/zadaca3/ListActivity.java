package com.example.sudo.zadaca3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    Button bZadatak;
    public ListView lvTask;


    private DBHelper dbHelper;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initializeUI();
    }

    private void initializeUI() {


        this.lvTask = (ListView) findViewById(R.id.lvTask);
        this.bZadatak = (Button) findViewById(R.id.bZadatak);
        this.bZadatak.setOnClickListener(this);
        this.lvTask.setAdapter(taskAdapter);

        this.taskAdapter = new TaskAdapter(this.loadTasks());

        this.lvTask.setOnLongClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public boolean onItemClick(AdapterView<?> parent, View view, int position, long id) {
                taskAdapter.deleteTask(position);
                return false;
            }

        });
        dbHelper = DBHelper.getInstance(this);
        ArrayList<Task> task = dbHelper.getAllTasks();
        if (task != null) {
            dbHelper.close();
            taskAdapter = new TaskAdapter(task, this, dbHelper);
            lvTask.setAdapter(taskAdapter);
        }
    }



    @Override
    public void onClick(View v) {
        Intent intent = null;
        int ID = v.getId();
        switch(ID){
            case R.id.bZadatak:
                intent = new Intent(this, AddTask.class);
                startActivity(intent);
            break;
        }
    }
    private ArrayList<Task> loadTasks() {
        return DBHelper.getInstance(this).getAllTasks();
    }
}

