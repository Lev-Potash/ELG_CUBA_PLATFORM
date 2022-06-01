package com.company.untitled.web.screens.xy_chart;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

@UiController("untitled_XychartFragment")
@UiDescriptor("XYChart-fragment.xml")
@DashboardWidget(name = "XYChart")
@LoadDataBeforeShow
public class XychartFragment extends ScreenFragment {
}