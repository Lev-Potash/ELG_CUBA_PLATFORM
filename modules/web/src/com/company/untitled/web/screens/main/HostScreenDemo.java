package com.company.untitled.web.screens.main;

import com.company.untitled.entity.ChartEnum;
import com.company.untitled.web.screens.chart_widgets.SerialChartWidget3;
import com.company.untitled.web.screens.chart_widgets.SerialChartWidget4;
import com.company.untitled.web.screens.pie_chart.PieChartFragment;
import com.company.untitled.web.screens.radar_chart.RadarChartFragments;
import com.company.untitled.web.screens.test_fragment.TestFragment;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
//import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.reports.entity.charts.ChartType;

import javax.inject.Inject;
import java.util.Collection;

@UiController("untitled_HostScreenDemo")
@UiDescriptor("host-screen-demo.xml")
public class HostScreenDemo extends Screen implements ChartsFragments<ScreenFragment> {
    @Inject
    private Fragments fragments;

    @Inject
    private GroupBoxLayout serialChartBox1;

   /* @Inject
    private GroupBoxLayout serialChartBox2;

    @Inject
    private GroupBoxLayout pieChartBox;

    @Inject
    private GroupBoxLayout radarChartBox;*/

    @Inject
    private LookupField/*<ChartEnum>*/ lookup;
    @Inject
    private InstanceContainer<com.company.untitled.entity.ChartType> chartDc;


    //@Inject
    //private GroupBoxLayout addressBox;

    @Subscribe
    private void onInit(InitEvent event) {

        




       /* TestFragment testSerialChartFragment = fragments.create(this, TestFragment.class);
        //serialChartFragment.setSerialChart();
        serialChartBox1.add(testSerialChartFragment.getFragment());*/

        /*SerialChartWidget3 serialChartFragment = fragments.create(this, SerialChartWidget3.class);
        //serialChartFragment.setSerialChart();
        serialChartBox2.add(serialChartFragment.getFragment());*/

        /*PieChartFragment pieChartFragment = fragments.create(this, PieChartFragment.class);
        //serialChartFragment.setSerialChart();
        pieChartBox.add(pieChartFragment.getFragment());*/

        /*RadarChartFragments radarChartFragment = fragments.create(this, RadarChartFragments.class);
        //serialChartFragment.setSerialChart();
        radarChartBox.add(radarChartFragment.getFragment());*/



        //SerialChartWidget3 serialChartFragment = fragments.create(this, SerialChartWidget3.class);
        //serialChartFragment.setSerialChart();
        //serialChartBox.add(serialChartFragment.getFragment());

        /*AddressFragment addressFragment = fragments.create(this, AddressFragment.class);
        addressBox.add(addressFragment.getFragment());*/

    }

/*    @Install(to = "lookup", subject = "lookupSelectHandler")
    private void lookupLookupSelectHandler(Collection collection) {

    }

    public LookupField<ChartEnum> getLookup() {
        return (LookupField<ChartEnum>) lookup;
    }*/

    @Subscribe("lookup")
    public void onLookupValueChange(HasValue.ValueChangeEvent<ChartType> event) {
        // Получаем значение из выбранного элемента в LookupField
        String s = String.valueOf(event.getComponent().getValue());

        /*if (s.equals("SERIAL_CHART")) {
            TestFragment testSerialChartFragment = fragments.create(this, TestFragment.class);
            //serialChartFragment.setSerialChart();
            serialChartBox1.add(testSerialChartFragment.getFragment());

        }*/

        switch (s) {
            case "SERIAL_CHART":
                /*TestFragment testSerialChartFragment = fragments.create(this, TestFragment.class);
                //serialChartFragment.setSerialChart();
                serialChartBox1.add(testSerialChartFragment.getFragment());
                SerialChartWidget3 serialChartFragment = fragments.create(this, SerialChartWidget3.class);
                //serialChartFragment.setSerialChart();
                serialChartBox2.add(serialChartFragment.getFragment());*/
                paintChart(fragments, TestFragment.class, serialChartBox1);
                break;
            case "PIE_CHART":
                paintChart(fragments, PieChartFragment.class, serialChartBox1);
                /*PieChartFragment pieChartFragment = fragments.create(this, PieChartFragment.class);
                //serialChartFragment.setSerialChart();
                pieChartBox.add(pieChartFragment.getFragment());*/
                break;
            case "RADAR_CHART":
                paintChart(fragments, RadarChartFragments.class, serialChartBox1);
                /*RadarChartFragments radarChartFragment = fragments.create(this, RadarChartFragments.class);
                //serialChartFragment.setSerialChart();
                radarChartBox.add(radarChartFragment.getFragment());*/
                break;
            default:
                break;
        }



        //lookup.getNewOptionHandler();
        //lookup.addValueChangeListener(event.getComponent())*/

    }

    @Override
    public ScreenFragment paintChart(Fragments fragments, Class<? extends ScreenFragment> clazz, GroupBoxLayout groupBoxLayout) {
        ScreenFragment chartFragment = fragments.create(this, clazz);
        groupBoxLayout.removeAll();
        groupBoxLayout.add(chartFragment.getFragment());
        return null;
    }






    /*@Subscribe
    public void onBeforeShow(BeforeShowEvent event) {


    }*/
    
    




}