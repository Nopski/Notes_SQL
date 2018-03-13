package com.example.lado.notes_sql;

/**
 * Created by lado on 13/3/18.
 */

public class UserInput {
    private int _id;
    private String theme, userinput;

    public UserInput() {

    }
    public UserInput(String theme, String userinput) {
        this.theme = theme;
        this.userinput = userinput;
    }

    public int get_id() {
        return _id;
    }

    public String getTheme() {
        return theme;
    }

    public String getUserinput() {
        return userinput;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setUserinput(String userinput) {
        this.userinput = userinput;
    }
}
