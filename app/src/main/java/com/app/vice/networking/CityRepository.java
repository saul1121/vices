package com.app.vice.networking;

import com.app.vice.models.CityListData;

import rx.Subscription;


public interface CityRepository extends GenericRepository<CityListData> {

    Subscription getCityList(final Service.GetCityListCallback callback);

}
