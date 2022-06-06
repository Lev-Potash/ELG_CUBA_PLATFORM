package com.company.untitled.web.screens.column_3d_chart;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.addon.dashboard.web.events.DashboardEvent;
import com.haulmont.addon.dashboard.web.widget.RefreshableWidget;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("untitled_Column3dChartFragment")
@UiDescriptor("column-3d-chart-fragment.xml")
@DashboardWidget(name = "Column3dChartFragment")
@LoadDataBeforeShow
public class Column3dChartFragment extends ScreenFragment implements RefreshableWidget {
    @Inject
    private SerialChart column3d;

    @Subscribe
    public void onInit(InitEvent event) {
        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(countryGrowth("China", 9.9, 10.1));
        dataProvider.addItem(countryGrowth("Canada", 2.8, 2.9));
        dataProvider.addItem(countryGrowth("Brazil", 2.6, 4.9));
        dataProvider.addItem(countryGrowth("France", 1.4, 2.1));
        dataProvider.addItem(countryGrowth("USA", 3.5, 4.2));
        dataProvider.addItem(countryGrowth("Россия", 6.4, 7.2));
        dataProvider.addItem(countryGrowth("Japan", 2.6, 2.3));
        dataProvider.addItem(countryGrowth("India", 8, 7.1));
        dataProvider.addItem(countryGrowth("UK", 1.7, 3.1));

        column3d.setDataProvider(dataProvider);

    }

    private DataItem countryGrowth(String country, double year2014, double year2015) {
        MapDataItem item = new MapDataItem();
        item.add("country", country);
        item.add("year2014", year2014);
        item.add("year2015", year2015);
        /*item.add("bicycles", bicycles);*/
        return item;
    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {

    }

    @Override
    public void refresh(DashboardEvent dashboardEvent) {

    }
}