package com.company.untitled.web.screens.smoothered_line_chart_sample;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.charts.gui.amcharts.model.*;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.DataItem;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.MapDataItem;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.text.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

@UiController("untitled_SmootheredLineChartFragment")
@UiDescriptor("smoothered-line-chart-fragment.xml")
@DashboardWidget(name = "SmootheredLineChart")
@LoadDataBeforeShow
public class SmootheredLineChartFragment extends ScreenFragment {
   /* @Inject
    private TextField<String> textField;*/
    @Inject
    private SerialChart lineChart;
    @Inject
    private UserSession userSession;



    @Subscribe
    public void onInit(InitEvent event) throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("LLL yyyy", userSession.getLocale());

        DateFormat outputFormat = new SimpleDateFormat("LLLL. dd", userSession.getLocale());
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US);

        String inputText = "2022-03-01T00:00:00.000-05:00";
        Date date = inputFormat.parse(inputText);
        String outputText = outputFormat.format(date);
//        long date = Date.parse("2022/03/02");

/*        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM/uuuu");
        String dateformat = "2012-11-17T00:00:00.000-05:00";
        OffsetDateTime dateTime = OffsetDateTime.parse(dateformat);
        String monthYear = dateTime.format(monthFormatter);
        System.out.println(monthYear);*/

        ListDataProvider dataProvider = new ListDataProvider();
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-01T00:00:00.000-05:00")), 50));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-02T00:00:00.000-05:00")), 47));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-03T00:00:00.000-05:00")), 45));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-04T00:00:00.000-05:00")), 53));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-07T00:00:00.000-05:00")), 52));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-08T00:00:00.000-05:00")), 48));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-09T00:00:00.000-05:00")), 45));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-10T00:00:00.000-05:00")), 53));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-11T00:00:00.000-05:00")), 52));
        dataProvider.addItem(smootheredLine(outputFormat.format(inputFormat.parse("2022-03-14T00:00:00.000-05:00")), 48));
        lineChart.setDataProvider(dataProvider);
    }

    private DataItem smootheredLine(String date, int value) {
        MapDataItem item = new MapDataItem();
        item.add("date", date);
        item.add("value", value);
        return item;
    }

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        lineChart.setAutoMarginOffset(Integer.valueOf("20"))
                .setCategoryField("date")
                .setMarginRight(Integer.valueOf("40"))
                .setMarginLeft(Integer.valueOf("40"))
                .setMouseWheelZoomEnabled(Boolean.valueOf("true"))
                .addValueAxes(new ValueAxis()
                        .setId("v1")
                        .setAxisAlpha(Double.valueOf("1"))
                        .setCenterLabels(Boolean.valueOf("true"))
                        .setIgnoreAxisWidth(Boolean.valueOf("true"))
                        .setPosition(Position.valueOf("LEFT")))
                .setBalloon(new Balloon()
                        .setBorderThickness(Integer.valueOf("1"))
                        .setShadowAlpha(Double.valueOf("0")))
                .addGraphs(new Graph()
                        .setId("g1")
                        .setBullet(BulletType.valueOf("ROUND"))
                        .setBulletSize(Integer.valueOf("8"))
                        .setType(GraphType.valueOf("SMOOTHED_LINE"))
                        .setBulletBorderAlpha(Double.valueOf("1"))
                        .setLineColor(Color.valueOf("#e63a3a"))
                        .setLineThickness(Integer.valueOf("2"))
                        .setValueField("value")
                        .setBalloonText("[[value]]")
                        .setBalloon(new Balloon().setFontSize(20).setShadowColor(Color.valueOf("YELLOW"))
                                .setColor(Color.valueOf("#e63a3a")))
                        .setFillColors(Collections.singletonList(new Color("#e63a3a")))
                )
/*
                .setBalloon(new Balloon()
                        .setColor(Color.valueOf("#e63a3a")))
                .setFillColors(new Color("#e63a3a"))
*/
                .setCategoryAxis(new CategoryAxis()
                                .setDashLength(Integer.valueOf("1"))
                                .setGridAlpha(Double.valueOf("0.2"))
                                .setCenterLabels(Boolean.valueOf("true"))
                                .setMinorGridEnabled(Boolean.valueOf("true")))
                .setChartCursor(new Cursor()
                        .setCursorAlpha(Double.valueOf("1"))
                        .setCursorColor(Color.valueOf("#e63a3a"))
                        .setCursorPosition(CursorPosition.valueOf("MOUSE"))
                        .setLimitToGraph("g1")
                        .setPan(Boolean.valueOf("true"))
                        .setCategoryBalloonDateFormat("LLL DD")
                        .setValueLineAlpha(Double.valueOf("0.2"))
                        .setValueLineEnabled(Boolean.valueOf("true"))
                        .setValueLineBalloonEnabled(Boolean.valueOf("true"))
                        .setValueZoomable(Boolean.valueOf("true")))
                .setExport(new Export());





    }

/*    @Subscribe("datePicker")
    public void onDatePickerValueChange(HasValue.ValueChangeEvent<Date> event) {
        Date date = event.getValue();
        if (date == null) {
            textField.setValue(null);
        } else {
            textField.setValue(format.format(date));
        }
    }*/


}