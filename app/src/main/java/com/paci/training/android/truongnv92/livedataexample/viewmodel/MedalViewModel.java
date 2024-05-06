package com.paci.training.android.truongnv92.livedataexample.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

public class MedalViewModel extends ViewModel {
    public static final String TAG = MedalViewModel.class.getSimpleName();

    public MutableLiveData<Integer> numberOfGoldMedal = new MutableLiveData<>();
    public MutableLiveData<Integer> numberOfSilverMedal = new MutableLiveData<>();
    public MutableLiveData<Integer> numberOfBronzeMedal = new MutableLiveData<>();

    public MutableLiveData<Integer> numberOfTotalMedal = new MutableLiveData<>();

    public MedalViewModel() {
        numberOfGoldMedal.setValue(0);
        numberOfSilverMedal.setValue(0);
        numberOfBronzeMedal.setValue(0);
        numberOfTotalMedal.setValue(0);
    }
}
