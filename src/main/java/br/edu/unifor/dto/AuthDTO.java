package br.edu.unifor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthDTO {

    public AuthDTO() {

    }
    @JsonProperty("user")
    private String user;

    @JsonProperty("password")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
