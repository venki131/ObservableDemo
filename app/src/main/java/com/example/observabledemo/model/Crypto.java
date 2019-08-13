package com.example.observabledemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Crypto {

    @SerializedName("ticker")
    @Expose
    public Ticker ticker;
    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("error")
    @Expose
    private String error;

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public class Market {
        @SerializedName("market")
        @Expose
        private String market;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("volume")
        @Expose
        private String volume;

        public String coinName;

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getVolume() {
            return volume;
        }

        public void setVolume(String volume) {
            this.volume = volume;
        }
    }

    public class Ticker {

        @SerializedName("base")
        @Expose
        private String base;
        @SerializedName("target")
        @Expose
        private String target;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("volume")
        @Expose
        private String volume;
        @SerializedName("change")
        @Expose
        private String change;
        @SerializedName("markets")
        @Expose
        public List<Market> markets = null;

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getVolume() {
            return volume;
        }
    }
}
