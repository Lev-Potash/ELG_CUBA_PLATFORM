package com.company.untitled.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Customer;

@UiController("untitled_Customer2.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class CustomerBrowse extends MasterDetailScreen<Customer> {
}