package client.model;

import share.util.Subject;

public interface ChatModel extends Subject {
    String sendMessage(String text);
}
