package com.example.a22501a0557_customtoast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v) {
        Toast.makeText(this, "Hi I'm 557's Toast", Toast.LENGTH_LONG).show();
    }

    public void showCustomToast(View v) {
        LayoutInflater lf = getLayoutInflater();
        View layout = lf.inflate(R.layout.cutomtoastlayout, (ViewGroup) findViewById(R.id.ll_ctoast));

        ImageView img = layout.findViewById(R.id.imgv_ctoast);
        img.setImageResource(R.drawable.img); // Set the image from drawable

        TextView txt = layout.findViewById(R.id.txtv_ctoast);
        txt.setText("Hi, I'm Ram, welcome to Custom Toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "APP HAS STARTED", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "APP IS NOW RUNNING", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "APP IS NOW PAUSED", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "APP IS NOW STOPPED", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "APP IS RESTARTING", Toast.LENGTH_LONG).show();
    }
}
