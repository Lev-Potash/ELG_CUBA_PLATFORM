package com.company.untitled.web.screens.chart_widgets;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Layout;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static com.haulmont.charts.gui.amcharts.model.Position.LEFT;

@UiController("untitled_SerialChartWidget3")
@UiDescriptor("serial-chart-widget3.xml")
@DashboardWidget(name = "SerialChartWidget3")
@LoadDataBeforeShow
public class SerialChartWidget3 extends ScreenFragment {
    @Inject
    private CollectionContainer<Product> productDc;

    @Inject
    private CollectionLoader<Product> productDl;

    @Inject
    private SerialChart serialChartId;

    /*@Subscribe(target = Target.PARENT_CONTROLLER)
    private void onBeforeShowHost(Screen.BeforeShowEvent event) {
        productDl.load();
    }*/
    /*@Inject
    CssLayout layout;*/

    @Subscribe
    public void onInit(InitEvent event) {
        productDl.load();

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        //setSerialChart();

        serialChartId.setDataProvider(new ContainerDataProvider(productDc));
        //serialChartId.setCategoryField("name");
        List<String> values = Arrays.asList("id");

        serialChartId.setAdditionalFields(values)
                .setAddClassNames(Boolean.valueOf("true"))
                .setAutoMargins(Boolean.valueOf("false"))
                .setCategoryField("name")
                .setMarginBottom(26)
                .setMarginLeft(35)
                .setMarginRight(8)
                .setMarginTop(10)
                .setStartDuration((double) 1)
                .setColumnSpacing(20)
                .setColumnSpacing3D(30)
                .setAngle(-30)
                .setTheme(ChartTheme.valueOf("LIGHT"));
        serialChartId.setWidth("100%");
        serialChartId.setHeight("100%");

        //List<ValueAxis> valuesAxes = List<ValueAxis> Arrays.asList("0", "LEFT");
        /*serialChartId.addValueAxes(new ValueAxis()
                .setPosition(LEFT)
                .setAxisAlpha((double) 0)
        );*/

        serialChartId.setBalloon(new Balloon()
                .setAdjustBorderColor(Boolean.valueOf("false"))
                .setColor(Color.valueOf("WHITE"))
                .setHorizontalPadding(10)
                .setVerticalPadding(8));
        serialChartId.addGraphs(new Graph()
                        .setBalloonText("[[title]] in [[category]]:[[value]]")
                        .setFillAlphas((double) 1)
                        .setTitle("Цена")
                        .setType(GraphType.valueOf("COLUMN"))
                        .setValueField("cost"),
                new Graph().setBalloon(new Balloon()
                        .setFontSize(12)
                        .setShadowAlpha(0.7)
                        .setShadowColor(Color.valueOf("GREEN"))
                )
                        .setBalloonText("[[title]] in [[category]] [[value]]")
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
        /*serialChartId.setCategoryAxis(new CategoryAxis()
                .setAxisAlpha((double) 0)
                .setGridPosition(GridPosition.valueOf("START"))
                .setTickLength(0)

        );*/
/*        serialChartId.addTitles(new Title()
                .setBold(true)
                .setColor(Color.valueOf("BLUE"))
                .setSize(20)
                .setTabIndex(0)
                .setText("Стоимость товара")

        );*/

        serialChartId.setExport(new Export());


        serialChartId.repaint();













//                .startDuration("1")
//                .theme("LIGHT")
//
//                .setDataProvider(new ContainerDataProvider(productDc))
//        .setDataContainer("productDc")


        /*.setMarginBottom("26")
        .marginLeft("30")
        .marginRight("8")
        .marginTop("10")
        .startDuration("1")
        .theme("LIGHT")
        .width("100%");*/


        /*
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
                .setDataProvider(dataProvider);
                */

    }

//    public void setSerialChart() {
//
//        serialChartId.setDataProvider(new ContainerDataProvider(productDc));
//        serialChartId.setCategoryField("name");
//        List<String> values = Arrays.asList("id");
//        serialChartId.setAdditionalFields(values)
//                .setAddClassNames(Boolean.valueOf("true"))
//                .setAutoMargins(Boolean.valueOf("false"))
//                .setCategoryField("name")
//                .setMarginBottom(26)
//                .setMarginLeft(35)
//                .setMarginRight(8)
//                .setMarginTop(10)
//                .setStartDuration((double) 1)
//                .setTheme(ChartTheme.valueOf("LIGHT"));
//        serialChartId.setWidth("100%");
//        serialChartId.setHeight("100%");
//        //List<ValueAxis> valuesAxes = List<ValueAxis> Arrays.asList("0", "LEFT");
//        serialChartId.addValueAxes(new ValueAxis()
//                .setPosition(LEFT)
//                .setAxisAlpha((double) 0)
//        );
//
//        serialChartId.setBalloon(new Balloon()
//                .setAdjustBorderColor(Boolean.valueOf("false"))
//                .setColor(Color.valueOf("WHITE"))
//                .setHorizontalPadding(10)
//                .setVerticalPadding(8));
//        serialChartId.addGraphs(new Graph()
//                        .setBalloonText("&lt;span style='font-size:12px;'&gt;[[title]] in [[category]]:&lt;br&gt;&lt;span style='font-size:20px;'&gt;[[value]]&lt;/span&gt; [[additional]]&lt;/span&gt;")
//                        .setFillAlphas((double) 1)
//                        .setTitle("Цена")
//                        .setType(GraphType.valueOf("COLUMN"))
//                        .setValueField("cost"),
//                new Graph()
//                        .setBalloonText("&lt;span style='font-size:12px;'&gt;[[title]] in [[category]]:&lt;br&gt;" +
//                                "&lt;span style='font-size:20px;'&gt;[[value]]&lt;/span&gt; [[additional]]&lt;/span&gt;")
//                        .setBullet(BulletType.valueOf("ROUND"))
//                        .setBulletBorderAlpha((double) 1)
//                        .setBulletBorderThickness(3)
//                        .setBulletColor(Color.valueOf("WHITE"))
//                        .setBulletSize(7)
//                        .setFillAlphas((double) 0)
//                        .setLineAlpha((double) 1)
//                        .setLineThickness(3)
//                        .setTitle("cost")
//                        .setUseLineColorForBulletBorder(true)
//                        .setValueField("cost")
//        );
//        serialChartId.setCategoryAxis(new CategoryAxis()
//                .setAxisAlpha((double) 0)
//                .setGridPosition(GridPosition.valueOf("START"))
//                .setTickLength(0)
//
//        );
//        serialChartId.setExport(new Export());
//
//    }


}