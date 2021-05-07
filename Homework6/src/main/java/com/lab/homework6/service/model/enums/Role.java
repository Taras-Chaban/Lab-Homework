package com.lab.homework6.service.model.enums;

import com.lab.homework6.service.model.User;

public enum Role {
    USER,
    CASHIER,
    SENIOR_CASHIER,
    MERCHANT,
    ADMIN;
    public static Role getRole(User user) {
        return Role.values()[user.getRole()];
    }
}