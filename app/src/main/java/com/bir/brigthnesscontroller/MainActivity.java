package com.bir.brigthnesscontroller;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends AppCompatActivity {
   private SeekBar seekBar;
   private ContentResolver contentResolver;
   private Window window;
   private int brightness;
   Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         seekBar=findViewById(R.id.skbar);
         contentResolver=getContentResolver();

         seekBar.setMax(255);
         seekBar.setKeyProgressIncrement(1);
         brightness = Settings.System.getInt(this.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS,0);

   seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
       @Override
       public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

       Settings.System.putInt(contentResolver,Settings.System.SCREEN_BRIGHTNESS,progress);

       }

       @Override
       public void onStartTrackingTouch(SeekBar seekBar) {

       }

       @Override
       public void onStopTrackingTouch(SeekBar seekBar) {

       }
   });

    }



}
