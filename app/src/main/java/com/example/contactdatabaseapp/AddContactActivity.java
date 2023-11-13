package com.example.contactdatabaseapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class AddContactActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private static final int REQUEST_IMAGE_CAPTURE = 2;

    private EditText editTextName, editTextDOB, editTextEmail;
    private ImageView imageViewCapture;
    private Button buttonSave, buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        editTextName = findViewById(R.id.editTextName);
        editTextDOB = findViewById(R.id.editTextDOB);
        editTextEmail = findViewById(R.id.editTextEmail);
        imageViewCapture = findViewById(R.id.imageViewCapture);
        buttonSave = findViewById(R.id.buttonSave);
        buttonView = findViewById(R.id.buttonView);

        ImageButton buttonCapture = findViewById(R.id.buttonCapture);

        // Set onClickListener for Capture button
        buttonCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Chọn ảnh từ thư viện hoặc chụp ảnh từ camera
                openImagePicker();
            }
        });

        // Set onClickListener for Save button
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle Save button click
            }
        });

        // Set onClickListener for View button
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle View button click
            }
        });
    }

    // Function to open the image picker (from camera or gallery)
    private void openImagePicker() {
        // Tạo Intent để chọn ảnh từ thư viện
        Intent pickPhotoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        // Tạo Intent để chụp ảnh từ camera
        Intent capturePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Kiểm tra xem có ứng dụng camera trên thiết bị không
        if (capturePhotoIntent.resolveActivity(getPackageManager()) != null) {
            // Tạo một sự lựa chọn giữa chụp ảnh và chọn ảnh từ thư viện
            Intent chooserIntent = Intent.createChooser(pickPhotoIntent, "Select Image");

            // Thêm Intent chụp ảnh vào sự lựa chọn
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{capturePhotoIntent});

            // Mở màn hình chọn ảnh với sự lựa chọn
            startActivityForResult(chooserIntent, PICK_IMAGE_REQUEST);
        } else {
            // Nếu không có ứng dụng camera, chỉ mở màn hình chọn ảnh từ thư viện
            startActivityForResult(pickPhotoIntent, PICK_IMAGE_REQUEST);
        }
    }

    // Xử lý kết quả từ việc chọn ảnh hoặc chụp ảnh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            // Lấy ảnh từ thư viện
            Uri selectedImageUri = data.getData();
            try {
                Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                imageViewCapture.setImageBitmap(imageBitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK && data != null) {
            // Lấy ảnh từ camera
            Bundle extras = data.getExtras();
            if (extras != null && extras.containsKey("data")) {
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imageViewCapture.setImageBitmap(imageBitmap);
            }
        }
    }
}
