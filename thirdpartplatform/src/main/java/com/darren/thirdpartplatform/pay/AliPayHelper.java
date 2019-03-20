package com.darren.thirdpartplatform.pay;

import android.app.Activity;


import retrofit2.Call;

/**
 * 阿里支付helper
 */
public class AliPayHelper extends PayHelper<BasePayResult, PayParam, AliPayment> {
    /**
     * 下订单
     * 向服务器请求订单
     */
    @Override
    public void pay(final Activity activity, Call<BasePayResult> call, final String price, final AliPayment payment, final PayFinishListener listener) {
        mActivity = activity;


        call.enqueue(new NetCallback<BasePayResult>() {//调用下单接口，由服务器向微信下单，并返回订单详情
            @Override
            protected void onSuccess(Object res) {
                mPayData = (BasePayResult.BasePayData) res;
                PayParam payParam = mPayData.getPayParam();
                payParam.setPrice(price);
                payment.startPay(mActivity, payParam, listener);//调起支付
            }

            @Override
            protected void onError(int sign, String msg) {
                if (sign == 1) {
                    ToastUtil.showToast(mActivity, msg);
                }
            }

            @Override
            protected void onLogout() {

            }
        });
    }
}
