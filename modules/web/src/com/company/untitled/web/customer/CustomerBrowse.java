package com.company.untitled.web.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Customer;

@UiController("untitled_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}