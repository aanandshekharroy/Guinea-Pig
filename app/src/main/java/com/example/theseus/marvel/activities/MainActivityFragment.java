package com.example.theseus.marvel.activities;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theseus.marvel.MarvelAPI;
import com.example.theseus.marvel.MarvelApplication;
import com.example.theseus.marvel.MarvelCharacters;
import com.example.theseus.marvel.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Inject
    MarvelAPI marvelAPI;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Timber.tag("initialized").d("init");
//        (TextView)
        ((MarvelApplication)getActivity().getApplication()).getMarvelApplicationComponent().inject(this);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        String hash=MD5(timeStamp+getString(R.string.private_key)+getString(R.string.public_key));
        Call<MarvelCharacters> call=marvelAPI.getMarvelCharacters(getString(R.string.public_key),timeStamp,hash);
        call.enqueue(new Callback<MarvelCharacters>() {
            @Override
            public void onResponse(Call<MarvelCharacters> call, Response<MarvelCharacters> response) {
                Timber.d("dert"+response.body().getData().getResults().size());
//                Toast.makeText(getContext(),"size: "+response.body().getResults().size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MarvelCharacters> call, Throwable t) {
                Timber.d("network error");
            }
        });
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
