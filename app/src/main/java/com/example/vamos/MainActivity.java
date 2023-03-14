package com.example.vamos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_create_database;
    Button btn_add_table;
    private Button btnListTables;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListTables = findViewById(R.id.btn_list_tables);
        btnListTables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListTablesActivity.class);
                startActivity(intent);
            }
        });

        btn_create_database = findViewById(R.id.btn_create_database);
        btn_add_table = findViewById(R.id.btn_add_table);
    }
    public void createDatabase(View view) {
        Intent intent = new Intent(this, CreateDatabase.class);
        startActivity(intent);
    }

    public void addTable(View view) {
        Intent intent = new Intent(this, AddTableActivity.class);
        startActivity(intent);
    }
}