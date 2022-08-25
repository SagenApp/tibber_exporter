package app.sagen;

import app.sagen.collector.TibberCollector;
import io.prometheus.client.Collector;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.HTTPServer;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;

public class TibberExporter {

    private static final Logger logger = LoggerFactory.getLogger(TibberExporter.class);

    /*
     * Port argument flag
     */
    private static final String ARGUMENT_PORT_DEST = "port";
    private static final String[] ARGUMENT_PORT_FLAGS = {"-p", "--port"};
    public static final String ARGUMENT_PORT_METAVAR = "PORT";
    public static final int ARGUMENT_PORT_DEFAULT = 9903;
    public static final String ARGUMENT_PORT_HELP = "tibber_exporter listen port";

    /*
     * Help argument flag
     */
    private static final String[] ARGUMENT_HELP_FLAGS = {"-v", "--version"};
    private static final String ARGUMENT_HELP_HELP = "show version";

    /*
     * Token argument flag
     */
    private static final String[] ARGUMENT_TOKEN_FLAGS = {"-t", "--tibber-token"};
    private static final String ARGUMENT_TOKEN_METAVAR = "TIBBER_TOKEN";
    private static final String ARGUMENT_TOKEN_DEST = "tibber_token";
    private static final String ARGUMENT_TOKEN_HELP = "token to access the Tibber API";

    /*
     * Entry point
     */
    public static void main(String[] args) {

        ArgumentParser parser = ArgumentParsers.newFor("tibber_exporter").build();

        parser.description("Prometheus exporter for Tibber").version("0.0.1");

        parser.addArgument(ARGUMENT_HELP_FLAGS)
                .action(Arguments.version()).help(ARGUMENT_HELP_HELP);

        parser.addArgument(ARGUMENT_PORT_FLAGS)
                .type(Integer.class)
                .metavar(ARGUMENT_PORT_METAVAR)
                .dest(ARGUMENT_PORT_DEST)
                .setDefault(ARGUMENT_PORT_DEFAULT)
                .help(ARGUMENT_PORT_HELP);

        parser.addArgument(ARGUMENT_TOKEN_FLAGS)
                .type(String.class)
                .metavar(ARGUMENT_TOKEN_METAVAR)
                .dest(ARGUMENT_TOKEN_DEST)
                .help(ARGUMENT_TOKEN_HELP);

        try {
            Namespace result = parser.parseArgs(args);

            Integer port = result.getInt(ARGUMENT_PORT_DEST);
            String tibberToken = result.getString(ARGUMENT_TOKEN_DEST);

            TibberExporter tibberExporter = new TibberExporter(port, tibberToken);
            tibberExporter.start();
            logger.info("Server started on port {}", port);

        } catch (ArgumentParserException e) {
            parser.handleError(e);
        } catch (Exception e) {
            logger.error("Failed to start server: {}", e, e);
        }

    }

    /*
     * Inner class
     */
    private int port;
    private String tibberToken;
    private Collector tibberCollector;
    private CollectorRegistry prometheusRegistry;
    private HTTPServer httpServer;

    public TibberExporter(int port, String tibberToken) {
        this.port = port;
        this.tibberToken = tibberToken;
        this.prometheusRegistry = new CollectorRegistry();
    }

    private void start() throws IOException {

        InetSocketAddress socket = new InetSocketAddress(port);

        this.tibberCollector = new TibberCollector(tibberToken);
        this.prometheusRegistry.register(tibberCollector);
        this.httpServer = new HTTPServer(socket, this.prometheusRegistry);

    }

    private void stop() {
        this.httpServer.close();
        this.prometheusRegistry.unregister(tibberCollector);
    }

}
