package com.company.untitled.web.screens.supplier;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Supplier;

@UiController("untitled_Supplier2.browse")
@UiDescriptor("supplier-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class SupplierBrowse extends MasterDetailScreen<Supplier> {
}