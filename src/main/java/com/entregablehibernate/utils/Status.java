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
    REJECTED(0), PENDING(1), ACCEPTED(2);
    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
