package repository.models;

import com.google.gson.annotations.SerializedName;

public class SingleUserModel{

	@SerializedName("ad")
	private Ad ad;

	@SerializedName("data")
	private Data data;
}