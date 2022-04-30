package com.company.untitled.web.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Customer;

@UiController("untitled_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}