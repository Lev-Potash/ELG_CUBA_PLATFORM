package com.company.untitled.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ChartEnum implements EnumClass<Integer> {

    SERIAL_CHART(10),
    PIE_CHART(20),
    RADAR_CHART(30);

    private Integer id;

    ChartEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static ChartEnum fromId(Integer id) {
        for (ChartEnum at : ChartEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}