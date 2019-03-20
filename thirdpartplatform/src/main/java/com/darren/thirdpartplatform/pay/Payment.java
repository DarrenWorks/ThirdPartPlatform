package com.darren.thirdpartplatform.pay;

import android.app.Activity;

import com.darren.thirdpartplatform.base.ThirdPartPlatformImpl;


/**
 * 第三方支付封装基类
 * 负责封装第三方支付的调起支付
 * @param <P> 第三方支付sdk下单接口必须参数
 */
public abstract class Payment<P extends BasePayParam> extends ThirdPartPlatformImpl {
    String mRechargeId;//订单编号
    String mPrice;//订单价格

    String type;//支付平台类型（如：微信）

    protected PayFinishListener mListener;//支付回调

    /**
     * 调起支付（跳转第三方支付平台页面）
     * @param payParam 第三方支付sdk下单接口必须参数
     * @param listener 支付完成回调，应用后续响应操作
     */
    public abstract void startPay(Activity activity, P payParam, PayFinishListener listener);

    /**
     * 支付成功回调
     * 在第三方支付回调后调用此接口以便应用响应
     */
    public abstract void paySuccess();
    /**
     * 支付失败回调
     * 在第三方支付回调后调用此接口以便应用响应
     */
    public abstract void payCancel();

    public String getPrice() {
        return mPrice;
    }

    public String getRechargeId() {
        return mRechargeId;
    }

    public String getType() {
        return type;
    }
}
