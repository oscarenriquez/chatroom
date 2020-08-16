package com.udacity.jwdnd.chatroom.ui;

import com.udacity.jwdnd.chatroom.model.ChatMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ChatRoomPage {
    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="messageText")
    private WebElement textField;

    @FindBy(id="messageType")
    private WebElement messageType;

    @FindBy(id="submitMessage")
    private WebElement submitButton;

    @FindBy(className = "chatMessageUsername")
    private WebElement firstMessageUsername;

    @FindBy(className = "chatMessageText")
    private WebElement firstMessageText;

    public ChatRoomPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendChatMessage(String text, String username) {
        this.textField.sendKeys(text);
        this.username.sendKeys(username);
        Select messageTypeSelect = new Select(messageType);
        messageTypeSelect.getFirstSelectedOption();
        this.submitButton.click();
    }

    public ChatMessage getFirstMessage() {
        ChatMessage result = new ChatMessage();
        result.setMessageText(firstMessageText.getText());
        result.setUsername(firstMessageUsername.getText());
        return result;
    }
}
