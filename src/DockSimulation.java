import java.util.Random;

public class DockSimulation {
    private final Random random = new Random();

    public long nextEventTime(double meanInterval) {
        return (long) (-Math.log(0.1 - random.nextDouble()) * meanInterval);
    }
}
