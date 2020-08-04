package repository.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUsersModel {
	private String name = "";
	private String job = "";

	@SerializedName("per_page")
	private int perPage;

	@SerializedName("total")
	private int total;

	@SerializedName("ad")
	private Ad ad;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	public void setName(String name){
		this.name = name;
	}

	public void setJob(String job){
		this.job = job;
	}
}