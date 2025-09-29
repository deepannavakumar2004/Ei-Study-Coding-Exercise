public class ChatUser implements Observer {
    private final String name;

    public ChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name + " received message from " + message);

    }

    public String getName() {
        return name;
    }

    public void sendMessage(String message, ChatUser target) {
        target.update(this.name + " says: " + message);
    }
}
