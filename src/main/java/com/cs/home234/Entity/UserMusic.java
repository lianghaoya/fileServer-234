package com.cs.home234.Entity;

import java.util.List;

/**
 * @author LH
 * @ClassName UserMusic
 * @Description
 * @date 2019/5/13 15:14
 */
public class UserMusic {
    private User user;
    private List<UMusic> uMusics;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UMusic> getuMusics() {
        return uMusics;
    }

    public void setuMusics(List<UMusic> uMusics) {
        this.uMusics = uMusics;
    }
}
