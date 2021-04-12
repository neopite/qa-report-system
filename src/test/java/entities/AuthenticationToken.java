package entities;

public class AuthenticationToken {
    private long id;
    private String token;

    public AuthenticationToken(long id, String token) {
        this.id = id;
        this.token = token;
    }

    public AuthenticationToken() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
