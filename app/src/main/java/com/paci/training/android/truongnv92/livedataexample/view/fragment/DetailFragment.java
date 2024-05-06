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
import android.widget.TextView;

import com.paci.training.android.truongnv92.livedataexample.R;
import com.paci.training.android.truongnv92.livedataexample.viewmodel.MedalViewModel;

public class DetailFragment extends Fragment {
    public static final String TAG = DetailFragment.class.getSimpleName();
    TextView tvDetailGoldNumber, tvDetailSilverNumber, tvDetailBronzeNumber;
    MedalViewModel medalViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG,"medalViewModel: " + medalViewModel);
        medalViewModel = new ViewModelProvider(requireActivity()).get(MedalViewModel.class);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDetailGoldNumber = view.findViewById(R.id.tvDetailGoldNumber);
        tvDetailSilverNumber = view.findViewById(R.id.tvDetailSilverNumber);
        tvDetailBronzeNumber = view.findViewById(R.id.tvDetailBronzeNumber);

        medalViewModel.numberOfGoldMedal.observe(requireActivity(), uiState -> {
            displayMedal();
        });
        medalViewModel.numberOfSilverMedal.observe(requireActivity(), uiState -> {
            displayMedal();
        });
        medalViewModel.numberOfBronzeMedal.observe(requireActivity(), uiState -> {
            displayMedal();
        });
    }

    private void displayMedal() {
        tvDetailGoldNumber.setText(String.valueOf(medalViewModel.numberOfGoldMedal.getValue()));
        tvDetailSilverNumber.setText(String.valueOf(medalViewModel.numberOfSilverMedal.getValue()));
        tvDetailBronzeNumber.setText(String.valueOf(medalViewModel.numberOfBronzeMedal.getValue()));
    }
}