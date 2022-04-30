package com.company.untitled.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.BaseIdentityIdEntity;
import com.haulmont.cuba.core.global.DdlGeneration;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@DdlGeneration(value = DdlGeneration.DbScriptGenerationMode.CREATE_ONLY)
@Table(name = "request")
@Entity(name = "untitled_Request")
public class Request extends BaseIdentityIdEntity {
    private static final long serialVersionUID = -7546350110838954496L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private com.company.untitled.entity.Customer customer;

    @Composition
    @OneToMany(mappedBy = "request")
    @NotNull(message = "Поля должны быть заполнены")
    private List<RequestItem> items;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id")
    private com.company.untitled.entity.Supplier supplier;

    public List<RequestItem> getItems() {
        return items;
    }

    public void setItems(List<RequestItem> items) {
        this.items = items;
    }

    public com.company.untitled.entity.Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(com.company.untitled.entity.Supplier supplier) {
        this.supplier = supplier;
    }

    public com.company.untitled.entity.Customer getCustomer() {
        return customer;
    }

    public void setCustomer(com.company.untitled.entity.Customer customer) {
        this.customer = customer;
    }
}