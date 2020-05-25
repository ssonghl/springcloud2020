package org.example.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author: songhl
 * @datetime: 2020/5/23 16:55:04
 * @description:
 */
@Slf4j
public class TimeDemo {

    @Test
    public void timeZone() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        log.info("打印时区：{}", zonedDateTime);

    }
}
