package com.fermin2049.evalucionmoviles.ui.carry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.evalucionmoviles.R;
import com.fermin2049.evalucionmoviles.databinding.FragmentCarryBinding;
import com.fermin2049.evalucionmoviles.ui.list.ListViewModel;

public class CarryFragment extends Fragment {

    private ActivityResultLauncher<Intent> pickImageLauncher;
    private FragmentCarryBinding binding;
    private CarryViewModel carryViewModel;
    private ListViewModel listViewModel;  // Agregar ListViewModel
    private Uri selectedImageUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializar el lanzador para la galería
        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == getActivity().RESULT_OK && result.getData() != null) {
                        selectedImageUri = result.getData().getData();
                        binding.productImagePreview.setImageURI(selectedImageUri);
                    } else {
                        Toast.makeText(getContext(), "Error al seleccionar imagen", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        carryViewModel = new ViewModelProvider(this).get(CarryViewModel.class);
        listViewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class); // Obtener ListViewModel compartido

        binding = FragmentCarryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        carryViewModel.setupSpinner(binding.productCategory, getContext());

        // Acción del botón para seleccionar imagen desde la galería
        binding.uploadImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            pickImageLauncher.launch(intent);
        });

        // Acción del botón para guardar el producto
        binding.saveProductButton.setOnClickListener(v -> {
            carryViewModel.saveProduct(
                    binding.productName.getText().toString(),
                    binding.productDescription.getText().toString(),
                    binding.productPrice.getText().toString(),
                    binding.productQuantity.getText().toString(),
                    binding.productCategory.getSelectedItem().toString(),
                    selectedImageUri, // Pasamos la URI de la imagen seleccionada
                    getContext(),
                    listViewModel  // Pasamos el ListViewModel
            );

            // Limpiar campos después de guardar el producto
            binding.productName.setText("");
            binding.productDescription.setText("");
            binding.productPrice.setText("");
            binding.productQuantity.setText("");
            binding.productCategory.setSelection(0); // Volver a la primera categoría
            binding.productImagePreview.setImageURI(null); // Resetear la imagen
            selectedImageUri = null; // Limpiar la URI seleccionada
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}