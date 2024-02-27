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
public class WorkDayTypeJobOfferConverter implements AttributeConverter<WorkDayType, Integer>{
      public Integer convertToDatabaseColumn(WorkDayType type) {
        int n = type.getValue();
        return n;
    }

    public WorkDayType convertToEntityAttribute(Integer n) {
        for (WorkDayType workDayType : WorkDayType.values()) {
            if (workDayType.getValue() == n) {
                return workDayType;
            }
        }
        return null;
    }
}
