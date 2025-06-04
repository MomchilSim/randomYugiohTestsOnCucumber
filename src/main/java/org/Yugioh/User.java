package org.Yugioh;

public class User {
    private String username;
    private String password;
    private boolean hasPerms;

    public User(String username, String password, boolean hasPerms) {
        this.username = username;
        this.password = password;
        this.hasPerms = hasPerms;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getHasPerms() {
        return hasPerms;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {        this.password = password;
    }

    public void setHasPerms(boolean hasPerms) {
        this.hasPerms = hasPerms;
    }
}
