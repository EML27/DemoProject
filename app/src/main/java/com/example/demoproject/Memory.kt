package com.example.demoproject

object Memory {
    var list: List<Item>

    init {
        list = listOf<Item>(
            Item(4, "Steve"),
            Item(5, "Bob")
        )
    }
}
