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
        val currentDateTime: LocalDateTime = LocalDateTime.now() // os>=21
        val formatter = DateTimeFormatter.ofPattern("yyyy年 M月 d日")
        val formattedDate: String = currentDateTime.format(formatter)
        val dateTime = CurrentDate(currentDateTime, "月曜日", formattedDate)
        binding.currentDateTime = dateTime
        binding.garbageKind.text = getString(R.string.garbage_kind, "月曜日")
        getKindOfGarbageByDate()
    }

    fun getKindOfGarbageByDate() {

    }
}