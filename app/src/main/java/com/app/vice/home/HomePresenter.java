package com.app.vice.home;

import com.app.vice.models.CityListResponse;
import com.app.vice.networking.CityRepository;
import com.app.vice.networking.NetworkError;
import com.app.vice.networking.Service;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public class HomePresenter {
    private Service service;

    private final HomeView view;
    private CompositeSubscription subscriptions;
    private CityRepository repository;

    public HomePresenter(Service service, HomeView view) {
        this.service = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }

    public HomePresenter(CityRepository service, HomeView view) {
        this.repository = service;
        this.view = view;
        this.subscriptions = new CompositeSubscription();
    }



    public void getCityList() {
        view.showWait();

        Subscription subscription = service.getCityList(new Service.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                view.removeWait();
                view.getityListSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }

    public void getCityList2() {
        view.showWait();

        repository.getAll();

        Subscription subscription = repository.getCityList(new Service.GetCityListCallback() {
            @Override
            public void onSuccess(CityListResponse cityListResponse) {
                view.removeWait();
                view.getityListSuccess(cityListResponse);
            }

            @Override
            public void onError(NetworkError networkError) {
                view.removeWait();
                view.onFailure(networkError.getAppErrorMessage());
            }

        });

        subscriptions.add(subscription);
    }



    public void onStop() {
        subscriptions.unsubscribe();
    }
}
