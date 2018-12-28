package com.scriptkiddy.freshid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    HomeFragment homeFragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, homeFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_kategori:
                    //mTextMessage.setText(R.string.title_kategori);
                    KategoriFragment kategoriFragment = new KategoriFragment();
                    FragmentTransaction katTransaction = getSupportFragmentManager().beginTransaction();
                    katTransaction.replace(R.id.content, kategoriFragment);
                    katTransaction.commit();
                    return true;
                case R.id.navigation_upload:
                    //mTextMessage.setText(R.string.title_upload);
                    UploadFragment uploadFragment = new UploadFragment();
                    FragmentTransaction uploadTransaction = getSupportFragmentManager().beginTransaction();
                    uploadTransaction.replace(R.id.content, uploadFragment);
                    uploadTransaction.commit();
                    return true;
                case R.id.navigation_profil:
                    //mTextMessage.setText(R.string.title_profile);
                    ProfilFragment profilFragment = new ProfilFragment();
                    FragmentTransaction profilTransaction = getSupportFragmentManager().beginTransaction();
                    profilTransaction.replace(R.id.content, profilFragment);
                    profilTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, homeFragment);
        fragmentTransaction.commit();
        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
