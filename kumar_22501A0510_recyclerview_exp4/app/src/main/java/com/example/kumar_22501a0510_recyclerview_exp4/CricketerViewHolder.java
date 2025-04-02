package com.example.kumar_22501a0510_recyclerview_exp4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CricketerViewHolder extends RecyclerView.ViewHolder {
    ImageView imgv_cpic;
    TextView txtv_cname, txtv_crole;
    public CricketerViewHolder(@NonNull View itemView) {
        super(itemView);
        imgv_cpic = (ImageView) itemView.findViewById(R.id.imgv_pic);
        txtv_cname = (TextView) itemView.findViewById(R.id.txtv_cname);
        txtv_crole = (TextView) itemView.findViewById(R.id.txt_crole);
    }
}
