import java.util.Random;

public class DockSimulation {
    private final Random random = new Random();

    public static void start(){
        for (int i = 0; i <= 86400; i++) {
            System.out.print("\rВремя: " + secondsToTime(i));
            try {
                Thread.sleep(1); // задержка для наглядности
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private long nextEventTime(double meanInterval) {
        return (long) (-Math.log(0.1 - random.nextDouble()) * meanInterval);
    }

    private static String secondsToTime(int totalSeconds) {
        String currentTime = "";
        int hours = totalSeconds / 3600; // 3600 секунд в одном часе
        int minutes = (totalSeconds % 3600) / 60; // остаток после часов делим на 60
        currentTime = hours<10 ? "0" + hours : "" + hours;
        currentTime += ":";
        currentTime += minutes<10 ? "0" + minutes : "" + minutes;
        return currentTime;
    }
}
