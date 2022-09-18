package model;

public class Note {
    public Header header;
    public Body body;
    public Priority priority;

    public Note(Header header, Body body, Priority priority){
        this.header = header;
        this.body = body;
        this.priority = priority;
    }

}
