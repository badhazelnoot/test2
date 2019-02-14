//dies ist ein kommentar 

package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

	public static new_feature(String x) {
		System.out.prinln("cool");
	}

    public static List<Integer> findPermutations(String a, String b) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> str = new HashMap<>();

        for (int i = 0; i < a.length(); i++) { // O(a)
            if(str.containsKey(a.charAt(i))) {
                str.put(a.charAt(i), str.get(a.charAt(i)) + 1);
            } else {
                str.put(a.charAt(i), 1);
            }
        }

        HashMap<Character, Integer> strh = new HashMap<>(str);

        for (int i = 0; i < b.length(); i++) { // O(b)
            if(!strh.containsKey(b.charAt(i))) {
                strh = new HashMap<>(str);
            }

            if(strh.containsKey(b.charAt(i))) {
                int val = strh.get(b.charAt(i));

                if(val - 1 <= 0) {
                    strh.remove(b.charAt(i));
                } else {
                    strh.put(b.charAt(i), val - 1);
                }

                if(strh.size() == 0) {
                    result.add(i - (a.length() - 1));
                    strh = new HashMap<>(str);
		    i = i - (a.length() - 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "abbc";
        String b = "ababadcbbabbcbabaabccababbc";

        List<Integer> test = findPermutations(a, b);

        for(int x: test) {
            System.out.println(x);
        }
    }
}
