package com.darren.thirdpartplatform.pay;

import android.app.Activity;


/**
 * 微信支付封装类
 */
public class WechatPayment extends Payment<PayParam> {
    private final String APPID = "wx86765066ff6aa6e3";//微信支付APPID
    private IWXAPI iwxapi;//微信支付核心类

    /**
     * 注册微信支付
     * 标记支付类型
     */
    protected WechatPayment() {
        super();
        iwxapi = WXAPIFactory.createWXAPI(MyApplication.getContext(), null);
        iwxapi.registerApp(APPID);

        type = "微信";
    }

    /**
     * 调起微信支付
     * @param payParam 第三方支付sdk下单接口必须参数
     * @param listener 支付完成回调，应用后续响应操作
     */
    @Override
    public void startPay(Activity activity, PayParam payParam, PayFinishListener listener) {
        //保存必要参数
        mRechargeId = payParam.getRecharge_id();
        mPrice = payParam.getPrice();
        mListener = listener;

        //调起微信支付
        PayReq request = new PayReq();
        request.appId = payParam.getAppid();
        request.partnerId = payParam.getPartnerid();
        request.prepayId = payParam.getPrepayid();
        request.packageValue = payParam.getPackageValue();
        request.nonceStr = payParam.getNoncestr();
        request.timeStamp = payParam.getTimestamp();
        request.sign = payParam.getSign();
        iwxapi.sendReq(request);
    }

    @Override
    public void paySuccess() {
        if (null != mListener) {
            mListener.success();
        }
    }


    @Override
    public void payCancel() {
        if (null != mListener) {
            mListener.cancel();
        }
    }

    public IWXAPI getIwxapi() {
        return iwxapi;
    }
}
