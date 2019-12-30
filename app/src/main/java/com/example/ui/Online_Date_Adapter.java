package com.example.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Online_Date_Adapter extends RecyclerView.Adapter<Online_Date_Adapter.ViewHolder> {

    private List<String> online_date_list;

    public Online_Date_Adapter(List<String> online_date_list) {
        this.online_date_list = online_date_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.onliine_date_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            String item_data=online_date_list.get(position);
        Log.d("123", "onBindViewHolder: "+item_data);
            holder.setItemTextData(item_data);
    }


    @Override
    public int getItemCount() {
        return online_date_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView online_date_item_data;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            online_date_item_data=itemView.findViewById(R.id.online_date_item);
        }
        private void setItemTextData(String itemText){
            online_date_item_data.setText(itemText);
        }
    }
}


