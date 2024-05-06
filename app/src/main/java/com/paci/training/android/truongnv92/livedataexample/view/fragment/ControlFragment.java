package com.paci.training.android.truongnv92.livedataexample.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.paci.training.android.truongnv92.livedataexample.R;
import com.paci.training.android.truongnv92.livedataexample.viewmodel.MedalViewModel;

public class ControlFragment extends Fragment {
    public static final String TAG = ControlFragment.class.getSimpleName();
    Button btnGoldMinus, btnGoldPlus, btnSilverMinus, btnSilverPlus, btnBronzeMinus, btnBronzePlus;
    MedalViewModel medalViewModel;

    TextView tvMainGoldNumber, tvMainSilverNumber, tvMainBronzeNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        medalViewModel = new ViewModelProvider(requireActivity()).get(MedalViewModel.class);
        Log.i(TAG, "medalViewModel: " + medalViewModel);

        initButton(view);
        initView(view);

        displayMedal();

        btnGoldMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medalViewModel.numberOfGoldMedal.getValue() > 0) {
                    medalViewModel.numberOfGoldMedal.setValue(medalViewModel.numberOfGoldMedal.getValue() - 1);
                }
                displayMedal();
            }
        });
        btnGoldPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medalViewModel.numberOfGoldMedal.setValue(medalViewModel.numberOfGoldMedal.getValue() + 1);
                displayMedal();
            }
        });
        btnSilverMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medalViewModel.numberOfSilverMedal.getValue() > 0) {
                    medalViewModel.numberOfSilverMedal.setValue(medalViewModel.numberOfSilverMedal.getValue() - 1);
                }
                displayMedal();
            }
        });
        btnSilverPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medalViewModel.numberOfSilverMedal.setValue(medalViewModel.numberOfSilverMedal.getValue() + 1);
                displayMedal();
            }
        });
        btnBronzeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (medalViewModel.numberOfBronzeMedal.getValue() > 0) {
                    medalViewModel.numberOfBronzeMedal.setValue(medalViewModel.numberOfBronzeMedal.getValue() - 1);
                }
                displayMedal();
            }
        });
        btnBronzePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                medalViewModel.numberOfBronzeMedal.setValue(medalViewModel.numberOfBronzeMedal.getValue() + 1);
                displayMedal();
            }
        });
    }

    private void displayMedal() {
        tvMainGoldNumber.setText(String.valueOf(medalViewModel.numberOfGoldMedal.getValue()));
        tvMainSilverNumber.setText(String.valueOf(medalViewModel.numberOfSilverMedal.getValue()));
        tvMainBronzeNumber.setText(String.valueOf(medalViewModel.numberOfBronzeMedal.getValue()));
    }

    private void initView(View view) {
        tvMainGoldNumber = view.findViewById(R.id.tvMainGoldNumber);
        tvMainSilverNumber = view.findViewById(R.id.tvMainSilverNumber);
        tvMainBronzeNumber = view.findViewById(R.id.tvMainBronzeNumber);
    }

    private void initButton(View view) {
        btnGoldMinus = view.findViewById(R.id.btnGoldMinus);
        btnGoldPlus = view.findViewById(R.id.btnGoldPlus);
        btnSilverMinus = view.findViewById(R.id.btnSilverMinus);
        btnSilverPlus = view.findViewById(R.id.btnSilverPlus);
        btnBronzeMinus = view.findViewById(R.id.btnBronzeMinus);
        btnBronzePlus = view.findViewById(R.id.btnBronzePlus);
    }
}