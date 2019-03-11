package com.techelevator.npgeek.model;

import java.util.List;

public interface ParkDao {
	
	List<Park> getAllParks();
	Park getInfoForPark(int parkCode);
	
}
