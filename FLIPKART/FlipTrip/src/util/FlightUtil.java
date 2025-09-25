package util;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class FlightUtil {
    private static AtomicInteger idCounter = new AtomicInteger(0);

    public static int getFlightId() {
        return idCounter.incrementAndGet();
    }
}
