package com.example.adeba.iceberg.userInterfaceLayer.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.media.Image;
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

public class EncryptFragment extends Fragment {
    private String title;
    private static int RESULT_LOAD_IMAGE = 1;
    Button encryptionUploadButton;
    ImageView uploadedImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.encrypt_fragment, container, false);
        encryptionUploadButton = (Button) rootView.findViewById(R.id.encrypt_upload_button);
        uploadedImage = rootView.findViewById(R.id.encrypt_image_view);
        encryptionUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadIntent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                uploadIntent.setType("image/*");
                startActivityForResult(uploadIntent, RESULT_LOAD_IMAGE);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};

//            Cursor cursor = getActivity().getApplicationContext().getContentResolver().query(selectedImage,filePathColumn,null,null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            System.out.print("boy poy coy");
            uploadedImage.setImageURI(selectedImage);
        }
    }
}


