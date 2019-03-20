package com.darren.thirdpartplatform.pay;

/**
 * 第三方支付操作完成后的回调（从第三方应用跳转回应用后的回调）
 */
public interface PayFinishListener {
    /**
     * 支付完成回调后进行的操作（eg:关闭支付fragment，跳转支付成功页等）
     */
    void success();

    /**
     * 用户操作取消支付后进行的操作（eg：toast提示）
     */
    void cancel();
}
