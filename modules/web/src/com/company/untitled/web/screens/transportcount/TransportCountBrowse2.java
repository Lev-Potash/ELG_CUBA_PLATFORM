package com.company.untitled.web.screens.transportcount;

import com.haulmont.cuba.gui.screen.*;
import com.company.untitled.entity.TransportCount;

@UiController("untitled_TransportCount2.browse")
@UiDescriptor("transport-count-browse2.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class TransportCountBrowse2 extends MasterDetailScreen<TransportCount> {
}