package ru.cmr.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock implements Runnable {

	private Thread thread;
	private ActionListener listener;
	private int delay;
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
	public Clock() {
		super();
	}
	
	
	public Clock(int delay,ActionListener listener) {
		super();
		this.delay = delay;
		this.listener=listener;
	}
	
	private Runnable r = () -> {
		try {
		for(;;Thread.sleep(delay))
			listener.actionPerformed(new ActionEvent(this, 0, ""));
		} catch (InterruptedException ex) {}
	};
	
	public void start() {
		if (thread != null) return;
		thread= new Thread(r);
		thread.start();
	}
	
	public void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread = null;
	}
}
