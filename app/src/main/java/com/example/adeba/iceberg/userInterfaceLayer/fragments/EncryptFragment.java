package com.example.adeba.iceberg.userInterfaceLayer.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adeba.iceberg.R;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

public class EncryptFragment extends Fragment {
    private String title;
    private static final int RESULT_LOAD_IMAGE = 1;
    private static final int RESULT_LOAD_FILE = 2;
    Button encryptionUploadButton;
    Button fileUploadButton;
    Button startEncryptionButton;
    ImageView uploadedImage;
    TextView showUploadedFileTextView;
    private String selectedFilePath;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.encrypt_fragment, container, false);
        encryptionUploadButton = (Button) rootView.findViewById(R.id.encrypt_upload_button);
        uploadedImage = rootView.findViewById(R.id.encrypt_image_view);
        fileUploadButton = (Button) rootView.findViewById(R.id.encrypt_file_upload_button);
        startEncryptionButton = (Button) rootView.findViewById(R.id.encrypt_button);
        showUploadedFileTextView = (TextView) rootView.findViewById(R.id.uploaded_file_text_view);
        encryptionUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadImageIntent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(uploadImageIntent, "Choose Image to upload"), RESULT_LOAD_IMAGE);
            }
        });

        fileUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent uploadFileIntent = new Intent();
                uploadFileIntent.setType("*/*");
                uploadFileIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(uploadFileIntent, "Choose File to Upload.."), RESULT_LOAD_FILE);
            }
        });

        startEncryptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ELP", "BAd badoo baddest");
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
        switch (requestCode) {
            case RESULT_LOAD_FILE:
                if (resultCode == RESULT_OK && null != data) {
                    Uri selectedFileUri = data.getData();
                    selectedFilePath = data.getData().getPath();

                    if (selectedFilePath != null && !selectedFilePath.equals("")) {
                        showUploadedFileTextView.setText(selectedFilePath);
                    }
                    break;
                }
            case RESULT_LOAD_IMAGE:
                if (resultCode == RESULT_OK && null != data) {
                    Uri selectedImage = data.getData();
                    uploadedImage.setImageURI(selectedImage);
                }
                break;
        }
    }
}

//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getActivity().getApplicationContext().getContentResolver().query(selectedImage,filePathColumn,null,null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//            System.out.print("boy poy coy");
//            uploadedImage.setImageURI(selectedImage);


