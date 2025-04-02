package com.example.kumar_22501a0510_exp7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editRoll, editName, editAverage, editGrade;
    Button btnInsert, btnDelete, btnSelect, btnUpdate;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editRoll = findViewById(R.id.edit_roll);
        editName = findViewById(R.id.edit_name);
        editAverage = findViewById(R.id.edit_average);
        editGrade = findViewById(R.id.edit_grade);
        btnInsert = findViewById(R.id.btn_insert);
        btnDelete = findViewById(R.id.btn_delete);
        btnSelect = findViewById(R.id.btn_select);
        btnUpdate = findViewById(R.id.btn_update);

        dbHelper = new DBHelper(this);

        btnInsert.setOnClickListener(v -> {
            int roll = Integer.parseInt(editRoll.getText().toString());
            String name = editName.getText().toString();
            double avg = Double.parseDouble(editAverage.getText().toString());
            String grade = editGrade.getText().toString();

            if (dbHelper.insertStudent(roll, name, avg, grade))
                Toast.makeText(this, "Inserted Successfully!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Insertion Failed!", Toast.LENGTH_SHORT).show();
        });

        btnDelete.setOnClickListener(v -> {
            int roll = Integer.parseInt(editRoll.getText().toString());
            if (dbHelper.deleteStudent(roll))
                Toast.makeText(this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Deletion Failed!", Toast.LENGTH_SHORT).show();
        });

        btnSelect.setOnClickListener(v -> {
            int roll;
            try {
                roll = Integer.parseInt(editRoll.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Enter a valid Roll Number!", Toast.LENGTH_SHORT).show();
                return;
            }

            Cursor cursor = dbHelper.getStudent(roll);
            if (cursor != null && cursor.moveToFirst()) {
                // Retrieve values from the cursor
                String name = cursor.getString(1);
                double avg = cursor.getDouble(2);
                String grade = cursor.getString(3);

                TextView tvResult = findViewById(R.id.tv_result);
                tvResult.setText("Roll: " + roll + "\nName: " + name + "\nAverage: " + avg + "\nGrade: " + grade);
            } else {
                Toast.makeText(this, "No Record Found!", Toast.LENGTH_SHORT).show();
            }
            if (cursor != null) {
                cursor.close(); // Close cursor to avoid memory leaks
            }
        });

        btnUpdate.setOnClickListener(v -> {
            int roll = Integer.parseInt(editRoll.getText().toString());
            String name = editName.getText().toString();
            double avg = Double.parseDouble(editAverage.getText().toString());
            String grade = editGrade.getText().toString();

            if (dbHelper.updateStudent(roll, name, avg, grade))
                Toast.makeText(this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Update Failed!", Toast.LENGTH_SHORT).show();
        });
    }
}