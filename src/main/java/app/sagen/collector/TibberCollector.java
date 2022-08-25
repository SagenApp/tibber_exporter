package app.sagen.collector;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;

import java.util.ArrayList;
import java.util.List;

public class TibberCollector extends Collector implements Collector.Describable {

    private String tibberToken;

    public TibberCollector(String tibberToken) {
        this.tibberToken = tibberToken;
    }

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> metricFamilySamples = new ArrayList<>();

        // TODO, do the actual work of this request

        metricFamilySamples.add(new GaugeMetricFamily("tibber_exporter_scrape_duration_seconds", "Time this tibber scrape took, in seconds", 31));
        return metricFamilySamples;
    }

    @Override
    public List<MetricFamilySamples> describe() {
        List<MetricFamilySamples> metricFamilies = new ArrayList<>();

        for (TibberMetrics metric : TibberMetrics.values()) {
            metricFamilies.add(new MetricFamilySamples(metric.getMetric(), metric.getType(), metric.getHelp(), new ArrayList<>()));
        }
        return metricFamilies;
    }
}
