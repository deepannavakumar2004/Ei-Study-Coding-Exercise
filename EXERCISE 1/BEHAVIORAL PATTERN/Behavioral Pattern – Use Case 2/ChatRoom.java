import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private final List<ChatUser> users = new ArrayList<>();

    public void addUser(ChatUser user) {
        users.add(user);
    }

    public void sendMessage(String message, ChatUser fromUser) {
        for (ChatUser user : users) {
            if (user != fromUser) { // don't send back to sender
                user.update("From " + fromUser.getName() + ": " + message);
            }
        }
    }

    public List<ChatUser> getUsers() {
        return new ArrayList<>(users);
    }
}
