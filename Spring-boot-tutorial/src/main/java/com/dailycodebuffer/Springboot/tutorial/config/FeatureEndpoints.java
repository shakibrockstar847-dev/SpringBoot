package com.dailycodebuffer.Springboot.tutorial.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Component
@Endpoint(id = "features")
public class FeatureEndpoints {
	
	private final Map<String,Feature> featureMap = new ConcurrentHashMap<>();
	
public FeatureEndpoints() {
	featureMap.put("Department", new Feature(true));
	featureMap.put("User", new Feature(false));
	featureMap.put("Authentication", new Feature(false));
}

//http://localhost:8082/actuator/features we need to use this URL
@ReadOperation
public Map<String,Feature> features() {
	
	return featureMap;
}

//http://localhost:8082/actuator/Department or instaed of department any value - Because we are passing the value as featureName
@ReadOperation
public Feature feature(@Selector String featureName) {
	
	return featureMap.get(featureName);
}
	



@Data
@AllArgsConstructor
private static class Feature {
	
	private boolean isEnabled;
	
}
}
