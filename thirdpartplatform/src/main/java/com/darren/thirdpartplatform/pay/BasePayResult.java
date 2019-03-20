package com.darren.thirdpartplatform.pay;


/**
 * 查询订单返回值基类
 */
public abstract class BasePayResult extends NetData {
    @Override
    protected abstract BasePayData getData();

    public static class BasePayData {
        protected PayParam payParam;

        public PayParam getPayParam() {
            return payParam;
        }
    }
}
