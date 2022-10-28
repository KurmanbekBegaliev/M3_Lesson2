package com.example.m3_lesson2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondFragment extends Fragment {

    public static final String SECOND_FRAGMENT_KEY = "second_key";
    TextView tvSecondFragment;
    EditText edtSecondFragment;
    Button secondBtnClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtSecondFragment = view.findViewById(R.id.edt_second_fragment);
        secondBtnClick = view.findViewById(R.id.btn_click2);

        tvSecondFragment = view.findViewById(R.id.tv_second_fragment);
        if (getArguments() != null) {
            String value = getArguments().getString(FirstFragment.KEY_FOR_BUNDLE);
            tvSecondFragment.setText(value);
        }

        secondBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(SECOND_FRAGMENT_KEY, edtSecondFragment.getText().toString());
                ThirdFragment thirdFragment = new ThirdFragment();
                thirdFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contianer, thirdFragment).addToBackStack(null).commit();
            }
        });

    }
}