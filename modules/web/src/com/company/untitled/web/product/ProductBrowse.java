package com.company.untitled.web.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Product;

@UiController("untitled_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}