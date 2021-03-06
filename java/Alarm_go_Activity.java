package com.example.ipd;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Alarm_go_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_go);

        final TimePicker picker=(TimePicker) findViewById(R.id.timePicker);
        picker.setIs24HourView(true);

        final EditText editText=(EditText)findViewById(R.id.edittext);
        Button button=(Button)findViewById(R.id.button);
        final TextView textView1=(TextView)findViewById(R.id.textview1);
        final TextView textView2=(TextView)findViewById(R.id.textview2);

        Button back_btn = (Button) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View search_go_btn) {
                onBackPressed();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int hour, hour_24, minute;
                String am_pm;
                if (Build.VERSION.SDK_INT >= 23 ){
                    hour_24 = picker.getHour();
                    minute = picker.getMinute();
                }
                else{
                    hour_24 = picker.getCurrentHour();
                    minute = picker.getCurrentMinute();
                }
                if(hour_24 > 12) {
                    am_pm = "PM";
                    hour = hour_24 - 12;
                }
                else
                {
                    hour = hour_24;
                    am_pm="AM";
                }

                // ?????? ????????? ???????????? ?????? ?????? ??????
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, hour_24);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);

                // ?????? ?????? ????????? ??????????????? ????????? ?????? ???????????? ??????
                if (calendar.before(Calendar.getInstance())) {
                    calendar.add(Calendar.DATE, 1);
                }

                Date currentDateTime = calendar.getTime();
                String date_text = new SimpleDateFormat("MM??? dd??? E?????? a hh??? mm??? ", Locale.getDefault()).format(currentDateTime);
                Toast.makeText(getApplicationContext(),date_text + "?????? ????????? ?????????????????????!", Toast.LENGTH_SHORT).show();

                //?????? ?????? ??????
                textView1.setText(date_text);
                textView2.setText(editText.getText());

                //  Preference??? ????????? ??? ??????
                SharedPreferences.Editor editor = getSharedPreferences("daily alarm", MODE_PRIVATE).edit();
                editor.putLong("nextNotifyTime", (long)calendar.getTimeInMillis());
                editor.apply();


                diaryNotification(calendar);
            }

        });



        // ?????? ????????? ????????? ????????????
        // ????????? ????????? ?????? ????????????
        SharedPreferences sharedPreferences = getSharedPreferences("daily alarm", MODE_PRIVATE);
        long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());

        Calendar nextNotifyTime = new GregorianCalendar();
        nextNotifyTime.setTimeInMillis(millis);

        // ?????? ??????????????? TimePicker ?????????
        Date currentTime = nextNotifyTime.getTime();
        SimpleDateFormat HourFormat = new SimpleDateFormat("kk", Locale.getDefault());
        SimpleDateFormat MinuteFormat = new SimpleDateFormat("mm", Locale.getDefault());

        int pre_hour = Integer.parseInt(HourFormat.format(currentTime));
        int pre_minute = Integer.parseInt(MinuteFormat.format(currentTime));


        if (Build.VERSION.SDK_INT >= 23 ){
            picker.setHour(pre_hour);
            picker.setMinute(pre_minute);
        }
        else{
            picker.setCurrentHour(pre_hour);
            picker.setCurrentMinute(pre_minute);
        }
    }


    void diaryNotification(Calendar calendar)
    {
        Boolean dailyNotify = true; // ????????? ????????? ??????

        PackageManager pm = this.getPackageManager();
        ComponentName receiver = new ComponentName(this, DeviceBootReceiver.class);
        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);


        // ???????????? ?????? ????????? ???????????????
        if (dailyNotify) {


            if (alarmManager != null) {

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                }
            }

            // ?????? ??? ???????????? ????????? ?????????????????? ??????
            pm.setComponentEnabledSetting(receiver,
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
