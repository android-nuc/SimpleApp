package io.innofang.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Author: Inno Fang
 * Time: 2017/12/9 10:15
 * Description:
 */


public class LuckyDayActivty extends AppCompatActivity {

    private Button mTestLuckyButton;
    private TextView mTipsTextView;
    private TextView mLuckyTextView;

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky_day);

        mTestLuckyButton = findViewById(R.id.test_lucky_button);
        mTipsTextView = findViewById(R.id.tips_text_view);
        mLuckyTextView = findViewById(R.id.lucky_text_view);

        mTipsTextView.setText("还没今日运势，赶紧测一测~");

        mTestLuckyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LuckyDayActivty.this, TestLuckyActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK)
            return;

        switch (requestCode) {
            case REQUEST_CODE:
                int lucky = data.getIntExtra(TestLuckyActivity.EXTRA_LUCKY, 100);
                mLuckyTextView.setText(lucky + "");
                mTipsTextView.setText("今日运势");
                break;
            default:
                break;
        }
    }
}
