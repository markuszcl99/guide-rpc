package com.markus.service.load.balanced;

/**
 * @author: markus
 * @date: 2024/2/25 1:49 PM
 * @Description:
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class IpInfo {

    private String ipAddr;
    private Integer weight;

    private Integer activeLink;

    public IpInfo(String ipAddr, Integer weight) {
        this.ipAddr = ipAddr;
        this.weight = weight;
        this.activeLink = 0;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getActiveLink() {
        return activeLink;
    }

    public void setActiveLink(Integer activeLink) {
        this.activeLink = activeLink;
    }

    @Override
    public String toString() {
        return "IpInfo{" +
                "ipAddr='" + ipAddr + '\'' +
                ", weight=" + weight +
                ", activeLink=" + activeLink +
                '}';
    }
}
