package com.example.visiblepractice

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.visiblepractice.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getCurrentDate()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getCurrentDate() {
        // 現在の日時
        val currentDateTime: LocalDateTime = LocalDateTime.now() // os>=21
        val formatter = DateTimeFormatter.ofPattern("yyyy年 M月 d日")
        // 整形後の日時
        val formattedDate: String = currentDateTime.format(formatter)
        // 曜日
        val date: String = currentDateTime.dayOfWeek.toString()
        // data classへ値を保存する
        val dateTime = CurrentDate(currentDateTime, date, formattedDate)
        // xmlへ値を共有する
        binding.currentDateTime = dateTime
        // ゴミの種類を計算する
        getKindOfGarbageByDate(date)
    }

    private fun getKindOfGarbageByDate(date: String) {
        var dateStr = ""
        when (date) {
            "SUNDAY" -> {
                dateStr = getString(R.string.garbage_kind_1)
            }
            "MONDAY" -> {
                dateStr = getString(R.string.garbage_kind_2)
            }
            "TUESDAY" -> {
                dateStr = getString(R.string.garbage_kind_3)
            }
            "WEDNESDAY" -> {
                dateStr = getString(R.string.garbage_kind_4)
            }
            "THURSDAY" -> {
                dateStr = getString(R.string.garbage_kind_5)
            }
            "FRIDAY" -> {
                dateStr = ""
            }
            "SATURDAY" -> {
                dateStr = getString(R.string.garbage_kind_1)
            }
            else -> {
                dateStr = ""
            }
        }
        if (!dateStr.isNullOrEmpty()) {
            binding.garbageKind.text = getString(R.string.garbage_kind, dateStr)
        } else {
            binding.garbageKind.text = getString(R.string.garbage_kind_no)
        }
    }
}