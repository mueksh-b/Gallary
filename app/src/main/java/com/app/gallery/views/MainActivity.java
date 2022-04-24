package com.app.gallery.views;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import com.app.gallery.views.adapter.RecyclerViewAdapter;
import com.app.gallery.viewModels.GalleryViewModel;
import com.app.newgallaryapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclerViewAdapter recyclerViewAdapter;
    GalleryViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerViewAdapter = new RecyclerViewAdapter();

        binding.galleryRecyclerView.setAdapter(recyclerViewAdapter);

        viewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        viewModel.getImages().observe(this, images -> recyclerViewAdapter.submitList(images));
    }
}