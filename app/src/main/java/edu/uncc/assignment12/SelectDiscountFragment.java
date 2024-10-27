package edu.uncc.assignment12;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.Arrays;

import edu.uncc.assignment12.databinding.FragmentSelectDiscountBinding;


public class SelectDiscountFragment extends Fragment {
    public SelectDiscountFragment() {
        // Required empty public constructor
    }

    private ArrayList<String> discountAmounts = new ArrayList<String>(Arrays.asList( "10", "15", "18", "Custom" ) );

    FragmentSelectDiscountBinding binding;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    DiscountRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSelectDiscountBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = binding.recyclerView;
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new DiscountRecyclerViewAdapter( discountAmounts );

        recyclerView.setAdapter(adapter);

        binding.seekBar.setMax(50);
        binding.seekBar.setProgress(25);

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.textViewSeekBarProgress.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onCancelSelectDiscount();
            }
        });
    }

    SelectDiscountListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SelectDiscountListener) {
            mListener = (SelectDiscountListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement SelectDiscountListener");
        }
    }

    interface SelectDiscountListener {
        void onDiscountSelected(double discount);
        void onCancelSelectDiscount();
    }
}