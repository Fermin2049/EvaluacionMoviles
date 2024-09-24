package com.fermin2049.evalucionmoviles.ui.carry;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.fermin2049.evalucionmoviles.R;
import com.fermin2049.evalucionmoviles.model.Product;
import com.fermin2049.evalucionmoviles.ui.list.ListViewModel;

import java.util.ArrayList;
import java.util.List;

public class CarryViewModel extends AndroidViewModel {

    private final List<Product> products;

    public CarryViewModel(@NonNull Application application) {
        super(application);
        products = new ArrayList<>();
    }

    // Método para configurar el spinner
    public void setupSpinner(Spinner spinner, Context context) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.product_categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    // Guardar el producto y enviarlo al ListViewModel
    public void saveProduct(String name, String description, String priceStr, String quantityStr, String category, Uri imageUri, Context context, ListViewModel listViewModel) {
        if (name.isEmpty() || description.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty() || imageUri == null) {
            Toast.makeText(context, "Por favor, complete todos los campos y seleccione una imagen", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            int quantity = Integer.parseInt(quantityStr);

            // Crear un nuevo producto con la URI de la imagen
            Product newProduct = new Product(name, description, String.valueOf(price), category, quantity, imageUri);
            products.add(newProduct);

            // Agregar el producto al ListViewModel
            listViewModel.addProduct(newProduct);

            Toast.makeText(context, "Producto agregado correctamente", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {
            Toast.makeText(context, "Precio o cantidad inválidos", Toast.LENGTH_SHORT).show();
        }
    }
}