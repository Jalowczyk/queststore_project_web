package com.school.controllers.WebControllers;

import com.school.models.User;
import com.sun.net.httpserver.Headers;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Cookie {

    public Integer getIdFromExistingCookies(Headers requestHeaders) {

        Integer userID;
        try {
            String key = "Cookie";
            List values = requestHeaders.get(key);
            String keyValue = (String) values.get(0);
            String id = keyValue.split("=")[1];
            userID = Integer.valueOf(id);
        } catch (Exception e) {
            return null;
        }

        return userID;
    }

    public String setupCookies(User user) {

        OffsetDateTime oneHourFromNow = OffsetDateTime.now(ZoneOffset.UTC).plus(Duration.ofSeconds(200000));
        String cookieExpire = "expires=" + DateTimeFormatter.RFC_1123_DATE_TIME.format(oneHourFromNow);
        String cookie = String.format("id=%s; %s;", user.getId(), cookieExpire);

        return cookie;
    }
}
