package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public List<Advertisement> getActiveVideos()
    {
        List<Advertisement> allList = advertisementStorage.list();
        List<Advertisement> result = new ArrayList<Advertisement>();
        for (Advertisement advertisement : allList)
        {
            if (advertisement.getHits()>0)
                result.add(advertisement);
        }
        Collections.sort(result,new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                String n1 = o1.getName();
                String n2 = o2.getName();
                return n1.compareToIgnoreCase(n2);
            }
        });
        return result;
    }

    public List<Advertisement> getArchVideos()
    {
        List<Advertisement> allList = advertisementStorage.list();
        List<Advertisement> result = new ArrayList<Advertisement>();
        for (Advertisement advertisement : allList)
        {
            if (advertisement.getHits()==0)
                result.add(advertisement);
        }
        Collections.sort(result,new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                String n1 = o1.getName();
                String n2 = o2.getName();
                return n1.compareToIgnoreCase(n2);
            }
        });
        return result;
    }
}
