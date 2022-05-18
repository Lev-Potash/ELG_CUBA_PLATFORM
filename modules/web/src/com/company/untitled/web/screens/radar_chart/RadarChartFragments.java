package com.company.untitled.web.screens.radar_chart;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
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

        radarChartId.setCategoryField("first_name")
                    .setStartDuration((double) 2)
                    .setTheme(ChartTheme.valueOf("PATTERNS"))
                    .setBorderColor(Color.valueOf("GOLD"));

        radarChartId.setWidth("100%");
        radarChartId.setHeight("100%");

        radarChartId.addValueAxes(new ValueAxis()
                                    .setAutoGridCount(false)
                                    .setAxisAlpha(0.2)
                                    .setFillAlpha(0.05)
                                    .setFillColor(Color.valueOf("WHITE"))
                                    .setGridAlpha(0.08)
                                    .setGridType(GridType.valueOf("CIRCLES"))
                                    .setMinimum((double) 0)
                                    .setPosition(Position.valueOf("LEFT"))

        );

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        productDl.load();
    }


}