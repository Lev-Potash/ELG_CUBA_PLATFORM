package com.company.untitled.web.screens.request;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Request;

@UiController("untitled_Request2.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class RequestBrowse extends MasterDetailScreen<Request> {
}