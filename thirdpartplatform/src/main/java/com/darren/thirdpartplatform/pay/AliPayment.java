package com.darren.thirdpartplatform.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * 阿里支付封装类
 */
public class AliPayment extends Payment<PayParam> {

    /**
     * 标记支付类型
     */
    protected AliPayment() {
        super();

        type = "支付宝";
    }

    /**
     * 调起支付（跳转第三方支付平台页面）
     *
     * @param payParam 第三方支付sdk下单接口必须参数
     * @param listener 支付完成回调，应用后续响应操作
     */
    @Override
    public void startPay(final Activity activity, final PayParam payParam, final PayFinishListener listener) {
        //配置数据
        mRechargeId = payParam.getRecharge_id();
        mPrice = payParam.getPrice();
        mListener = listener;

        //支付操作完成后回调
        final Handler mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Map<String, String> result = (Map<String, String>) msg.obj;
                if (result.get("resultStatus").equals("6001")) {//用户取消支付
                    payCancel();
                } else {
                    paySuccess();
                }
                return true;
            }
        });

        //调起支付宝
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(payParam.getSign(), true);

                Message msg = new Message();
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 支付成功回调
     * 在第三方支付回调后调用此接口以便应用响应
     */
    @Override
    public void paySuccess() {
        mListener.success();
    }

    /**
     * 支付失败回调
     * 在第三方支付回调后调用此接口以便应用响应
     */
    @Override
    public void payCancel() {
        mListener.cancel();
    }
}
