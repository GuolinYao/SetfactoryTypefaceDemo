package com.gaodun.www.mytestapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Typeface typeFace;

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
                if(view!=null&& (view instanceof TextView)){
                    ((TextView) view).setTypeface(typeFace);
                }
                return view;
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
//        Intent intent = new Intent(this, BActivity.class);
//        startActivity(intent);
    }
}
