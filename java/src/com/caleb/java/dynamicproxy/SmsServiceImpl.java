package com.caleb.java.dynamicproxy;

/**
 * @author：hanzhigang
 * @Date : 2021/1/24 4:17 PM
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String s) {
        System.out.println("send message:" + s);
        return s;
    }
}
