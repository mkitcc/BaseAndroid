package com.psuwgipgf.myapplication.model;

import android.app.Application;
import android.content.Context;
import android.widget.ImageView;

import com.psuwgipgf.myapplication.eventbus.RxBus;
import com.psuwgipgf.myapplication.eventbus.RxBusType;
import com.psuwgipgf.myapplication.model.api.ApiHelper;
import com.psuwgipgf.myapplication.model.image.GlideConfig;
import com.psuwgipgf.myapplication.model.sp.SharedPreferencesUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by psu on 2016/4/5.
 */
public class ModelManager {

    public static void initModelManager(Application context) {
        SharedPreferencesUtil.init(context);
        ApiHelper.init(context);
    }

    public static Observable<String> apiGet(final String url,
                                            final Map<String, String> params) {
        return Observable.create(new Observable.OnSubscribe<Response>() {

            @Override
            public void call(Subscriber<? super Response> o) {
                o.onNext(ApiHelper.get(url, params));
            }
        }).map(new Func1<Response, String>() {
            @Override
            public String call(Response o) {
                if (o != null) {
                    try {
                        return o.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                RxBus.send(new RxBusType(RxBusType.NETWORK_STATUS));
                return null;
            }
        }).subscribeOn(Schedulers.io());
    }

    public static Observable<String> apiPost(final String url,
                                             final Map<String, String> params) {
        return Observable.create(new Observable.OnSubscribe<Response>() {

            @Override
            public void call(Subscriber<? super Response> o) {
                o.onNext(ApiHelper.post(url, params));
            }
        }).map(new Func1<Response, String>() {
            @Override
            public String call(Response o) {
                if (o != null) {
                    try {
                        return o.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                RxBus.send(new RxBusType(RxBusType.NETWORK_STATUS));
                return null;
            }
        }).subscribeOn(Schedulers.io());
    }

    public static Observable<String> apiPostFile(final String url,
                                                 final Map<String, Object> params, final String arrkey,
                                                 final List<Object> arr) {
        return Observable.create(new Observable.OnSubscribe<Response>() {

            @Override
            public void call(Subscriber<? super Response> o) {
                o.onNext(ApiHelper.postFile(url, params, arrkey, arr));
            }
        }).map(new Func1<Response, String>() {
            @Override
            public String call(Response o) {
                if (o != null) {
                    try {
                        return o.body().string();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                RxBus.send(new RxBusType(RxBusType.NETWORK_STATUS));
                return null;
            }
        }).subscribeOn(Schedulers.io());
    }

    public static void imageLoad(Context c, String url, ImageView view) {
        GlideConfig.load(c, url, view);
    }

}
