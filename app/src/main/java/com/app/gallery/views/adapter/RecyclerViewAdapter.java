package com.app.gallery.views.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.gallery.models.Image;
import com.app.gallery.databinding.GalleryRecyclerViewItemBinding;

public class RecyclerViewAdapter extends ListAdapter<Image, RecyclerViewAdapter.ViewHolder> {

    public RecyclerViewAdapter() {
        super(Image.itemCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(GalleryRecyclerViewItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.recyclerViewItemBinding.setImage(getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        GalleryRecyclerViewItemBinding recyclerViewItemBinding;
        public ViewHolder(@NonNull GalleryRecyclerViewItemBinding binding) {
            super(binding.getRoot());
            this.recyclerViewItemBinding = binding;
        }
    }
}
