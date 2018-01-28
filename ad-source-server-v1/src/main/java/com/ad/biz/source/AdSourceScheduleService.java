package com.ad.biz.source;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ad.biz.mem.buffer.AdSourceBuffer;
import com.ad.biz.source.apihandler.AgentBaseHandler;
import com.ad.biz.source.apihandler.AgentHandlerGroup;
import com.sdk.core.cache.jedis.JedisDao;
import com.sdk.core.cache.jedis.core.type.JLock;

import snowfox.lang.time.DateUtil;

public class AdSourceScheduleService {
	private static final Logger log = LoggerFactory.getLogger(AdSourceScheduleService.class);
	public static Runnable runGetStaticAdSchedule = new Runnable() {

		public void run() {
			try {
				long curTime = System.currentTimeMillis();
				System.out.println("Start runGetStaticAdSchedule now at: " + DateUtil.now(curTime));

				JLock lock = JedisDao.getDao("ad-source").getLock(AdSourceBuffer.adSourceGetStaticAdLock);
				boolean isLock = lock.tryLock(0, TimeUnit.MILLISECONDS);
				if (isLock) {
					try {
						long time1 = System.currentTimeMillis();
						reflashStaticAd();
						long time2 = System.currentTimeMillis();
						System.out.println(String.format("complete runGetStaticAdSchedule  consume :%sms ; start at ： ",
								time2 - time1, DateUtil.now(curTime)));
					} catch (Exception e) {
						log.error("run getStaticAd error : {}", ExceptionUtils.getFullStackTrace(e));
					} finally {
						lock.unlock();
					}
				}
			} catch (Exception e) {
				log.error("runGetStaticAdSchedule error : {}", ExceptionUtils.getFullStackTrace(e));
			}
		}

	};
private static ExecutorService reflashStaticPool=Executors.newFixedThreadPool(30);
	private static void reflashStaticAd() {
try{
	
	System.out.println("reflashStaticAd pool : "+reflashStaticPool);
	
	List<Future<Boolean>>futureLIst=new ArrayList<Future<Boolean>>();
	
	for (Integer partnerId: AgentHandlerGroup.staAgentGroup.keySet()) {
		AgentBaseHandler handler=AgentHandlerGroup.staAgentGroup.get(partnerId);
		futureLIst.add(reflashStaticPool.submit(new reflashStaticTask(handler,partnerId.toString())));
		
	}
}catch(Exception e){
	log.error("reflashTask error : {}", ExceptionUtils.getFullStackTrace(e));
}
	}
	
	private static class reflashStaticTask implements Callable<Boolean>{
		private AgentBaseHandler handler;
		private String	partnerIdStr;
		public reflashStaticTask(AgentBaseHandler handler, String partnerIdStr){
			this.handler=handler;
			this.partnerIdStr=partnerIdStr;
		}
		   public Boolean call() throws Exception {
//			   long time1=System.currentTimeMillis();
			   int campaignSize = this.handler.reflashAPI(this.partnerIdStr);
//			   long time2=System.currentTimeMillis();
			   if(campaignSize>=0){
//				   System.out.println(String.format("updateApiCacheV2 Partner: %s{%s}, campSize: %s, consume: %sms",
//                 this.partnerIdStr,
//                 campaignSize,
//                 (time2 - time1)));
			   }
			   return true;
		   }
	}

	public static Runnable runGetSubAdSchedule = new Runnable() {

		public void run() {
			// TODO Auto-generated method stub

		}
	};
}
