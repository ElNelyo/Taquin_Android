package com.example.cstern.projetpac;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.zip.GZIPInputStream;


public class Main2Activity extends Activity {

    private Bitmap mBitmap;
    private Bitmap bitmap;
    private ArrayList<Bitmap> maListeImage = new ArrayList<Bitmap>();
    private GridViewAdapter gridViewAdapter;
    private int nbColumn = 3;
    private GridView myGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        // A DECOMMENTER ICI

        //On traduit l'image en BitMap
        //mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);

        //On créer un adaptateur pour mettre l'image dans la gridview
        //gridViewAdapter = new GridViewAdapter(mBitmap, (int) (this.getWindowManager().getDefaultDisplay().getWidth() - (getResources().getDimension(R.dimen.activity_horizontal_margin)*2)),nbColumn,this);

        //myGridView = (GridView) findViewById(R.id.gridviewImage);

        //On met en variable le nombre de colonne et de ligne
        //myGridView.setNumColumns(nbColumn);
        //myGridView.setAdapter(gridViewAdapter);


        final Button button3x3 = findViewById(R.id.btn3);
        button3x3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nbColumn =3;
                System.out.println("Choix de la partie : 3x3");
                StartGame(nbColumn);
//
//                int mainwidth=mImageView.getWidth();
//                int mainheight = mImageView.getHeight();
//                int nbColumn = 4;
//                int childwidht = mainwidth /nbColumn;
//                int childheight = mainheight /nbColumn;
//
//                mBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.image1);
//
//                for(int i=0; i<nbColumn * nbColumn ;i++){
//                    int x = i % nbColumn;
//                    int y= i / nbColumn;
//
//                    bitmap =  Bitmap.createBitmap(mBitmap, x * childwidht, y * childheight, mainwidth, mainheight, null, false);
//                    maListeImage.add(bitmap);
//
//                }
//
//
//                ImageView tv1;
//                tv1= (ImageView) findViewById(R.id.imageviewtest);
//
//                for(int i =0;i < maListeImage.size();i++){
//
//                    tv1.setImageBitmap(maListeImage.get(6));
//                }
//                ImageView displayImage  = new ImageView(getApplicationContext());
//                displayImage.setImageBitmap(maListeImage.get(1));Context context = getApplicationContext();

//
//                RelativeLayout rl = (RelativeLayout) findViewById(R.id.rlimage);
//
//                rl.addView(displayImage);
            }
        });

        final Button button4x4 = findViewById(R.id.btn4x4);
        button4x4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nbColumn = 4;
                System.out.println("Choix de la partie : 4x4");
                StartGame(nbColumn);

            }
        });

        final Button button5x5 = findViewById(R.id.btn5);
        button5x5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nbColumn = 5;
                System.out.println("5x5");
                StartGame(nbColumn);
            }
        });



    }
    public void StartGame(int nb){


        //On traduit l'image en BitMap
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);

        //On créer un adaptateur pour mettre l'image dans la gridview
        gridViewAdapter = new GridViewAdapter(mBitmap, (int) (this.getWindowManager().getDefaultDisplay().getWidth() - (getResources().getDimension(R.dimen.activity_horizontal_margin)*2)),nbColumn,this);

        myGridView = (GridView) findViewById(R.id.gridviewImage);

        //On met en variable le nombre de colonne et de ligne
        myGridView.setNumColumns(nbColumn);
        myGridView.setAdapter(gridViewAdapter);
    }
}
