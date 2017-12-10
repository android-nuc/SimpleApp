package io.innofang.simpleapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * Author: Inno Fang
 * Time: 2017/12/10 11:01
 * Description:
 */


public class LoadImageActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512875682&di=c59614d21a656b11ee3a5bee508321b2&src=http://img3.duitang.com/uploads/item/201508/18/20150818180747_xBte2.png";

    private String[] IMAGE_URLS = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512886917197&di=c9ff87c960dfbe0a8ce236c474ce9931&imgtype=0&src=http%3A%2F%2Fwanzao2.b0.upaiyun.com%2Fsystem%2Fpictures%2F38652968%2Foriginal%2F1474366880_640x779.png",
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1512875682&di=c59614d21a656b11ee3a5bee508321b2&src=http://img3.duitang.com/uploads/item/201508/18/20150818180747_xBte2.png",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1512886989626&di=2c7bd78fbdc4299cdb59d61003492fe2&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D42827810%2C1262558606%26fm%3D214%26gp%3D0.jpg",

    };

    private ImageView mOnlineImageView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        mOnlineImageView = findViewById(R.id.online_image_view);
        mProgressBar = findViewById(R.id.progress_bar);

        loadOnlineImage();

    }

    private void loadOnlineImage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream is = null;
                BufferedInputStream bis = null;

                try {
                    URL url = new URL(IMAGE_URLS[new Random().nextInt(3)]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5000);
                    connection.connect();
                    is = connection.getInputStream();
                    bis = new BufferedInputStream(is);
                    final Bitmap bitmap = BitmapFactory.decodeStream(bis);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mOnlineImageView.setImageBitmap(bitmap);
                            mProgressBar.setVisibility(View.GONE);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(LoadImageActivity.this, "Failed to load online image.", Toast.LENGTH_SHORT).show();
                } finally {

                    try {
                        if (is != null) {
                            is.close();
                        }
                        if (bis != null) {
                            bis.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}
