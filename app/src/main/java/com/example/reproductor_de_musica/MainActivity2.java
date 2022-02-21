package com.example.reproductor_de_musica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    // objetos que se enlaza con las vistas
    ImageView imageView;
    ImageButton btfoto;

    //para administrar la toma de la foto cuando se ejecuta la Intent
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Enlaces con las vistas
        btfoto = (ImageButton) findViewById(R.id.TomarFoto);
        imageView = (ImageView)findViewById(R.id.MostrarFoto);

        // Evento clic del botón
        btfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
    }

    private void abrirCamara(){
        Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intentCamara.resolveActivity(getPackageManager()) !=null){
            startActivityForResult(intentCamara, 1);
       // }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imgBitmap);
        }
    }
}