package com.company.untitled.web.requestitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.RequestItem;

@UiController("untitled_RequestItem.browse")
@UiDescriptor("request-item-browse.xml")
@LookupComponent("requestItemsTable")
@LoadDataBeforeShow
public class RequestItemBrowse extends StandardLookup<RequestItem> {
}