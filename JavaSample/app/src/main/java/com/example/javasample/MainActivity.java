package com.example.javasample;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @NonNull
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // deprecated pattern - START
//        Runnable beeper = () -> Log.d(TAG, "beep");
//        // 初期遅延3秒、その後5秒間隔で実行する
//        var beeperHandle = scheduler.scheduleAtFixedRate(beeper, 3, 5, TimeUnit.SECONDS);
//        Runnable canceller = () -> {
//            Log.d(TAG, "cancel!");
//            beeperHandle.cancel(false);
//        };
//        scheduler.schedule(canceller, 20, TimeUnit.SECONDS); // 30秒で定期実行を終了する
        // deprecated pattern - END

        // new pattern - START
        Runnable beeper = () -> Log.d(TAG, "beep");
        // 初期遅延3秒、その後5秒間隔で実行する
        var beeperHandle = scheduler.scheduleWithFixedDelay(beeper, 3, 5, TimeUnit.SECONDS);
        Runnable canceller = () -> {
            Log.d(TAG, "cancel!");
            beeperHandle.cancel(false);
        };
        scheduler.schedule(canceller, 20, TimeUnit.SECONDS); // 30秒で定期実行を終了する
        // new pattern - END

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scheduler.shutdown();
    }
}