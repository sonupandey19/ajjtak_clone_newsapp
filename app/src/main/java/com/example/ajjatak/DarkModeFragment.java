package com.example.ajjatak;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DarkModeFragment extends Fragment {

    boolean isDakmode = false;
    int modeLigth = AppCompatDelegate.MODE_NIGHT_NO;
    int modeDark = AppCompatDelegate.MODE_NIGHT_YES;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dark_mode2, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.lightmode).setOnClickListener(v->{

        view.findViewById(R.id.darkmode).setVisibility(View.VISIBLE);
        view.findViewById(R.id.lightmode).setVisibility(View.GONE);
        btnlightmode(modeLigth);
        });
        view.findViewById(R.id.darkmode).setOnClickListener(v->{btnlightmode(modeDark);
                view.findViewById(R.id.lightmode).setVisibility(View.VISIBLE);
                view.findViewById(R.id.darkmode).setVisibility(View.GONE);
});
    }

    public void btnlightmode(int mode){

                AppCompatDelegate.setDefaultNightMode(mode);
    }

}