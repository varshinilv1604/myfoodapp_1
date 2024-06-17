package com.myapp_1.myapplication2.data

import android.content.Context
import java.io.File
data class Food(
    var name: String,
    var canteen:String,
    var cuisine:String,
    var price:Double
)
object FileManager {

    fun writeFoodListToFile(context: Context, fileName: String, foodList: List<Food>) {
        val file = File(context.filesDir, fileName)
        file.printWriter().use { out ->
            foodList.forEach { food ->
                out.println("${food.name},${food.canteen},${food.cuisine},${food.price}")
            }
        }
    }

    fun readFromFile(context: Context, fileName: String): String {
        val file = File(context.filesDir, fileName)
        return if (file.exists()) {
            file.readText()
        } else {
            ""
        }
    }
}