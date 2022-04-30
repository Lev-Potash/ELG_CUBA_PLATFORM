package com.company.untitled.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Product;

@UiController("untitled_Product2.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ProductBrowse extends MasterDetailScreen<Product> {
}