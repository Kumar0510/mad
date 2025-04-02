package com.example.a22501a0510_exp72_firebase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText edtxt_roll,edtxt_name,edtxt_avg, edtxt_grade;
    FirebaseDatabase fdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtxt_roll = (EditText) this.findViewById(R.id.edtxt_roll);
        edtxt_name= (EditText) this.findViewById(R.id.edtxt_name);
        edtxt_avg = (EditText) this.findViewById(R.id.edtxt_avg);
        edtxt_grade = (EditText) this.findViewById(R.id.edtxt_grade);
        fdb = FirebaseDatabase.getInstance();
    }

    public void insertStu(View v) {
        Student s = new Student(edtxt_roll.getText().toString(),
                edtxt_name.getText().toString(),
                edtxt_avg.getText().toString(),
                edtxt_grade.getText().toString());
        fdb.getReference("students").push().setValue(s)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "success insert", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "faileure in insert", Toast.LENGTH_LONG).show();
                    }
                });
    }
    public void viewStu(View v) {
        fdb.getReference("students").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dss : snapshot.getChildren()){
                    Student st = dss.getValue(Student.class);
                    if(edtxt_roll.getText().toString().equals(st.getRoll())){
                        edtxt_name.setText(st.getName());
                        edtxt_avg.setText(st.getAvg());
                        edtxt_grade.setText(st.getGrade());

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}