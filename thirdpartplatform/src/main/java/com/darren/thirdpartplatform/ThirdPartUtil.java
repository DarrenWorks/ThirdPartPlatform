package com.darren.thirdpartplatform;

import android.app.Activity;


import com.darren.thirdpartplatform.base.Singleton;
import com.darren.thirdpartplatform.pay.PayFinishListener;
import com.darren.thirdpartplatform.pay.PayHelper;
import com.darren.thirdpartplatform.pay.PayHelperFactory;
import com.darren.thirdpartplatform.pay.PayWay;
import com.darren.thirdpartplatform.pay.Payment;
import com.darren.thirdpartplatform.pay.PaymentFactory;

import retrofit2.Call;

public class ThirdPartUtil extends Singleton {

    public static PayHelper getPayHelper(PayWay payWay) {
        return PayHelperFactory.getInstance().getPayHelper(payWay);
    }

    public static Payment getPayment(PayWay payWay) {
        return PaymentFactory.getInstance().getPayment(payWay);
    }

    public static void pay(final Activity activity, Call call, PayWay payWay, String price, final PayFinishListener listener) {
        PayHelper payHelper = getPayHelper(payWay);
       payHelper.pay(activity, call, price, getPayment(payWay), listener);
    }


}
