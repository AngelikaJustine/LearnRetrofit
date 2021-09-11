package com.example.retrofittrial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");

        getSupportActionBar().setTitle(title);

        Picasso.get().load(image).into((ImageView) findViewById(R.id.imageView));

    }
}