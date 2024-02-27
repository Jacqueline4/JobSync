/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.entregablehibernate.utils;

/**
 *
 * @author jacqueline
 */
public enum WorkDayType {
    INTERSHIP(1), FULL_TIME(2), CONTRAC(3), PART_TIME(4), TEMPORARY(5);
    private final int value;

    WorkDayType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
