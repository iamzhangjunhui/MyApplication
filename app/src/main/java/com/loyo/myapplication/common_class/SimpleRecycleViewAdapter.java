package com.loyo.myapplication.common_class;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleRecycleViewAdapter extends RecyclerView.Adapter<SimpleRecycleViewAdapter.ViewHolder> {
    List<String> data;
    SimpleRecycleViewAdapter(List<String> data){
        this.data=data;
    }
    @NonNull
    @Override
    public SimpleRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView=new TextView(parent.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,100));
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleRecycleViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= (TextView) itemView;
        }
    }
}
