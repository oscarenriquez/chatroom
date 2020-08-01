package com.udacity.jwdnd.chatroom.service;

import com.udacity.jwdnd.chatroom.model.ChatForm;
import com.udacity.jwdnd.chatroom.model.ChatMessage;
import com.udacity.jwdnd.chatroom.converter.ChatMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private List<ChatMessage> chatHistory;

    @PostConstruct
    public void postConstruct() {
        logger.info("Message service created");
        this.chatHistory = new ArrayList<>();
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = ChatMessageConverter.convertChatForm(chatForm);
        chatHistory.add(chatMessage);
    }

    public List<ChatMessage> getChatHistory() {
        return chatHistory;
    }
}
