package Wallpaper.HD;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Preference extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
        Load_setting();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.settings);

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
    private void Load_setting(){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        boolean chk_night = sp.getBoolean("NIGHT",false);
        if(chk_night){
            getListView().setBackgroundColor(Color.parseColor("222222"));
        }else{
            getListView().setBackgroundColor(Color.parseColor("ffffff"));
        }

        CheckBoxPreference chk_night_instant = (CheckBoxPreference)findPreference("NIGHT");
        chk_night_instant.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference prefs, Object obj) {

                boolean yes = (boolean)obj;
                if(yes){
                    getListView().setBackgroundColor(Color.parseColor("222222"));
                }else{
                    getListView().setBackgroundColor(Color.parseColor("ffffff"));
                }
                return true;

            }
        });
        ListPreference LP = (ListPreference)findPreference("ORIENTATION");
        String orien = sp.getString("ORIENTATION","false");
        if("1".equals(orien)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
            LP.setSummary(LP.getEntry());
        }else if ("2".equals(orien)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            LP.setSummary(LP.getEntry());
        }else if("3".equals(orien)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            LP.setSummary(LP.getEntry());
        }

        LP.setOnPreferenceChangeListener(new android.preference.Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(android.preference.Preference prefs, Object obj) {
                String items = (String)obj;
                if(prefs.getKey().equals("ORIENTATION")){
                   switch (items){
                       case "1":
                           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);
                           break;
                       case "2":
                           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                       case "3":
                           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                           break;
                   }
                }

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        Load_setting();
        super.onResume();
    }
}
