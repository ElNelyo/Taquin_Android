package com.example.cstern.projetpac;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LogRecord;

/**
 * Created by cstern on 11/12/17.
 */
public class GridViewAdapter extends BaseAdapter {

    private final Main2Activity mActivity;
    private final Bitmap mBitmap;
    private final int mImageWidth;
    private final int mImageHeight;
    private final int mColumn;
    private final int mSize;
    private ArrayList<Bitmap> mListBitmapFinal;
    private int mBlancPos=0;
    private Bitmap mBlackCase;
    private ArrayList<Bitmap> mListBitmapActuel;
    private int count = 0;
    private int automode =0;

    public GridViewAdapter(Bitmap bitmap, int gridViewWidht, int column, Main2Activity activity) {
        mActivity = activity;
        mBitmap = bitmap;
        mImageWidth = mBitmap.getWidth();
        mImageHeight = mBitmap.getHeight();
        mColumn = column;
        mSize = (((gridViewWidht - (1 * mColumn))) / mColumn);
        createList();
    }

    private void createList() {
        mListBitmapFinal = new ArrayList<>();
        int widht = mImageWidth / mColumn;
        int height = mImageHeight / mColumn;
        for (int i = 0; i < mColumn * mColumn; i++) {
            int x = i % mColumn;
            int y = i / mColumn;
            Bitmap bitmap = Bitmap.createBitmap(mBitmap, x * widht, y * height, widht, height, null, false);
            mListBitmapFinal.add(bitmap);
        }
        mListBitmapFinal.set(mBlancPos,Bitmap.createBitmap(widht,height, Bitmap.Config.ARGB_8888));
        mBlackCase = Bitmap.createBitmap(widht,height,Bitmap.Config.ARGB_8888);
        mListBitmapActuel = new ArrayList<>();
        mListBitmapActuel.addAll(mListBitmapFinal);
        melangerJeu();
    }

    private void melangerJeu() {

        for(int i = 0;i<1000;i++){

//        for(int i = 0;i<1000;i++){
            Random r = new Random();
            int min = 0;
            int max = (mColumn * mColumn) -1;
            int rand = r.nextInt(max - min+1) + min;

            bougerCase(rand,false);
        }
//           ArrayList<Integer> ListeABouger = new ArrayList<Integer>();
//           for (int i =0;i<mColumn;i++){
//               ListeABouger.add(i);
//           }
//        for (Integer a: ListeABouger
//             ) {
//
//
//        }
//           Bitmap mTempoBitmapActuel =  mListBitmapActuel.get(5);
//           mListBitmapActuel.set(1,mTempoBitmapActuel);
//           mListBitmapActuel.set(5,mListBitmapActuel.get(1));

    }
    private void bougerCase(int position,boolean manual){

        if(
                (position+mColumn != mBlancPos &&
                position-mColumn != mBlancPos&&
                position-1 != mBlancPos&&
                position+1 != mBlancPos ) || mBlancPos%mColumn == mColumn -1 && position%mColumn==0 ||
                        mBlancPos%mColumn == 0 && mBlancPos == position+1){

            System.out.println("Attention : Mouvement interdit");
            //Toast.makeText(mActivity, "Attention : Mouvement interdit", Toast.LENGTH_SHORT).show();




        }else{
            if(manual){mActivity.majCounter();}
            System.out.println("Position : "+position);
            System.out.println("mColumn: " + mColumn);
  //          System.out.println("position%mColumn: " + position%mColumn);
//            System.out.println("mColumn%position: " + mColumn%position);

            mBlackCase = Bitmap.createBitmap(mImageWidth/mColumn,mImageHeight/mColumn,Bitmap.Config.ARGB_8888);
            Bitmap mTempoBitmapActuel =  mListBitmapActuel.get(position);
           // System.out.println("Positon blanc trouvé en "+mBlancPos);
            mListBitmapActuel.set(mBlancPos,mTempoBitmapActuel);
            mListBitmapActuel.set(position,mBlackCase);
            //System.out.println("Echange entre l'image "+position+" et blanc");
            mBlancPos = position;
            //System.out.println("Position blanc en "+position);
            notifyDataSetChanged();
            count +=1;

        }





    }

    @Override
    public int getCount() {
        return mColumn*mColumn;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        int widht = mImageWidth / mColumn;
        int height = mImageHeight / mColumn;
        if (convertView == null) {
            imageView = new ImageView(mActivity);
            imageView.setLayoutParams(new GridView.LayoutParams(mSize, mSize));
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(mListBitmapActuel.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                bougerCase(position,true);
                automodeCounter(position);
                if(verifierVictoire()){
                    Toast.makeText(mActivity, "Vous avez gagné en :  "+count +"coups ! ", Toast.LENGTH_LONG).show();




                }
            }


        });

        return imageView;


    }
    private void automodeCounter(int position){
        if(position==0){

            automode+=1;
        }else{
            automode = 1;
        }

        if(automode==10){

            autoMode();
        }
    }


    private void autoMode() {


        while (!verifierVictoire()) {


//                            Random r = new Random();
//                            int min = 0;
//                            int max = (mColumn * mColumn) - 1;
//                            int rand = r.nextInt(max - min + 1) + min;
//                            notifyDataSetChanged();
//                            bougerCase(rand, false);

                        mListBitmapActuel =mListBitmapFinal;
                        notifyDataSetChanged();
                        }



    }
    private boolean verifierVictoire() {
        boolean bool  = false;
        int count = 0;
      for(int i=0;i< mListBitmapFinal.size();i++){
          if (i!= 0){
              if (mListBitmapActuel.get(i) == mListBitmapFinal.get(i)){
                  count +=1;
              }
          }
      }

        if(count== mColumn*mColumn-1){
            bool = true;
        }
        return bool;
    }




}
