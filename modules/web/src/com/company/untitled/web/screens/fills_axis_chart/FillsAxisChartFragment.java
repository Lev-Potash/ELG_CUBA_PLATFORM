package com.company.untitled.web.screens.fills_axis_chart;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

@UiController("untitled_FillsAxisChartFragment")
@UiDescriptor("fills-axis-chart-fragment.xml")
@DashboardWidget(name = "FillsAxisChart")
@LoadDataBeforeShow
public class FillsAxisChartFragment extends ScreenFragment {
}