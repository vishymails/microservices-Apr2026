package com.bvr;

public class AppConfigs1 {

	public AppConfigs1() {
		// TODO Auto-generated constructor stub
	}
	
	
	final static String applicationID = "HelloProducer";
	final static String bootstrapServers = "localhost:9092, localhost:9093";
	final static String topicName = "invoice";
	final static int numEvents = 100000;

}
