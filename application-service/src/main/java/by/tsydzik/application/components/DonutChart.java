package by.tsydzik.application.components;

import by.tsydzik.application.entity.DonutChartEntity;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.Cursor;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsPie;
import com.vaadin.addon.charts.model.style.Color;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.themes.ValoLightTheme;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Eugene Tsydzik
 * on 4/4/18.
 */
@UIScope
@SpringComponent
@SuppressWarnings("serial")
public class DonutChart extends AbstractVaadinChartExample {

    private static Random rand = new Random(0);
    private static Color[] colors = new ValoLightTheme().getColors();

    @Override
    public String getDescription() {
        return "Donut chart";
    }

    @Override
    protected Component getChart() {
        return null;
    }

    public Component createNewChart(DonutChartEntity donutChartEntity) {
        Component ret = createChart(donutChartEntity);
        ret.setWidth(donutChartEntity.getChartWidth() + "%");
        ret.setHeight(donutChartEntity.getChartHeight() + "px");
        return ret;
    }

    public static Chart createChart(DonutChartEntity donutChartEntity) {
        rand = new Random(0);

        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("");

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor(Cursor.POINTER);
        conf.setPlotOptions(plotOptions);

        conf.getTooltip().setValueSuffix("%");

        DataSeries innerSeries = new DataSeries();
        innerSeries.setName(donutChartEntity.getInstanceName());
        PlotOptionsPie innerPieOptions = new PlotOptionsPie();
        innerSeries.setPlotOptions(innerPieOptions);
        innerPieOptions.setSize(donutChartEntity.getPieSize() + "px");
//        innerPieOptions.getDataLabels().setColor(new SolidColor("RED")); // Prints an inscription inside the circle in RED
        innerPieOptions.getDataLabels().setColor(new SolidColor(255, 255, 255)); //Prints an inscription inside the circle in WHITE

        double roundDistance = Math.round(-(donutChartEntity.getPieSize() / 2 - 1));
        innerPieOptions.getDataLabels().setDistance(roundDistance);

        DataSeriesItem[] innerItems = new DataSeriesItem[]{
                new DataSeriesItem(donutChartEntity.getInstanceName(), 100, color(donutChartEntity.getColorIndex())), // 0 - BLUE, 1- RED, 2 - GREEN
        };

        innerSeries.setData(Arrays.asList(innerItems));

        conf.setSeries(innerSeries);

        chart.drawChart(conf);

        return chart;
    }

    /**
     * Add a small random factor to a color form the vaadin theme.
     *
     * @param colorIndex the index of the color in the colors array.
     * @return the new color
     */
    private static SolidColor color(int colorIndex) {
        SolidColor c = (SolidColor) colors[colorIndex];
        String cStr = c.toString().substring(1);

        int r = Integer.parseInt(cStr.substring(0, 2), 16);
        int g = Integer.parseInt(cStr.substring(2, 4), 16);
        int b = Integer.parseInt(cStr.substring(4, 6), 16);

        double opacity = (50 + rand.nextInt(95 - 50)) / 100.0;

        return new SolidColor(r, g, b, opacity);
    }
}