package com.udacity.jwdnd.chatroom;

import com.udacity.jwdnd.chatroom.model.ChatMessage;
import com.udacity.jwdnd.chatroom.ui.ChatRoomPage;
import com.udacity.jwdnd.chatroom.ui.LoginPage;
import com.udacity.jwdnd.chatroom.ui.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatroomApplicationTests {
	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private static final String USER_NAME = "oenriquez";
	private static final String PASSWORD = "password";
	private static final String MESSAGE = "This is the first message.";

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}


	@Test
	void testUserSignUpLoginAndSubmitMessage() {

		driveTo("/signup");
		RegistrationPage signupPage = new RegistrationPage(driver);
		signupPage.signup("Oscar", "Enriquez", USER_NAME, PASSWORD);

		driveTo("/login");
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(webDriver -> webDriver.findElement(By.id("inputUsername")));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(USER_NAME, PASSWORD);


		wait.until(webDriver -> webDriver.findElement(By.id("submitMessage")));
		ChatRoomPage chatPage = new ChatRoomPage(driver);
		chatPage.sendChatMessage(MESSAGE, USER_NAME);

		ChatMessage sentMessage = chatPage.getFirstMessage();

		assertEquals(USER_NAME, sentMessage.getUsername());
		assertEquals(MESSAGE, sentMessage.getMessageText());
	}

	void driveTo(String url) {
		driver.get("http://localhost:" + port + url);
	}

}
