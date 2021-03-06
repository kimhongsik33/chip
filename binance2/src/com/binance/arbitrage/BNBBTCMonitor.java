package com.binance.arbitrage;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ClientEndpoint
public class BNBBTCMonitor {
	
    @OnOpen
    public void onOpen(Session session) {
    	System.out.println("[BNBBTCMonitor.onOpen()]");
    	System.out.println("Method invoked when response from server!!!!");
    }

    // Method invoked when a data comes from the server
    @OnMessage
    public void onMessage(String data) throws JSONException {

        JSONObject jso = new JSONObject(data);
        JSONArray bidValues = (JSONArray) jso.get("b"); //bid(sell) price and quantity
        JSONArray askValues = (JSONArray) jso.get("a"); //ask(buy) price and quantity
        
        String symbol = (String) jso.get("s");          //symbol
        long timeStamp = (Long) jso.get("E");           //event time
        
        JsonInfoStorage.BNBBTCDealTime = timeStamp;
        JsonInfoStorage.BNBBTCSymbol = symbol;
        
        if(bidValues.length() > 0){
        	float bidPrice = Float.valueOf((String) ((JSONArray) bidValues.get(0)).get(0));
        	float bidQuantity = Float.valueOf((String) ((JSONArray) bidValues.get(0)).get(1));
        	if (bidQuantity > 0){
        		JsonInfoStorage.BNBBTCbidPrice = bidPrice;
        		JsonInfoStorage.BNBBTCbidQuantity = bidQuantity;
        		ArbitrageOutput.calcArbitrage(symbol);
        	}
        }
        
        if (askValues.length() > 0){
        	float askPrice = Float.valueOf((String) ((JSONArray) askValues.get(0)).get(0));
        	float askQuantity = Float.valueOf((String) ((JSONArray) askValues.get(0)).get(1));
        	if (askQuantity > 0){
        		JsonInfoStorage.BNBBTCaskPrice = askPrice;
        		JsonInfoStorage.BNBBTCaskQuantity = askQuantity;
        		ArbitrageOutput.calcArbitrage(symbol);
        	}
        }
    }

    @OnError
    public void onError(Throwable t) {
        BinanceArbitrageMain.threadLatch.countDown();
    }
}