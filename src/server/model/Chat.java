package server.model;

import share.util.Subject;

public interface Chat extends Subject {
    String addMessage(String object);
}
