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
	if (message.contains("我說冠儀 你說")) {
	    return new TextMessage("帥");
	} else if (message.equals("尖叫聲")) {
	    return new TextMessage("啊啊啊啊啊!!"); 
	} else if (message.contains("我是說在座的各位都是")) {
	    return new TextMessage("口口");
	} else {
	    return new TextMessage(event.getSource().getSenderId());
	}					        
    }

    @EventMapping
    public void handleDefaultMessageEvent(Event event) {
        System.out.println("event: " + event);
    }
}
