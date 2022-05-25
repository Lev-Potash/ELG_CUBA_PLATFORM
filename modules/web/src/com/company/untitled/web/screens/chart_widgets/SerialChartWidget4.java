package com.company.untitled.web.screens.chart_widgets;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;

import static com.haulmont.charts.gui.amcharts.model.Position.LEFT;

@UiController("untitled_SerialChartWidget4")
@UiDescriptor("serial-chart-widget4.xml")
@DashboardWidget(name = "SerialChartWidget4")
@LoadDataBeforeShow
public class SerialChartWidget4 extends ScreenFragment {

    @Inject
    private CollectionContainer<Product> productDc;

    @Inject
    private CollectionLoader<Product> productDl;

    @Inject
    private SerialChart serialChartId;

    @Subscribe
    public void onInit(InitEvent event) {

        productDl.load();




        /*for (Product p : productDc.getItems()) {

        }*/
    }



    @Subscribe
    private void onAfterInit(AfterInitEvent event) {
        serialChartId.setDataProvider(new ContainerDataProvider(productDc));
        serialChartId.setCategoryField("name");
        //serialChartId.setGraphs().

        //serialChartId.setBackgroundColor(Color.valueOf("#333333"));
        //serialChartId.setStartDuration(0.2);

        serialChartId.setDataProvider(new ContainerDataProvider(productDc));
        serialChartId.setCategoryField("name");
        List<String> values = Arrays.asList("id");

        serialChartId.setAdditionalFields(values)
                .setAddClassNames(Boolean.valueOf("true"))
                .setAutoMargins(Boolean.valueOf("false"))
                .setCategoryField("name")
                .setMarginBottom(26)
                .setMarginLeft(35)
                .setMarginRight(8)
                .setMarginTop(10)
                .setColumnSpacing(20)
                .setStartDuration((double) 1)
                .setTheme(ChartTheme.valueOf("LIGHT"))
                .setColumnSpacing3D(10);
        serialChartId.setWidth("100%");
        serialChartId.setHeight("100%");
        //List<ValueAxis> valuesAxes = List<ValueAxis> Arrays.asList("0", "LEFT");
        serialChartId.addValueAxes(new ValueAxis()
                .setPosition(LEFT)
                .setAxisAlpha((double) 0)
        );

        serialChartId.setBalloon(new Balloon()
                .setAdjustBorderColor(Boolean.valueOf("false"))
                .setColor(Color.valueOf("WHITE"))
                .setHorizontalPadding(10)
                .setVerticalPadding(8));



        serialChartId.addGraphs(new Graph()
                        .setId("g1")
                        .setNegativeLineColor(Color.valueOf("CORAL"))
                        .setBalloonText("&lt;span style='font-size:12px;'&gt;[[title]] in [[category]]:&lt;br&gt;&lt;span style='font-size:20px;'&gt;[[value]]&lt;/span&gt; [[additional]]&lt;/span&gt;")
                        .setFillAlphas((double) 1)
                        .setTitle("Цена")
                        .setType(GraphType.valueOf("COLUMN"))
                        .setValueField("cost"),
                new Graph().setBalloon(new Balloon()
                        .setFontSize(20)
                        .setShadowAlpha(0.7)
                        .setShadowColor(Color.valueOf("GREEN")).setTextAlign(Align.valueOf("CENTER"))
                )
                        .setBalloonText("[[title]] in [[category]] \n" +
                                "[[value]] [[additional]]")
                        .setBullet(BulletType.valueOf("ROUND"))
                        .setBulletBorderAlpha((double) 1)
                        .setBulletBorderThickness(3)
                        .setBulletColor(Color.valueOf("WHITE"))
                        .setBulletSize(7)
                        .setFillAlphas((double) 0)
                        .setLineAlpha((double) 1)
                        .setLineThickness(3)
                        .setTitle("cost")
                        .setUseLineColorForBulletBorder(true)
                        .setValueField("cost")
        );


        serialChartId.setCategoryAxis(new CategoryAxis()
                .setAxisColor(Color.valueOf("#DADADA"))
                .setAxisAlpha((double) 0)
                .setGridPosition(GridPosition.valueOf("START"))
                .setTickLength(0)

        );
        serialChartId.setBalloon(new Balloon()
                .setAdjustBorderColor(false)
                .setColor(Color.valueOf("WHITE"))
                .setHorizontalPadding(10)
                .setVerticalPadding(8)
        );
        serialChartId.addTitles(new Title()
                .setBold(true)
                .setColor(Color.valueOf("DARKSLATEGREY"))
                .setSize(20)
                .setTabIndex(0)
                .setText("Стоимость товара")

        );

        serialChartId.setChartCursor(new Cursor()
                .setCursorAlpha(0.8)
                .setCursorColor(Color.valueOf("BROWN"))
                .setCursorPosition(CursorPosition.valueOf("MIDDLE"))
                .setLimitToGraph("g1")
                .setPan(true)
                .setValueLineAlpha(0.8)
                .setValueLineBalloonEnabled(true)
                .setValueLineEnabled(true)
                .setValueZoomable(true)
        );

        serialChartId.setLegend(new Legend()
                .setAutoMargins(true)
                .setMarginBottom(20)
                .setMarkerType(MarkerType.valueOf("CIRCLE"))
                .setPosition(LegendPosition.valueOf("BOTTOM"))
                .setAlign(Align.valueOf("LEFT"))

        );
        //serialChartId.repaint();
        serialChartId.setExport(new Export());


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