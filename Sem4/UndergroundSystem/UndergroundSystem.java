import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class UndergroundSystem {

    private Map<List, ArrayList> cityTime = new Hashtable<>();

    private Map<Integer, String> cityStart = new Hashtable<>();
    private Map<Integer, Integer> timeStart = new Hashtable<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        cityStart.put(id, stationName);
        timeStart.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        if (cityStart.containsKey(id)) {
            if (cityTime.containsKey(Arrays.asList(cityStart.get(id), stationName))) {
                ArrayList<Integer> resTime = cityTime.get(Arrays.asList(cityStart.get(id), stationName));
                resTime.add(t - timeStart.get(id));
                cityTime.put(Arrays.asList(cityStart.get(id), stationName), resTime);
            } else {
                ArrayList<Integer> resTime = new ArrayList<>();
                resTime.add(t - timeStart.get(id));
                cityTime.put(Arrays.asList(cityStart.get(id), stationName), resTime);

            }
        }

    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> citys = cityTime.get(Arrays.asList(startStation, endStation));
        double resTime = 0;
        for (int i = 0; i < citys.size(); i++) {
            resTime += citys.get(i);
        }
        return resTime / citys.size();
    }
}