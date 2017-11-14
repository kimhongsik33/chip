package com.binance.arbitrage;
import java.io.IOException;
import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class ArbitrageThread implements Runnable{

	private WebSocketContainer container;
	private Class coinMonitor;
	private URI socketUri;
	private Session session = null;
	
	public ArbitrageThread(Class coinMonitor, URI socketUri){
		this.container = ContainerProvider.getWebSocketContainer();
		this.coinMonitor = coinMonitor;
		this.socketUri = socketUri;
	}
	
	@Override
	public void run() {
		try {
			session = container.connectToServer(this.coinMonitor, this.socketUri); //Connect to Server
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			if(session == null) {
				try {
					session.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
