package io.innofang.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

/**
 * Author: Inno Fang
 * Time: 2017/12/9 10:26
 * Description:
 */


public class TestLuckyActivity extends AppCompatActivity {

    public static final String EXTRA_LUCKY = "lucky";

    private TextView mTipsTextView;
    private TextView mLuckyTextView;
    private int mLucky;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lucky);

        mTipsTextView = findViewById(R.id.tips_text_view);
        mLuckyTextView = findViewById(R.id.lucky_text_view);


        mTipsTextView.setText("今日运势");

        Random random = new Random();
        mLucky = random.nextInt(101) + 100;
        mLuckyTextView.setText(mLucky + "");
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent();
        intent.putExtra("lucky", mLucky);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
