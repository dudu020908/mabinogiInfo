package com.example.mabinogiinfoapp


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.mabinogiinfoapp.databinding.ActivityMainBinding
import com.example.mabinogiinfoapp.ui.JobCategoryActivity
import com.example.mabinogiinfoapp.ui.EquipmentCategoryActivity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

// 해당 앱의 모든 이미지 출처는 넥슨 - 마비노기 모바일에 있습니다. https://mabinogimobile.nexon.com/Media/Image
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()
        requestNotificationPermission()
        checkExactAlarmPermission()

        setSupportActionBar(binding.toolbar)
        drawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_alarm_on -> {
                    AlarmHelper.setHourlyAlarm(this)
                    Toast.makeText(this, "알람이 켜졌습니다.", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_alarm_off -> {
                    AlarmHelper.cancelAlarm(this)
                    Toast.makeText(this, "알람이 꺼졌습니다.", Toast.LENGTH_SHORT).show()
                }
                //테스팅용
                R.id.nav_test_alarm -> {
                    AlarmHelper.setTestAlarm(this)
                    Toast.makeText(this, "10초 후 테스트 알람이 울립니다.", Toast.LENGTH_SHORT).show()
                }

            }
            updateAlarmStatus()
            binding.drawerLayout.closeDrawers()
            true
        }

        binding.cardJob.setOnClickListener {
            startActivity(Intent(this, JobCategoryActivity::class.java))
        }

        binding.cardRune.setOnClickListener {
            startActivity(Intent(this, EquipmentCategoryActivity::class.java))
        }

    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "hourly_channel",
                "정각 알림 채널",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    1001
                )
            }
        }
    }
    private fun updateAlarmStatus() {
        val statusItem = binding.navView.menu.findItem(R.id.nav_alarm_status)
        val isOn = AlarmHelper.isAlarmSet(this)
        statusItem.title = if (isOn) "알람 상태: ON" else "알람 상태: OFF"
    }
    private fun checkExactAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val alarmManager = getSystemService(ALARM_SERVICE) as android.app.AlarmManager
            if (!alarmManager.canScheduleExactAlarms()) {
                val intent = Intent(android.provider.Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
                    data = android.net.Uri.parse("package:$packageName")
                }
                startActivity(intent)
            }
        }
    }
}
