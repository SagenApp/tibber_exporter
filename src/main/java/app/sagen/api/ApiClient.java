package app.sagen.api;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiClient {

    private static final String BODY_WRAPPER = "{\"query\": \":query\"}";

    protected String doFetch(String query, String url, String token) throws IOException {
        URL tibberUrl = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) tibberUrl.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + token);
        connection.setDoOutput(true);
        connection.setDoInput(true);

        query = query.replaceAll("\n", "");
        String body = BODY_WRAPPER.replace(":query", query);

        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = body.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(getResultStreamFromConnection(connection), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = bufferedReader.readLine()) != null) {
                response.append(responseLine.trim());
            }
            return response.toString();
        }
    }

    private InputStream getResultStreamFromConnection(HttpsURLConnection connection) throws IOException {
        InputStream inputStream = connection.getErrorStream();
        if (inputStream == null) {
            inputStream = connection.getInputStream();
        }
        return inputStream;
    }

}
