package edu.uncc.assignment12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiscountRecyclerViewAdapter extends RecyclerView.Adapter<DiscountRecyclerViewAdapter.DiscountViewHolder> {
    ArrayList<String> discountAmounts;

    public DiscountRecyclerViewAdapter(ArrayList<String> discountAmounts) {
        this.discountAmounts = discountAmounts;
    }

    @NonNull
    @Override
    public DiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        DiscountViewHolder viewHolder = new DiscountViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountViewHolder holder, int position) {
        String mDiscount = discountAmounts.get( position );

        holder.textView.setText( mDiscount + "%" );
        holder.mDiscount = mDiscount;

    }

    @Override
    public int getItemCount() {
        return this.discountAmounts.size();
    }

    public static class DiscountViewHolder extends RecyclerView.ViewHolder {

        SelectDiscountFragment.SelectDiscountListener mListener;
        TextView textView;
        SeekBar seekBar;
        String mDiscount;

        public DiscountViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(android.R.id.text1);
            seekBar = itemView.findViewById(R.id.seekBar);
            mListener = (SelectDiscountFragment.SelectDiscountListener) itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mDiscount.equalsIgnoreCase("custom")) {
                        mDiscount = String.valueOf(seekBar.getProgress());
                    }
                    mListener.onDiscountSelected(Double.valueOf(mDiscount));
                }
            });

        }
    }
}
