package com.udacity.jwdnd.chatroom.service;

import com.udacity.jwdnd.chatroom.mapper.MessageMapper;
import com.udacity.jwdnd.chatroom.model.ChatForm;
import com.udacity.jwdnd.chatroom.model.ChatMessage;
import com.udacity.jwdnd.chatroom.converter.ChatMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    public void addMessage(ChatForm chatForm) {
        ChatMessage chatMessage = ChatMessageConverter.convertChatForm(chatForm);
        this.messageMapper.insert(chatMessage);
    }

    public List<ChatMessage> getChatHistory() {
        return this.messageMapper.getAllMessages();
    }
}
