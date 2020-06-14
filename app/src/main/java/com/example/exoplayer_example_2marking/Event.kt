package com.example.exoplayer_example_2marking

open class Event<out T>(private val content: T) {
    var testEvent = false

    fun getFunTest(): T? {
        if (testEvent) return null
        else {
            testEvent = true
            return content
        }
    }
}