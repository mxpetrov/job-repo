package com.restservice.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {
   private ArrayList<String> strings;

   @JsonCreator
   public Sorted(@JsonProperty("strings")ArrayList<String> strings) {
      this.strings = strings;
   }

   public ArrayList<String> getStrings() {
      return strings;
   }

   public void setStrings(ArrayList<String> strings) {
      this.strings = strings;
   }

   public static ArrayList<String> sortedStringArray(ArrayList<String> stringArray) {
      ArrayList<String> sortedStrings = new ArrayList<>(stringArray);
      sortedStrings.sort((a, b) -> a.length() > b.length() ? 1 : (a.length() < b.length() ? -1 : a.compareTo(b)));
      List<String> collect = sortedStrings.stream().map(s -> s = String.format("(%d): %s", s.length(), s)).collect(Collectors.toList());
      return (ArrayList<String>) collect;
   }
}
