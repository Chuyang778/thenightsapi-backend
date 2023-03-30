package com.yupi.project.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ChuYang
 * @version 1.0
 */
@Component
public class RedPocketUtils {
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        if (totalPeopleNum > 0 && totalPeopleNum > 0) {
            Integer restAmount = totalAmount;
            Integer restPeopleNum = totalPeopleNum;
            Random random = new Random();
            for (int i = 1; i <= totalPeopleNum - 1; i++) {
                Integer amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
                restAmount -= amount;
                restPeopleNum--;
                amountList.add(amount);
            }
            amountList.add(restAmount);
        }
        return amountList;
    }
}
