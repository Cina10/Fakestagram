package com.example.instragram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    EditText etCaption;
    Button btTakePicture;
    Button btSubmit;
    ImageView ivPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCaption = findViewById(R.id.etCaption);
        btTakePicture = findViewById(R.id.btPicture);
        btSubmit = findViewById(R.id.btSubmit);
        ivPost = findViewById(R.id.ivPost);

    }
}