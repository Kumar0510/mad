package com.example.kumar_510_exp2;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class linearlayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_linearlayout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView img1 = (ImageView) findViewById(R.id.imageView);
        img1.setImageResource(R.drawable.img1);
        ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        img2.setImageResource(R.drawable.img1);
    }
    public void  changeOrientation(View v){
        LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
        if(ll.getOrientation() == LinearLayout.HORIZONTAL){
            ll.setOrientation(LinearLayout.VERTICAL);
        }else{
            ll.setOrientation(LinearLayout.HORIZONTAL);
        }
    }
}