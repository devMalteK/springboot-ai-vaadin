package de.kochnetonline.springbootaivaadin.ui;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.ai.chat.ChatClient;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.List;

@Route(value = "chatview", layout = MainView.class)
@PageTitle("Chat")
@CssImport("./styles/shared-styles.css")
public class ChatView extends VerticalLayout {

    List<MessageListItem> messageListItemList = new LinkedList<>();

    public ChatView(ChatClient chatClient) {


        MessageList messageList = new MessageList();
        add(messageList);


        var avatar = new Avatar();
        avatar.setImage("img/dev.malte.jpeg");
        var question = new TextField();
        var ask = new Button("Ask");
        question.setWidth("500px");

        ask.addClickListener(e -> {
            messageListItemList.add(createQuestion(question.getValue()));
            messageList.setItems(messageListItemList);

            var clientAnswer = chatClient.call(question.getValue());
            messageListItemList.add(createAnswer(clientAnswer));
            messageList.setItems(messageListItemList);
        });
        add(new HorizontalLayout(avatar, question, ask));

    }

    private MessageListItem createQuestion(String value) {
        return new MessageListItem(value,
                LocalDateTime.now().toInstant(ZoneOffset.UTC), "Malte", "img/dev.malte.jpeg");

    }

    private MessageListItem createAnswer(String value) {
        return new MessageListItem(value,
                LocalDateTime.now().toInstant(ZoneOffset.UTC), "GPT");

    }
}
