package model;

public class Header {
    private final String text;
    private final int style;

    public Header(String text, int style) {
        this.text = text;
        this.style = style;
    }


    @Override
    public String toString() {
    StringBuilder str = new StringBuilder();
        for (char sign : text.toCharArray()) {
            str.append(sign);
            str.append(" ".repeat(Math.max(0, style)));
        }
        return str.toString().toUpperCase();
    }
}
