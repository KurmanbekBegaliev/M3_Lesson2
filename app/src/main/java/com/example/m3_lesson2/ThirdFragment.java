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


public class ThirdFragment extends Fragment {

    public static final String THIRD_FRAGMENT_KEY = "third_fragment_key";
    TextView tvThirdFragment;
    Button thirdBtnClick;
    EditText edtThirdFr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thirdBtnClick = view.findViewById(R.id.btn_click3);
        edtThirdFr = view.findViewById(R.id.edt_third_fragment);

        tvThirdFragment = view.findViewById(R.id.tv_third_fragment);
        if (getArguments() != null) {
            tvThirdFragment.setText(getArguments().getString(SecondFragment.SECOND_FRAGMENT_KEY));
        }

        thirdBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(THIRD_FRAGMENT_KEY, edtThirdFr.getText().toString());
                FirstFragment fragment = new FirstFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contianer, fragment).addToBackStack(null).commit();
            }
        });

    }
}