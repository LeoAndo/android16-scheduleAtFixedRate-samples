# WIP!

# logcat
```
2025-01-30 01:30:28.675  6920-6946  MainActivity            com.example.javasample               D  beep
2025-01-30 01:30:31.264  6920-6963  ProfileInstaller        com.example.javasample               D  Installing profile for com.example.javasample
2025-01-30 01:30:33.676  6920-6946  MainActivity            com.example.javasample               D  beep
2025-01-30 01:30:38.676  6920-6946  MainActivity            com.example.javasample               D  beep
2025-01-30 01:30:43.676  6920-6946  MainActivity            com.example.javasample               D  beep
2025-01-30 01:30:45.675  6920-6946  MainActivity            com.example.javasample               D  cancel!
```

# memo
`scheduleAtFixedRate` is deprecated.<br>

# set PATH
export PATH=$PATH:/Users/$USER/Library/Android/sdk/platform-tools

# app compatibility settings
adb shell am compat enable STPE_SKIP_MULTIPLE_MISSED_PERIODIC_TASKS com.example.javasample
adb shell am compat disable STPE_SKIP_MULTIPLE_MISSED_PERIODIC_TASKS com.example.javasample

# reset app compatibility settings
adb shell am compat reset STPE_SKIP_MULTIPLE_MISSED_PERIODIC_TASKS com.example.javasample

# refs
https://developer.android.com/about/versions/16/overview<br>
https://android-developers.googleblog.com/2025/01/first-beta-android16.html<br>
https://developer.android.com/reference/java/util/concurrent/ScheduledExecutorService#usage-example<br>
https://developer.android.com/about/versions/16/reference/compat-framework-changes?hl=ja#stpe_skip_multiple_missed_periodic_tasks<br>
https://developer.android.com/guide/app-compatibility/test-debug#toggle<br>
