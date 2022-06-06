package com.company.untitled.web.screens.xy_chart;

import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.XYChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("untitled_XychartFragment")
@UiDescriptor("XYChart-fragment.xml")
@DashboardWidget(name = "XYChart")
@LoadDataBeforeShow
public class XychartFragment extends ScreenFragment {
    /*@Inject
    private CollectionContainer<Product> productDc;
    @Inject
    private CollectionLoader<Product> productDl;*/
    @Inject
    private XYChart xyChart;

    @Subscribe
    public void onInit(InitEvent event) {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(xyTrendLine(1, 1, 1, 2));
        dataProvider.addItem(xyTrendLine(2, 2, 2, 4));
        dataProvider.addItem(xyTrendLine(3, 5, 3, 1));
        dataProvider.addItem(xyTrendLine(4, 5, 4, 1));
        dataProvider.addItem(xyTrendLine(5, 7, 5, 10));
        dataProvider.addItem(xyTrendLine(6, 9, 6, 11));
//        MapDataItem item = new MapDataItem();
//        item.add("name", "genry");
//        item.add("cost",70 );

        /*<chart:data>
                <chart:item>
                    <chart:property name="ax" value="1" type="double"/>
                    <chart:property name="ay" value="1" type="double"/>
                    <chart:property name="bx" value="1" type="double"/>
                    <chart:property name="by" value="2" type="double"/>
                </chart:item>
                <chart:item>
                    <chart:property name="ax" value="2" type="double"/>
                    <chart:property name="ay" value="2" type="double"/>
                    <chart:property name="bx" value="2" type="double"/>
                    <chart:property name="by" value="4" type="double"/>
                </chart:item>
                <chart:item>
                    <chart:property name="ax" value="3" type="double"/>
                    <chart:property name="ay" value="5" type="double"/>
                    <chart:property name="bx" value="3" type="double"/>
                    <chart:property name="by" value="1" type="double"/>
                </chart:item>
                <chart:item>
                    <chart:property name="ax" value="4" type="double"/>
                    <chart:property name="ay" value="5" type="double"/>
                    <chart:property name="bx" value="4" type="double"/>
                    <chart:property name="by" value="1" type="double"/>
                </chart:item>
                <chart:item>
                    <chart:property name="ax" value="5" type="double"/>
                    <chart:property name="ay" value="7" type="double"/>
                    <chart:property name="bx" value="5" type="double"/>
                    <chart:property name="by" value="10" type="double"/>
                </chart:item>
            </chart:data>*/
//        dataProvider.addItem(item);
        xyChart.setDataProvider(dataProvider);

    }

    private DataItem xyTrendLine(double ax, double ay, double bx, double by) {
        MapDataItem item = new MapDataItem();
        item.add("ax", ax);
        item.add("ay", ay);
        item.add("bx", bx);
        item.add("by", by);
        return item;
    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        xyChart.setAutoMarginOffset(20)
                .setMarginBottom(60)
                .setMarginLeft(64)
                .setStartDuration((double)1)
                .setTheme(ChartTheme.valueOf("LIGHT"))
                .setChartCursor(new Cursor())
                .setChartScrollbar(new Scrollbar());
        xyChart.addGraphs(new Graph()
                        .setBalloonText("x:[[x]] y:[[y]]")
                        .setBullet(BulletType.valueOf("TRIANGLE_UP"))
                        .setFillAlphas((double) 0)
                        .setLineAlpha((double) 0)
                        .setLineColor(Color.valueOf("#FF6600"))
                        .setXField("ax")
                        .setYField("ay"),
                new Graph()
                        .setBalloonText("x:[[x]] y:[[y]]")
                        .setBullet(BulletType.valueOf("TRIANGLE_DOWN"))
                        .setFillAlphas((double) 0)
                        .setLineAlpha((double) 0)
                        .setLineColor(Color.valueOf("#FCD202"))
                        .setXField("bx")
                        .setYField("by")
                )
                .addTrendLines(new TrendLine()
                        .setFinalValue((double) 12)
                        .setFinalXValue((double) 12)
                        .setInitialValue((double) 2)
                        .setInitialXValue((double) 1)
                        .setLineColor(Color.valueOf("#FF6600"))
                        ,
                        new TrendLine()
                        .setFinalValue(Double.valueOf("19"))
                        .setFinalXValue(Double.valueOf("12"))
                        .setInitialValue(Double.valueOf("1"))
                        .setInitialXValue(Double.valueOf("1"))
                        .setLineColor(Color.valueOf("#FCD202"))


                )
                .addValueAxes(new ValueAxis()
                        .setAxisAlpha((double) 0)
                        .setDashLength(1)
                        .setPosition(Position.valueOf("BOTTOM"))
                        .setTitle("X Axis")
                        )
                .setExport(new Export());




        /*height="100%"

        width="100%"*/


/*        <chart:xyChart id="xyChart"
        autoMarginOffset="20"

        height="100%"
        marginBottom="60"
        marginLeft="64"
        startDuration="1"
        theme="LIGHT"
        width="100%">*/
/*<!--            width="100%"-->
<!--            height="100%"
        dataContainer="productDc"-->*/
/*            <chart:chartCursor/>
            <chart:chartScrollbar/>
            <chart:graphs>
                <chart:graph balloonText="x:[[x]] y:[[y]]"
        bullet="TRIANGLE_UP"
        fillAlphas="0"
        lineAlpha="0"
        lineColor="#FF6600"
        xField="ax"
        yField="ay"/>
                <chart:graph balloonText="x:[[x]] y:[[y]]"
        bullet="TRIANGLE_DOWN"
        fillAlphas="0"
        lineAlpha="0"
        lineColor="#FCD202"
        xField="bx"
        yField="by"/>
            </chart:graphs>
            <chart:trendLines>
                <!--<chart:trendLine initialValue="1"
        initialXValue="1"
        lineColor="#FCD202"/>-->
                <chart:trendLine finalValue="12"
        finalXValue="12"
        initialValue="2"
        initialXValue="1"
        lineColor="#FF6600"/>
                <chart:trendLine finalValue="19"
        finalXValue="12"
        initialValue="1"
        initialXValue="1"
        lineColor="#FCD202"/>
            </chart:trendLines>*/
/*
            <chart:valueAxes>
                <chart:axis axisAlpha="0"
        dashLength="1"
        position="BOTTOM"
        title="X Axis"/>
                <chart:axis axisAlpha="0"
        dashLength="1"
        position="LEFT"
        title="Y Axis"/>
            </chart:valueAxes>
            <chart:export position="BOTTOM_RIGHT"/>
*/

    }


}