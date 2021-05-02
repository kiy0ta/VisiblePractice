package com.example.visiblepractice

import java.util.*

class CurrentDate {
    // 今日の日付
    var currentDate: Calendar
        get() {
            return currentDate
        }
        set(value) {
            this.currentDate = value
        }

    // 曜日
    var date: String
        get() {
            return date
        }
        set(value) {
            this.date = value
        }

    // 整形後の今日の日付
    var formattedDate: String
        get() {
            return formattedDate
        }
        set(value) {
            this.formattedDate = value
        }
}