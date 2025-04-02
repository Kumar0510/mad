package com.example.kumar_22501a0510_fragment_exp6;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    SportsFragment sf;
    FragmentManager fm;
    FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sf = new SportsFragment();
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.top_ll, sf);
        ft.commit();

        fm.setFragmentResultListener("si", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                int option = result.getInt("si");
                ft = fm.beginTransaction();
                switch(option){
                    case 0:ft.replace(R.id.bottom_ll, new VolleyFragment()); break;
                    case 1:ft.replace(R.id.bottom_ll, new CricketFragment()); break;
                    case 2:ft.replace(R.id.bottom_ll, new FootballFragment()); break;
                    case 3:ft.replace(R.id.bottom_ll, new HockeyFragment()); break;

                }
                ft.commit();
            }
        });
    }
}