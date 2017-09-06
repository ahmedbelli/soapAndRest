package com.bharaththippireddy.trainings.jaxrs;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import com.bharathippireddy.trainings.jaxrs.dto.Passenger;
import com.bharathippireddy.trainings.jaxrs.dto.PassengerList;

@Path("/Passenger")
@Produces("application/xml")
public class PassengerService {

	PassengerList passengersList = new PassengerList();

	public PassengerService() {
		init();
	}

	public void init() {
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		Passenger passenger = new Passenger();
		passenger.setId(123);
		passenger.setName("Bharath");
		passengers.add(passenger);
		passengersList.setPassengers(passengers);
	}

	@GET
	public PassengerList getPassengers(@QueryParam("start") int start, @QueryParam("size") int size,
			@HeaderParam("agent") String agent, @Context HttpHeaders headers) {

		Map<String, Cookie> cookiesMap = headers.getCookies();
		Set<String> cookies = cookiesMap.keySet();
		System.out.println(cookies.size());
		for (String string : cookies) {
			Cookie cookie = cookiesMap.get(string);
			System.out.println("Cookie Value::" + cookie.getValue());

		}

		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		Set<String> keySet = requestHeaders.keySet();
		for (String header : keySet) {
			System.out.println(headers.getHeaderString(header));
		}

		System.out.println(start);
		System.out.println(size);

		System.out.println(agent);
		return passengersList;
	}

	@POST
	public void addPassenger(@FormParam("firstname") String firstName, @FormParam("lastname") String lastName) {
		System.out.println(firstName);
		System.out.println(lastName);
	}

}
