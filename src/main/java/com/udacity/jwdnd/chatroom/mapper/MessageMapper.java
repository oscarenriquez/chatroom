package com.udacity.jwdnd.chatroom.mapper;

import com.udacity.jwdnd.chatroom.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES ORDER BY messageId DESC")
    List<ChatMessage> getAllMessages();

    @Select("SELECT * FROM MESSAGES username = #{username}")
    List<ChatMessage> getMessagesByUser(String username);

    @Select("SELECT * FROM MESSAGES WHERE messageId = #{messageId}")
    ChatMessage getMessage(Integer messageId);

    @Insert("INSERT INTO MESSAGES (username, messageText) VALUES(#{username}, #{messageText})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(ChatMessage chatMessage);
}
