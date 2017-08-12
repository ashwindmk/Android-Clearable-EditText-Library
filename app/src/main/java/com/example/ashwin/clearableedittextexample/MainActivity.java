package com.example.ashwin.clearableedittextexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ashwin.clearableedittext.ClearableEditText;

public class MainActivity extends AppCompatActivity {

    private String mFirstName = "", mLastName = "";

    private ClearableEditText mFirstNameClearableEditText, mLastNameClearableEditText;
    private Button mSaveButton;
    private TextView mFirstNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mFirstNameClearableEditText = (ClearableEditText) findViewById(R.id.firstname_clearableedittext);
        mLastNameClearableEditText = (ClearableEditText) findViewById(R.id.lastname_clearableedittext);

        mSaveButton = (Button) findViewById(R.id.save_button);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirstName = mFirstNameClearableEditText.getText();
                mLastName = mLastNameClearableEditText.getText();
                mFirstNameTextView.setText("Hello " + mFirstName + " " + mLastName);
            }
        });

        mFirstNameTextView = (TextView) findViewById(R.id.firstname_textview);
    }
}
