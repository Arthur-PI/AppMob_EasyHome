package fr.appmob.easyhome.models;

import android.util.Log;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataHandler {
	private static final String API_URL = "https://api.fluximmo.com/v1";
	private static final String API_KEY = "DUTSTUDENT_pgTrnSMIW7";
	private static DataHandler INSTANCE;
	private static final String TAG = "DATA HANDLER";

	private List<Advert> adverts;
	private String lastAdvertID;

	public Criteria getCriteres() {
		return criteres;
	}

	private Criteria criteres;
	private List<String> likesId;
	private boolean finished;

	static {
		INSTANCE = new DataHandler();
		Log.i(TAG, "Data Handler instanciate");
	}

	public static DataHandler getInstance() {
		return INSTANCE;
	}

	private DataHandler() {
		this.adverts = new Vector<>();
		this.likesId = new Vector<>();
	}

	public List<Advert> getAdverts() {
		if (this.adverts.size() == 0) { fetchAdverts(); }
		return this.adverts;
	}

	private boolean fetchAdverts() {
		String endpoint = "/adverts/search";
		if (criteres == null || !criteres.isNew()) return false;
		Map<String, String> criteres = this.criteres.getFormatedData();

		OkHttpClient client = new OkHttpClient();
		Request req = new Request.Builder().url(API_URL + endpoint + parameterBuilder(criteres) + "&limit=5").addHeader("X-API-KEY", API_KEY).build();
		Response res = null;
		Gson g = new Gson();
		try {
			res = client.newCall(req).execute();
			String stringRes = res.body().string();
			ApiResponse apiRes = g.fromJson(stringRes, ApiResponse.class);
			adverts = apiRes.getAds();
			Log.i(TAG, "Fetching API success");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Log.i(TAG, "Error fetching API");
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

	public List<String> getLikesId() {
		return likesId;
	}

	public void updateLikesId(String userId) {
		likesId.clear();
		FirebaseFirestore db = FirebaseFirestore.getInstance();
		db.collection("likes")
			.whereEqualTo("userId", userId)
			.get()
			.addOnSuccessListener(s -> {
				for (DocumentSnapshot doc : s.getDocuments()) likesId.add((String) doc.get("advertId"));
				Log.i(TAG, "Likes IDs fetched !");
			}).addOnFailureListener(f -> {
			Log.i(TAG, "Error fetching likes IDs !");
		});
	}


	public void setCriteres(Criteria c) {
		this.criteres = c;
	}

	public void likeAdvert(String userId, String advertId) {
		FirebaseFirestore db = FirebaseFirestore.getInstance();
		Map<String, String> like = new HashMap<>();
		like.put("userId", userId);
		like.put("advertId", advertId);
		db.collection("likes").add(like).addOnSuccessListener(s -> {
			Log.i("DataHandler like", "Advert liked !");
		}).addOnFailureListener(f -> {
			Log.i("DataHandler like", "Error: Advert not liked !!!");
		});
	}

	public void unlikeAdvert(String userId, String advertId) {
		FirebaseFirestore db = FirebaseFirestore.getInstance();
		db.collection("likes")
			.whereEqualTo("advertId", advertId)
			.whereEqualTo("userId", userId)
			.get()
			.addOnSuccessListener(s -> {
				if (s.getDocuments().size() > 0) {
					db.collection("likes")
						.document(s.getDocuments().get(0).getId())
						.delete()
						.addOnSuccessListener(s2 -> {
							Log.i("Delete like", "Like deleted !");
						}).addOnFailureListener(f -> {
							Log.i("Delete like", "Error deleting the like !!!");
						});
				}
			});
	}

	public void initUser(String userId) {
		FirebaseFirestore db = FirebaseFirestore.getInstance();
		db.collection("likes")
			.whereEqualTo("userId", userId)
			.addSnapshotListener((value, e) -> {
				if (e != null) {
					Log.i(TAG, "Likes listener failed");
					return;
				}
				for (DocumentChange dc : value.getDocumentChanges()) {
					switch (dc.getType()) {
						case ADDED:
							likesId.add((String)dc.getDocument().get("advertId"));
							break;
						case REMOVED:
							likesId.remove((String)dc.getDocument().get("advertId"));
							break;
					}
				}
				Log.i(TAG, "Likes IDs updated !");
			});
	}

	public List<Advert> getLikedAdvert() {
		List<Advert> likedAdvert = new Vector<>();

		String endpoint = "/adverts/";

		OkHttpClient client = null;
		Request req = null;
		Response res = null;
		Gson g = new Gson();
		String stringRes = null;
		Advert fetchAdvert = null;

		for (String advertId : likesId) {
			client = new OkHttpClient();
			req = new Request.Builder().url(API_URL + endpoint + advertId).addHeader("X-API-KEY", API_KEY).build();
			try {
				res = client.newCall(req).execute();
				stringRes = res.body().string();
				fetchAdvert = g.fromJson(stringRes, Advert.class);
				likedAdvert.add(fetchAdvert);
				Log.i(TAG, "Fetching API for " + advertId + " success");
			} catch (Exception e) {
				e.printStackTrace();
				Log.i(TAG, "Error fetching " + advertId + "API");
			}
		}

		return likedAdvert;
	}


}
