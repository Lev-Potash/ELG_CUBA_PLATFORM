package com.company.untitled.web.screens.main;

import com.company.untitled.web.chart_widgets.SerialChartWidget;
import com.company.untitled.web.chart_widgets.SerialChartWidget2;
import com.company.untitled.web.chart_widgets.SerialChartWidget3;
import com.company.untitled.web.screens.address.AddressFragment;
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

    //@Inject
    //private GroupBoxLayout addressBox;

    @Subscribe
    private void onInit(InitEvent event) {
        SerialChartWidget2 serialChartFragment = fragments.create(this, SerialChartWidget2.class);
        //serialChartFragment.setSerialChart();
        serialChartBox.add(serialChartFragment.getFragment());


        /*AddressFragment addressFragment = fragments.create(this, AddressFragment.class);
        addressBox.add(addressFragment.getFragment());*/

    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        SerialChartWidget2 serialChartFragment = fragments.create(this, SerialChartWidget2.class);
        //serialChartFragment.setSerialChart();
        serialChartBox.add(serialChartFragment.getFragment());

    }




}