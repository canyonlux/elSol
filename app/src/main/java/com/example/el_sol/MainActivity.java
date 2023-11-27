package com.example.el_sol;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SolarImageAdapter adapter;
    private List<SolarImage> solarImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa la lista de imágenes solares (aquí deberías añadir tus datos)
        solarImageList = new ArrayList<>();
        solarImageList.add(new SolarImage(R.drawable.corona_solar, "Corona"));
        solarImageList.add(new SolarImage(R.drawable.erupcionsolar, "Erupcion"));
        solarImageList.add(new SolarImage(R.drawable.espiculas, "Espiculas"));
        solarImageList.add(new SolarImage(R.drawable.filamentos, "Filamentos"));
        solarImageList.add(new SolarImage(R.drawable.magnetosfera, "Magnetosfera"));
        solarImageList.add(new SolarImage(R.drawable.manchasolar, "Mancha"));


        recyclerView = findViewById(R.id.recyclerView);
        int numberOfColumns = 2; // Ajusta este valor para tu diseño
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

        // Inicializa el adaptador con la lista de imágenes solares
        adapter = new SolarImageAdapter(solarImageList);
        recyclerView.setAdapter(adapter);
    }

    // Método para actualizar los datos en el adaptador y refrescar el RecyclerView
    private void updateSolarImages() {
        // Aquí actualizas la lista de solarImageList con nuevos datos
        adapter.notifyDataSetChanged();
    }
}
