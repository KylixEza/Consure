package com.bccxraion.consure.model.chat

data class Chat(
    val avatar: Int,
    val name: String,
    val message: String,
    val time: String,
    val isRead: Boolean
)
