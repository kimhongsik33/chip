package com.binance.arbitrage;

public class ArbitrageOutput {
	
	public final static String BINANCE = "BNB";   // BINANCE
	public final static String BITCOIN = "BTC";   // BITCOIN
	public final static String ETHEREUM = "ETH";  // ETHEREUM
	
	public static void calcArbitrage(String type){
		
		//TimeStamp
		long BNBETHDealTime = JsonInfoStorage.BNBETHDealTime;
		long BNBBTCDealTime = JsonInfoStorage.BNBBTCDealTime;
		long ETHBTCDealTime = JsonInfoStorage.ETHBTCDealTime;
		
		//Sysbol
		String BNBETHSymbol = JsonInfoStorage.BNBETHSymbol;
		String BNBBTCSymbol = JsonInfoStorage.BNBBTCSymbol;
		String ETHBTCSymbol = JsonInfoStorage.ETHBTCSymbol;
		
		//BNBBTC
		float BNBBTCbidPrice = JsonInfoStorage.BNBBTCbidPrice;
		float BNBBTCbidQuantity = JsonInfoStorage.BNBBTCbidQuantity;
		float BNBBTCaskPrice = JsonInfoStorage.BNBBTCaskPrice;
		float BNBBTCaskQuantity = JsonInfoStorage.BNBBTCaskQuantity;
				
		//BNBETH
		float BNBETHbidPrice = JsonInfoStorage.BNBETHbidPrice;	
		float BNBETHbidQuantity = JsonInfoStorage.BNBETHbidQuantity;
		float BNBETHaskPrice = JsonInfoStorage.BNBETHaskPrice;
		float BNBETHaskQuantity = JsonInfoStorage.BNBETHaskQuantity;
		
		//ETHBTC
		float ETHBTCbidPrice = JsonInfoStorage.ETHBTCbidPrice;
		float ETHBTCbidQuantity = JsonInfoStorage.ETHBTCbidQuantity;
		float ETHBTCaskPrice = JsonInfoStorage.ETHBTCaskPrice;
		float ETHBTCaskQuantity = JsonInfoStorage.ETHBTCaskQuantity;
		
		if(type.equals(BINANCE+BITCOIN)){
			calcPrint(BNBBTCbidPrice, BNBBTCbidQuantity, BNBBTCaskPrice, BNBBTCaskQuantity, BNBBTCSymbol, BNBBTCDealTime);
		}else if(type.equals(BINANCE+ETHEREUM)){
			calcPrint(BNBETHbidPrice, BNBETHbidQuantity, BNBETHaskPrice, BNBETHaskQuantity, BNBETHSymbol, BNBETHDealTime);
		}else if(type.equals(ETHEREUM+BITCOIN)){
			calcPrint(ETHBTCbidPrice, ETHBTCbidQuantity, ETHBTCaskPrice, ETHBTCaskQuantity, ETHBTCSymbol, ETHBTCDealTime);
		}
	}
	
	//print
	private static void calcPrint(
			float bidPrice,float bidQuantity,float askPrice,float askQuantity,String symbol, long time) {
		
		float expectedProfit = (bidPrice * bidQuantity) - (askPrice * askQuantity);
		
		System.out.println("=====================================");
		System.out.println("[Event Time]         " + time);
		System.out.println("[symbol]             " + symbol);
		System.out.println("[bid Price/Quantity] " + bidPrice + "/" + bidQuantity);
		System.out.println("[ask Price/Quantity] " + askPrice + "/" + askQuantity);
		System.out.println("[Expected Profit]    " + expectedProfit);
		System.out.println("=====================================");
	}
}
