package com.example.javasample;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class BeeperControl {
   private final ScheduledExecutorService scheduler =
     Executors.newScheduledThreadPool(1);

   public void beepForAnHour() {
     Runnable beeper = () -> System.out.println("beep");
     ScheduledFuture<?> beeperHandle =
       scheduler.scheduleAtFixedRate(beeper, 10, 10, TimeUnit.SECONDS);
     Runnable canceller = () -> beeperHandle.cancel(false);
     scheduler.schedule(canceller, 1, TimeUnit.HOURS);
   }
 }