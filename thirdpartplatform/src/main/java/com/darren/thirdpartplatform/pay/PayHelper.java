package com.darren.thirdpartplatform.pay;

import android.app.Activity;


import com.darren.thirdpartplatform.base.ThirdPartHelper;

import retrofit2.Call;

/**
 * 第三方支付平台helper
 * 负责封装第三方sdk调用前后的处理工作，简化重复代码
 * 必须重写
 * @param <PR> 服务器下单接口返回值，仅用于泛型以便子类继承
 * @param <PP> 第三方支付sdk下单方法参数，仅用于泛型以便子类继承
 * @param <PM> 第三方支付封装类
 */
public class PayHelper<PR extends BasePayResult, PP extends BasePayParam, PM extends Payment> extends ThirdPartHelper {
    protected Activity mActivity;//用于跳转支付成功页和弹出toast通知
    protected BasePayResult.BasePayData mPayData;//用于查询订单成功的后续处理

    /**
     * 下订单
     * 向服务器请求订单
     */
    public void pay(final Activity activity, Call<PR> call, String price, PM payment, final PayFinishListener listener){}

    /**
     * 预留接口
     * @return 查询订单返回值
     */
    public BasePayResult.BasePayData getmPayData() {
        return mPayData;
    }
}
