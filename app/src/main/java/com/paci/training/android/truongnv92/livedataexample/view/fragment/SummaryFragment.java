package com.paci.training.android.truongnv92.livedataexample.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.paci.training.android.truongnv92.livedataexample.R;
import com.paci.training.android.truongnv92.livedataexample.viewmodel.MedalViewModel;

public class SummaryFragment extends Fragment {

    TextView tvNumberOfMedal;
    MedalViewModel medalViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        medalViewModel = new ViewModelProvider(requireActivity()).get(MedalViewModel.class);

        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvNumberOfMedal = view.findViewById(R.id.tvNumberOfMedal);

        medalViewModel.numberOfGoldMedal.observe(requireActivity(), uiState -> {
            displayTotalMedal();
        });
        medalViewModel.numberOfSilverMedal.observe(requireActivity(), uiState -> {
            displayTotalMedal();
        });
        medalViewModel.numberOfBronzeMedal.observe(requireActivity(), uiState -> {
            displayTotalMedal();
        });
    }

    private void displayTotalMedal() {
        int totalMedal = medalViewModel.numberOfTotalMedal.getValue();
        totalMedal = medalViewModel.numberOfGoldMedal.getValue()
                + medalViewModel.numberOfSilverMedal.getValue() + medalViewModel.numberOfBronzeMedal.getValue();
        tvNumberOfMedal.setText(String.valueOf(totalMedal));
    }
}