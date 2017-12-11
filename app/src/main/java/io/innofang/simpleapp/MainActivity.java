package io.innofang.simpleapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

/**
 * Author: Inno Fang
 * Time: 2017/12/9 10:48
 * Description:
 */


public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.counter_activity_button:
                startActivity(new Intent(this, CounterActivity.class));
                break;
            case R.id.login_activity_button:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.gallery_activity_button:
                startActivity(new Intent(this, GalleryActivity.class));
                break;
            case R.id.lucky_day_activity_button:
                startActivity(new Intent(this, LuckyDayActivty.class));
                break;
            case R.id.load_iamge_activity_button:
                startActivity(new Intent(this, LoadImageActivity.class));
                break;
            default:
                break;
        }
    }
}
