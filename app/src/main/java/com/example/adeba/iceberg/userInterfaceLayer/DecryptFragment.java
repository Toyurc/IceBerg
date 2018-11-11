package com.example.adeba.iceberg.userInterfaceLayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adeba.iceberg.R;

public class DecryptFragment extends Fragment {
    private String title;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.decrypt_fragment, container, false);

        return rootView;
    }

    public static DecryptFragment newInstance(String title) {
        DecryptFragment decryptFragment = new DecryptFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        decryptFragment.setArguments(args);
        return decryptFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("title");
    }
}
