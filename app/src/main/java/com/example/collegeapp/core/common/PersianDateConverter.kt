package com.example.collegeapp.core.common

import java.util.*

class PersianDateConverter {
    var strWeekDay = ""
    var strMonth = ""
    var date = 0
    var month = 0
    var year = 0

    fun calcSolarCalendar(MiladiDate: Date): PersianDateConverter {
        val ld: Int
        val miladiYear: Int = MiladiDate.year + 1900
        val miladiMonth: Int = MiladiDate.month + 1
        val miladiDate: Int = MiladiDate.date
        val WeekDay: Int = MiladiDate.day
        val buf1 = IntArray(12)
        val buf2 = IntArray(12)
        buf1[0] = 0
        buf1[1] = 31
        buf1[2] = 59
        buf1[3] = 90
        buf1[4] = 120
        buf1[5] = 151
        buf1[6] = 181
        buf1[7] = 212
        buf1[8] = 243
        buf1[9] = 273
        buf1[10] = 304
        buf1[11] = 334
        buf2[0] = 0
        buf2[1] = 31
        buf2[2] = 60
        buf2[3] = 91
        buf2[4] = 121
        buf2[5] = 152
        buf2[6] = 182
        buf2[7] = 213
        buf2[8] = 244
        buf2[9] = 274
        buf2[10] = 305
        buf2[11] = 335
        if (miladiYear % 4 != 0) {
            date = buf1[miladiMonth - 1] + miladiDate
            if (date > 79) {
                date = date - 79
                if (date <= 186) {
                    when (date % 31) {
                        0 -> {
                            month = date / 31
                            date = 31
                        }
                        else -> {
                            month = date / 31 + 1
                            date = date % 31
                        }
                    }
                    year = miladiYear - 621
                } else {
                    date = date - 186
                    when (date % 30) {
                        0 -> {
                            month = date / 30 + 6
                            date = 30
                        }
                        else -> {
                            month = date / 30 + 7
                            date = date % 30
                        }
                    }
                    year = miladiYear - 621
                }
            } else {
                ld = if (miladiYear > 1996 && miladiYear % 4 == 1) {
                    11
                } else {
                    10
                }
                date = date + ld
                when (date % 30) {
                    0 -> {
                        month = date / 30 + 9
                        date = 30
                    }
                    else -> {
                        month = date / 30 + 10
                        date = date % 30
                    }
                }
                year = miladiYear - 622
            }
        } else {
            date = buf2[miladiMonth - 1] + miladiDate
            ld = if (miladiYear >= 1996) {
                79
            } else {
                80
            }
            if (date > ld) {
                date = date - ld
                if (date <= 186) {
                    when (date % 31) {
                        0 -> {
                            month = date / 31
                            date = 31
                        }
                        else -> {
                            month = date / 31 + 1
                            date = date % 31
                        }
                    }
                    year = miladiYear - 621
                } else {
                    date = date - 186
                    when (date % 30) {
                        0 -> {
                            month = date / 30 + 6
                            date = 30
                        }
                        else -> {
                            month = date / 30 + 7
                            date = date % 30
                        }
                    }
                    year = miladiYear - 621
                }
            } else {
                date = date + 10
                when (date % 30) {
                    0 -> {
                        month = date / 30 + 9
                        date = 30
                    }
                    else -> {
                        month = date / 30 + 10
                        date = date % 30
                    }
                }
                year = miladiYear - 622
            }
        }
        when (month) {
            1 -> strMonth = "??????????????"
            2 -> strMonth = "????????????????"
            3 -> strMonth = "??????????"
            4 -> strMonth = "??????"
            5 -> strMonth = "??????????"
            6 -> strMonth = "????????????"
            7 -> strMonth = "??????"
            8 -> strMonth = "????????"
            9 -> strMonth = "??????"
            10 -> strMonth = "????"
            11 -> strMonth = "????????"
            12 -> strMonth = "??????????"
        }
        when (WeekDay) {
            0 -> strWeekDay = "????????????"
            1 -> strWeekDay = "????????????"
            2 -> strWeekDay = "???? ????????"
            3 -> strWeekDay = "????????????????"
            4 -> strWeekDay = "?????? ????????"
            5 -> strWeekDay = "????????"
            6 -> strWeekDay = "????????"
        }
        return this
    }
}