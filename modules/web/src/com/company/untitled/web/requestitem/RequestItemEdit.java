package com.company.untitled.web.requestitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.RequestItem;

@UiController("untitled_RequestItem.edit")
@UiDescriptor("request-item-edit.xml")
@EditedEntityContainer("requestItemDc")
@LoadDataBeforeShow
public class RequestItemEdit extends StandardEditor<RequestItem> {
}