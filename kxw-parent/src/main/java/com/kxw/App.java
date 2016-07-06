package com.kxw;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        List<String> list = app.getGroup("", "1234");
        list.forEach(System.out::println);
        System.out.println("----------总记录数----------");
        System.out.println(list.size());

        //去掉重复分组
        
    }

    public List<String> getGroup(String key, String str) {
        List<String> result = new ArrayList<>();
        if (str.length() == 2) {
            key += str.charAt(0) + " " + str.charAt(1) + " ";
            result.add(key);
            return result;
        }
        for (int i = 0; i < str.length(); i += 2) {
            for (int j = i + 1; j < str.length(); j++) {
                StringBuffer buffer = new StringBuffer();
                for (int k = 0; k < str.length(); k++) {
                    if (k != i && k != j) {
                        buffer.append(str.charAt(k));
                    }
                }
                String newKey = str.charAt(i) + " " + str.charAt(j) + " ";
                result.addAll(getGroup(key + newKey, buffer.toString()));
            }
        }
        return result;
    }

}
