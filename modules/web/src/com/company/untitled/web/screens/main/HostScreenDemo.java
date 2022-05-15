package com.company.untitled.web.screens.main;

import com.company.untitled.web.chart_widgets.SerialChartWidget3;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("untitled_HostScreenDemo")
@UiDescriptor("host-screen-demo.xml")
public class HostScreenDemo extends Screen {
    @Inject
    private Fragments fragments;

    @Inject
    private GroupBoxLayout serialChartBox;

    @Subscribe
    private void onInit(InitEvent event) {
        SerialChartWidget3 serialChartFragment = fragments.create(this, SerialChartWidget3.class);
        serialChartBox.add(serialChartFragment.getFragment());
    }


}