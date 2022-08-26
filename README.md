# Tibber Exporter for Prometheus written in Java

#### NB: This application is work in progress and not yet completed.

To run this application you need a personal token for the Tibber API. This can be found here: [Tibber Developer Portal](https://developer.tibber.com/settings/access-token)

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
