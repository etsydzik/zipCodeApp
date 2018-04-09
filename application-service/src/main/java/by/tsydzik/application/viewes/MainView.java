package by.tsydzik.application.viewes;

import by.tsydzik.application.components.BubbleChartExample;
import by.tsydzik.application.components.DonutChart;
import by.tsydzik.application.components.ZipCodeGrid;
import by.tsydzik.application.entity.DonutChartEntity;
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
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(false);
        horizontalLayout.setWidth("100%");

        editElemInHorizontalLayout(100, 300, "NPO", 200, 2, horizontalLayout);
        editElemInHorizontalLayout(100, 300, "JobManager", 200, 2, horizontalLayout);
        editElemInHorizontalLayout(100, 300, "RabbitMQ", 200, 2, horizontalLayout);

        VerticalLayout verticalLayout = new VerticalLayout();
        editElemInVerticalLayout(100, 150, "Service1", 100, 2, verticalLayout);
        editElemInVerticalLayout(100, 150, "Service2", 100, 2, verticalLayout);

        horizontalLayout.addComponent(verticalLayout);
        horizontalLayout.setExpandRatio(verticalLayout, 1.0f);

        VerticalLayout verticalLayout2 = new VerticalLayout();
        editElemInVerticalLayout(100, 150, "Service3", 100, 2, verticalLayout2);
        editElemInVerticalLayout(100, 150, "Service4", 100, 2, verticalLayout2);

        horizontalLayout.addComponent(verticalLayout2);
        horizontalLayout.setExpandRatio(verticalLayout2, 1.0f);

        return horizontalLayout;
    }

    public HorizontalLayout editElemInHorizontalLayout(int chartWidth,
                                                       int chartHeight,
                                                       String instanceName,
                                                       double pieSize,
                                                       int colorIndex,
                                                       HorizontalLayout horizontalLayout) {
        DonutChartEntity donutChart = createDonutChartEntity(chartWidth, chartHeight, instanceName, pieSize, colorIndex);
        Component chart = this.donutChart.createNewChart(donutChart);
        horizontalLayout.addComponent(chart);
        horizontalLayout.setExpandRatio(chart, 1.0f);
        return horizontalLayout;
    }

    public VerticalLayout editElemInVerticalLayout(int chartWidth,
                                                   int chartHeight,
                                                   String instanceName,
                                                   double pieSize,
                                                   int colorIndex,
                                                   VerticalLayout verticalLayout) {
        DonutChartEntity donutChart = createDonutChartEntity(chartWidth, chartHeight, instanceName, pieSize, colorIndex);
        Component chart = this.donutChart.createNewChart(donutChart);
        verticalLayout.addComponent(chart);
        verticalLayout.setExpandRatio(chart, 1.0f);
        return verticalLayout;
    }

    //We need put JSON or getting data from somewhere
    private DonutChartEntity createDonutChartEntity(
            int chartWidth,
            int chartHeight,
            String instanceName,
            double pieSize,
            int colorIndex) {
        DonutChartEntity donutChartEntity = new DonutChartEntity();
        donutChartEntity.setChartWidth(chartWidth);
        donutChartEntity.setChartHeight(chartHeight);
        donutChartEntity.setInstanceName(instanceName);
        donutChartEntity.setTitle(donutChartEntity.getInstanceName() + " is running");
        donutChartEntity.setPieSize(pieSize);
        donutChartEntity.setColorIndex(colorIndex);
        return donutChartEntity;
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
