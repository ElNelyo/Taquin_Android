package com.example.cstern.projetpac;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by cstern on 11/12/17.
 */
public class GridViewAdapter extends BaseAdapter {

    private final Activity mActivity;
    private final Bitmap mBitmap;
    private final int mImageWidth;
    private final int mImageHeight;
    private final int mColumn;
    private final int mSize;
    private ArrayList<Bitmap> mListBitmapFinal;
    private int mBlancPos=0;
    private Bitmap mBlackCase;
    private ArrayList<Bitmap> mListBitmapActuel;

    public GridViewAdapter(Bitmap bitmap, int gridViewWidht, int column, Activity activity) {
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
        //ArrayList<Integer> mListBitmapActuel;
        //Bitmap mTempoBitmapActuel =  mListBitmapActuel.get(5);
        //System.out.println(mListBitmapActuel.get(1));
        // mListBitmapActuel.set(1,mListBitmapActuel.get(5));
        //mListBitmapActuel.set(5,mListBitmapActuel.get(1));

    }
    private void bougerCase(int position){

        if(
                position+mColumn != mBlancPos &&
                position-mColumn != mBlancPos&&
                position-1 != mBlancPos&&
                position+1 != mBlancPos) {

            System.out.println("Attention : Mouvement interdit");
            Toast.makeText(mActivity, "Attention : Mouvement interdit", Toast.LENGTH_SHORT).show();




        }else{

            System.out.println("Position : "+position);
            System.out.println("mColumn: " + mColumn);
            System.out.println("mColumn%position : " + position%mColumn);
            System.out.println("mBlanc: " + mBlancPos);

            if (mBlancPos%mColumn == 0){
                Toast.makeText(mActivity, "TOUJOURS PAS", Toast.LENGTH_SHORT).show();
            }
            if (mBlancPos%position == mColumn-1 ){
                Toast.makeText(mActivity, "NON", Toast.LENGTH_SHORT).show();
            }
                mBlackCase = Bitmap.createBitmap(mImageWidth/mColumn,mImageHeight/mColumn,Bitmap.Config.ARGB_8888);
                Bitmap mTempoBitmapActuel =  mListBitmapActuel.get(position);
               // System.out.println("Positon blanc trouvé en "+mBlancPos);
                mListBitmapActuel.set(mBlancPos,mTempoBitmapActuel);
                mListBitmapActuel.set(position,mBlackCase);
                //System.out.println("Echange entre l'image "+position+" et blanc");
                mBlancPos = position;
                //System.out.println("Position blanc en "+position);
                notifyDataSetChanged();
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

                bougerCase(position);
//                verifierVictoire();
            }
        });

        return imageView;


    }


}
