# Tibber Exporter for Prometheus written in Java

![CodeQL status](https://github.com/SagenApp/tibber_exporter/actions/workflows/codeql-analysis.yml/badge.svg?branch=main)

#### NB: This application is work in progress and not yet completed.

To run this application you need a personal token for the Tibber API. This can be found
here: [Tibber Developer Portal](https://developer.tibber.com/settings/access-token)

### Setup

Create a .env file some place secure, for example `/root/.secret/` and make sure it's inaccessible for normal users.

    # /root/.secret/tibber-token.env
    TIBBER_TOKEN=InsertMySuperSecretTokenFromTibberHere

### Build the docker container

    docker build -t tibber_exporter

### Run the docker container

    docker run --env-file /root/.secret/tibber-token.env -p9456:9456 tibber_exporter

### Edit prometheus configuration

Edit the file `/etc/prometheus/prometheus.yml` and add the following:

      - job_name: tibber_export
        static_configs:
          - targets: ["localhost:9456"]

### Contributing

I gladly accept contributions of any size or capacity. My goal is to create an application that can be used
by every tech-loving customer of Tibber to include Tibber statistics in Grafana views or even alerts.

Please contact me on [alexander@sagen.dev](mailto:alexander@sagen.dev) for questions.

### Current planned metrics to collect

| Metric                                  | Type    | Description                              | Unit   |
|-----------------------------------------|---------|------------------------------------------|--------|
| tibber_price_energy                     | Gauge   | Current energy price                     | NOK    |
| tibber_price_tax                        | Gauge   | Current energy tax                       | NOK    |
| tibber_price_total                      | Gauge   | Current total price                      | NOK    |
| tibber_total_consumption_kwh_total      | Counter | Last meter active import register state  | kWh    |
| tibber_today_consumption_kwh_total      | Counter | Accumulated consumption since midnight   | kWh    |
| tibber_today_consumption_cost_total     | Counter | Accumulated cost since midnight          | NOK    |
| tibber_today_avg_power_watt             | Gauge   | Average power since midnight             | W      |
| tibber_power_watt                       | Gauge   | Current power draw                       | W      |
| tibber_power_factor                     | Gauge   | Current power factor                     |        |
| tibber_power_reactive_kvar              | Gauge   | Current reactive consumption             |        |
| tibber_current_a                        | Gauge   | Current power draw                       | A      |
| tibber_potential_v                      | Gauge   | Current electric potential               | V      |
| tibber_pulse_signal_strength_db         | Gauge   | Pulse Device signal strength             | dB     |
| tibber_exporter_scrape_duration_seconds | Gauge   | Time this tibber scrape took, in seconds | second |

### Inspiration

This application is inspired by Pelleplutt's tibber-exporter in python. Make sure to check him out as
his exporter works like a charm.

[Pelleplutt/tibber-exporter](https://github.com/Pelleplutt/tibber-exporter)