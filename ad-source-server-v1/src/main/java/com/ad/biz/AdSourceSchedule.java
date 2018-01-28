package com.ad.biz;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ad.biz.source.AdSourceScheduleService;

public class AdSourceSchedule {

	private static ScheduledExecutorService poolService = Executors.newScheduledThreadPool(2);

	public static void startScheculed() {
		poolService.scheduleAtFixedRate(AdSourceScheduleService.runGetStaticAdSchedule, 1, 2, TimeUnit.MINUTES);
		poolService.scheduleAtFixedRate(AdSourceScheduleService.runGetSubAdSchedule, 1, 2, TimeUnit.MINUTES);
	}

}
