package com.app.vice.networking;


import com.app.vice.models.CityListData;
import com.app.vice.models.CityListResponse;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class Service implements CityRepository{
    private final NetworkService networkService;

    public Service(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Subscription getCityList(final GetCityListCallback callback) {

        return networkService.getCityList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CityListResponse>>() {
                    @Override
                    public Observable<? extends CityListResponse> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CityListResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(new NetworkError(e));

                    }

                    @Override
                    public void onNext(CityListResponse cityListResponse) {
                        callback.onSuccess(cityListResponse);

                    }
                });
    }

    @Override
    public CityListData getById(int id) {
        return null;
    }

    @Override
    public List<CityListData> getAll() {
        return null;
    }

    @Override
    public void save(CityListData entity) {

    }

    @Override
    public void remove(CityListData entity) {

    }

    public interface GetCityListCallback{
        void onSuccess(CityListResponse cityListResponse);

        void onError(NetworkError networkError);
    }
}
