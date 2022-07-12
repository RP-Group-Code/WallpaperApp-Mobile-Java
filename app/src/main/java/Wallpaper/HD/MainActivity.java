package Wallpaper.HD;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView gambar1,gambar2,gambar3,gambar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.wallpaper);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.wallpaper:
                        return true;
                    case R.id.album:
                        startActivity(new Intent(getApplicationContext()
                                ,Album.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext()
                                ,setting.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        gambar1 = findViewById(R.id.gambar1);
        gambar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TampilGambar1.class));
            }
        });
        gambar2 = findViewById(R.id.gambar2);
        gambar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, TampilGambar2.class));
            }
        });
        gambar3 = findViewById(R.id.gambar3);
        gambar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, TampilGambar3.class));
            }
        });
        gambar4 = findViewById(R.id.gambar4);
        gambar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, TampilGambar4.class));
            }
        });


    }
}