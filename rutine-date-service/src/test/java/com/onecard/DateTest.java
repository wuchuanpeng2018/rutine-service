package com.onecard;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.Date;

/**
 * @description: 时间处理测试
 * 项目开发阶段，有一个关于下单发货的需求：如果今天下午 3 点前进行下单，
 * 那么发货时间是明天，如果今天下午 3 点后进行下单，
 * 那么发货时间是后天，如果被确定的时间是周日，那么在此时间上再加 1 天为发货时间。
 * @author: wuchu
 * @date: Created in 2019/6/16 15:58
 */
public class DateTest {

    //distribution_time_split_time,当前3点
    final DateTime DISTRIBUTION_TIME_SPLIT_TIME_ = new DateTime().withTime(15,0,0,0);

    final DateTime DISTRIBUTION_TIME_SPLIT_TIME = new DateTime(2019, 06,14,15,0).withTime(15,0,0,0);

    public static void main(String[] args) {

        DateTime DISTRIBUTION_TIME_SPLIT_TIME_ORDER = new DateTime(2019, 06,14,15,0).withTime(16,0,0,0);

        System.out.println(new DateTest().DISTRIBUTION_TIME_SPLIT_TIME_.toLocalDateTime());
        System.out.println(new DateTest().DISTRIBUTION_TIME_SPLIT_TIME.toLocalDateTime());
        System.out.println(new DateTest().calculateDistributionTimeByOrderCreateTime(DISTRIBUTION_TIME_SPLIT_TIME_ORDER.toDate()));
    }

    private Date calculateDistributionTimeByOrderCreateTime(Date orderCreateTime){
        DateTime orderCreateDateTime = new DateTime(orderCreateTime);
        Date tomorrow = orderCreateDateTime.plusDays(1).toDate();
        Date theDayAfterTomorrow = orderCreateDateTime.plusDays(2).toDate();
        return orderCreateDateTime.isAfter(DISTRIBUTION_TIME_SPLIT_TIME) ? wrapDistributionTime(theDayAfterTomorrow) : wrapDistributionTime(tomorrow);
    }
    private Date wrapDistributionTime(Date distributionTime){
        DateTime currentDistributionDateTime = new DateTime(distributionTime);
        DateTime plusOneDay = currentDistributionDateTime.plusDays(1);
        boolean isSunday = (DateTimeConstants.SUNDAY == currentDistributionDateTime.getDayOfWeek());
        return isSunday ? plusOneDay.toDate() : currentDistributionDateTime.toDate() ;
    }

}
