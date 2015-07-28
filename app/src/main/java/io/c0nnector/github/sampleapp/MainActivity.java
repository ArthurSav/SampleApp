package io.c0nnector.github.sampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity{

    RelativeLayout wrapper;

    ImageView imgHaptic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupLayouts();
    }

    private void setupLayouts(){

        wrapper = (RelativeLayout) findViewById(R.id.wrapper);
        wrapper.setOnClickListener(wrapperListener);

        imgHaptic = (ImageView) findViewById(R.id.imgHaptic);
        imgHaptic.setOnClickListener(wrapperListener);
    }


    /*****************************************************
     * ---------------- * Listener * --------------------
     *
     *
     *
     ****************************************************/

    View.OnClickListener wrapperListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

        }
    };
}
