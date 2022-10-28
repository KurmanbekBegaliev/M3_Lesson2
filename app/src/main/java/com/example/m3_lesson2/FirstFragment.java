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


public class FirstFragment extends Fragment {

    public static final String KEY_FOR_BUNDLE = "key.bundle";
    EditText edtFirst;
    Button btnClick;
    TextView tvFirstFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvFirstFragment = view.findViewById(R.id.tv_first_fragment);
        if (getArguments() != null) {
            tvFirstFragment.setText(getArguments().getString(ThirdFragment.THIRD_FRAGMENT_KEY));
        }

        btnClick = view.findViewById(R.id.btn_click1);
        edtFirst = view.findViewById(R.id.edt_first_fragment);
        btnClick.setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putString(KEY_FOR_BUNDLE, edtFirst.getText().toString());
            SecondFragment fragment = new SecondFragment();
            fragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contianer, fragment).addToBackStack(null).commit();
        });

    }
}