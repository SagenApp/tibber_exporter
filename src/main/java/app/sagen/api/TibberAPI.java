package app.sagen.api;

import app.sagen.api.model.Home;

import java.io.IOException;

public interface TibberAPI {

    Home[] fetchHomes() throws IOException;

}
