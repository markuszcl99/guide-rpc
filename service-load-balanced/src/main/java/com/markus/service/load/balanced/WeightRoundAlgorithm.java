package com.markus.service.load.balanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.markus.service.load.balanced.ServerRegister.ipInfoMap;

/**
 * @author: markus
 * @date: 2024/2/25 2:04 PM
 * @Description: 加权轮询算法
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WeightRoundAlgorithm {

    private static List<String> getIpList() {
        List<String> result = new ArrayList<>(ipInfoMap.size());
        for (Map.Entry<String, IpInfo> entry : ipInfoMap.entrySet()) {
            String ip = entry.getKey();
            IpInfo ipInfo = entry.getValue();
            // 根据权重 像可用列表里增加相应 IP 出现的次数
            for (int i = 0; i < ipInfo.getWeight(); i++) {
                result.add(ip);
            }
        }

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
