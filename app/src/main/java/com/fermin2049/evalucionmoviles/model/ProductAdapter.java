package com.fermin2049.evalucionmoviles.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.fermin2049.evalucionmoviles.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolderProduct> {

    private List<Product> products;
    private LayoutInflater inflater;

    public ProductAdapter(List<Product> products, LayoutInflater inflater) {
        this.products = products;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla el layout correcto para el item de la lista (item_product.xml)
        View view = inflater.inflate(R.layout.item_product, parent, false);  // Cambiado a item_product.xml
        return new ViewHolderProduct(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolderProduct holder, int position) {
        Product product = products.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText("Price: $" + product.getPrice());
        holder.productQuantity.setText("Quantity: " + product.getQuantity());
        holder.productImage.setImageURI(product.getImage());

        // Configuramos el listener para navegar al fragmento de detalle
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("product", product);
            Navigation.findNavController(v).navigate(R.id.action_nav_list_to_detailProductFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ViewHolderProduct extends RecyclerView.ViewHolder {
        TextView productName, productPrice, productQuantity;
        ImageView productImage;

        public ViewHolderProduct(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }
}
