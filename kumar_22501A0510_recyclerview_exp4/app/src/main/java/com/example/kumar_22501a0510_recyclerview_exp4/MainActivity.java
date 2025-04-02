package com.example.kumar_22501a0510_recyclerview_exp4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        List<Cricketer> players = new ArrayList<>();

        players.add(new Cricketer(R.drawable.virat,"Kohli", "Batsman"));
        players.add(new Cricketer(R.drawable.sachin,"Sachin", "Batsman"));

        players.add(new Cricketer(R.drawable.rohit,"Rohit", "Batsman"));

        RecyclerView rcv = (RecyclerView) this.findViewById(R.id.rcv);
        rcv.setAdapter(new CricketerAdapter(getApplicationContext(),players));
        rcv.setLayoutManager(new LinearLayoutManager((getApplicationContext())));
    }
}