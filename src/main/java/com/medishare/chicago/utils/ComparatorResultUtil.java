package com.medishare.chicago.utils;

import com.medishare.chicago.domain.reservation.Result;

import java.util.Comparator;


public class ComparatorResultUtil implements Comparator<Result> {
  //排列即从从小到大，若需要修改返回值1 和 -1  
  @Override
  public int compare(Result o1, Result o2) {  
      double score1 = getSort(o1);
      double score2 = getSort(o2);
      if (score1 > score2) {  
          return 1;  
      } else if (score1 < score2) {  
          return -1;  
      } else {  
          return 0;  
      }  
  }
  private static int getSort(Result res) {
    if ("am".equals(res.getDayPart())) {
      return 1;
    } else if ("pm".equals(res.getDayPart())) {
      return 2;
    } else {
      return 0;
    }
  }
  
}
