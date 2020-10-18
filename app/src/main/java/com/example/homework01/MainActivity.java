package com.example.homework01;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private SeekBar seekBar;
    private Button b1;
    private Button b2;
    private LinearLayout rl;
    private TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //实现图片透明度调节
        imageView = findViewById(R.id.image1);
        seekBar = findViewById(R.id.seekBar1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageView.setAlpha(1 - progress / 100.0f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //实现深夜模式
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        rl = findViewById(R.id.back);
        t = findViewById(R.id.textView2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (t.getText().equals("日间模式")) {
                    rl.setBackgroundColor(Color.parseColor("#696969"));
                    t.setText("夜间模式");
                    t.setTextColor(Color.parseColor("#FFFFFF"));
                    b1.setBackgroundColor(Color.parseColor("#000000"));
                    b2.setBackgroundColor(Color.parseColor("#000000"));
                    b1.setTextColor(Color.WHITE);
                    b2.setTextColor(Color.WHITE);
                } else if (t.getText().equals("夜间模式")) {
                    rl.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    t.setText("日间模式");
                    t.setTextColor(Color.parseColor("#000000"));
                    b1.setBackgroundColor(Color.parseColor("#AAAAAA"));
                    b2.setBackgroundColor(Color.parseColor("#AAAAAA"));
                    b1.setTextColor(Color.BLACK);
                    b2.setTextColor(Color.BLACK);
                }

            }

        });

        //实现图片保存
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();
            }
        });


    }

    private void showNormalDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("提示").setMessage("是否确定保存该图片？");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                MainActivity.this.finish ();
            }
        });
        dialog.setNegativeButton("取消", null);
        dialog.show();
    }

}
