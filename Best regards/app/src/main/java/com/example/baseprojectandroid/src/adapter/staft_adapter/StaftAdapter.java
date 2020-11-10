package com.example.baseprojectandroid.src.adapter.staft_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.models.staft_models.StaftModels;

import java.util.ArrayList;

public class StaftAdapter extends RecyclerView.Adapter<StaftAdapter.ViewHolder> {
    private Context mContext;
    private int layout;
    private ArrayList<StaftModels>mArrayStaft;

    public StaftAdapter(Context mContext, int layout, ArrayList<StaftModels> mArrayStaft) {
        this.mContext = mContext;
        this.layout = layout;
        this.mArrayStaft = mArrayStaft;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StaftModels staftModels = mArrayStaft.get(position);
        holder.mAccount.setText(staftModels.getmNameStaft());
        holder.mRole.setText(staftModels.getmRole());
    }

    @Override
    public int getItemCount() {
        return mArrayStaft.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mAccount,mRole;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mAccount = itemView.findViewById(R.id.txt_account);
            mRole = itemView.findViewById(R.id.txt_role);
        }
    }
}
