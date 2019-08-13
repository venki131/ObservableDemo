package com.example.observabledemo.ApiClient;

import com.example.observabledemo.model.Crypto;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("{coin}-usd")
    Observable<Crypto> getCoinData(@Path("coin") String coin);
}
