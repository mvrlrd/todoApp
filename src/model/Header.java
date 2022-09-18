package model;

public class Header {
    private String text;
    private int style;

    public Header(String text, int style) {
        this.text = text;
        this.style = style;
    }
    public Header(String text){
        this.text=text;
    }

    public String getText() {
        return text;
    }

    public int getStyle() {
        return style;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStyle(int style) {
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
    public boolean equals(String text){
        return this.text.equalsIgnoreCase(text);
    }
}
