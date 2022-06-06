package com.company.untitled.web.screens.funnel_3d_fragment;

import com.company.untitled.entity.Product;
//import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.amcharts.model.Export;
import com.haulmont.charts.gui.amcharts.model.LabelPosition;
import com.haulmont.charts.gui.components.charts.FunnelChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("untitled_Funnel3dChartFragment")
@UiDescriptor("funnel-3d-chart-fragment.xml")
@DashboardWidget(name = "Funnel3dChartFragment")
@LoadDataBeforeShow
public class Funnel3dChartFragment extends ScreenFragment {
    @Inject
    FunnelChart funnelChartId;
    /*@Inject
    private CollectionContainer<Product> productDc;
    @Inject
    private CollectionLoader<Product> productDl;*/

    @Subscribe
    public void onInit(InitEvent event) {
        //productDl.load();
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(transportCount(1994, /*1587, 650,*/ 121));
        dataProvider.addItem(transportCount(1995, /*1567, 683,*/ 146));
        dataProvider.addItem(transportCount(1996, /*1617, 691,*/ 138));
       /* dataProvider.addItem(transportCount(1997, 1630, 642, 127));
        dataProvider.addItem(transportCount(1998, 1660, 699, 105));
        dataProvider.addItem(transportCount(1999, 1683, 721, 109));
        dataProvider.addItem(transportCount(2000, 1691, 737, 112));
        dataProvider.addItem(transportCount(2001, 1298, 680, 101));
        dataProvider.addItem(transportCount(2002, 1275, 664, 97));
        dataProvider.addItem(transportCount(2003, 1246, 648, 93));
        dataProvider.addItem(transportCount(2004, 1318, 697, 111));
        dataProvider.addItem(transportCount(2005, 1213, 633, 87));
        dataProvider.addItem(transportCount(2006, 1199, 621, 79));
        dataProvider.addItem(transportCount(2007, 1110, 210, 81));
        dataProvider.addItem(transportCount(2008, 1165, 232, 75));
        dataProvider.addItem(transportCount(2009, 1145, 219, 88));
        dataProvider.addItem(transportCount(2010, 1163, 201, 82));
        dataProvider.addItem(transportCount(2011, 1180, 285, 87));
        dataProvider.addItem(transportCount(2012, 1159, 277, 71));*/

        funnelChartId.setDataProvider(dataProvider);

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
/*       ListDataProvider dataProvider = new ListDataProvider();


    dataProvider.addItem(new MapDataItem(
            ImmutableMap.of("cost", 3, "name", "Sam")));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("cost", 2, "name", "Bob")));
    dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("cost", 1, "name", "Jack")));
        funnelChartId.setDataProvider(dataProvider);*/
/*

        ListDataProvider dataProvider = new ListDataProvider();
        MapDataItem item = new MapDataItem();
        item.add("name", "Jack");
        item.add("cost", 1);
        item.add("name", "Bob");
        item.add("cost", 2);
        item.add("name", "Sam");
        item.add("cost", 3);

        dataProvider.addItem(item);
        */
/*dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("value", 75, "description", "Sky")));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("value", 7, "description", "Shady side of pyramid")));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("value", 18, "description", "Sunny side of pyramid")));*/


//        funnelChartId.setDataProvider(dataProvider);
//        funnelChartId.setHeight("100%");
//        funnelChartId.setWidth("100%");
        funnelChartId.setAngle(40)
                    .setDepth3D(100)
                    .setLabelPosition(LabelPosition.RIGHT)
                    .setMarginLeft(50)
                    .setMarginRight(240)
                    .setOutlineAlpha((double) 1)
                    .setOutlineColor(Color.valueOf("#FFFFFF"))
                    .setOutlineThickness(2)
                    .setStartX(-500)
                    .setTitleField("year")
                    .setValueField("bicycles");
                    /*.setTitleField("name")
                    .setValueField("cost");*/

        //funnelChartId.setBalloonText("[[title]]: [[value]]");
        funnelChartId.setExport(new Export());

//        funnelChartId.repaint();


    }

    private DataItem transportCount(int year, /*int cars, int motorcycles,*/ int bicycles) {
        MapDataItem item = new MapDataItem();
        item.add("year", year);
        /*item.add("cars", cars);
        item.add("motorcycles", motorcycles);*/
        item.add("bicycles", bicycles);
        return item;
    }

            /*<chart:data>
                <chart:item>
                    <chart:property name="name" value="Jack"/>
                    <chart:property name="cost" value="1" type="int"/>
                </chart:item>
                <chart:item>
                    <chart:property name="name" value="Bob"/>
                    <chart:property name="cost" value="2" type="int"/>
                </chart:item>
                <chart:item>
                    <chart:property name="name" value="Sam"/>
                    <chart:property name="cost" value="3" type="int"/>
                </chart:item>
            </chart:data>*/

}