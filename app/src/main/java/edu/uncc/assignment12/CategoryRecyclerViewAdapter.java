package edu.uncc.assignment12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryViewHolder> {

    ArrayList<String> mCategories;

    public CategoryRecyclerViewAdapter(ArrayList<String> mCategories) {
        this.mCategories = mCategories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        CategoryViewHolder viewHolder = new CategoryRecyclerViewAdapter.CategoryViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String mCategory = mCategories.get( position );

        holder.textView.setText( mCategory );
        holder.mCategory = mCategory;

    }

    @Override
    public int getItemCount() {
        return this.mCategories.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        SelectCategoryFragment.SelectCategoryListener mListener;
        TextView textView;
        String mCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(android.R.id.text1);
            mListener = (SelectCategoryFragment.SelectCategoryListener) itemView.getContext();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.selectCategory( mCategory );
                }
            });

        }
    }

}
