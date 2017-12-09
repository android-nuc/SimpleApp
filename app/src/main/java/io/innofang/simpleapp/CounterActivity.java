package io.innofang.simpleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends AppCompatActivity {

    private TextView mNumberTextView;
    private Button mAddButton;
    private Button mSubButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        mNumberTextView = findViewById(R.id.number_text_view);
        mAddButton = findViewById(R.id.add_button);
        mSubButton = findViewById(R.id.sub_button);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = mNumberTextView.getText().toString();
                mNumberTextView.setText((Integer.valueOf(num) + 1) + "");
            }
        });

        mSubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = mNumberTextView.getText().toString();
                mNumberTextView.setText((Integer.valueOf(num) - 1) + "");
            }
        });
    }
}
