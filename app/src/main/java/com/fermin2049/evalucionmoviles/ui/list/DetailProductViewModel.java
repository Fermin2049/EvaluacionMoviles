package com.fermin2049.evalucionmoviles.ui.list;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fermin2049.evalucionmoviles.model.Product;

public class DetailProductViewModel extends AndroidViewModel {

    private final MutableLiveData<Product> productMutableLiveData = new MutableLiveData<>();

    public DetailProductViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Product> getProductMutableLiveData() {
        return productMutableLiveData;
    }

    // Método para recibir el producto desde el Bundle
    public void receiveProduct(Bundle bundle) {
        if (bundle != null) {
            Product product = (Product) bundle.getSerializable("product");
            if (product != null) {
                productMutableLiveData.setValue(product);
            }
        }
    }
}