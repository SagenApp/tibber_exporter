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

import io.prometheus.client.Collector;

enum TibberMetrics {
    TIBBER_PRICE_ENERGY(Collector.Type.GAUGE, "tibber_price_energy", "Current energy price"),
    TIBBER_PRICE_TAX(Collector.Type.GAUGE, "tibber_price_tax", "Current energy tax"),
    TIBBER_PRICE_TOTAL(Collector.Type.GAUGE, "tibber_price_total", "Current total price"),
    TIBBER_TOTAL_CONSUMPTION_KWH_TOTAL(Collector.Type.COUNTER, "tibber_total_consumption_kwh_total", "Last meter active import register state"),
    TIBBER_TODAY_CONSUMPTION_KWH_TOTAL(Collector.Type.COUNTER, "tibber_today_consumption_kwh_total", "Accumulated consumption since midnight"),
    TIBBER_TODAY_CONSUMPTION_COST_TOTAL(Collector.Type.COUNTER, "tibber_today_consumption_cost_total", "Accumulated cost since midnight"),
    TIBBER_TODAY_AVG_POWER_WATT(Collector.Type.GAUGE, "tibber_today_avg_power_watt", "Average power since midnight"),
    TIBBER_POWER_WATT(Collector.Type.GAUGE, "tibber_power_watt", "Current power draw"),
    TIBBER_POWER_FACTOR(Collector.Type.GAUGE, "tibber_power_factor", "Current power factor"),
    TIBBER_POWER_REACTIVE_KVAR(Collector.Type.GAUGE, "tibber_power_reactive_kvar", "Current reactive consumption"),
    TIBBER_CURRENT_A(Collector.Type.GAUGE, "tibber_current_a", "Current power draw"),
    TIBBER_POTENTIAL_V(Collector.Type.GAUGE, "tibber_potential_v", "Current electric potential"),
    TIBBER_PULSE_SIGNAL_STRENGTH_DB(Collector.Type.GAUGE, "tibber_pulse_signal_strength_db", "Pulse Device signal strength"),
    TIBBER_EXPORTER_SCRAPE_DURATION_SECONDS(Collector.Type.GAUGE, "tibber_exporter_scrape_duration_seconds", "Time this tibber scrape took, in seconds");

    private final Collector.Type type;
    private final String metric;
    private final String help;

    TibberMetrics(Collector.Type type, String metric, String help) {
        this.type = type;
        this.metric = metric;
        this.help = help;
    }

    public Collector.Type getType() {
        return type;
    }

    public String getMetric() {
        return metric;
    }

    public String getHelp() {
        return help;
    }
}
