package linebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

/**
 * Created by Gregory on 2016/12/20.
 */
@SpringBootApplication
@LineMessageHandler
public class EchoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EchoApplication.class, args);
    }

    @EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
        String message = event.getMessage().getText();
        String userId = event.getSource().getUserId();
        String reply = null;

        if (message.contains("代名詞")) {
            if (message.contains("冠儀")) {
                reply = "帥、帥、帥";
            } else if (message.contains("雨晨")) {
                reply = "溫柔體貼，美麗大方";
            }
        }

        if (message.contains("穩誠的專長是")) {
            int random = (int) (Math.random() * 2);
            if (random % 2 == 0) {
                reply = "糗捏捏?";
            } else {
                reply = "糗口口口的捏捏?";
            }
        }

        return new TextMessage(reply);
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
