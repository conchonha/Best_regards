package com.example.baseprojectandroid.src.adapter.bill_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.models.bill_models.BillModels;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {
    private Context mContext;
    private int mLayout;
    private ArrayList<BillModels>mArrayBill;

    public BillAdapter(ArrayList<BillModels> mArrayBill,Context mContext, int mLayout) {
        this.mContext = mContext;
        this.mLayout = mLayout;
        this.mArrayBill = mArrayBill;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, mLayout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BillModels billModels = mArrayBill.get(position);
        holder.mCodeBill.setText(billModels.getmBillCode());
        holder.mDateBill.setText(billModels.getmDate());
        holder.mSumBill.setText(billModels.getmSumBill());

    }

    @Override
    public int getItemCount()    {
        return mArrayBill.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mCodeBill,mDateBill,mSumBill;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCodeBill = itemView.findViewById(R.id.txt_code_bill);
            mDateBill = itemView.findViewById(R.id.txt_date_bill);
            mSumBill = itemView.findViewById(R.id.txt_sum_bill);
        }
    }
}
