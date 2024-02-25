package com.markus.service.load.balanced;

import java.util.*;

import static com.markus.service.load.balanced.ServerRegister.ipInfoMap;

/**
 * @author: markus
 * @date: 2024/2/25 1:35 PM
 * @Description: 加权随机算法
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class WeightRandomAlgorithm {

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

    public static String getIpByRandomAlgorithm() {
        List<String> ipList = getIpList();

        Random random = new Random();
        // 在 [0,size) 中选择一个随机数
        int index = random.nextInt(ipList.size());
        return ipList.get(index);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String ip = getIpByRandomAlgorithm();
            System.out.println("选择的 IP 为 : " + ip);
        }
    }
}
