package com.restservice.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

   @GetMapping("/get/{month}") // expl http://localhost:8080/get/5
   public MonthAsString getMonth(@PathVariable("month") Integer month) {
      return new MonthAsString(month);
   }

   @PostMapping("/sort")  // expl http://localhost:8080/post { "strings" : ["somestring", "12345", ...] }
   public Sorted sort(@RequestBody Sorted sorted){
      if (sorted != null && sorted.getStrings() != null){
         return new Sorted(Sorted.sortedStringArray(sorted.getStrings()));
      }
      else return null;
   }
}
