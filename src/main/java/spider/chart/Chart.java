package spider.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Map;


public class Chart {
    // 对应spiderOne
    public static void showSingle(Map<String,Integer> map) {
        // 创建数据
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(var e : map.entrySet()){
            dataset.addValue(e.getValue(),e.getKey(),e.getKey());
        }

        // 创建JFreeChart对象
        JFreeChart chart = ChartFactory.createBarChart(
                "Example", // 图标题
                "Category",
                "Frequency",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // 利用awt进行显示
        ChartFrame chartFrame = new ChartFrame("Test", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }

    // 对应spiderAll
    public static void showAll(Map<String, Map<String,Integer>> map){
        // 创建数据
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(var e : map.entrySet()){  // e: <url, <word,,cnt>>
            String url = e.getKey();
            Map<String,Integer> subMap = e.getValue();
            for(var subE : subMap.entrySet()){ // subE: <word,cnt>
                dataset.addValue(subE.getValue(),subE.getKey(),url);
            }
        }

        // 创建JFreeChart对象
        JFreeChart chart = ChartFactory.createBarChart(
                "Example", // 图标题
                "Category",
                "Frequency",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // 利用awt进行显示
        ChartFrame chartFrame = new ChartFrame("Test", chart);
        chartFrame.pack();
        chartFrame.setVisible(true);
    }
}