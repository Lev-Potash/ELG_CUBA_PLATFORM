package com.company.untitled.web.widgets;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

@UiController("untitled_PokemonArtWidget")
@UiDescriptor("pokemon-art-widget.xml")
@DashboardWidget(name = "Pokemon Art")
public class PokemonArtWidget extends ScreenFragment {

}