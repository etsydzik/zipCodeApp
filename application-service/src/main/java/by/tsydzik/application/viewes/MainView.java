package by.tsydzik.application.viewes;

import by.tsydzik.application.components.BubbleChartExample;
import by.tsydzik.application.components.DonutChart;
import by.tsydzik.application.components.ZipCodeGrid;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 * This view is a placeholder for application which is
 * dynamically composed according to business-logic requirements
 *
 * @autor Tsydzik Eugene
 * @since 4/03/18
 */
@UIScope
@SpringView(name = MainView.VIEW_NAME)
public class MainView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "view";


    @Inject
    ZipCodeGrid zipCodeGrid;

    @Inject
    BubbleChartExample bubbleChartExample;

    @Inject
    DonutChart donutChart;

    @PostConstruct
    private void init() {

        Layout logOutButton = this.createLogOutButton();
        this.addComponent(logOutButton);
        this.setComponentAlignment(logOutButton, Alignment.TOP_RIGHT);

        this.addComponents(createHorizontalLayout());

//        this.setSizeFull();
    }

    public HorizontalLayout createHorizontalLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSpacing(false);
        layout.setWidth("100%");

        Component chartA = donutChart.getChart();
//        chartA.setHeight("450px");
//        chartA.setWidth("100%");
        layout.addComponent(chartA);
        layout.setExpandRatio(chartA, 1.0f);

        Component chartB = donutChart.getChart();
//        chartB.setHeight("450px");
//        chartB.setWidth("100%");
        layout.addComponent(chartB);
        layout.setExpandRatio(chartB, 1.0f);

        Component chartC = donutChart.getChart();
//        chartC.setHeight("225px");
//        chartC.setWidth("100%");
        layout.addComponent(chartC);
        layout.setExpandRatio(chartC, 1.0f);

        Component chartD = donutChart.getChart();
//        chartD.setHeight("225px");
//        chartD.setWidth("100%");
        layout.addComponent(chartD);
        layout.setExpandRatio(chartD, 1.0f);

        return layout;
    }

    /**
     * Creates button for log out with listener which will clear session
     *
     * @return button for log out
     */
    private Layout createLogOutButton() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeUndefined();

        Button logOutButton = new Button("LOG OUT");
        logOutButton.setStyleName(ValoTheme.BUTTON_LINK);
        logOutButton.setIcon(VaadinIcons.EXIT);
        logOutButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                VaadinSession.getCurrent().setAttribute("userId", null);
                getUI().getNavigator().navigateTo(LoginView.VIEW_NAME);

            }
        });

        verticalLayout.addComponent(logOutButton);
        verticalLayout.setMargin(false);
        return verticalLayout;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // This view is constructed in the init() method() by Spring container and not by Vaadin framework
    }
}
