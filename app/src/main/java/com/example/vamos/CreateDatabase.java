package com.example.vamos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateDatabase extends AppCompatActivity {

    private Button btnCreateDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_database);

        btnCreateDB = findViewById(R.id.btn_create_db);
        btnCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbHelper = new DBHelper(CreateDatabase.this);
                SQLiteDatabase database = dbHelper.getWritableDatabase();
                Toast.makeText(CreateDatabase.this, "Base de datos creada correctamente", Toast.LENGTH_SHORT).show();
            }
        });


    }

}