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
        long[][] ary = new long[Integer.MAX_VALUE][Integer.MAX_VALUE];
        return "Hello, " + name;
    }

    @GetMapping("/good")
    public String normal() {
        return "A good call.";
    }
}
