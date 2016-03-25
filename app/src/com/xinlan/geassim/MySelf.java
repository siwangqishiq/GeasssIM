package com.xinlan.geassim;

/**
 * Created by panyi on 2016/3/25.
 */
public class MySelf {
    private String account;
    private String token;

    public MySelf(String token, String account) {
        this.token = token;
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}//end class
