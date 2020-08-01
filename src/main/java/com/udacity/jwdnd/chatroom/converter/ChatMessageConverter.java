package com.udacity.jwdnd.chatroom.converter;

import com.udacity.jwdnd.chatroom.model.ChatForm;
import com.udacity.jwdnd.chatroom.model.ChatMessage;

public class ChatMessageConverter {

    public static ChatMessage convertChatForm(ChatForm chatForm) {
        ChatMessage chatMessage = (ChatMessage) chatForm;
        switch (chatMessage.getMessageType()){
            case "Shout":
                chatMessage.setMessageText(chatMessage.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatMessage.getMessageText().toLowerCase());
                break;
        }
        return chatMessage;
    }
}
