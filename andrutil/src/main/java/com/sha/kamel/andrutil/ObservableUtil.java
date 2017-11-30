package com.sha.kamel.andrutil;


import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final class ObservableUtil {

    private static ObservableTransformer schedulersTransformer;

    public static <T> Observable observableActivity(
            Observable<ActivityEvent> lifeCycle,
            Observable<T> observable)
    {
        return observable
                        .compose(RxLifecycle.bindUntilEvent(lifeCycle, ActivityEvent.DESTROY))
                        .compose(applyScheduler());
    }

    private static <T> ObservableTransformer applyScheduler(){
        if (schedulersTransformer == null) {
            schedulersTransformer = (ObservableTransformer<T, T>) observable ->
                    observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
        return schedulersTransformer;
    }

    public static  <T> ObservableTransformer<T, T> handleExceptionKeepingSubscription() {
        return observable ->
                observable
                        .doOnError(Throwable::printStackTrace)
                        .retry(); // Ignore error to keep subscription.
    }
}
