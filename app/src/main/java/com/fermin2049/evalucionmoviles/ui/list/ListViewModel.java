package com.fermin2049.evalucionmoviles.ui.list;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fermin2049.evalucionmoviles.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListViewModel extends AndroidViewModel {

    private final MutableLiveData<List<Product>> productsLiveData;
    private final List<Product> productList;

    public ListViewModel(@NonNull Application application) {
        super(application);
        productList = new ArrayList<>();
        productsLiveData = new MutableLiveData<>(productList);
    }

    public LiveData<List<Product>> getProducts() {
        return productsLiveData;
    }

    public void addProduct(Product product) {
        productList.add(product);
        productsLiveData.setValue(productList);  // Actualizar LiveData
    }


}