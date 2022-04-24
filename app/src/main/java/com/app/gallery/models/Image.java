package com.app.gallery.models;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Image {

    @SerializedName("author")
    private String author;

    @SerializedName("width")
    private long width;

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private long height;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getAuthor() { return author; }
    public void setAuthor(String value) { this.author = value; }

    public long getWidth() { return width; }
    public void setWidth(long value) { this.width = value; }

    public long getHeight() { return height; }
    public void setHeight(long value) { this.height = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public String getDownloadURL() { return downloadUrl; }
    public void setDownloadURL(String value) { this.downloadUrl = value; }

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Log.d("TAG", "loadImage: "+imageUrl);
        Glide.with(view.getContext())
                .load(imageUrl)
                .centerCrop()
                .into(view);
    }

    public static DiffUtil.ItemCallback<Image> itemCallback = new DiffUtil.ItemCallback<Image>() {
        @Override
        public boolean areItemsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
            return oldItem.getID().equals(newItem.getID());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Image oldItem, @NonNull Image newItem) {
            return oldItem.equals(newItem);
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;
        Image image = (Image) o;
        return getWidth() == image.getWidth() && getHeight() == image.getHeight() && id.equals(image.id) && getAuthor().equals(image.getAuthor()) && url.equals(image.url) && getDownloadURL().equals(image.getDownloadURL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getAuthor(), getWidth(), getHeight(), url, getDownloadURL());
    }
}
