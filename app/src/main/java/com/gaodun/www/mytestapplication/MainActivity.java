package com.gaodun.www.mytestapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_main)
    TextView tvMain;
    @BindView(R.id.iv_icon)
    ImageView ivIcon;
    private Typeface typeFace;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (typeFace == null) {
            typeFace = Typeface.createFromAsset(getAssets(), "lovely.ttf");
        }
        LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                AppCompatDelegate delegate = getDelegate();
                View view = delegate.createView(parent, name, context, attrs);
                if (view != null && (view instanceof TextView)) {
                    ((TextView) view).setTypeface(typeFace);
                }
                return view;
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_icon:
                intent = new Intent(this, BActivity.class);
                break;
            case R.id.tv_main:
                 intent = new Intent(this, Main2Activity.class);
                break;
        }

        startActivity(intent);
    }
}
