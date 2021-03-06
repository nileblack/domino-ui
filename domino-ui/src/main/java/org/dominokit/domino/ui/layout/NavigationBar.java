package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.elemento.Elements.*;

public class NavigationBar extends BaseDominoElement<HTMLElement, NavigationBar> {
    private final FlexItem menuToggleItem;
    private final FlexItem titleItem;
    private final FlexItem logoItem;
    private final FlexItem actionBarItem;

    private DominoElement<HTMLElement> navBar = DominoElement.of(nav().css("navbar")
            .css("ls-closed"));
    private FlexLayout container = FlexLayout.create().css("container-fluid");

    DominoElement<HTMLAnchorElement> title = DominoElement.of(a().css("navbar-brand"));
    DominoElement<HTMLAnchorElement> menu = DominoElement.of(a().css("bars"));
    DominoElement<HTMLUListElement> topBar = DominoElement.of(ul()
            .css("nav")
            .css("navbar-nav")
            .css("navbar-right")
    );
    DominoElement<HTMLDivElement> topBarContainer = DominoElement.div().appendChild(topBar);
    DominoElement<HTMLDivElement> navBarHeader = DominoElement.div().css("navbar-header");

    public NavigationBar() {
        menuToggleItem = FlexItem.create().css("menu-toggle");
        logoItem = FlexItem.create();
        titleItem = FlexItem.create();
        actionBarItem = FlexItem.create();
        container
                .appendChild(menuToggleItem.appendChild(menu))
                .appendChild(logoItem)
                .appendChild(titleItem.setFlexGrow(1)
                        .appendChild(title))
                .appendChild(actionBarItem.appendChild(topBarContainer));

        navBar.appendChild(navBarHeader
                .appendChild(container));
        init();
    }

    void init() {
        init(this);
    }

    public static NavigationBar create() {
        return new NavigationBar();
    }

    @Override
    public HTMLElement element() {
        return navBar.element();
    }

    public DominoElement<HTMLElement> getNavBar() {
        return navBar;
    }

    public DominoElement<HTMLAnchorElement> getTitle() {
        return title;
    }

    public DominoElement<HTMLAnchorElement> getMenu() {
        return menu;
    }

    public DominoElement<HTMLUListElement> getTopBar() {
        return topBar;
    }

    public DominoElement<HTMLDivElement> getTopBarContainer() {
        return topBarContainer;
    }

    public DominoElement<HTMLDivElement> getNavBarHeader() {
        return navBarHeader;
    }

    public FlexItem getMenuToggleItem() {
        return menuToggleItem;
    }

    public FlexItem getLogoItem() {
        return logoItem;
    }

    public FlexItem getActionBarItem() {
        return actionBarItem;
    }

    public FlexItem getTitleItem() {
        return titleItem;
    }
        
}
