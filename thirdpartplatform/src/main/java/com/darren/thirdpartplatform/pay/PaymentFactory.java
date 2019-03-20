package com.darren.thirdpartplatform.pay;


import com.darren.thirdpartplatform.base.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link Payment} 工厂类，实现单例模式
 */
public class PaymentFactory extends Singleton {
    private static PaymentFactory instance;

    private final Map<PayWay, Payment> mPaymentMap = new HashMap<>();//利用map实现每种支付方式的payment均保存一个实例

    public static PaymentFactory getInstance() {
        if (instance == null) {
            instance = new PaymentFactory();
        }
        return instance;
    }

    /**
     * 仅在map中没有需要实例时创建并存入map
     */
    public Payment getPayment(PayWay payWay) {
        if (!mPaymentMap.containsKey(payWay)) {
            mPaymentMap.put(payWay, createPayment(payWay));
        }
        return mPaymentMap.get(payWay);
    }

    /**
     * 创建Payment实例
     * @param payWay 支付方式
     * @return payment实例
     */
    private Payment createPayment(PayWay payWay) {
        Payment payment = null;
        switch (payWay) {
            case WECHAT:
                payment = new WechatPayment();
                break;
            case ALI:
                payment = new AliPayment();
                break;
        }
        return payment;
    }
}
