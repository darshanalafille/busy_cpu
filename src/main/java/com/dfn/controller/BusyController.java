package com.dfn.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.tan;
import static java.lang.Math.atan;

@RestController
public class BusyController {

    private static final Logger logger = LogManager.getLogger(BusyController.class);

    AtomicInteger count = new AtomicInteger(0);
    AtomicInteger inPThreads = new AtomicInteger(0);

    @GetMapping("/api/fuckCpu")
    public ResponseEntity<Result> getBusyCpuResp(){
        logger.info("Got New Requests, count {} ", count.get());
        logger.info("In Progress Thread {} ",inPThreads.incrementAndGet());
        long st = System.currentTimeMillis();
        double resu = fuckCpu();
        count.set(count.get() + 1);
        inPThreads.decrementAndGet();
        return ResponseEntity.ok(new Result(true,resu,(System.currentTimeMillis() - st)));
    }

    @GetMapping("/api/testMe")
    public ResponseEntity testMe(){
        logger.info("Calling test end point");
       return ResponseEntity.ok("Ok");
    }


    private static double fuckCpu(){
        long st = System.currentTimeMillis();
        double result = 0;
        for (int i=0; i<1_000_999_0; i++) {
            double val = ThreadLocalRandom.current().nextDouble(123456789.123456789,987654321.9876543);
            result = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(val))))))))));
        }
        logger.info("Time " + (System.currentTimeMillis() - st));
        return result;
    }



}
