package com.markus.service.load.balanced;

import java.util.ArrayList;
import java.util.List;

import static com.markus.service.load.balanced.ServerRegister.ipInfoMap;

/**
 * @author: markus
 * @date: 2024/2/25 2:04 PM
 * @Description: 轮询算法
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class RoundAlgorithm {

    private static List<String> getIpList() {
        List<String> result = new ArrayList<>(ipInfoMap.size());
        result.addAll(ipInfoMap.keySet());
        return result;
    }

    // 起始位置
    private static Integer round = 0;

    public static String getIpByRoundAlgorithm() {
        List<String> ipList = getIpList();
        String ip = ipList.get(round);
        round = (round + 1) % ipList.size();
        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String ip = getIpByRoundAlgorithm();
            System.out.println("选择的 IP 为 : " + ip);
        }
    }
}
