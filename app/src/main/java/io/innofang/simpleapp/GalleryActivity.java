package io.innofang.simpleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Author: Inno Fang
 * Time: 2017/12/9 09:43
 * Description:
 */


public class GalleryActivity extends AppCompatActivity {

    private ImageView mGalleryImageView;
    private Button mPreviousButton;
    private Button mNextButton;
    private TextView mIndexTextView;

    private int[] mImageRes = new int[]{
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8
    };

    private int mIndex = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        mGalleryImageView = findViewById(R.id.gallery_image_view);
        mPreviousButton = findViewById(R.id.previous_button);
        mNextButton = findViewById(R.id.next_button);
        mIndexTextView = findViewById(R.id.index_text_view);

        updateImage();

        mPreviousButton.setOnClickListener(mClickListener);
        mNextButton.setOnClickListener(mClickListener);
    }

    private void updateImage() {
        mGalleryImageView.setImageResource(mImageRes[mIndex]);
        mIndexTextView.setText(String.format("%d/%d", mIndex + 1, mImageRes.length));
    }


    private View.OnClickListener mClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.previous_button:
                    if (mIndex == 0) {
                        mIndex = mImageRes.length - 1;
                    } else {
                        mIndex--;
                    }
                    updateImage();
                    break;
                case R.id.next_button:
                    if (mIndex == mImageRes.length - 1) {
                        mIndex = 0;
                    } else {
                        mIndex++;
                    }
                    updateImage();
                default:
                    break;
            }
        }
    };
}
