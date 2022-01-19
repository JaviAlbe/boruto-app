package com.albe.borutoapp.data.local

import androidx.room.TypeConverter
import java.lang.StringBuilder

/** Type Converter to to be able to add a list of strings inside the Room DB*/

class DatabaseConverter {

    private val separator = ","

    /** It converts the list of string into a single string with all strings of the list*/
    @TypeConverter
    fun convertListToString(list: List<String>): String {
        val stringBuilder = StringBuilder()
        for (item in list) {
            stringBuilder.append(item).append(separator)
        }

        //the comma from the last string needs to be removed
        stringBuilder.setLength(stringBuilder.length - separator.length)
        return stringBuilder.toString()
    }

    /** and the other way around*/
    @TypeConverter
    fun convertStringToList(string: String): List<String> {
        return string.split(separator)
    }
}