package com.company.untitled.web.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Product;

@UiController("untitled_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}