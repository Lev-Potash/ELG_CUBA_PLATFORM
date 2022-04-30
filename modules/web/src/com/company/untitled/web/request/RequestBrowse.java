package com.company.untitled.web.request;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Request;

@UiController("untitled_Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
@LoadDataBeforeShow
public class RequestBrowse extends StandardLookup<Request> {
}