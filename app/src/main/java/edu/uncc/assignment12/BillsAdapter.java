package edu.uncc.assignment12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.BillsViewHolder> {

    ArrayList<Bill> bills;

    public BillsAdapter(ArrayList<Bill> bills) {
        this.bills = bills;
    }


    public static class BillsViewHolder extends RecyclerView.ViewHolder {
        TextView billName;
        TextView billAmount;
        TextView billDiscount;
        TextView billTotal;
        TextView billDate;
        TextView billCategory;

        public BillsViewHolder(@NonNull View itemView) {
            super(itemView);
            billName = itemView.findViewById(R.id.textView_bill_name);
            billAmount = itemView.findViewById(R.id.textView_bill_amount);
        }
    }

    @NonNull
    @Override
    public BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bill_row_item, parent, false);
        BillsViewHolder billsViewHolder = new BillsViewHolder(view);
        return billsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BillsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.bills.size();
    }


}
