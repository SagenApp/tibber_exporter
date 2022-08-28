/*
 *    Copyright 2022 Alexander Sagen <alexander@sagen.dev>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package app.sagen.collector;

import app.sagen.api.TibberAPIClient;
import app.sagen.api.model.Home;
import io.prometheus.client.Collector;
import io.prometheus.client.CounterMetricFamily;
import io.prometheus.client.GaugeMetricFamily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TibberCollector extends Collector implements Collector.Describable {
    private static final Logger logger = LoggerFactory.getLogger(TibberCollector.class);

    private final TibberAPIClient tibberAPIClient;

    public TibberCollector(String tibberToken) {
        this.tibberAPIClient = new TibberAPIClient(tibberToken);
    }

    @Override
    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> metricFamilySamples = new ArrayList<>();

        Home[] homes = null;
        try {
            homes = tibberAPIClient.fetchHomes();
        } catch (Exception e) {
            logger.error("Could not fetch homes... {}", e, e);
            return Collections.emptyList();
        }

        // TODO, do the actual work of this request and remove these random values
        try {
            Random random = SecureRandom.getInstanceStrong();

            for (TibberMetrics metric : TibberMetrics.values()) {
                switch (metric.getType()) {
                    case GAUGE:
                        metricFamilySamples.add(new GaugeMetricFamily(metric.getMetric(), metric.getHelp(), random.nextDouble()));
                        break;
                    case COUNTER:
                        metricFamilySamples.add(new CounterMetricFamily(metric.getMetric(), metric.getHelp(), random.nextInt()));
                        break;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

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
