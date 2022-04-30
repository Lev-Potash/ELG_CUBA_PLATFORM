package com.company.untitled.web.supplier;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Supplier;

@UiController("untitled_Supplier.edit")
@UiDescriptor("supplier-edit.xml")
@EditedEntityContainer("supplierDc")
@LoadDataBeforeShow
public class SupplierEdit extends StandardEditor<Supplier> {
}