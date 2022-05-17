package com.company.untitled.web.screens.radar_chart;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.components.charts.RadarChart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@UiController("untitled_RadarChartFragments")
@UiDescriptor("radar-chart-fragments.xml")
@DashboardWidget(name = "RadarChartFragments")
@LoadDataBeforeShow
public class RadarChartFragments extends ScreenFragment {

    @Inject
    private CollectionContainer<Product> productDc;

    @Inject
    private CollectionLoader<Product> productDl;

    @Inject
    private RadarChart radarChartId;

    @Subscribe
    public void onInit(InitEvent event) {
        radarChartId.setDataProvider(new ContainerDataProvider(productDc));
        List<String> fields = Arrays.asList("last_name", "email");
        radarChartId.setAdditionalFields(fields);

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        productDl.load();
    }


}