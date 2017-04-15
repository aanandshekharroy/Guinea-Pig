package com.example.theseus.marvel.modules;

import com.example.theseus.marvel.MarvelAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by theseus on 14/4/17.
 */
@Module(includes = NetworkModule.class)
public class MarvelAPIModule {
    private final String BASE_URL="";
    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient,Gson gson){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
    }
    @Provides
    public MarvelAPI getMarvelAPI(Retrofit retrofit){
        return retrofit.create(MarvelAPI.class);
    }
    @Provides
    public Gson getGson(){
        return new GsonBuilder().create();
    }
}
