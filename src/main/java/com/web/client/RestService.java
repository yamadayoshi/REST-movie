package com.web.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.web.classes.CurrentLocal;
import com.web.classes.Places;

@Component
public class RestService implements CommandLineRunner {
	
	private static void restService() {		
		String poi = null;
		
		RestTemplate rest = new RestTemplate();
		CurrentLocal location = rest.postForObject("https://www.googleapis.com/geolocation/v1/geolocate?key=AIzaSyDqgciEIUlh0jYgm1FpTnEseSRDIQGRHZY", new CurrentLocal(), CurrentLocal.class);
		Places place = rest.getForObject("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location.getLocation().getLat() + "," + location.getLocation().getLng()+"&radius=5000&key=AIzaSyC5muCBxo-anKgX2vkAgask5Hd-owbdpfo", Places.class);
		System.out.println("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + location.getLocation().getLat() + "," + location.getLocation().getLng()+"&radius=5000&key=AIzaSyC5muCBxo-anKgX2vkAgask5Hd-owbdpfo");

		for(int i=0; i < place.getResults().size();i++) {
			poi += place.getResults().get(i).getName() + ", ";
		}		
	
		System.out.println(poi);		
	}

	@Override
	public void run(String... args) throws Exception {
		restService();		
	}
}
