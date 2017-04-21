package com.app.vice.home;

import com.app.vice.models.CityListResponse;


public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getityListSuccess(CityListResponse cityListResponse);

}
