public class TextEditor {
    private final StringBuilder text = new StringBuilder();

    public void write(String newText) {
        text.append(newText);
    }

    public void erase(int length) {
        if (length > 0 && length <= text.length()) {
            text.delete(text.length() - length, text.length());
        }
    }

    public String getText() {
        return text.toString();
    }
}
