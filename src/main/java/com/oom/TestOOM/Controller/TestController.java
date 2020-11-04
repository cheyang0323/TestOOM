package com.oom.TestOOM.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/oom")
public class TestController {
    @GetMapping("/{name}")
    public String tryIt(@PathVariable String name) throws Exception {
        Long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Total memory: " + maxMemory);
        int[] matrix = new int[(int) (maxMemory + 1024000)];
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i] = i + 1;
        }
        int iteratorValue = 20;
        System.out.println("\n=================> OOM test started..\n");
        for (int outerIterator = 1; outerIterator < 20; outerIterator++) {
            System.out.println("Iteration " + outerIterator + " Free Mem: " + Runtime.getRuntime().freeMemory());
            int loop1 = 2;
            int[] memoryFillIntVar = new int[iteratorValue];
            // feel memoryFillIntVar array in loop..
            do {
                memoryFillIntVar[loop1] = 0;
                loop1--;
            } while (loop1 > 0);
            iteratorValue = iteratorValue * 5;
            System.out.println("\nRequired Memory for next loop: " + iteratorValue);
            Thread.sleep(100);
        }
        return "Hello, " + name;
    }

    @GetMapping("/good")
    public String normal() {
        return "A good call.";
    }
}
