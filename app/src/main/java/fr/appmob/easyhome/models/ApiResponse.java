package fr.appmob.easyhome.models;

import java.util.List;
import java.util.Vector;

public class ApiResponse {
		private Vector<Advert> adverts;

	public ApiResponse(Vector<Advert> adverts) {
		this.adverts = adverts;
	}

	public List<Advert> getAds(){
		return adverts;
	}
}
