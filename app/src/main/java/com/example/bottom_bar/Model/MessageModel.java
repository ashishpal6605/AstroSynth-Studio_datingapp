package com.example.bottom_bar.Model;

public class MessageModel {
    private int image;
    private String time; // Change the data type of 'time' to String
    private String name;
    private String lastMessage; // Change 'lastmessege' to 'lastMessage'

    public MessageModel(int image, String time, String name, String lastMessage) { // Change the parameter data type to String
        this.image = image;
        this.time = time;
        this.name = name;
        this.lastMessage = lastMessage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) { // Change the parameter data type to String
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() { // Change the getter method name to 'getLastMessage'
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) { // Change the parameter name to 'lastMessage'
        this.lastMessage = lastMessage;
    }
}
