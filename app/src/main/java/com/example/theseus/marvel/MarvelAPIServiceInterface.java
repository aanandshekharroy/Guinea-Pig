package com.example.theseus.marvel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by theseus on 12/4/17.
 */

public interface MarvelAPIServiceInterface {
    @GET("characters")
    Call<MarvelCharacters.DataBean.ResultsBean> getMarvelCharacters(@Query("api_key") String api_key);
}
