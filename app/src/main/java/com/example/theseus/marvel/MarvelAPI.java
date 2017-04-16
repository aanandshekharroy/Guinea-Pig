package com.example.theseus.marvel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by theseus on 12/4/17.
 */

public interface MarvelAPI {
    @GET("characters")
    Call<MarvelCharacters> getMarvelCharacters(@Query("apikey") String api_key,
                                                        @Query("ts") String ts,
                                                        @Query("hash") String hash);
}
