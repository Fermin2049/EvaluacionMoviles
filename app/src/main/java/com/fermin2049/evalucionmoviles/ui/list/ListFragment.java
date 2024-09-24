package com.fermin2049.evalucionmoviles.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.fermin2049.evalucionmoviles.databinding.FragmentListBinding;
import com.fermin2049.evalucionmoviles.model.Product;
import com.fermin2049.evalucionmoviles.model.ProductAdapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private ListViewModel listViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        // Observar la lista de productos y actualizar el RecyclerView
        listViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                ProductAdapter adapter = new ProductAdapter(products, getLayoutInflater());
                binding.recyclerView.setAdapter(adapter);
                binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}