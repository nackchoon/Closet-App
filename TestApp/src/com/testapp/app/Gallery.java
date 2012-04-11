package com.testapp.app;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
public class Gallery extends Activity {
	
	
	   
   DataManipulator dm;
   
   List<byte[]> list = new ArrayList<byte[]>();
   
   
   List<Hashtable> dataHashTable = new ArrayList<Hashtable>();
   List<Hashtable> hashtable = null;
   
	   
   @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        GridView g = (GridView) findViewById(R.id.myGrid);
        g.setAdapter(new ImageAdapter(this));
        g.setOnItemClickListener(new OnItemClickListener() {
           public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
              Toast.makeText(Gallery.this, "" + position, Toast.LENGTH_SHORT).show();
           }
        });

        dm = new DataManipulator(this);
        hashtable = dm.selectHashtable();
        
        for(Hashtable table : hashtable){
        	byte[] bytes = (byte[]) table.get("Picture");

        }
   }
   public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
                mContext = c;
        }
        public int getCount() {
                return mThumbIds.length;
        }
        public Object getItem(int position) {
                return position;
        }
        public long getItemId(int position) {
                return position;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if (convertView == null) {
                   imageView = new ImageView(mContext);
                   imageView.setLayoutParams(new GridView.LayoutParams(90, 90));
                   imageView.setAdjustViewBounds(false);
                   imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                   imageView.setPadding(0, 0, 0, 0);
                } else {
                   imageView = (ImageView) convertView;
                }
                imageView.setImageResource(mThumbIds[position]);
//                InputStream is = new ByteArrayInputStream(list.get(position));
//                Bitmap bmp = BitmapFactory.decodeStream(is);
//                imageView.setImageBitmap(bmp);
                return imageView;
        }
        private Context mContext;
        private Integer[] mThumbIds = {
                R.drawable.buttondown, R.drawable.dress,
                R.drawable.pants, R.drawable.shorts,
                R.drawable.tshirt, R.drawable.sweatpants,
                R.drawable.sweatshirt, R.drawable.jacket,
                R.drawable.jeans, R.drawable.khakis,
                R.drawable.sundress,
        };
    }
}