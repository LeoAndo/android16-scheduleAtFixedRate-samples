package com.example.kotlinsample

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1)

    companion object {
        private const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // deprecated pattern - START
//        val beeper = Runnable { Log.d(TAG, "beep") }
//
//        // 初期遅延3秒、その後5秒間隔で実行する
//        val beeperHandle = scheduler.scheduleAtFixedRate(beeper, 3, 5, TimeUnit.SECONDS)
//        val canceller = Runnable {
//            Log.d(TAG, "cancel!")
//            beeperHandle.cancel(false)
//        }
//        scheduler.schedule(canceller, 20, TimeUnit.SECONDS) // 30秒で定期実行を終了する
        // deprecated pattern - END

        // new pattern - START
        val beeper = Runnable { Log.d(TAG, "beep") }

        // 初期遅延3秒、その後5秒間隔で実行する
        val beeperHandle = scheduler.scheduleWithFixedDelay(beeper, 3, 5, TimeUnit.SECONDS)
        val canceller = Runnable {
            Log.d(TAG, "cancel!")
            beeperHandle.cancel(false)
        }
        scheduler.schedule(canceller, 20, TimeUnit.SECONDS) // 30秒で定期実行を終了する
        // new pattern - END
    }
}