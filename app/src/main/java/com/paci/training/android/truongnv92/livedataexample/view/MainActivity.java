package com.paci.training.android.truongnv92.livedataexample.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.paci.training.android.truongnv92.livedataexample.R;
import com.paci.training.android.truongnv92.livedataexample.view.fragment.ControlFragment;
import com.paci.training.android.truongnv92.livedataexample.view.fragment.DetailFragment;
import com.paci.training.android.truongnv92.livedataexample.view.fragment.SummaryFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initSummaryView();
        initDetailView();
        initControlView();
    }

    private void initSummaryView() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment, new SummaryFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void initDetailView() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment2, new DetailFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void initControlView() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment3, new ControlFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}