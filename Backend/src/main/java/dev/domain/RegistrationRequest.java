package dev.domain;

public class RegistrationRequest {
    private User user;
    private UserDetail userDetail;

    public RegistrationRequest(User user, UserDetail userDetail) {
        this.user = user;
        this.userDetail = userDetail;
    }

    public RegistrationRequest() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
