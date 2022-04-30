package com.company.untitled.web.supplier;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Supplier;

@UiController("untitled_Supplier.browse")
@UiDescriptor("supplier-browse.xml")
@LookupComponent("suppliersTable")
@LoadDataBeforeShow
public class SupplierBrowse extends StandardLookup<Supplier> {
}