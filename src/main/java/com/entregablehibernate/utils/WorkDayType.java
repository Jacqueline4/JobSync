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
    INTERSHIP(0), FULL_TIME(1), CONTRAC(2), PART_TIME(3), TEMPORARY(4);
    private final int value;

    WorkDayType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
