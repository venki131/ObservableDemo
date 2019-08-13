package com.example.observabledemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.observabledemo.ApiClient.ApiInterface;
import com.example.observabledemo.ApiClient.RestClient;
import com.example.observabledemo.R;
import com.example.observabledemo.model.Crypto;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CryptoCurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_currency);

        ApiInterface apiInterface = RestClient.getClient().create(ApiInterface.class);

        Observable<Crypto> cryptoObservable = apiInterface.getCoinData("btc");
        cryptoObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result.ticker)
                .subscribe();

        Observable<List<Crypto.Market>> btcObservable = apiInterface.getCoinData("btc")
                //fromIterable - convert map result into observable streams
                .map(result -> Observable.fromIterable(result.ticker.markets))
                //flatMap - works on elements one by one
                .flatMap(x -> x).filter(y -> {
                    y.coinName = "btc";
                    return true;
                }).toList().toObservable();
        //toList - used to convert the results of flatMap back to List
        //toObservable - wraps them as observable streams.

        Observable<List<Crypto.Market>> ethObservable = apiInterface.getCoinData("eth")
                .map(result -> Observable.fromIterable(result.ticker.markets))
                .flatMap(x -> x).filter(y -> {
                    y.coinName = "eth";
                    return true;
                }).toList().toObservable();

        Observable.merge(btcObservable, ethObservable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }
}
