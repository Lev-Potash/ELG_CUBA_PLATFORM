package com.company.untitled.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;
import com.haulmont.cuba.core.global.DdlGeneration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "supplier")
@Entity(name = "untitled_Supplier")
@NamePattern("%s|name")
public class Supplier extends BaseIdentityIdEntity {
    private static final long serialVersionUID = 2213756568947894183L;

    @Lob
    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}