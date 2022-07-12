package Wallpaper.HD;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class KlikGambar3_4 extends AppCompatActivity {
    WallpaperManager wallpaperManager;
    Bitmap bitmap1, bitmap2;
    DisplayMetrics displayMetrics;
    int width, height;
    BitmapDrawable bitmapDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klik_gambar3_4);

        ImageView imageView2 = findViewById(R.id.imageView2);

        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        bitmapDrawable = (BitmapDrawable) imageView2.getDrawable();

        bitmap1 = bitmapDrawable.getBitmap();

        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetScreenWidhtHeight();
                setBitmapSize();
                wallpaperManager = WallpaperManager.getInstance(KlikGambar3_4.this);
                try{
                    wallpaperManager.setBitmap(bitmap2);
                    wallpaperManager.suggestDesiredDimensions(width,height);
                    Toast.makeText(KlikGambar3_4.this, "Wallpaper Selected", Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
    private void setBitmapSize() {
        bitmap2 = Bitmap.createScaledBitmap(bitmap1, width,height, false);
    }
    private void GetScreenWidhtHeight() {
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }
}