package fr.appmob.easyhome.models;

import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataHandler {
	private static final String API_URL = "https://api.fluximmo.com/v1";
	private static final String API_KEY = "DUTSTUDENT_pgTrnSMIW7";
	private static DataHandler INSTANCE;

	private List<Advert> adverts;
	private String lastAdvertID;
	private Criteria criteres;

	static {
		INSTANCE = new DataHandler();
		System.out.println("Data Handler instanciate");
	}

	public static DataHandler getInstance() {
		return INSTANCE;
	}

	private DataHandler() {
		this.adverts = new Vector<>();
	}

	public List<Advert> getAdverts() {
		if (this.adverts.size() == 0) { fetchAdverts(); }
		return this.adverts;
	}

	private boolean fetchAdverts() {
		String endpoint = "/adverts/search";
		if (criteres == null || !criteres.isNew()) return false;
		Map<String, String> criteres = this.criteres.getFormatedData();
		System.out.println(StringUtils.join(criteres));

		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(API_URL + endpoint + parameterBuilder(criteres) + "&limit=5").addHeader("X-API-KEY", API_KEY).build();
		Response res = null;
		Gson g = new Gson();
		try {
			res = client.newCall(req).execute();
			String stringRes = res.body().string();
			ApiResponse apiRes = g.fromJson(stringRes, ApiResponse.class);
			adverts = apiRes.getAds();
			System.out.println("Fetching API success");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error fetching API");
			return false;
		}
	}

	private String parameterBuilder(Map<String, String>  params) {
		String formatedParam = "?postal_codes=" + params.get("postal_codes");
		for (String fieldName : params.keySet()) {
			formatedParam += "&" + fieldName + "=" + params.get(fieldName);
		}
		return formatedParam;
	}

	private boolean fetchNext() {
		// TODO
		return false;
	}

	public void setCriteres(Criteria c) {
		this.criteres = c;
	}
}
