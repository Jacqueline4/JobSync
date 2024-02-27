/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.entregablehibernate.utils;

/**
 *
 * @author jacqueline
 */
public enum Status {
    REJECTED(1), PENDING(2), ACCEPTED(3);
    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
