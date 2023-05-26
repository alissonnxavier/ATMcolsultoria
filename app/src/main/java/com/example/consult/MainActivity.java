package com.example.consult;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.consult.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    String text = "Ola";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servico, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    public void enviarEmail(){
        //Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse("tel:41995796362"));
        //String umaImagen = "https://img.freepik.com/fotos-gratis/praia-tropical_74190-188.jpg";
        //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(umaImagen));
        //String linkMap = "https://www.google.com/maps/place/Jardim+Bot%C3%A2nico,+Curitiba+-+PR,+82590-300/@-25.4432842,-49.247017,15z/data=!3m1!4b1!4m6!3m5!1s0x94dce4ff6c236d65:0xdcb9bf3363daa784!8m2!3d-25.4414024!4d-49.2487178!16s%2Fg%2F122vlt_r?entry=ttu";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkMap));
        //startActivity(intent);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"alissonubuntu29@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo app");
        intent.putExtra(Intent.EXTRA_TEXT, "Menssagem automatica");

        intent.setType("message/rfc822");
        //intent.setType("text/plain");

        startActivity( Intent.createChooser( intent, "Escolha um app de email"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}