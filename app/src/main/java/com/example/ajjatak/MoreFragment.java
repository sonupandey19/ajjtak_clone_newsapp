package com.example.ajjatak;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class MoreFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //home id and onclick
        view.findViewById(R.id.Home).setOnClickListener(v-> Toast.makeText(getContext(), "Home", Toast.LENGTH_SHORT).show());

        //india id and onclick
        view.findViewById(R.id.india).setOnClickListener(view1 -> Toast.makeText(getContext(), "India", Toast.LENGTH_SHORT).show());

        //videos id and onclick
        view.findViewById(R.id.livetv).setOnClickListener(view1 -> Toast.makeText(getContext(), "Videos", Toast.LENGTH_SHORT).show());

        //sports id and onclick
        view.findViewById(R.id.sports).setOnClickListener(view1 -> Toast.makeText(getContext(), "Sports", Toast.LENGTH_SHORT).show());

        //Photos id and onclick
        view.findViewById(R.id.photos).setOnClickListener(view1 -> Toast.makeText(getContext(), "Photos", Toast.LENGTH_SHORT).show());



    }

}