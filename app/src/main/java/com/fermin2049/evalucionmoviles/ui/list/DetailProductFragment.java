package com.fermin2049.evalucionmoviles.ui.list;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fermin2049.evalucionmoviles.R;
import com.fermin2049.evalucionmoviles.databinding.FragmentDetailProductBinding;

public class DetailProductFragment extends Fragment {

    private DetailProductViewModel mViewModel;

    private FragmentDetailProductBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(DetailProductViewModel.class);
        binding = FragmentDetailProductBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Observar los datos del producto desde el ViewModel y mostrarlos en la vista
        mViewModel.getProductMutableLiveData().observe(getViewLifecycleOwner(), product -> {
            binding.productName.setText(product.getName());
            binding.productDescription.setText(product.getDescription());
            binding.productPrice.setText("Price: $" + product.getPrice());
            binding.productCategory.setText(product.getCategory());
            binding.productQuantity.setText("Quantity: " + product.getQuantity());
            binding.productImage.setImageURI(product.getImage());
        });

        // Recibir el producto desde el Bundle
        mViewModel.receiveProduct(getArguments());

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}