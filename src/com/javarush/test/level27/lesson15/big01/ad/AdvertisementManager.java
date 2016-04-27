package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    List<Advertisement> videos = storage.list();
    private int timeSeconds;
    long maxProf = 0;
    int minTimeRem = timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> bestList = new ArrayList<>();
        bestList = videoPick(null, null, timeSeconds, 0, bestList);
        long totalAmount = 0;
        int totalDuration = 0;
        for (Advertisement ad : bestList) {
            totalAmount += ad.getAmountPerOneDisplaying();
            totalDuration += ad.getDuration();
        }
        StatisticEventManager.getInstance().register(new VideoSelectedEventDataRow(bestList, totalAmount, totalDuration));

        for (Advertisement ad : bestList) {
            ad.revalidate();
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", ad.getName(), ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration()));
        }
    }
    private List<Advertisement> videoPick(List<Advertisement> previousVideosList, Advertisement previousAd, int remainingTime, long prof, List<Advertisement> bestRes) throws NoVideoAvailableException {
        List<Advertisement> newList = new ArrayList<>();
        if (previousVideosList != null) {
            newList.addAll(previousVideosList);
            remainingTime -= previousAd.getDuration();
            prof += previousAd.getAmountPerOneDisplaying();
            newList.add(previousAd);
        }

        for (Advertisement ad : videos) {
            if (remainingTime == 0)
                break;
            if (newList.contains(ad))
                continue;
            if (ad.getHits() <= 0)
                continue;
            if (remainingTime >= ad.getDuration()) {
                bestRes = videoPick(newList, ad, remainingTime, prof, bestRes);
            }
        }
        if (prof > maxProf) {
            maxProf = prof;
            minTimeRem = remainingTime;
            bestRes = newList;
        } else if (prof == maxProf && remainingTime < minTimeRem) {
            minTimeRem = remainingTime;
            bestRes = newList;
        } else if (prof == maxProf && remainingTime == minTimeRem && bestRes.size() > newList.size()) {
            bestRes = newList;
        }
        if (bestRes.isEmpty()) {
            throw new NoVideoAvailableException();
        }
        Collections.sort(bestRes, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                long price = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                if (price != 0)
                    return (int) price;
                else
                    return (int) (o1.getAmountPerOneDisplaying() * 100 / o1.getDuration() - o2.getAmountPerOneDisplaying() * 100 / o2.getDuration());
            }
        });
        return bestRes;
    }
}