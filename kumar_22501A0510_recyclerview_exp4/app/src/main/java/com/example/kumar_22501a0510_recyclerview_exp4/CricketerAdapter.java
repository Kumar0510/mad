package com.example.kumar_22501a0510_recyclerview_exp4;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class CricketerAdapter extends RecyclerView.Adapter<CricketerViewHolder>{
    Context ct;
    List<Cricketer> players;
    public CricketerAdapter(Context ct,List<Cricketer> l) {
        this.ct = ct;
        this.players = l;
    }
    @NonNull
    @Override
    public CricketerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CricketerViewHolder(LayoutInflater.from(ct).inflate(R.layout.itemlayout_rcv, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull CricketerViewHolder holder, int position) {
        holder.imgv_cpic.setImageResource(players.get(position).getCpic());
        holder.txtv_cname.setText(players.get(position).getCname());
        holder.txtv_crole.setText(players.get(position).getCrole());
    }
    @Override
    public int getItemCount() {
        return players.size();
    }
}
