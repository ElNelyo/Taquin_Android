package com.example.cstern.projetpac;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static java.lang.System.out;

public class MainActivity extends Activity {
    private ImageView mImageView_1;
    private ImageView mImageView_2;
    private ImageView mImageView_3;
    private ImageView mImageView_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView_1 = (ImageView) findViewById(R.id.imageview_1);
        mImageView_1.setImageResource(R.drawable.image1);
        mImageView_2 = (ImageView) findViewById(R.id.imageview_2);
        mImageView_2.setImageResource(R.drawable.image2);
        mImageView_3 = (ImageView) findViewById(R.id.imageview_3);
        mImageView_3.setImageResource(R.drawable.image3);
        mImageView_4 = (ImageView) findViewById(R.id.imageview_4);
        mImageView_4.setImageResource(R.drawable.image4);

        mImageView_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent (MainActivity.this, Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",R.drawable.image1);
                activity.putExtras(bundle);
                startActivity(activity);
                finish();



            }
        });
        mImageView_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent (MainActivity.this, Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",R.drawable.image2);
                activity.putExtras(bundle);
                startActivity(activity);
                finish();

            }
        });
        mImageView_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent (MainActivity.this, Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",R.drawable.image3);
                activity.putExtras(bundle);
                startActivity(activity);
                finish();

            }
        });
        mImageView_4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity = new Intent (MainActivity.this, Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",R.drawable.image4);
                activity.putExtras(bundle);
                startActivity(activity);
                finish();
            }
        });

//        final Button buttonplay= findViewById(R.id.btnPlay);
//        buttonplay.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent activity = new Intent (MainActivity.this, Main2Activity.class);
//                startActivity(activity);
//
//            }
//        });



    }

}
