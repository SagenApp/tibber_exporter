package app.sagen.api;

import app.sagen.api.model.Home;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class TibberAPIClient extends ApiClient implements TibberAPI {

    private static final Logger logger = LoggerFactory.getLogger(TibberAPIClient.class);

    private static final String BASE_URI = "https://api.tibber.com/v1-beta/gql";
    private final String tibberToken;

    public TibberAPIClient(String tibberToken) {
        this.tibberToken = tibberToken;
        Configuration.setDefaults(new JsonConfiguration());
    }

    public Home[] fetchHomes() throws IOException {
        String query = """
                  {
                    viewer {
                      homes {
                        id,
                        timeZone,
                        appNickname,
                        appAvatar,
                        size,
                        type,
                        numberOfResidents,
                        primaryHeatingSource,
                        hasVentilationSystem,
                        mainFuseSize,
                        address {
                          address1,
                          address2,
                          address3,
                          city,
                          postalCode,
                          country,
                          latitude,
                          longitude
                        },
                        owner {
                          id,
                          firstName,
                          isCompany,
                          name,
                          middleName,
                          lastName,
                          organizationNo,
                          language,
                          contactInfo {
                            email,
                            mobile
                          }
                          address {
                            address1,
                            address2,
                            address3,
                            city,
                            postalCode,
                            country,
                            latitude,
                            longitude
                          }
                        }
                      }
                    }
                  }
                """;

        String result = doFetch(query, BASE_URI, tibberToken);

        return JsonPath.parse(result).read("$.data.viewer.homes[*]", Home[].class);
    }

}
