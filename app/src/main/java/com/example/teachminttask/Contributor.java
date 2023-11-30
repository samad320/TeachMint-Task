package com.example.teachminttask;
import com.google.gson.annotations.SerializedName;

public class Contributor {
    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private int id;


    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }


}
