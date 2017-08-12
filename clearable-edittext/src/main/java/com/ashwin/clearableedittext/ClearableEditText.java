package com.ashwin.clearableedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by ashwin on 6/7/17.
 */

public class ClearableEditText extends FrameLayout {

    private Context mContext;
    private View mView;
    private TextInputLayout mTextInputLayout;
    private AutoCompleteTextView mAutoCompleteTextView;
    private Button mClearButton;
    private String mHintText;
    private int mInputType, mImeOption, mMaxLines = 1;
    private boolean mWhiteClearButton = false;

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        mView = inflater.inflate(R.layout.clearable_edit_text, this);

        mContext = context;

        initViews();

        // retrieved values correspond to the positions of the attributes
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ClearableEditText);
        int count = typedArray.getIndexCount();
        try {
            for (int i = 0; i < count; ++i) {
                int attr = typedArray.getIndex(i);
                if (attr == R.styleable.ClearableEditText_hintText) {
                    mHintText = typedArray.getString(attr);
                    setHintText(mHintText);
                } else if (attr == R.styleable.ClearableEditText_android_inputType) {
                    mInputType = typedArray.getInt(attr, EditorInfo.TYPE_TEXT_VARIATION_NORMAL);
                    setInputType(mInputType);
                } else if (attr == R.styleable.ClearableEditText_android_imeOptions) {
                    mImeOption = typedArray.getInt(attr, 0);
                    setImeOption(mImeOption);
                } else if (attr == R.styleable.ClearableEditText_android_maxLines) {
                    mMaxLines = typedArray.getInt(attr, 1);
                    setMaxLines(mMaxLines);
                } else if (attr == R.styleable.ClearableEditText_whiteClearButton) {
                    mWhiteClearButton = typedArray.getBoolean(attr, false);
                }
            }

            setClearButtonEnabled(mWhiteClearButton);
        }

        // the recycle() will be executed obligatorily
        finally {
            // for reuse
            typedArray.recycle();
        }
    }

    private void initViews() {
        mTextInputLayout = (TextInputLayout) mView.findViewById(R.id.textinputlayout);

        mClearButton = (Button) mView.findViewById(R.id.clear_button);
        mClearButton.setVisibility(GONE);

        mAutoCompleteTextView = (AutoCompleteTextView) mView.findViewById(R.id.autocompletetextview);
    }

    public void setHintText(String hintText) {
        mTextInputLayout.setHint(hintText);
    }

    public void setInputType(int inputType) {
        mAutoCompleteTextView.setInputType(inputType);
    }

    public void setImeOption(int imeOption) {
        mAutoCompleteTextView.setImeOptions(imeOption);
    }

    public void setMaxLines(int maxLines) {
        mAutoCompleteTextView.setMaxLines(maxLines);
    }

    public void setClearButtonEnabled(boolean whiteClearButton) {
        mClearButton.setVisibility(GONE);

        if (whiteClearButton) {
            mClearButton.setBackgroundResource(R.drawable.ic_close_white_24dp);
        }

        mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // Do nothiing
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() > 0) {
                        mClearButton.setVisibility(VISIBLE);
                    } else {
                        mClearButton.setVisibility(GONE);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                    // Do nothing
                }
        });

        mClearButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAutoCompleteTextView.setText("");
                }
        });
    }

    public void setText(String text) {
        mAutoCompleteTextView.setText(text);
    }

    public String getText() {
        return mAutoCompleteTextView.getText().toString();
    }

}
