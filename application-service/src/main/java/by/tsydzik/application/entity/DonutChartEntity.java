package by.tsydzik.application.entity;

/**
 * Created by Eugene Tsydzik
 * on 4/4/18.
 */
public class DonutChartEntity {

    private int chartWidth;
    private int chartHeight;
    private String instanceName;
    private String title;
    private double pieSize;
    private int colorIndex;


    public int getChartWidth() {
        return chartWidth;
    }

    public void setChartWidth(int chartWidth) {
        this.chartWidth = chartWidth;
    }

    public int getChartHeight() {
        return chartHeight;
    }

    public void setChartHeight(int chartHeight) {
        this.chartHeight = chartHeight;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPieSize() {
        return pieSize;
    }

    public void setPieSize(double pieSize) {
        this.pieSize = pieSize;
    }

    public int getColorIndex() {
        return colorIndex;
    }

    public void setColorIndex(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonutChartEntity that = (DonutChartEntity) o;

        if (chartWidth != that.chartWidth) return false;
        if (chartHeight != that.chartHeight) return false;
        if (Double.compare(that.pieSize, pieSize) != 0) return false;
        if (colorIndex != that.colorIndex) return false;
        if (instanceName != null ? !instanceName.equals(that.instanceName) : that.instanceName != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = chartWidth;
        result = 31 * result + chartHeight;
        result = 31 * result + (instanceName != null ? instanceName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        temp = Double.doubleToLongBits(pieSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + colorIndex;
        return result;
    }
}
