package com.company.untitled.web.request;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.Request;

@UiController("untitled_Request.edit")
@UiDescriptor("request-edit.xml")
@EditedEntityContainer("requestDc")
@LoadDataBeforeShow
public class RequestEdit extends StandardEditor<Request> {
}