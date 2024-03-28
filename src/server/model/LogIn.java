package server.model;

import share.transferObject.User;
import share.util.Subject;

import java.util.ArrayList;

public interface LogIn extends Subject {
    int addClient(User user);
    String login(User user);
}
