package com.company.untitled.web.screens.requestitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.RequestItem;

@UiController("untitled_RequestItem2.browse")
@UiDescriptor("request-item-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class RequestItemBrowse extends MasterDetailScreen<RequestItem> {
}