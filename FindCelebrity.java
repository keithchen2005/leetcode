package com.leetcode_new;

/*
 * from http://algobox.org/find-the-celebrity/
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and 
 * among them, there may exist one celebrity. The definition of a 
 * celebrity is that all the other n - 1 people know him/her but he/she 
 * does not know any of them.

Now you want to find out who the celebrity is or verify that there is 
not one. The only thing you are allowed to do is to ask questions like: 
“Hi, A. Do you know B?” to get information of whether A knows B. 
You need to find out the celebrity (or verify there is not one) by 
asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether 
A knows B.
Implement a function int findCelebrity(n), your function should minimize 
the number of calls to knows.

Note:
There will be exactly one celebrity if he/she is in the party. Return the 
celebrity’s label if there is a celebrity in the party. If there is no 
celebrity, return -1.
 */
public class FindCelebrity {

  public static void main(String[] args) {
    int n = 100;
    FindCelebrity prog = new FindCelebrity();
    int celebrityIndex = prog.findCelebrity(n);
    System.out.println(celebrityIndex);
  }
  
  /*
   * return celebrity's index 
   * if a celebrity exists, it must be in [0..n-1]
   * if no celebrity, return -1;
   * 
   * Note: it is possible that there is no celebrity
   * 
   * reference: http://algobox.org/find-the-celebrity/
   * 
   */
  //return celebrity's label
  //return -1, if no celebrity
  //minimize calls to knows()
  //critical:
  //minimum calls to knows() is 2.5 * n in average
  public int findCelebrity(int n) {
      int cur = 0;
      for (int i = 1; i < n; ++i) {
          //whether cur knows i
          boolean res = knows(cur, i);
          if (res) {
              //cur is not celebrity
              //i may be celebrity
              cur = i;
          } else {
              //i is not celebrity
              //cur may be
          }
      }
      
      //if there is a celebrity, then cur must be the celebrity
      //but there can be no celebrity, 
      //so cur maybe the celebrity.
      //
      //now we need to check two things:
      //1. whether all others knows cur
      //AND
      //2. whether cur knows all people before cur
      for (int i = 0; i < n; ++i) {
          if (i != cur) {
              if (!knows(i, cur)) {
                  return -1;
              }
          }
      }
      
      //whether cur knows all people before cur
      for (int i = 0; i < cur; ++i) {
          if (knows(cur, i)) {
              return -1;
          }
      }
      
      return cur;
  }

  /*
   * whether A knows B
   * 
   * assume celebrity index is 98
   */
  private boolean knows(int a, int b) {
    if (b == 98) {
      return true;
    } else if (a == 98) {
      return false;
    }
    
    //b != 98 && a != 98
    if (a < 50) {
      return true;
    } else {
      return false;
    }
  }
}
