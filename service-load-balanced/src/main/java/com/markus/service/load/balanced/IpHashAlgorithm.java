package com.markus.service.load.balanced;

import java.util.ArrayList;
import java.util.List;

import static com.markus.service.load.balanced.ServerRegister.ipInfoMap;

/**
 * @author: markus
 * @date: 2024/2/25 2:41 PM
 * @Description: IP-HASH 一致性 HASH 算法
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class IpHashAlgorithm {

    private static List<String> getIpList() {
        List<String> result = new ArrayList<>(ipInfoMap.size());
        result.addAll(ipInfoMap.keySet());
        return result;
    }

    // 这里 请求入参 仅是简单的设置 String remoteIP
    public static String getIpByIpHashAlgorithm(String remoteIp) {
        List<String> ipList = getIpList();

        int hashCode = remoteIp.hashCode();
        int index = hashCode % ipList.size();
        return ipList.get(index);
    }

    public static void main(String[] args) {
        String remoteIp = "127.0.0.1";
        for (int i = 0; i < 20; i++) {
            String ip = getIpByIpHashAlgorithm(remoteIp);
            System.out.println("remoteIp " + remoteIp + " 选择的 IP 为 : " + ip);
        }

        remoteIp = "192.168.163.11";
        for (int i = 0; i < 20; i++) {
            String ip = getIpByIpHashAlgorithm(remoteIp);
            System.out.println("remoteIp " + remoteIp + " 选择的 IP 为 : " + ip);
        }
    }
}
