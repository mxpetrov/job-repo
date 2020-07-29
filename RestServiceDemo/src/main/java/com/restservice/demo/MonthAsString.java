package com.restservice.demo;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthAsString {
   private String month;

   public MonthAsString(int number){
      if (numberIsOk(number)){
         month = getMonthAsString(number);
      } else {
         month = "INCORRECT INPUT DATA";
      }
   }

   public String getMonth() {
      return month;
   }

   public void setMonth(String month) {
      this.month = month;
   }

   private static String getMonthAsString(int number) {
      Month m = Month.of(number);
      Locale loc = Locale.forLanguageTag("ru");
      String month = m.getDisplayName(TextStyle.FULL_STANDALONE, loc).toUpperCase();
      StringBuilder sb = new StringBuilder(month);
      for (int i = 1, j = 1; i < month.length(); i++, j+=2) {
         sb.insert(j, "-");
      }
      return sb.toString();
   }

   private static boolean numberIsOk(int number) {
      return number > 0 && number <= 13;
   }
}
