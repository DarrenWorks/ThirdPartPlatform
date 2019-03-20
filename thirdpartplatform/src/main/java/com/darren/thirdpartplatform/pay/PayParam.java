package com.darren.thirdpartplatform.pay;

/**
 * 下单接口必备参数数据类
 */
public class PayParam extends BasePayParam {
    /**
     * appid : wx8251cb908bb4fb86
     * noncestr : 7bbf26281a1340b7ab27709c0c7d390a
     * package : Sign=WXPay
     * packageValue : Sign=WXPay
     * partnerid : 1487943032
     * prepayid : wx14112033877332c8770c75c43047930301
     * recharge_id : 20180914112033355724
     * sign : 93576F9D5C5F4C3AF8032ABE17F25BF1
     * timestamp : 1536895233
     */

    private String appid;
    private String noncestr;
    private String packageValue;
    private String partnerid;
    private String prepayid;
    private String recharge_id;
    private String sign;
    private String timestamp;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepayid(String prepayid) {
        this.prepayid = prepayid;
    }

    public String getRecharge_id() {
        return recharge_id;
    }

    public void setRecharge_id(String recharge_id) {
        this.recharge_id = recharge_id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
