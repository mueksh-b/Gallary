package com.app.gallery.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.gallery.models.Image;
import com.app.gallery.repositories.GalleryRepo;

import java.util.List;

public class GalleryViewModel extends ViewModel {
    GalleryRepo galleryRepo = new GalleryRepo();

    MutableLiveData<Image> mutableImage = new MutableLiveData<>();

    public LiveData<List<Image>> getImages() {return galleryRepo.getImages();}

    public void setImage(Image image){
        mutableImage.setValue(image);
    }
}
