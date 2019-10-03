package com.brena.siadedapplication.Activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;


import com.brena.siadedapplication.Fragments.AsistentenciaFragment;
import com.brena.siadedapplication.Fragments.ComunicadosFragment;
import com.brena.siadedapplication.Fragments.HomeFragment;
import com.brena.siadedapplication.Fragments.NotasFragment;
import com.brena.siadedapplication.Fragments.PagosFragment;
import com.brena.siadedapplication.R;

import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;


public class PrincipalActivity extends AppCompatActivity {


    //DECLARANDO VARIABLES
    private String urlPhoto;
    private String firstWord;
    private String fullName;
    private SharedPreferences sharedPreferences;


    //DECLARANDO COMPONENTES DE MATERIAL X
    private ActionBar actionBar;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private NavigationView nav_view;
    private View headerView;


    private static final int PERMISSIONS_REQUEST = 100;
    private static String[] PERMISSIONS_LIST = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.siaded_green));
        }


        //capturas de los componentes en la navegacion lateral
        navigationView = findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);

        initApliccation();
        initNavigationMenu();
        showNavigationHome();

    }


    private void initApliccation() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.siaded_green));
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setTitle("Inicio");
    }

    private void initNavigationMenu() {
        nav_view = findViewById(R.id.nav_view);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
        };
        drawer.closeDrawer(GravityCompat.START);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home: {
                        showNavigationHome();
                        actionBar.setTitle(item.getTitle());
                        break;
                    }
                    case R.id.nav_pagos: {
                        showNavigationPagos();
                        actionBar.setTitle(item.getTitle());
                        break;
                    }
                    case R.id.nav_asistencia: {
                        showNavigationAsistencia();
                        actionBar.setTitle(item.getTitle());
                        break;
                    }
                    case R.id.nav_comunicados:{
                        showNavigationComunicados();
                        toolbar.setTitle(item.getTitle());
                        break;
                    }
                    case  R.id.nav_notas: {
                        showNavigationNotas();
                        toolbar.setTitle(item.getTitle());
                        break;
                    }
                    /*case R.id.nav_addPost: {
                        showAddPost();
                        actionBar.setTitle(item.getTitle());
                        break;
                    }*/
                }
                return true;
            }
        });
    }

    private void showNavigationHome() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.drawer_content, homeFragment).commit();
        drawer.closeDrawers();
    }

    private void showNavigationPagos() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //PagosFragment pagosFragment = new PagosFragment();
        PagosFragment pagosFragment =new PagosFragment();
        fragmentManager.beginTransaction().replace(R.id.drawer_content, pagosFragment).commit();
        drawer.closeDrawers();
    }

    private void showNavigationAsistencia() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        AsistentenciaFragment asistentenciaFragment = new AsistentenciaFragment();
        fragmentManager.beginTransaction().replace(R.id.drawer_content, asistentenciaFragment).commit();
        drawer.closeDrawers();
    }
    private void showNavigationComunicados(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        ComunicadosFragment comunicadosFragment=new ComunicadosFragment();
        fragmentManager.beginTransaction().replace(R.id.drawer_content,comunicadosFragment).commit();
        drawer.closeDrawers();
    }

   private void showNavigationNotas(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        NotasFragment notasFragment=new NotasFragment();
        fragmentManager.beginTransaction().replace(R.id.drawer_content,notasFragment).commit();
        drawer.closeDrawers();
    }

    /*private void getInsertUser(User user) {
        Call<User> userCall = jsonApiRetrofit().createUser(user);
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Bienvenido nuevamente", Toast.LENGTH_LONG).show();
                    return;
                }

                User userResponse = response.body();
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                boolean success = sharedPreferences.edit()
                        .putString("name", fullName)
                        .putString("email", googleEmail)
                        .putInt("id", userResponse.getId())
                        .putString("photo", urlPhoto)
                        .commit();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    private void checkAllPermissions() {
        boolean permissionRequired = false;
        for (String permission : PERMISSIONS_LIST) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                permissionRequired = true;
        }
        if (permissionRequired) {
            ActivityCompat.requestPermissions(this, PERMISSIONS_LIST, PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST: {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, PERMISSIONS_LIST[i] + " permissions declined!", Toast.LENGTH_LONG).show();
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                finishAffinity();
                            }
                        }, Toast.LENGTH_LONG);
                    }
                }
            }
        }
    }


    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(PrincipalActivity.this, "Cerrando Sesion ...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(PrincipalActivity.this, LoginActivity.class));
                        finish();

                    }
                });

    }
*/

}

