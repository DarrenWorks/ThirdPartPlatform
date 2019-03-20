package com.darren.thirdpartplatform.pay;

import com.darren.thirdpartplatform.base.Singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂类，实现单例模式
 */
public class PayHelperFactory extends Singleton {
    private static PayHelperFactory instance;

    private final Map<PayWay, PayHelper> mPayHelperMap = new HashMap<>();

    public static PayHelperFactory getInstance() {
        if (instance == null) {
            instance = new PayHelperFactory();
        }
        return instance;
    }

    /**
     * 仅在map中没有需要实例时创建并存入map
     */
    public PayHelper getPayHelper(PayWay payWay) {
        if (!mPayHelperMap.containsKey(payWay)) {
            mPayHelperMap.put(payWay, createPayHelper(payWay));
        }
        return mPayHelperMap.get(payWay);
    }

    /**
     * 创建payHelper实例
     * @param payWay 支付方式
     * @return payHelper实例
     */
    private PayHelper createPayHelper(PayWay payWay) {
        PayHelper payHelper = null;
        switch (payWay) {
            case WECHAT:
                payHelper = new WechatPayHelper();
                break;
            case ALI:
                payHelper = new AliPayHelper();
                break;
        }
        return payHelper;
    }
}
