package com.example.adeba.iceberg.userInterfaceLayer.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.adeba.iceberg.R;

import static android.app.Activity.RESULT_OK;

public class DecryptFragment extends Fragment {
    private String title;
    private static int RESULT_LOAD_IMAGE = 1;
    Button decryptionUploadButton;
    Button startDecryptionButton;
    ImageView uploadedImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.decrypt_fragment, container, false);
        decryptionUploadButton = (Button) rootView.findViewById(R.id.decrypt_upload_button);
        startDecryptionButton = (Button) rootView.findViewById(R.id.decrypt_button);
        uploadedImage = rootView.findViewById(R.id.decrypt_image_view);
        decryptionUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadIntent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(uploadIntent, RESULT_LOAD_IMAGE);
            }
        });

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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            uploadedImage.setImageURI(selectedImage);
        }
    }
}