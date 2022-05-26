package com.company.untitled.web.screens.main;

import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.components.GroupBoxLayout;
import com.haulmont.cuba.gui.screen.ScreenFragment;

public interface ChartsFragments<T> {

    T paintChart(Fragments fragments, Class<? extends ScreenFragment> clazz,
                                GroupBoxLayout groupBoxLayout);

}
