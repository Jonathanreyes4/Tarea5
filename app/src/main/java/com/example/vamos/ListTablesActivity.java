package com.example.vamos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListTablesActivity extends AppCompatActivity {
    private ListView lvTables;
    private List<String> tablesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tables);

        lvTables = findViewById(R.id.lv_tables);
        tablesList = new ArrayList<>();

        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        if (cursor.moveToFirst()) {
            do {
                tablesList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }

        cursor.close();
        database.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tablesList);
        lvTables.setAdapter(adapter);
    }
}