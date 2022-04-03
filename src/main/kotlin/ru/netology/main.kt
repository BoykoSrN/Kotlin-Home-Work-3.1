package ru.netology

const val SECOND = 71_200

fun main() {

    println(agoToText(SECOND))
}

fun agoToText(secondToText : Int) : String {

    val minute = 60
    val hours = 3_600
    val day = 86_400
    val twoDays = 172_800
    val threeDays = 259_200

    return when {
        secondToText <= minute -> "был(а) только что"
        (secondToText >= (minute + 1)) && (secondToText <= hours) -> "был(а) в сети ${secondToText / 60} " +
                "${declinationsMinutes(secondToText)} назад"
        (secondToText >= (hours + 1)) && (secondToText <= day) -> "был(а) в сети ${(secondToText / 60) / 60} " +
                "${declinationsHours(secondToText)} назад"
        (secondToText >= (day + 1)) &&  (secondToText <= twoDays) -> "был(а) в сети сегодня"
        (secondToText >= (twoDays + 1)) &&  (secondToText <= threeDays) -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

fun declinationsMinutes(secondToMinutes : Int) : String {

     return when {
        (secondToMinutes / 60) % 100 / 10 == 1 -> "минут"
        (secondToMinutes / 60) % 10 == 1 -> "минута"
        (secondToMinutes / 60) % 10 == 2 -> "минуты"
        (secondToMinutes / 60) % 10 == 3 -> "минуты"
        (secondToMinutes / 60) % 10 == 4 -> "минуты"
        (secondToMinutes / 60) % 10 == 5 -> "минут"
        else -> "минут"
    }
}

fun declinationsHours(secondToHours : Int) : String {

    return when {
        ((secondToHours / 60) / 60) % 100 / 10 == 1 -> "часов"
        ((secondToHours / 60) / 60) % 10 == 1 -> "час"
        ((secondToHours / 60) / 60) % 10 == 2 -> "часа"
        ((secondToHours / 60) / 60) % 10 == 3 -> "часа"
        ((secondToHours / 60) / 60) % 10 == 4 -> "часа"
        ((secondToHours / 60) / 60) % 10 == 5 -> "часов"
        else -> "часов"
    }
}
