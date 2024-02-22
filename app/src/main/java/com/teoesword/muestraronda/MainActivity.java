package com.teoesword.muestraronda;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.action_settings) {
            // Muestra el submenú "Configuración" al seleccionar "Configuración"
            showSubMenu(R.menu.submenu_settings);
            return true;
        } else if (itemId == R.id.action_about) {
            // Muestra el submenú "Acerca de" al seleccionar "Acerca de"
            showSubMenu(R.menu.submenu_about);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showSubMenu(int submenuResId) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        PopupMenu popupMenu = new PopupMenu(this, toolbar);
        popupMenu.getMenuInflater().inflate(submenuResId, popupMenu.getMenu());

        // Configurar el listener para las opciones del menú desplegable
        popupMenu.setOnMenuItemClickListener(submenuItem -> {
            // Puedes agregar lógica específica para cada opción aquí
            showToast(submenuItem.getTitle().toString());
            return true;
        });

        // Mostrar el menú desplegable
        popupMenu.show();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
