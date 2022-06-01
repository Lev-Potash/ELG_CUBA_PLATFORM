package com.company.untitled.web.screens.main;

import com.company.untitled.web.screens.funnel_3d_fragment.Funnel3dChartFragment;
import com.company.untitled.web.screens.pie_chart.PieChartFragment;
import com.company.untitled.web.screens.radar_chart.RadarChartFragments;
import com.company.untitled.web.screens.test_fragment.TestFragment;
import com.company.untitled.web.screens.xy_chart.XychartFragment;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import org.springframework.stereotype.Service;

//import javax.inject.Inject;

@Service(ChartsFragments.NAME)
public class ChartFragmentsImpl implements ChartsFragments {

    private static ChartFragmentsImpl instance;
    public static ChartFragmentsImpl getInstance() { // #3
        if(instance == null) {		//если объект еще не создан
            instance = new ChartFragmentsImpl();	//создать новый объект
        }
        return instance;		// вернуть ранее созданный объект
    }

    @Override
    public void paintChart(Fragments fragments, Class<? extends ScreenFragment> clazz,
                           GroupBoxLayout groupBoxLayout, Screen parent) {
        ScreenFragment chartFragment = fragments.create(parent, clazz);
        groupBoxLayout.removeAll();
        groupBoxLayout.focusFirstComponent();
        groupBoxLayout.setCollapsable(true);
        groupBoxLayout.setExpanded(true);
        groupBoxLayout.setHeightFull();
        groupBoxLayout.setResponsive(true);
        groupBoxLayout.setSizeFull();
        groupBoxLayout.setWidthFull();
        //groupBoxLayout.resetExpanded();
        groupBoxLayout.add(chartFragment.getFragment());
    }

    @Override
    public void printChart(String s, Fragments fragments, GroupBoxLayout serialChartBox1, Screen parent) {
        switch (s) {
            case "SERIAL_CHART":

                //ChartsFragments.paintChart(fragments, TestFragment.class, serialChartBox1, parent);
                paintSerialChart(fragments, serialChartBox1, parent);
                break;
            case "PIE_CHART":
                //ChartsFragments.paintChart(fragments, PieChartFragment.class, serialChartBox1, parent);
                paintPieChart(fragments, serialChartBox1, parent);

                break;
            case "RADAR_CHART":
                //ChartsFragments.paintChart(fragments, RadarChartFragments.class, serialChartBox1, parent);
                paintRadarChart(fragments, serialChartBox1, parent);

                break;

            case "FUNNEL_CHART":
                //ChartsFragments.paintChart(fragments, RadarChartFragments.class, serialChartBox1, parent);
                paintFunnelChart(fragments, serialChartBox1, parent);
                break;

            case "XY_CHART":
                //ChartsFragments.paintChart(fragments, RadarChartFragments.class, serialChartBox1, parent);
                paintXYChart(fragments, serialChartBox1, parent);
                break;

            default:
                cleanChart(serialChartBox1);
                break;
        }
    }

    @Override
    public void paintSerialChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent) {
        TestFragment testSerialChartFragment = fragments.create(parent, TestFragment.class);
        setGroupBoxLayout(groupBoxLayout);
        groupBoxLayout.add(testSerialChartFragment.getFragment());
    }

    @Override
    public void paintPieChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent) {
        PieChartFragment pieChartFragment = fragments.create(parent, PieChartFragment.class);
        setGroupBoxLayout(groupBoxLayout);
        groupBoxLayout.add(pieChartFragment.getFragment());

    }

    @Override
    public void paintRadarChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent) {
        RadarChartFragments radarChartFragment = fragments.create(parent, RadarChartFragments.class);
        setGroupBoxLayout(groupBoxLayout);
        groupBoxLayout.add(radarChartFragment.getFragment());

    }

    @Override
    public void paintFunnelChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent) {
        Funnel3dChartFragment funnelChartFragment = fragments.create(parent, Funnel3dChartFragment.class);
        setGroupBoxLayout(groupBoxLayout);
        groupBoxLayout.add(funnelChartFragment.getFragment());

    }

    @Override
    public void paintXYChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent) {
        XychartFragment xyChartFragment = fragments.create(parent, XychartFragment.class);
        setGroupBoxLayout(groupBoxLayout);
        groupBoxLayout.add(xyChartFragment.getFragment());

    }

    @Override
    public void setGroupBoxLayout(GroupBoxLayout groupBoxLayout) {
        groupBoxLayout.removeAll();
        groupBoxLayout.focusFirstComponent();
        groupBoxLayout.setCollapsable(true);
        groupBoxLayout.setExpanded(true);
        groupBoxLayout.setHeightFull();
        groupBoxLayout.setResponsive(true);
        groupBoxLayout.setSizeFull();
        groupBoxLayout.setWidthFull();

    }

    @Override
    public void cleanChart(GroupBoxLayout groupBoxLayout) {
        groupBoxLayout.removeAll();
    }

}
