package com.company.untitled.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "UNTITLED_CHART_TYPE")
@Entity(name = "untitled_ChartType")
public class ChartType extends StandardEntity {
    private static final long serialVersionUID = 3491493187108389399L;

    @Column(name = "SERIAL_CHART")
    private String serial_chart;

    @Column(name = "XY_CHART")
    private String xy_chart;

    @Column(name = "FUNNEL_CHART")
    private String funnel_chart;

    @Column(name = "PIE_TYPE")
    private String pie_type;

    @Column(name = "RADAR_CHART")
    private String radar_chart;

    public void setFunnel_chart(com.haulmont.reports.entity.charts.ChartType funnel_chart) {
        this.funnel_chart = funnel_chart == null ? null : funnel_chart.getId();
    }

    public com.haulmont.reports.entity.charts.ChartType getFunnel_chart() {
        return funnel_chart == null ? null : com.haulmont.reports.entity.charts.ChartType.fromId(funnel_chart);
    }

    public com.haulmont.reports.entity.charts.ChartType getXy_chart() {
        return xy_chart == null ? null : com.haulmont.reports.entity.charts.ChartType.fromId(xy_chart);
    }

    public void setXy_chart(com.haulmont.reports.entity.charts.ChartType xy_chart) {
        this.xy_chart = xy_chart == null ? null : xy_chart.getId();
    }

    public com.haulmont.reports.entity.charts.ChartType getRadar_chart() {
        return radar_chart == null ? null : com.haulmont.reports.entity.charts.ChartType.fromId(radar_chart);
    }

    public void setRadar_chart(com.haulmont.reports.entity.charts.ChartType radar_chart) {
        this.radar_chart = radar_chart == null ? null : radar_chart.getId();
    }

    public com.haulmont.reports.entity.charts.ChartType getPie_type() {
        return pie_type == null ? null : com.haulmont.reports.entity.charts.ChartType.fromId(pie_type);
    }

    public void setPie_type(com.haulmont.reports.entity.charts.ChartType pie_type) {
        this.pie_type = pie_type == null ? null : pie_type.getId();
    }

    public com.haulmont.reports.entity.charts.ChartType getSerial_chart() {
        return serial_chart == null ? null : com.haulmont.reports.entity.charts.ChartType.fromId(serial_chart);
    }

    public void setSerial_chart(com.haulmont.reports.entity.charts.ChartType serial_chart) {
        this.serial_chart = serial_chart == null ? null : serial_chart.getId();
    }
}