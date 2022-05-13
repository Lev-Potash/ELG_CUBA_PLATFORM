package com.company.untitled.web.chart_widgets;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
//import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("untitled_SerialChartWidget")
@UiDescriptor("serial-chart-widget.xml")
@DashboardWidget(name = "SerialChartWidget")
@LoadDataBeforeShow
public class SerialChartWidget extends ScreenFragment {

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





    /*@Inject
    private CollectionContainer<TransportCount> transportCountsDc;

    @Inject
    private SerialChartWidget stackedArea;

    @Subscribe
    private void onInit(InitEvent event) {
        stackedArea.setDataProvider(new ContainerDataProvider(transportCountsDc));
        stackedArea.setCategoryField("year");
    }*/


    /*@Inject
    private PieChart chart;

    @Subscribe
    protected void onInit(InitEvent event) {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("value", 75, "description", "Sky")));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("value", 7, "description", "Shady side of pyramid")));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("value", 18, "description", "Sunny side of pyramid")));

        chart.setDataProvider(dataProvider);*/

    /*@Inject
    PieChart pieChart;

    pieChart.setWidth("700px");
    pieChart.setTitleField("description")
        .setValueField("value")
        .setStartAngle(312)
        .setLegend(new Legend()
                .setMarkerType(MarkerType.CIRCLE)
                .setPosition(LegendPosition.RIGHT)
                .setMarginRight(80))
            .addLabels(
                new Label()
                    .setText("Sample Chart")
                    .setSize(26)
                    .setBold(true)
                    .setAlign(Align.CENTER),
                new Label()
                    .setText("extra information")
                    .setAlign(Align.RIGHT))
            .setLabelTickColor(Color.GOLDENROD)
        .setColors(Arrays.asList(
            Color.valueOf("#446493"),
                    Color.valueOf("#5E3D2C"),
                            Color.valueOf("#D0A557")))
                            .setDataProvider(dataProvider);*/
}