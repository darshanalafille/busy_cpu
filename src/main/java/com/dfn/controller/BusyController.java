package com.dfn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.tan;
import static java.lang.Math.atan;

@RestController
public class BusyController {

    @GetMapping("/api/fuckCpu")
    public ResponseEntity<Result> getBusyCpuResp(){
        long st = System.currentTimeMillis();
        double resu = fuckCpu();
        return ResponseEntity.ok(new Result(true,resu,(System.currentTimeMillis() - st)));
    }


    private static double fuckCpu(){
        long st = System.currentTimeMillis();
        double result = 0;
        for (int i=0; i<1_000_000; i++) {
            double val = ThreadLocalRandom.current().nextDouble(123456789.123456789,987654321.9876543);
            result = tan(atan(tan(atan(tan(atan(tan(atan(tan(atan(val))))))))));
        }
        System.out.println("Time " + (System.currentTimeMillis() - st));
        return result;
    }



}
