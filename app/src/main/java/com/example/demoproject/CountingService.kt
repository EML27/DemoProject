package com.example.demoproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class CountingService : Service() {

    var counter = 0

    private var CHANNEL_ID = "27"

    private var mt: MyThread? = null

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent.let {
            when (intent?.action) {
                "start" -> {
                    start()
                }
                "stop" -> {
                    stop()
                }
                else -> {
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun setNotification() {
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Counting"
            val descriptionText = "Count things"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel =
                notificationManager.getNotificationChannel(CHANNEL_ID) ?: NotificationChannel(
                    CHANNEL_ID,
                    name,
                    importance
                ).apply {
                    description = descriptionText
                }
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(counter.toString())
            .setSmallIcon(R.drawable.ic_baseline_add_circle_outline_24)
            .build()

        notificationManager.notify(1, notification)
        startForeground(1, notification)
    }

    private fun stop() {
        mt?.mustGo = false
        stopForeground(true)
        stopSelf()
    }

    private fun start() {
        if (mt == null) {
            mt = MyThread()
        }
        mt?.start()
    }

    inner class MyThread : Thread() {
        var mustGo = true
        private val waitTime = 1000.toLong()

        override fun run() {
            super.run()
            while (mustGo) {
                counter++
                setNotification()
                sleep(waitTime)
            }
        }
    }
}
