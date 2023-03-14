package com.example.vamos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTableActivity extends AppCompatActivity {
    private EditText etTableName;
    private Button btnAddTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);

        etTableName = findViewById(R.id.et_table_name);
        btnAddTable = findViewById(R.id.btn_add_table);

        btnAddTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tableName = etTableName.getText().toString().trim();

                if (tableName.isEmpty()) {
                    Toast.makeText(AddTableActivity.this, "Debe ingresar un nombre para la tabla", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper dbHelper = new DBHelper(AddTableActivity.this);
                    SQLiteDatabase database = dbHelper.getWritableDatabase();

                    String createTableQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";

                    database.execSQL(createTableQuery);

                    Toast.makeText(AddTableActivity.this, "Tabla " + tableName + " creada correctamente", Toast.LENGTH_SHORT).show();

                    etTableName.setText("");
                }
            }
        });
    }

}