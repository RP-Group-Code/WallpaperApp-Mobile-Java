package Wallpaper.HD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TampilGambar2 extends AppCompatActivity {
    ImageView img1,img2,img3,img4,img5,img6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_gambar2);

        img1 = findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( TampilGambar2.this, KlikGambar2.class));
            }
        });
        img2 = findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( TampilGambar2.this, KlikGambar2_1.class));
            }
        });
        img3 = findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( TampilGambar2.this, KlikGambar2_2.class));
            }
        });
        img4 = findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( TampilGambar2.this, KlikGambar2_3.class));
            }
        });
        img5 = findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( TampilGambar2.this, KlikGambar2_4.class));
            }
        });
        img6 = findViewById(R.id.img6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( TampilGambar2.this, KlikGambar2_5.class));
            }
        });
    }
}