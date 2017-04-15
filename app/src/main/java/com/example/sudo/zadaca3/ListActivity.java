package com.example.sudo.zadaca3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener{

    Button bZadatak;
    ListView lvTask;


    DBHelper dbHelper;
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



            dbHelper = DBHelper.getInstance(this);

            this.taskAdapter = new TaskAdapter(this.loadTasks());

            this.lvTask.setOnItemLongClickListener(this);

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

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        this.taskAdapter.deleteTask(position);
        dbHelper.Delete(getTaskId());
        return false;
    }
}

