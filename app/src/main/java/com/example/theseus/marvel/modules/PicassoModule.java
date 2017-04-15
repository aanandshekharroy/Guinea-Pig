package com.example.theseus.marvel.modules;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by theseus on 15/4/17.
 */
@Module(includes = {ContextModule.class,NetworkModule.class})
public class PicassoModule {
    @Provides
    public Picasso getPicasso(Context context, OkHttpClient okHttpClient){
        return new Picasso.Builder(context).downloader(new OkHttp3Downloader(okHttpClient)).build();
    }
}
