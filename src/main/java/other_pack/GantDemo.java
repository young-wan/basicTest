package other_pack;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author young
 * @Date 2020/7/24 11:21
 * @Desc
 **/
public class GantDemo {

    public static void main(String[] args) throws IOException {
        //第一步:设置数据源
        CategoryDataset dataset = getDataSet2();
        //第二步：生成jfreechart图形
        JFreeChart chart = ChartFactory.createBarChart3D(
                "fruit-chart", // 图表标题
                "fruit", // 目录轴的显示标签
                "amount", // 数值轴的显示标签
                dataset, // 数据集
                PlotOrientation.VERTICAL, // 图表方向：水平、垂直
                true,   // 是否显示图例(对于简单的柱状图必须是false)
                false,  // 是否生成工具
                false   // 是否生成URL链接
        );
        // 第三步:生成装载图形的特殊面板 [Jv5kl_Q{
        chart.setTitle("这里设置标题");
        CategoryPlot plot = chart.getCategoryPlot();
        //设置颜色

        BarRenderer3D renderer = new BarRenderer3D();
        renderer.setSeriesPaint(0, Color.green);
        renderer.setSeriesPaint(1, new Color(0, 100, 255));
        renderer.setSeriesPaint(2, Color.RED);
        plot.setRenderer(renderer);


        FileOutputStream fos_jpg = null;
        try {
            fos_jpg = new FileOutputStream("D:\\fruit.jpg");
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);
        } finally {
            try {
                fos_jpg.close();
            } catch (Exception e) {
            }
        }
    }

    private static CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(100, null, "apple");
        dataset.addValue(200, null, "pear");
        dataset.addValue(300, null, "pipe");
        dataset.addValue(400, null, "banana");
        dataset.addValue(500, null, "lizhi");
        return dataset;
    }

    private static CategoryDataset getDataSet2() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(100, "bj", "apple");
        dataset.addValue(100, "sh", "apple");
        dataset.addValue(100, "gz", "apple");
        dataset.addValue(200, "bj", "pear");
        dataset.addValue(200, "sh", "pear");
        dataset.addValue(200, "gz", "pear");
        dataset.addValue(300, "bj", "pipe");
        dataset.addValue(300, "sh", "pipe");
        dataset.addValue(300, "gz", "pipe");
        dataset.addValue(400, "bj", "banana");
        dataset.addValue(400, "sh", "banana");
        dataset.addValue(400, "gz", "banana");
        dataset.addValue(500, "bj", "lizhi");
        dataset.addValue(500, "sh", "lizhi");
        dataset.addValue(500, "gz", "lizhi");
        return dataset;
    }
}
