package kr.hs.emirim.s2019s05.mirimgallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class GalleryAdapter extends BaseAdapter {

    int[] imgRes = {R.drawable.poster1,R.drawable.poster2,R.drawable.poster3,R.drawable.poster4,R.drawable.poster5,R.drawable.poster6,R.drawable.poster7
            ,R.drawable.poster8,R.drawable.poster9,R.drawable.poster10,R.drawable.poster11,R.drawable.poster12,R.drawable.poster13,R.drawable.poster14,R.drawable.poster15,
            R.drawable.poster16};

    String[] imgName = {"삼진그룹영어토익반","소리도 없이","담보","아이랜드","코랠라인","기생충","시동"
            ,"인터스텔라","검은 사제들","사자","늑대소년","너의이름은","컨져링","애나벨","해리포터 마법의돌",
            "해리포터 비밀의방"};


    Context context;
    ImageView imgvMain;



    public GalleryAdapter(Context context,ImageView imgvMain){
        this.context = context;
        this.imgvMain = imgvMain;
    }

    @Override
    public int getCount() {
        return imgRes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageView imgV = new ImageView(context);
        imgV.setLayoutParams(new Gallery.LayoutParams(200,300));
        imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imgV.setPadding(5,5,5,5 );
        imgV.setImageResource(imgRes[position]);

        final  View toastView = View.inflate(context,R.layout.layout,null);
        final TextView textTitle = toastView.findViewById(R.id.text_title);

        final  int pos = position;
        imgV.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               imgvMain.setScaleType(ImageView.ScaleType.FIT_CENTER);
               imgvMain.setImageResource(imgRes[pos]);

                Toast toast = new Toast(context);
                textTitle.setText(imgName[pos]);
                toast.setView(toastView);
                toast.show();


                return false;
            }
        });


        return imgV;
    }
}
