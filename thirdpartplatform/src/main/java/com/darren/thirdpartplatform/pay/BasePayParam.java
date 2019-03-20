package com.darren.thirdpartplatform.pay;

/**
 * 第三方支付sdk必须参数基类
 */
public class BasePayParam {
    /**
     * 订单价格
     * 间接将值传递给 {@link Payment#mPrice}
     * 简化调用传值
     */
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
