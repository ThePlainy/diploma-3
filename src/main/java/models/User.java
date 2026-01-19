package models;

import io.restassured.response.Response;

public class User {

    private String email;
    private String password;
    private String name;
    private String accessToken;
    private String refreshToken;

    public String getEmail() {
        return email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void addAccessToken(Response response) {
        this.accessToken = response.then().extract().body().path("accessToken");
    }

    public void setAccessToken(String accessToken){
        this.accessToken=accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void addRefreshToken(Response response) {
        this.refreshToken = response.then().extract().body().path("refreshToken");
    }

    public void setRefreshToken(String refreshToken){
        this.refreshToken=refreshToken;
    }
}
