package com.udacity.jwdnd.chatroom.converter;

import com.udacity.jwdnd.chatroom.model.ChatForm;
import com.udacity.jwdnd.chatroom.model.ChatMessage;

public class ChatMessageConverter {

    public static ChatMessage convertChatForm(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say" -> chatMessage.setMessage(chatForm.getMessageText());
            case "Shout" -> chatMessage.setMessage(chatForm.getMessageText().toUpperCase());
            case "Whisper" -> chatMessage.setMessage(chatForm.getMessageText().toLowerCase());
        }
        return chatMessage;
    }
}
