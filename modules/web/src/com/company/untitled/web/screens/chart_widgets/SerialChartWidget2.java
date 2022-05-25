package com.company.untitled.web.screens.chart_widgets;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("untitled_SerialChartWidget2")
@UiDescriptor("serial-chart-widget2.xml")
@DashboardWidget(name = "SerialChartWidget2")
@LoadDataBeforeShow
public class SerialChartWidget2 extends ScreenFragment {

    @Inject
    private CollectionContainer<Product> productDc;

    @Inject
    private CollectionLoader<Product> productDl;

    @Inject
    private SerialChart serialChartId;

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        productDl.load();

        /*for (Product p : productDc.getItems()) {

        }*/
    }



    @Subscribe
    private void onInit(InitEvent event) {
        serialChartId.setDataProvider(new ContainerDataProvider(productDc));
        serialChartId.setCategoryField("name");
        //serialChartId.setGraphs().

        //serialChartId.setBackgroundColor(Color.valueOf("#333333"));
        //serialChartId.setStartDuration(0.2);

    }
}