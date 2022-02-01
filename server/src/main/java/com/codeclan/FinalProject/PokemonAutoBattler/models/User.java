package com.codeclan.FinalProject.PokemonAutoBattler.models;

public class User {

    private String email;

    private String username;

    private String password;

    private String avatarImage;

    private StatTracker statTracker;

    public User(String email, String username, String password, String avatarImage, StatTracker statTracker) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatarImage = avatarImage;
        this.statTracker = statTracker;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public StatTracker getStatTracker() {
        return statTracker;
    }

    public void login(){

    }
    public void logout(){

    }

//    public void setStatTracker(StatTracker statTracker) {
//        this.statTracker = statTracker;
//    }
}
