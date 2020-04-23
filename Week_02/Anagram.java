package org.geekbang.ljz.Week_02;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class Anagram {
    @Test
    public void testAnagram() {
        boolean isTrue = isAnagram4("anagram", "nagaram");//"anagram", "nagaram"
        System.out.println(isTrue);
    }

    //错误测试
    public boolean isAnagram(String s, String t) {
        if (s != null && t != null && s.length() == t.length()) {
            //只包含小写字母
            Pattern pattern = Pattern.compile("^[a-z]+$");
            Matcher ms = pattern.matcher(s);
            Matcher mt = pattern.matcher(t);
            HashMap<Character, Integer> smap = new HashMap<>();
            HashMap<Character, Integer> tmap = new HashMap<>();
            if (!(ms.matches() && mt.matches())) return false;

            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                int ts = smap.get(sc) == null ? 0 : smap.get(sc);
                smap.put(sc, ts + 1);
                sc = t.charAt(i);
                ts = tmap.get(sc) == null ? 0 : tmap.get(sc);
                tmap.put(sc, ts + 1);
            }
            for (char stemp : smap.keySet()) {
                if (tmap.get(stemp) != smap.get(stemp)) return false;
            }
            return true;
        }
        return false;
    }

    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length() || s.equals(t)) return false;
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
//        if (Arrays.equals(ss,ts)) return true;
        for (int i = 0; i < s.length(); i++) {
            if (ss[i] != ts[i]) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int v : counter) {
            if (v != 0) return false;
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer v = counter.get(s.charAt(i));
            counter.put(s.charAt(i), v == null ? 1 : ++v);
            Integer tv = counter.get(t.charAt(i));
            counter.put(t.charAt(i), tv == null ? -1 : --tv);
        }
        for (int v : counter.values()) {
            if (v != 0) return false;
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        for (int i = 0, v; i < t.length(); i++) {
            v = counter[t.charAt(i) - 'a']--;
            if (v < 0) return false;
        }
        return true;
    }
}
