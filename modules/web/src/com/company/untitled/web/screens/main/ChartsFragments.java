package com.company.untitled.web.screens.main;

import com.company.untitled.web.screens.pie_chart.PieChartFragment;
import com.company.untitled.web.screens.radar_chart.RadarChartFragments;
import com.company.untitled.web.screens.test_fragment.TestFragment;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.ScreenFragment;

public interface ChartsFragments {

    final static String NAME = "untitled_ChartsFragments";

    /*static*/ void paintChart(Fragments fragments, Class<? extends ScreenFragment> clazz,
                           GroupBoxLayout groupBoxLayout, Screen parent); /*{
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
    }*/

  /*default*/ void printChart(String s, Fragments fragments, GroupBoxLayout serialChartBox1, Screen parent); /*{
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
          default:
              cleanChart(serialChartBox1);
              break;
      }
   }*/

   /*default*/ void paintSerialChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent); /*{
       TestFragment testSerialChartFragment = fragments.create(parent, TestFragment.class);
       setGroupBoxLayout(groupBoxLayout);
       groupBoxLayout.add(testSerialChartFragment.getFragment());
   };*/
   /*default*/ void paintPieChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent); /*{
       PieChartFragment pieChartFragment = fragments.create(parent, PieChartFragment.class);
       setGroupBoxLayout(groupBoxLayout);
       groupBoxLayout.add(pieChartFragment.getFragment());

   };*/

   /*default*/ void paintRadarChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent);/* {
       RadarChartFragments radarChartFragment = fragments.create(parent, RadarChartFragments.class);
       setGroupBoxLayout(groupBoxLayout);
       groupBoxLayout.add(radarChartFragment.getFragment());

   };*/

    void paintFunnelChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent);

    void paintXYChart(Fragments fragments, GroupBoxLayout groupBoxLayout, Screen parent);

   /*default*/ void setGroupBoxLayout(GroupBoxLayout groupBoxLayout); /*{
       groupBoxLayout.removeAll();
       groupBoxLayout.focusFirstComponent();
       groupBoxLayout.setCollapsable(true);
       groupBoxLayout.setExpanded(true);
       groupBoxLayout.setHeightFull();
       groupBoxLayout.setResponsive(true);
       groupBoxLayout.setSizeFull();
       groupBoxLayout.setWidthFull();

   }*/

   /*default*/ void cleanChart(GroupBoxLayout groupBoxLayout);/* {
       groupBoxLayout.removeAll();
   }*/


}
