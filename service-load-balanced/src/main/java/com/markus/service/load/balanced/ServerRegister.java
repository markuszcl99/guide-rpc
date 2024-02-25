package com.markus.service.load.balanced;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: markus
 * @date: 2024/2/25 2:05 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ServerRegister {
    public static final Map<String, IpInfo> ipInfoMap = new HashMap<>();

    static {
        ipInfoMap.put("192.168.163.1", new IpInfo("192.168.163.1", 1));
        ipInfoMap.put("192.168.163.2", new IpInfo("192.168.163.2", 2));
        ipInfoMap.put("192.168.163.3", new IpInfo("192.168.163.3", 3));
        ipInfoMap.put("192.168.163.4", new IpInfo("192.168.163.4", 4));
    }
}
