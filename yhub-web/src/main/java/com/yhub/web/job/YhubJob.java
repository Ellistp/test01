package com.yhub.web.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chengtianping
 * @description
 * @date 2018/8/8
 */
@Component
public class YhubJob {

    private Logger logger = LoggerFactory.getLogger(YhubJob.class);

    public final static long ONE_MINUTE =  10 * 1000;

    /**
     * fixedDelay：当任务执行完毕后x毫秒后再执行下一个任务
     * @throws InterruptedException
     */
    @Scheduled(fixedDelay = ONE_MINUTE)
    public void fixedDelayJob() throws InterruptedException {
        logger.debug("fixedDelayJob start =====");
    }

    /**
     * fixedRate： 每隔x毫秒执行一次，不论你业务执行花费了多少时间
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = ONE_MINUTE)
    public void fixedRateJob() throws InterruptedException {
        logger.debug("fixedRateJob start =====");
    }

    /**
     * 第一位，表示秒，取值0-59
     * 第二位，表示分，取值0-59
     * 第三位，表示小时，取值0-23
     * 第四位，日期天/日，取值1-31
     * 第五位，日期月份，取值1-12
     * 第六位，星期，取值1-7，1表示星期天，2表示星期一
     * 第七位，年份，可以留空，取值1970-2099
     */
    @Scheduled(cron="0 0 0 * * ?")
    public void cronJob(){
        logger.info("cronJob start =====");
    }
}
