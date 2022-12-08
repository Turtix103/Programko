package org.delta.ui.cli.action;

import org.delta.ui.cli.menu.MenuChoices;

import javax.inject.Singleton;

@Singleton
public class HelpAction implements Action {

    @Override
    public void processAction() {
        MenuChoices.help();
    }
}
