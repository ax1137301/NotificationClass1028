package com.example.notificationclass1028;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {
    String idLove = "L";
    String idClass = "C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //通知一設定
        NotificationChannel channelLove = new NotificationChannel(
                idLove,
                "Channel Love",
                NotificationManager.IMPORTANCE_HIGH);
        channelLove.setDescription("情人節快到了");
        channelLove.enableLights(true);
        channelLove.enableVibration(true);
        //通知二設定
        NotificationChannel channelCourse = new NotificationChannel(
                idClass,
                "ChannelClass",
                NotificationManager.IMPORTANCE_LOW);
        channelCourse.setDescription("課程通知");
        channelCourse.enableLights(true);
        channelCourse.enableVibration(true);
        //依設定建立通知
        notificationManager.createNotificationChannel(channelLove);
        //第一個訊息
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, idLove)
                .setSmallIcon(R.mipmap.love)
                .setContentTitle("LoveAPP")
                .setContentText("情人節特賣開始了")
                .setAutoCancel(true);
        //第二個訊息
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, idLove)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Android課程")
                .setContentText("Android課程新上線，趕快來參加")
                .setAutoCancel(true);
        //啟動通知
        notificationManager.notify(0,builder.build());
        notificationManager.notify(1,builder2.build());
    }
}
