package com.example.baseprojectandroid.src.adapter.table_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.src.repositories.TableRepositories;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHodler> {
    private ArrayList<TableRepositories>mArrayTable;
    private Context mContext;
    private int mLayout;

    public TableAdapter(ArrayList<TableRepositories> mArrayTable, Context mContext, int mLayout) {
        this.mArrayTable = mArrayTable;
        this.mContext = mContext;
        this.mLayout = mLayout;
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext,mLayout,null);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {
        holder.mTxtTable.setText((position+1)+"");
    }

    @Override
    public int getItemCount() {
        return mArrayTable.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
        private TextView mTxtTable;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            mTxtTable = itemView.findViewById(R.id.txt_table);
        }
    }
}
