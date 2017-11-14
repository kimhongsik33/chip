package com.binance.arbitrage;
import java.net.URI;
import java.util.concurrent.CountDownLatch;

public class BinanceArbitrageMain {
	
	// Set Web Socket Address
	private static final String SOCKET_BNB_BTC = "wss://stream.binance.com:9443/ws/bnbbtc@depth@0ms";
	private static final String SOCKET_BNB_ETH = "wss://stream.binance.com:9443/ws/bnbeth@depth@0ms";
	private static final String SOCKET_ETH_BTC = "wss://stream.binance.com:9443/ws/ethbtc@depth@0ms";
	
	// If communication error occurs, wait state is terminated
	// Error monitoring is monitored by each monitor class.
	private static int countDownLatchNum = 1;
	
	static CountDownLatch threadLatch = new CountDownLatch(countDownLatchNum);
	
    public static void main(String[] args) {    
    	try {
    		ArbitrageThread aotBNBBTC = new ArbitrageThread(BNBBTCMonitor.class, URI.create(SOCKET_BNB_BTC));
    		ArbitrageThread aotBNBETH = new ArbitrageThread(BNBETHMonitor.class, URI.create(SOCKET_BNB_ETH));
    		ArbitrageThread aotETHBTC = new ArbitrageThread(ETHBTCMonitor.class, URI.create(SOCKET_ETH_BTC));
    		
        	Thread threadBnbBtc = new Thread(aotBNBBTC); //Define a work thread(BNBBTC)
        	Thread threadBnbEth = new Thread(aotBNBETH); //Define a work thread(BNBETH)
        	Thread threadEthBtc = new Thread(aotETHBTC); //Define a work thread(ETHBTC)

        	//run the thread
        	threadBnbBtc.start();
        	threadBnbEth.start();
        	threadEthBtc.start();
            
        	threadLatch.await();
        	            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}