package com.darren.thirdpartplatform.pay;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;


import retrofit2.Call;

/**
 * 对通用实现进行了封装，使支付完成回调实现更简洁
 */
public abstract class EasyPayFinishListener implements PayFinishListener {
    private Activity mActivity;
    private Payment mPayment;
    private WaitingView mWaitingView;

    public EasyPayFinishListener(Activity activity, PayWay payWay) {
        super();
        mActivity = activity;
        mPayment = ThirdPartUtil.getPayment(payWay);
    }

    /**
     * 替代原 {@link PayFinishListener#success()} 方法以实现后续自定义操作
     */
    public abstract void easySuccess();
    /**
     * 替代原 {@link PayFinishListener#cancel()} 方法以实现后续自定义操作
     */
    public abstract void easyCancel();

    /**
     * 第三方平台回调后调取查询订单接口并跳转支付成功页面
     */
    @Override
    public void success() {
        //进行查询订单请求时显示加载控件，避免重复操作
        if (mActivity instanceof AppCompatActivity) {
        mWaitingView = new CommonWaitingView((AppCompatActivity) mActivity);
        }
        if (mWaitingView != null) {
            mWaitingView.show();
        }
        Api serverApi = ClientOld.getInstance().getApi();
        Call<PayQueryOrderResult> call = serverApi.payQueryOrder(new PayQueryOrderData(mPayment.getRechargeId()));
        call.enqueue(new NetCallback<PayQueryOrderResult>() {
            @Override
            protected void onSuccess(Object res) {
                //调转支付成功页
                PayQueryOrderResult.Data data = (PayQueryOrderResult.Data) res;
                PaySuccessActivity.toPaySuccessActivity(mActivity, mPayment.getType(), mPayment.getPrice(), mPayment.getRechargeId(), data.getFinishDate());
                if (mWaitingView != null) {
                    mWaitingView.hide();
                }
            }

            @Override
            protected void onError(int sign, String msg) {

            }

            @Override
            protected void onLogout() {

            }
        });
        easySuccess();
    }

    /**
     * toast提示用户取消
     */
    @Override
    public void cancel() {
        ToastUtil.showToast(mActivity, "用户中途取消支付");
        easyCancel();
        if (mWaitingView != null) {
            mWaitingView.hide();
        }
    }
}
