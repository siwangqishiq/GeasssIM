package com.xinlan.geassim.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by panyi on 2016/3/25.
 */
public class Friend implements Serializable {
    public String id;
    public String name;
    public String headImage;

    public Friend(String id, String name, String headImage) {
        this.id = id;
        this.name = name;
        this.headImage = headImage;
    }

    static final String BASE = "http://i.imgur.com/";
    static final String EXT = ".jpg";
    static final String[] URLS = {
            "http://square.github.io/picasso/static/sample.png", BASE + "zkaAooq" + EXT, BASE + "0gqnEaY" + EXT,
            BASE + "9gbQ7YR" + EXT, BASE + "aFhEEby" + EXT, BASE + "0E2tgV7" + EXT,
            BASE + "P5JLfjk" + EXT, BASE + "nz67a4F" + EXT, BASE + "dFH34N5" + EXT,
            BASE + "FI49ftb" + EXT, BASE + "DvpvklR" + EXT, BASE + "DNKnbG8" + EXT,
            BASE + "yAdbrLp" + EXT, BASE + "55w5Km7" + EXT, BASE + "NIwNTMR" + EXT,
            BASE + "DAl0KB8" + EXT, BASE + "xZLIYFV" + EXT, BASE + "HvTyeh3" + EXT,
            BASE + "Ig9oHCM" + EXT, BASE + "7GUv9qa" + EXT, BASE + "i5vXmXp" + EXT,
            BASE + "glyvuXg" + EXT, BASE + "u6JF6JZ" + EXT, BASE + "ExwR7ap" + EXT,
            BASE + "Q54zMKT" + EXT, BASE + "9t6hLbm" + EXT, BASE + "F8n3Ic6" + EXT,
            BASE + "P5ZRSvT" + EXT, BASE + "jbemFzr" + EXT, BASE + "8B7haIK" + EXT,
            BASE + "aSeTYQr" + EXT, BASE + "OKvWoTh" + EXT, BASE + "zD3gT4Z" + EXT,
            BASE + "z77CaIt" + EXT,
    };

    public static List<Friend> createFriendList() {
        List<Friend> list = new ArrayList<Friend>();
        list.add(new Friend("hanminmin", "韩敏敏", URLS[0]));
        list.add(new Friend("luluxiu", "鲁路修", URLS[1]));
        list.add(new Friend("conan", "柯南", URLS[2]));
        list.add(new Friend("hanminmin", "韩敏敏", URLS[3]));
        list.add(new Friend("luluxiu", "鲁路修", URLS[4]));
        list.add(new Friend("conan", "柯南", URLS[5]));
        list.add(new Friend("conan", "柯南", URLS[6]));
        list.add(new Friend("conan", "柯南", URLS[7]));
        list.add(new Friend("conan", "柯南", URLS[8]));
        list.add(new Friend("hanminmin", "韩敏敏", URLS[0]));
        list.add(new Friend("luluxiu", "鲁路修", URLS[1]));
        list.add(new Friend("conan", "柯南", URLS[2]));
        list.add(new Friend("hanminmin", "韩敏敏", URLS[3]));
        list.add(new Friend("luluxiu", "鲁路修", URLS[4]));
        list.add(new Friend("conan", "柯南", URLS[5]));
        list.add(new Friend("conan", "柯南", URLS[6]));
        list.add(new Friend("conan", "柯南", URLS[7]));
        list.add(new Friend("conan", "柯南", URLS[8]));
        list.add(new Friend("hanminmin", "韩敏敏", URLS[0]));
        list.add(new Friend("luluxiu", "鲁路修", URLS[1]));
        list.add(new Friend("conan", "柯南", URLS[2]));
        list.add(new Friend("hanminmin", "韩敏敏", URLS[3]));
        list.add(new Friend("luluxiu", "鲁路修", URLS[4]));
        list.add(new Friend("conan", "柯南", URLS[5]));
        list.add(new Friend("conan", "柯南", URLS[6]));
        list.add(new Friend("conan", "柯南", URLS[7]));
        list.add(new Friend("conan", "柯南", URLS[8]));
        return list;
    }
}//end class
