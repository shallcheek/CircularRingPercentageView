package com.shallcheek.circularringpercentageview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.shall.myapplication.R;

/**
 * Created by Shall on 2015.12.15.
 */
public class MainActivity extends AppCompatActivity {
    CircularRingPercentageView progressCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        progressCircle = (CircularRingPercentageView) findViewById(R.id.progress);

        SeekBar progressBar = (SeekBar) findViewById(R.id.progressBar2);
        SeekBar progressBar5 = (SeekBar) findViewById(R.id.progressBar5);
        SeekBar progressBar3 = (SeekBar) findViewById(R.id.progressBar3);
        SeekBar progressBar4 = (SeekBar) findViewById(R.id.progressBar4);
        progressBar4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressCircle.setMaxColorNumber(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        progressBar3.setMax(getWindowManager().getDefaultDisplay().getWidth());
        progressBar5.setMax(progressCircle.getCircleWidth() / 2);

        progressBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) progressCircle.getLayoutParams();
                layoutParams.width = progress;
                layoutParams.height = progress;
                progressCircle.setLayoutParams(layoutParams);
                progressCircle.setCircleWidth(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        progressBar5.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressCircle.setRoundWidth(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        CheckBox checkBox = (CheckBox) findViewById(R.id.line_scale_check);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                progressCircle.setLine(isChecked);
            }
        });
        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressCircle.setProgress(progress, new CircularRingPercentageView.OnProgressScore() {
                    @Override
                    public void setProgressScore(float score) {
                        Log.e("12", score + "");
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        progressCircle.setProgress(100, new CircularRingPercentageView.OnProgressScore() {
            @Override
            public void setProgressScore(float score) {
                Log.e("12", score + "");
            }
        });
    }


}
