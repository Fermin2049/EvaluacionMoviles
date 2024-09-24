package com.fermin2049.evalucionmoviles.ui.leave;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fermin2049.evalucionmoviles.MainActivity;
import com.fermin2049.evalucionmoviles.databinding.FragmentLeaveBinding;

public class LeaveFragment extends Fragment {

    private FragmentLeaveBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLeaveBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Mostrar el cuadro de diálogo de confirmación cuando se acceda a esta vista
        showExitConfirmationDialog();

        return root;
    }

    private void showExitConfirmationDialog() {
        // Crear el cuadro de diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Confirmación de salida");
        builder.setMessage("¿Está seguro de que desea salir?");

        // Opción "Sí"
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Salir de la aplicación
                getActivity().finishAffinity(); // Cierra todas las actividades
            }
        });

        // Opción "No"
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Redirigir al fragmento principal (puedes cambiar a cualquier fragmento que prefieras)
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragment", "nav_list"); // Muestra el fragmento de la lista (puedes ajustar esto según tus necesidades)
                startActivity(intent);
            }
        });

        // Mostrar el cuadro de diálogo
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}