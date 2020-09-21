package com.dts.rentgameapi.domain.request;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rin-DTS
 */
public class LoginRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String display_name;

    @JsonCreator
    public LoginRequest(@JsonProperty("username") String username,
                        @JsonProperty("password") String password,
                        @JsonProperty("email") String email,
                        @JsonProperty("display_name") String display_name,
                        @JsonProperty("phone") String phone) {
        this.username = username;
        this.password = password;
        this.display_name=display_name;
        this.email=email;
        this.phone=phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", display_name='" + display_name + '\'' +
                '}';
    }
}
