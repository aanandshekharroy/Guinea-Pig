package com.example.theseus.marvel.activities;

import android.support.annotation.Nullable;
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
import com.example.theseus.marvel.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

import static com.example.theseus.marvel.Utilities.MD5;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Inject
    MarvelAPI marvelAPI;
    public MainActivityFragment() {
    }
    private Unbinder unbinder;
    @BindView(R.id.text_view)
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MarvelApplication)getActivity().getApplication()).getMarvelApplicationComponent().inject(this);
        initNetwork();

        View view= inflater.inflate(R.layout.fragment_main, container, false);
        unbinder=ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Observable.OnSubscribe observableAction=new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Game over");
                subscriber.onCompleted();
            }
        };
        Subscriber<String> textChanger=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                textView.setText(s);
            }
        };
        Subscriber<String> toastShower=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Toast.makeText(getContext(),"Hehe",Toast.LENGTH_SHORT).show();
            }
        };
        Observable<String> observable=Observable.create(observableAction);
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(toastShower);
        observable.subscribe(textChanger);
    }

    private void initNetwork() {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        String hash= Utilities.MD5(timeStamp+getString(R.string.private_key)+getString(R.string.public_key));
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
