package Wallpaper.HD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class KlikGambar1_3 extends AppCompatActivity {
    WallpaperManager wallpaperManager;
    Bitmap bitmap1, bitmap2;
    DisplayMetrics displayMetrics;
    int width, height;
    BitmapDrawable bitmapDrawable;
    Button btn1, btn2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klik_gambar1_3);

        ImageView imageView2 = findViewById(R.id.imageView2);

        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        bitmapDrawable = (BitmapDrawable) imageView2.getDrawable();

        bitmap1 = bitmapDrawable.getBitmap();

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetScreenWidhtHeight();
                setBitmapSize();
                wallpaperManager = WallpaperManager.getInstance(KlikGambar1_3.this);
                Toast.makeText(KlikGambar1_3.this, "Wallpaper Selected", Toast.LENGTH_LONG).show();
                try{
                    wallpaperManager.setBitmap(bitmap2);
                    wallpaperManager.suggestDesiredDimensions(width,height);
                    Toast.makeText(KlikGambar1_3.this, "Wallpaper Selected", Toast.LENGTH_LONG).show();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        imageView = findViewById(R.id.imageView2);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable=imageView.getDrawable();
                Bitmap bitmap=((BitmapDrawable)drawable).getBitmap();

                try {
                    File file = new File(getApplicationContext().getExternalCacheDir(), File.separator +"Share_img1.jpg");
                    FileOutputStream fOut = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
                    fOut.flush();
                    fOut.close();
                    file.setReadable(true, false);
                    final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Uri photoURI = FileProvider.getUriForFile(getApplicationContext(), BuildConfig.APPLICATION_ID +".provider", file);

                    intent.putExtra(Intent.EXTRA_STREAM, photoURI);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setType("image/jpg");

                    startActivity(Intent.createChooser(intent, "Share image via"));
                } catch (Exception e) {
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