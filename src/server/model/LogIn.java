package server.model;

import share.transferObject.User;
import share.util.Subject;

public interface LogIn extends Subject {
    String login(User user);
}
