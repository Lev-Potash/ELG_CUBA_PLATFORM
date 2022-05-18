package com.company.untitled.web.screens.pie_chart;

//import com.company.untitled.entity.Customer2;
import com.company.untitled.entity.Product;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.charts.gui.data.ContainerDataProvider;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static com.haulmont.charts.gui.amcharts.model.LegendPosition.RIGHT;

@UiController("untitled_PieChartFragment")
@UiDescriptor("pie-chart-fragment.xml")
@DashboardWidget(name = "PieChart")
@LoadDataBeforeShow
public class PieChartFragment extends ScreenFragment {

    @Inject
    private CollectionContainer<Product> productDc;
    
    @Inject
    private CollectionLoader<Product> productDl;
    
    @Inject
    private PieChart pieChartId;

    @Subscribe
    public void onInit(InitEvent event) {
        pieChartId.setDataProvider(new ContainerDataProvider(productDc));

        //pieChartId.setCategoryField("first_name");
        List<String> fields = Arrays.asList("name");

        pieChartId.setTitleField("name")
                    .setValueField("cost")
                    .addTitles(new Title()
                            .setBold(true)
                            .setSize(18)
                            .setColor(Color.valueOf("GRAY"))
                            .setText("Цены на продукты")
        );
                    //setCaption("Цены на продукты");
                    //.setDataContainer("customerDC")
                    //.setHeight("100%")


        pieChartId.setWidth("100%");
        pieChartId.setHeight("100%");
        pieChartId.setAlignment(Component.Alignment.valueOf("MIDDLE_LEFT"));

        pieChartId.setLegend(new Legend()
                                        .setAutoMargins(true)
                                        .setMarginBottom(20)
                                        .setMarginRight(100)
                                        .setMarkerType(MarkerType.valueOf("CIRCLE"))
                                        .setPosition(RIGHT)
                                        .setValueText("[[value]] ч.")
        )
                .setExport(new Export());

        pieChartId.setAdditionalFields(fields);

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        productDl.load();


    }


}