/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entregablehibernate.utils;

import jakarta.persistence.AttributeConverter;

/**
 *
 * @author jacqueline
 */
public class CandidatureStatusConverter implements AttributeConverter<Status, Integer> {

    public Integer convertToDatabaseColumn(Status type) {
        int n = type.getValue();
        return n;
    }

    public Status convertToEntityAttribute(Integer n) {
        for (Status s : Status.values()) {
            if (s.getValue() == n) {
                return s;
            }
        }
        return null;
    }
}
