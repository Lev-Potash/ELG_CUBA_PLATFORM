package com.company.untitled.web.screens.test_fragment;

//import com.company.untitled.entity.CustomerList;
import com.company.untitled.entity.Product;
import com.google.common.collect.ImmutableMap;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.*;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import org.apache.commons.collections4.MapUtils;

import javax.inject.Inject;
//import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

@UiController("untitled_TestFragment")
@UiDescriptor("test-fragment.xml")
@DashboardWidget(name = "TestFragment")
@LoadDataBeforeShow
public class TestFragment extends ScreenFragment {
    @Inject
    private CollectionContainer<Product> productDc;

    @Inject
    private CollectionLoader<Product> productDl;

    @Inject
    private SerialChart serialChartId;

    @Inject
    Metadata metadata;

    /*@Subscribe(target = Target.PARENT_CONTROLLER)
    private void onBeforeShowHost(Screen.BeforeShowEvent event) {
        productDl.load();
    }*/

    @Subscribe
    public void onInit(InitEvent event) {
        productDl.load();

    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
//        Map<Long, Map<String, Integer>> customerMap = new AbstractMap<Long, Map<String, Integer>>() {
//            @Override
//            public Set<Entry<Long, Map<String, Integer>>> entrySet() {
//
//                return null;
//            }
//        }
        //Map<Customer2, Map<Long, Customer2>> dateAndEmployeesCount
        //setSerialChart();
        //serialChartId.setDe;
        //Map<Integer, Map<Long, String>> dateAndEmployeesCount = new HashMap<>();
        /*Map<String, Integer> customerMap = new HashMap<>();
        customerMap.put("Борис", 12);
        customerMap.put("Илья", 8);
        customerMap.put("Михаил", 40);
        customerMap.put("Денис", 15);*/
        /*Integer i = 1;
        for(Map<Long, String> m :  customerMap){

            dateAndEmployeesCount.put(i, m);
            i++;
        }*/

       /* ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("Борис", 12)));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("Илья", 8)));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("Михаил", 40)));
        dataProvider.addItem(new MapDataItem(
                ImmutableMap.of("Денис", 15)));

        serialChartId.setDataProvider(dataProvider);*/


//        ListDataProvider dataProvider = new ListDataProvider();
//        dataProvider.addItem(new EntityDataItem(
//               customerDescription("Sky", 75)));
//        dataProvider.addItem(new EntityDataItem(
//                (Entity) customerDescription("Shady side of pyramid", 7)));
//        dataProvider.addItem(new EntityDataItem(
//                (Entity) customerDescription("Sunny side of pyramid", 18)));



        ListDataProvider dataProvider = new ListDataProvider();
        MapDataItem item = new MapDataItem();
        item.add("name", "genry");
        item.add("cost",70 );
        /*dataProvider.addItem(new SimpleDataItem(
                new CustomerList("Sky", 75)));
        dataProvider.addItem(new SimpleDataItem(
                new CustomerList("Shady side of pyramid", 7)));
        dataProvider.addItem(new SimpleDataItem(
                new CustomerList("Sunny side of pyramid", 18)));*/
        dataProvider.addItem(item);
        serialChartId.setDataProvider(dataProvider);

        //dateAndEmployeesCount.put()

//serialChartId.setDataProvider(new ContainerDataProvider(customerDc));
        //serialChartId.setCategoryField("first_name");
        //List<String> values = Arrays.asList("last_name", "email");
        serialChartId//.setAdditionalFields(values)
                .setAddClassNames(Boolean.valueOf("true"))
                .setAutoMargins(Boolean.valueOf("false"))
//                .setCategoryField("first_name")
                .setMarginBottom(26)
                .setMarginLeft(35)
                .setMarginRight(8)
                .setMarginTop(10)
                .setStartDuration((double) 1)
                .setTheme(ChartTheme.valueOf("LIGHT"))
                .setColumnSpacing3D(35).setColumnSpacing(20).setBackgroundColor(Color.valueOf("RED")).setAngle(-30);
        serialChartId.setWidth("100%");
        serialChartId.setHeight("100%");
        //List<ValueAxis> valuesAxes = List<ValueAxis> Arrays.asList("0", "LEFT");



/*
        serialChartId.setValueAxes(Collections.singletonList(new ValueAxis()
                .setAxisAlpha((double) 0)));
*/

//        serialChartId.setValueAxes(new ValueAxis()
//                        .setAxisAlpha((double) 0)
//                //.setPosition(LEFT)
//        );

        /*serialChartId.setBalloon(new Balloon()
                .setAdjustBorderColor(Boolean.valueOf("false"))
                .setColor(Color.valueOf("WHITE"))
                .setHorizontalPadding(10)
                .setVerticalPadding(8));*/
        serialChartId.addGraphs(new Graph()
                        //.setBalloonText("&lt;span style='font-size:12px;'&gt;[[title]] in [[category]]:&lt;br&gt;&lt;span style='font-size:20px;'&gt;[[value]]&lt;/span&gt; [[additional]]&lt;/span&gt;")
//                .setBalloonText("[[title]] in [[category]]")
//                .setBalloonText("[[value]] [[additional]]")

                        .setFontSize(40)
                        .setBulletSize(40)
                        .setBalloon(new Balloon().setFontSize(50).setColor(Color.valueOf("RED")).setFillColor(Color.valueOf("BLUE")))
                        .setBalloonText("[[title]] in [[category]]: [[value]]")
                        .setFillAlphas((double) 1)
                        .setTitle("Количество часов")
                        .setType(GraphType.valueOf("COLUMN"))
                        .setValueField("cost")/*,
                new Graph()
                        .setBalloonText("&lt;span style='font-size:12px;'&gt;[[title]] in [[category]]:&lt;br&gt;" +
                                "&lt;span style='font-size:20px;'&gt;[[value]]&lt;/span&gt; [[additional]]&lt;/span&gt;")
                        .setBullet(BulletType.valueOf("ROUND"))
                        .setBulletBorderAlpha((double) 1)
                        .setBulletBorderThickness(3)
                        .setBulletColor(Color.valueOf("WHITE"))
                        .setBulletSize(7)
                        .setFillAlphas((double) 0)
                        .setLineAlpha((double) 1)
                        .setLineThickness(3)
                        .setTitle("count_hours")
                        .setUseLineColorForBulletBorder(true)
                        .setValueField("count_hours")*/
        );
        serialChartId.setCategoryAxis(new CategoryAxis()
                .setAxisAlpha((double) 0)
                .setGridPosition(GridPosition.valueOf("START"))
                .setTickLength(0)




        );
        /*serialChartId.addTitles(new Title()
                .setAlpha((double) 1)
                .setBold(true)
                .setColor(Color.valueOf("DARKSLATEGREY"))
                .setSize(20)
                .setTabIndex(1)
                .setText("График пользователей")
        );*/
        //serialChartId.setExport(new Export());
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





/*    private CustomerList customerDescription(String customerName, Integer count_hours) {
        CustomerList entity = new CustomerList();
        entity.setCustomerName(customerName);
        entity.setCount_hours(count_hours);
        return entity;
    }
*/


    /*private void repaintGraph(Map<Date, Map<Long, List<Long>>> dateAndEmployeesCount) {
        ListDataProvider dataProvider = new ListDataProvider();

        Set<Long> totalCountList = new HashSet<>();
        Map<Long, Set<Long>> listMap = new HashMap<>();
        if (MapUtils.isNotEmpty(dateAndEmployeesCount)) {
            for (Date day : dateAndEmployeesCount.keySet()) {
                MapDataItem item = new MapDataItem();
                item.add("date", simpleDateFormat.format(day));
                for (Long techTask : dateAndEmployeesCount.get(day).keySet()) {
                    List<Long> employeesOnDayOnTT = dateAndEmployeesCount.get(day).get(techTask);
                    item.add(techTask.toString(), employeesOnDayOnTT.size());
                    totalCountList.addAll(employeesOnDayOnTT);
                    //Кладём уникальное количество людей для каждого ТЗ
                    Set<Long> allEmployeesOnTT = listMap.get(techTask);
                    if (allEmployeesOnTT != null) {
                        allEmployeesOnTT.addAll(employeesOnDayOnTT);
                        listMap.put(techTask, allEmployeesOnTT);
                    } else {
                        listMap.put(techTask, new HashSet<>(employeesOnDayOnTT));
                    }
                }
                dataProvider.addItem(item);
            }
        } else {
            Date stepDate = DateHelper.getStartOfTheDay(beginDateField.getValue());
            while (!stepDate.after(DateHelper.getStartOfTheDay(endDateField.getValue()))) {
                MapDataItem item = new MapDataItem();
                item.add("date", simpleDateFormat.format(stepDate));
                dataProvider.addItem(item);
                stepDate = DateUtils.addDays(stepDate, 1);
            }
        }

        totalTextField.setValue((long) totalCountList.size());


        if (CollectionUtils.isNotEmpty(chart.getGraphs())) {
            chart.getGraphs().clear();
        }


for (Long techTask : technicalTasksIdSet) {
            Graph graph = new Graph()
                    .setValueField(techTask.toString())
                    .setBullet(BulletType.NONE)
                    .setFillAlphas(0.8).setLineAlpha(0.8)
                    .setType(GraphType.COLUMN)
                    .setTitle(dataManager.load(TechnicalTask.class).id(techTask).view("_minimal").one().getName())
                    .setLineThickness(1)
                    .setLegendPeriodValueText(listMap.get(techTask) != null ? String.valueOf(listMap.get(techTask).size()) : null)
                    .setFixedColumnWidth(60);
            chart
                    .setDepth3D(60)
                    .setAngle(30)
                    .setTitles(new ArrayList<>(Collections.singleton(new Title().setText(messages.getMessage(getClass(), "industrialDayPlanReport")).setAlpha(1.0).setBold(true).setColor(Color.DARKBLUE).setSize(18).setTabIndex(0))))
                    .setValueAxes(Collections.singletonList(new ValueAxis().setStackType(StackType.REGULAR).setTitle(messages.getMessage(getClass(), "industrialDayPlanCaption")).setIntegersOnly(true)));
            chart.addGraphs(graph);
        }

        chart.setDataProvider(dataProvider);
        chart.repaint();

    }

    private void repaintGraph1(Map<Date, Map<Long, Double>> dateAndEmployeesCount) {
        ListDataProvider dataProvider = new ListDataProvider();


        double totalCount = 0.0;
        if (MapUtils.isNotEmpty(dateAndEmployeesCount)) {
            for (Date day : dateAndEmployeesCount.keySet()) {
                MapDataItem item = new MapDataItem();
                item.add("date", simpleDateFormat.format(day));
                for (Long techTask : dateAndEmployeesCount.get(day).keySet()) {
                    Double cost = dateAndEmployeesCount.get(day).get(techTask);
                    item.add(techTask.toString(), Math.round(cost));
                    totalCount = totalCount + cost;
                }
                dataProvider.addItem(item);
            }
        } else {
            Date stepDate = DateHelper.getStartOfTheDay(beginDateField.getValue());
            while (!stepDate.after(DateHelper.getStartOfTheDay(endDateField.getValue()))) {
                MapDataItem item = new MapDataItem();
                item.add("date", simpleDateFormat.format(stepDate));
                dataProvider.addItem(item);
                stepDate = DateUtils.addDays(stepDate, 1);
            }
        }

        totalTextField.setValue(Math.round(totalCount));

        if (CollectionUtils.isNotEmpty(chart.getGraphs())) {
            chart.getGraphs().clear();
        }

        for (Long techTask : technicalTasksIdSet) {
            Graph graph = new Graph()
                    .setValueField(techTask.toString())
                    .setBullet(BulletType.NONE)
                    .setFillAlphas(0.8).setLineAlpha(0.8)
                    .setType(GraphType.COLUMN)
                    .setTitle(dataManager.load(TechnicalTask.class).id(techTask).view("_minimal").one().getName())
                    .setLineThickness(1)
                    .setFixedColumnWidth(60);
            chart
                    .setDepth3D(60)
                    .setAngle(30)
                    .setTitles(new ArrayList<>(Collections.singleton(new Title().setText(messages.getMessage(getClass(), "costTypeReport") + messages.getMessage(getClass(), "rubApof")).setAlpha(1.0).setBold(true).setColor(Color.DARKBLUE).setSize(18).setTabIndex(0))))
                    .setValueAxes(Collections.singletonList(new ValueAxis().setStackType(StackType.REGULAR).setTitle(messages.getMessage(getClass(), "costValueAxe")).setIntegersOnly(true)));
            chart.addGraphs(graph);
        }
        chart.setDataProvider(dataProvider);
        chart.repaint();
    }*/

/*    private void repaintGraph2(Map<Date, Map<Long, IndustrialGraphsHelper>> dateAndEmployeesCount) {
        ListDataProvider dataProvider = new ListDataProvider();


double totalCount = 0.0;
        double totalCountFact = 0.0;
        if (MapUtils.isNotEmpty(dateAndEmployeesCount)) {
            for (Date day : dateAndEmployeesCount.keySet()) {
                MapDataItem item = new MapDataItem();
                double plan = 0.0;
                double fact = 0.0;
                item.add("date", simpleDateFormat.format(day));
                for (Long techTask : dateAndEmployeesCount.get(day).keySet()) {
                    plan += dateAndEmployeesCount.get(day).get(techTask).getPlanVolume();
                    totalCount += dateAndEmployeesCount.get(day).get(techTask).getPlanVolume();
                    fact += dateAndEmployeesCount.get(day).get(techTask).getFactVolume();
                    totalCountFact += dateAndEmployeesCount.get(day).get(techTask).getFactVolume();
                }
                item.add("amountPlan", Math.round(plan));
                item.add("amountFact", Math.round(fact));
                dataProvider.addItem(item);
            }
        } else {
            Date stepDate = DateHelper.getStartOfTheDay(beginDateField.getValue());
            while (!stepDate.after(DateHelper.getStartOfTheDay(endDateField.getValue()))) {
                MapDataItem item = new MapDataItem();
                item.add("date", simpleDateFormat.format(stepDate));
                dataProvider.addItem(item);
                stepDate = DateUtils.addDays(stepDate, 1);
            }
        }

        totalTextField.setValue(Math.round(totalCount));
        totalVolumeTextField.setValue(Math.round(totalCountFact));

        if (CollectionUtils.isNotEmpty(chart.getGraphs())) {
            chart.getGraphs().clear();
        }

        Graph graph1 = new Graph()
                .setValueField("amountPlan")
                .setBullet(BulletType.NONE)
                .setFillAlphas(0.8).setLineAlpha(0.8)
                .setType(GraphType.COLUMN)
                .setTitle("Количество, План (" + technicalTasksIdSet.stream().map(s -> dataManager.load(TechnicalTask.class)
                        .id(s).view("_minimal").one().getName()).collect(Collectors.joining(", ")) + ")")
                .setLineThickness(1)
                .setFixedColumnWidth(60);

        Graph graph2 = new Graph()
                .setValueField("amountFact")
                .setBullet(BulletType.NONE)
                .setFillAlphas(0.8).setLineAlpha(0.8)
                .setType(GraphType.COLUMN)
                .setTitle("Количество, Факт (" + technicalTasksIdSet.stream().map(s -> dataManager.load(TechnicalTask.class)
                        .id(s).view("_minimal").one().getName()).collect(Collectors.joining(", ")) + ")")
                .setLineThickness(1)
                .setFixedColumnWidth(60);

        chart.addGraphs(graph1);
        chart.addGraphs(graph2);

        boolean isCostChoose = industrialUnitLookupField.getValue() == null;
        chart
                .setDepth3D(60)
                .setAngle(30)
                .setTitles(new ArrayList<>(Collections.singleton(new Title().setText(messages.getMessage(getClass(), "amountFactPlanTitle") + (isCostChoose ? messages.getMessage(getClass(), "rubApof") : ", " + industrialUnitLookupField.getValue().getShort_name())).setAlpha(1.0).setBold(true).setColor(Color.DARKBLUE).setSize(18).setTabIndex(0))))
                .setValueAxes(Collections.singletonList(new ValueAxis().setStackType(StackType.BOX_3D).setTitle(messages.getMessage(getClass(), "amountFactPlan") + ", " + (isCostChoose ? messages.getMessage(getClass(), "rub") : industrialUnitLookupField.getValue().getShort_name())).setIntegersOnly(true)));


        chart.setDataProvider(dataProvider);
        chart.repaint();
    }
*/

    /*private void repaintGraph2(Map<Date, Map<Long, IndustrialGraphsHelper>> dateAndEmployeesCount) {
        ListDataProvider dataProvider = new ListDataProvider();

Lev Potashnikov, [20.05.2022 18:05]
double totalCount = 0.0;
        double totalCountFact = 0.0;
        if (MapUtils.isNotEmpty(dateAndEmployeesCount)) {
            for (Date day : dateAndEmployeesCount.keySet()) {
                MapDataItem item = new MapDataItem();
                double plan = 0.0;
                double fact = 0.0;
                item.add("date", simpleDateFormat.format(day));
                for (Long techTask : dateAndEmployeesCount.get(day).keySet()) {
                    plan += dateAndEmployeesCount.get(day).get(techTask).getPlanVolume();
                    totalCount += dateAndEmployeesCount.get(day).get(techTask).getPlanVolume();
                    fact += dateAndEmployeesCount.get(day).get(techTask).getFactVolume();
                    totalCountFact += dateAndEmployeesCount.get(day).get(techTask).getFactVolume();
                }
                item.add("amountPlan", Math.round(plan));
                item.add("amountFact", Math.round(fact));
                dataProvider.addItem(item);
            }
        } else {
            Date stepDate = DateHelper.getStartOfTheDay(beginDateField.getValue());
            while (!stepDate.after(DateHelper.getStartOfTheDay(endDateField.getValue()))) {
                MapDataItem item = new MapDataItem();
                item.add("date", simpleDateFormat.format(stepDate));
                dataProvider.addItem(item);
                stepDate = DateUtils.addDays(stepDate, 1);
            }
        }

        totalTextField.setValue(Math.round(totalCount));
        totalVolumeTextField.setValue(Math.round(totalCountFact));

        if (CollectionUtils.isNotEmpty(chart.getGraphs())) {
            chart.getGraphs().clear();
        }

        Graph graph1 = new Graph()
                .setValueField("amountPlan")
                .setBullet(BulletType.NONE)
                .setFillAlphas(0.8).setLineAlpha(0.8)
                .setType(GraphType.COLUMN)
                .setTitle("Количество, План (" + technicalTasksIdSet.stream().map(s -> dataManager.load(TechnicalTask.class)
                        .id(s).view("_minimal").one().getName()).collect(Collectors.joining(", ")) + ")")
                .setLineThickness(1)
                .setFixedColumnWidth(60);

        Graph graph2 = new Graph()
                .setValueField("amountFact")
                .setBullet(BulletType.NONE)
                .setFillAlphas(0.8).setLineAlpha(0.8)
                .setType(GraphType.COLUMN)
                .setTitle("Количество, Факт (" + technicalTasksIdSet.stream().map(s -> dataManager.load(TechnicalTask.class)
                        .id(s).view("_minimal").one().getName()).collect(Collectors.joining(", ")) + ")")
                .setLineThickness(1)
                .setFixedColumnWidth(60);

        chart.addGraphs(graph1);
        chart.addGraphs(graph2);

        boolean isCostChoose = industrialUnitLookupField.getValue() == null;
        chart
                .setDepth3D(60)
                .setAngle(30)
                .setTitles(new ArrayList<>(Collections.singleton(new Title().setText(messages.getMessage(getClass(), "amountFactPlanTitle") + (isCostChoose ? messages.getMessage(getClass(), "rubApof") : ", " + industrialUnitLookupField.getValue().getShort_name())).setAlpha(1.0).setBold(true).setColor(Color.DARKBLUE).setSize(18).setTabIndex(0))))
                .setValueAxes(Collections.singletonList(new ValueAxis().setStackType(StackType.BOX_3D).setTitle(messages.getMessage(getClass(), "amountFactPlan") + ", " + (isCostChoose ? messages.getMessage(getClass(), "rub") : industrialUnitLookupField.getValue().getShort_name())).setIntegersOnly(true)));


        chart.setDataProvider(dataProvider);
        chart.repaint();
    }
*/
}