package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticEventManager {
        private static StatisticEventManager ourInstance = new StatisticEventManager();
        private static StatisticStorage storage = new StatisticStorage();
    private final Set<Cook> set = new HashSet<Cook>();

         public static StatisticEventManager getInstance()
    {
        return ourInstance;
    }

    private StatisticEventManager()
    {
    }

    private static class StatisticStorage
    {
        private Map<EventType, List<EventDataRow>> map = new HashMap<>(); //private
        public StatisticStorage()
        {
            for (EventType type : EventType.values())
                map.put(type, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data)
        {
            map.get(data.getType()).add(data);
        }

        private List<EventDataRow> getList(EventType eventType)
        {
            return map.get(eventType);
        }

    }
    public void register(Cook cook){
        if (cook == null) return;
        this.set.add(cook);
    }

    public void register(EventDataRow data)
    {
        if (data == null) return;
        storage.put(data);
    }

    public Map<Date, Object> getAdRevenue(){
        List<EventDataRow> list = storage.getList(EventType.SELECTED_VIDEOS);
        Map<Date, Object> results = new TreeMap<Date, Object>(Collections.reverseOrder());
        for (EventDataRow vsedr : list){
            VideoSelectedEventDataRow video = (VideoSelectedEventDataRow) vsedr;
            Date key = getRightDate(video.getDate());
            if (results.containsKey(key)) results.put(key, (Double) results.get(key) + 0.01d * video.getAmount());
            else results.put(key, video.getAmount() * 0.01d);
        }
        return results;
    }
    public Map<Date, Object> getCookWorkload(){
        List<EventDataRow> list = storage.getList(EventType.COOKED_ORDER);
        Map<Date, Object> results = new TreeMap<Date, Object>(Collections.reverseOrder());
        for (EventDataRow coedr : list){
            CookedOrderEventDataRow cooks = (CookedOrderEventDataRow) coedr;
            Date key = getRightDate(cooks.getDate());
            Integer time = (cooks.getTime() + 59) / 60;
            if (results.containsKey(key)) {
                HashMap<String, Integer> temp = (HashMap<String, Integer>) results.get(key);
                if (temp.containsKey(cooks.getCookName())) temp.put(cooks.getCookName(), temp.get(cooks.getCookName()) + time);
                else temp.put(cooks.getCookName(), time);
                results.put(key, temp);
            } else {
                HashMap<String, Integer> temp = new HashMap<String, Integer>();
                temp.put(cooks.getCookName(), time);
                results.put(key, temp);
            }
        }
        return results;
    }
    private Date getRightDate(Date date){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        gc.set(Calendar.HOUR_OF_DAY, 0);
        gc.set(Calendar.MINUTE, 0);
        gc.set(Calendar.SECOND, 0);
        gc.set(Calendar.MILLISECOND, 0);
        return gc.getTime();
    }
}
