package edu.uncc.assignment12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
        BillsFragment.BillsListener mListener;
        TextView billName;
        TextView billAmount;
        TextView billDiscount;
        TextView billTotal;
        TextView billDate;
        TextView billCategory;
        ImageButton editButton;
        ImageButton deleteButton;
        View rootView;


        public BillsViewHolder(@NonNull View itemView) {
            super(itemView);
            mListener = (BillsFragment.BillsListener) itemView.getContext();
            billName = itemView.findViewById(R.id.textView_bill_name);
            billAmount = itemView.findViewById(R.id.textView_bill_amount);
            billDiscount = itemView.findViewById(R.id.textView_bill_discount);
            billTotal = itemView.findViewById(R.id.textView_bill_total);
            billDate = itemView.findViewById(R.id.textView_bill_date);
            billCategory = itemView.findViewById(R.id.textView_bill_category);
            editButton = itemView.findViewById(R.id.imageButton_bill_edit);
            deleteButton = itemView.findViewById(R.id.imageButton_bill_delete);
            rootView = itemView;
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

        Bill bill = this.bills.get(position);
        holder.billName.setText(bill.getName());
        holder.billAmount.setText(String.valueOf(bill.getAmount()));
        holder.billDiscount.setText(String.valueOf(bill.getDiscount()));
        holder.billTotal.setText(String.valueOf(bill.getAmount() - ( bill.getAmount() * ( bill.getDiscount() / 100 ) )));
        holder.billDate.setText(bill.getBillDate().toString());
        holder.billCategory.setText(bill.getCategory());

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.mListener.goToEditBill(bill);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mListener.trashCan(bill);
            }
        });
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.mListener.goToBillSummary(bill);
            }

        });
    }

    @Override
    public int getItemCount() {
        return this.bills.size();
    }




}
