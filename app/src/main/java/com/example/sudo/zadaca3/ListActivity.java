package com.example.sudo.zadaca3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    Button bZadatak;
    ListView lvTask;
    TaskAdapter taskAdapter;
    RecyclerView.LayoutManager  layoutManager;
    RecyclerView.ItemDecoration itemDecoration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initializeUI();
    }

    private void initializeUI() {

        this.lvTask = (ListView) findViewById(R.id.lvTask);
        this.taskAdapter = new TaskAdapter(this.loadTasks());
        this.bZadatak = (Button) findViewById(R.id.bZadatak);
        this.bZadatak.setOnClickListener(this);

        DBHelper databaseHelper = DBHelper.getInstance(this);
        ArrayList<Task> taskArrayList = databaseHelper.getAllTasks();
        databaseHelper.close();
        TaskAdapter taskAdapter = new TaskAdapter(taskArrayList);
        lvTask.setAdapter(taskAdapter);
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

