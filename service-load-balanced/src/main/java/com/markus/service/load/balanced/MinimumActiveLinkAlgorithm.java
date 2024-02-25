package com.markus.service.load.balanced;

import java.util.ArrayList;
import java.util.List;

import static com.markus.service.load.balanced.ServerRegister.ipInfoMap;

/**
 * @author: markus
 * @date: 2024/2/25 2:56 PM
 * @Description: 最小活跃连接算法
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class MinimumActiveLinkAlgorithm {

    private static List<String> getIpList() {
        List<String> result = new ArrayList<>(ipInfoMap.size());
        result.addAll(ipInfoMap.keySet());
        return result;
    }

    public static String getIpByMinimumActiveLinkAlgorithm() {
        List<String> ipList = getIpList();

        IpInfo minimumActiveLinkIp = null;
        int minimumActiveLinkCount = Integer.MAX_VALUE;

        for (String ip : ipList) {
            IpInfo ipInfo = ipInfoMap.get(ip);
            int activeLinkCount = ipInfo.getActiveLink();
            if (activeLinkCount < minimumActiveLinkCount) {
                minimumActiveLinkCount = activeLinkCount;
                minimumActiveLinkIp = ipInfo;
            }
        }

        System.out.println("当前服务集群节点状态 :" + ipInfoMap);
        if (minimumActiveLinkIp != null) {
            // 本次 连接数加 +1
            Integer activeLink = minimumActiveLinkIp.getActiveLink();
            minimumActiveLinkIp.setActiveLink(activeLink + 1);
        }
        return minimumActiveLinkIp != null ? minimumActiveLinkIp.getIpAddr() : null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String ip = getIpByMinimumActiveLinkAlgorithm();
            System.out.println("选择的 IP 为 :" + ip);
        }

    }
}
