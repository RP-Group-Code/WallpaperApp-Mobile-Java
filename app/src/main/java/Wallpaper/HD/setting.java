package Wallpaper.HD;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class setting extends AppCompatActivity {

    public static final String KEY_ISNIGHTMODE = "isNightMode";
    public static final String MyPREFERENCE = "nightModePrefs";
    SharedPreferences sharedPreferences;
    Switch dark;
    LinearLayout ln2,ln3;
    TextView tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ln3 = findViewById(R.id.ln3);
        ln2 = findViewById(R.id.ln2);
        dark = findViewById(R.id.switch1);
        tv3 = findViewById(R.id.tv3);


        sharedPreferences = getSharedPreferences(MyPREFERENCE, Context.MODE_PRIVATE);
        checkNightModeActivated();
        dark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    saveNightModeState(true);
                    Toast.makeText(setting.this, "Night Mode", Toast.LENGTH_LONG).show();
                    recreate();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Toast.makeText(setting.this, "Light Mode", Toast.LENGTH_LONG).show();
                    saveNightModeState(false);
                    recreate();
                }
            }
        });

        ln3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(setting.this, "Versi Sudah Terbaru", Toast.LENGTH_LONG).show();

            }
        });
        ln2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(setting.this, "Data & Sync Berhasil", Toast.LENGTH_LONG).show();

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.album);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.wallpaper:
                        startActivity(new Intent(getApplicationContext()
                                ,MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.album:
                        startActivity(new Intent(getApplicationContext()
                                ,Album.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        return true;
                }
                return false;
            }
        });

    }

    private void saveNightModeState(boolean nightMode) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean(KEY_ISNIGHTMODE, nightMode);

        editor.apply();
    }

    public void checkNightModeActivated() {
        if (sharedPreferences.getBoolean(KEY_ISNIGHTMODE, false)) {
            dark.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            dark.setChecked(false);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}