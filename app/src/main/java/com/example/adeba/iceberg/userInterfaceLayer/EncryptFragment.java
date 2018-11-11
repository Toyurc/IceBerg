package com.example.adeba.iceberg.userInterfaceLayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adeba.iceberg.R;

public class EncryptFragment extends Fragment {
    private String title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.encrypt_fragment, container, false);

        return rootView;
    }

    public static EncryptFragment newInstance(String title) {
        EncryptFragment encryptFragment = new EncryptFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        encryptFragment.setArguments(args);
        return encryptFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
    }
}
