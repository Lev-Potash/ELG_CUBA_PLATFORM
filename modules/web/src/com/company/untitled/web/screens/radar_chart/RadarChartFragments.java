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
        //List<String> fields = Arrays.asList("last_name", "email");
        //radarChartId.setAdditionalFields(fields);

        radarChartId.setCategoryField("name")
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
                .addGuides(new Guide().setAngle(255)
                                .setFillAlpha(0.3)
                                .setFillColor(Color.valueOf("#0066CC"))
                                .setLineAlpha((double) 0)
                                .setTickLength(0)
                                .setToAngle(315)
                                .setToValue(60)
                                .setValue(0),
                        new Guide().setAngle(45)
                                .setFillAlpha(0.3)
                                .setFillColor(Color.valueOf("#CC3333"))
                                .setLineAlpha((double) 0)
                                .setTickLength(0)
                                .setToAngle(135)
                                .setToValue(60)
                                .setValue(0)
                )

        )
        .addGraphs(new Graph().setBalloonText("[[category]] назнаачено [[value]] часов работы")
                                .setTitle("Количество часов")
                                .setBullet(BulletType.valueOf("ROUND"))
                                .setValueField("cost")
        )
        .addTitles(new Title().setAlpha((double) 1)
                                .setBold(true)
                                .setColor(Color.valueOf("DARKSLATEGREY"))
                                .setSize(20)
                                .setTabIndex(0)
                                .setText("График пользователей"),
                    new Title().setAlpha(0.5)
                        .setBold(true)
                        .setColor(Color.valueOf("DARKGREEN"))
                        .setSize(12)
                        .setText("Количество назначенных Пользователю часов")
        )
        .setLegend(new Legend().setAutoMargins(true)
                                .setMarginBottom(20)
                                .setMarginLeft(100)
                                .setMarkerType(MarkerType.valueOf("CIRCLE"))
                                .setPosition(LegendPosition.valueOf("TOP"))
                                .setValueText("[[category]]")
        )
        .setExport(new Export());
        radarChartId.repaint();


    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        productDl.load();
    }


}