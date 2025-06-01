package com.example.mabinogiinfoapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.mabinogiinfoapp.R

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        // 알림 권한 체크 (Android 13 이상일 때만)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // 권한이 없으면 알림 생성하지 않고 종료
            return
        }

        // 알림 생성
        val notification = NotificationCompat.Builder(context, "hourly_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("결계 시간 알림")
            .setContentText("마비노기 모바일 결계 시간입니다 확인해보세요!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // 알림 표시
        NotificationManagerCompat.from(context).notify(1001, notification)
    }
}
