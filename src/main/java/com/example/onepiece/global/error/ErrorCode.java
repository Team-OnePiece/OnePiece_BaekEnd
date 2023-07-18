package com.example.onepiece.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    USER_NOT_FOUND(404, "User Not Found"),
    ACCOUNTID_ALREADY_EXISTS(409, "AccountId Already Exists"),
    NICKNAME_ALREADY_EXISTS(409, "Nickname Already Exists"),
    PASSWORD_MISS_MATCH(400, "Password Miss Match"),

    JWT_EXPIRED(401, "Jwt Expired"),
    JWT_INVALID(401, "Jwt Invalid");

    private final Integer httpStatus;
    private final String message;
}
