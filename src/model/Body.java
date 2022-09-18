package model;

public class Body {
    private String text;

    public Body(String text){
        this.text= text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
