package com.e.aplikasiadabakhlak.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class AdabAkhlak{

	@SerializedName("adabakhlak")
	private List<AdabAkhlakList> adabakhlak;

	public void setAdabAkhlak(List<AdabAkhlakList> adabakhlak){
		this.adabakhlak = adabakhlak;
	}

	public List<AdabAkhlakList> getAdabAkhlak(){
		return adabakhlak;
	}

	@Override
 	public String toString(){
		return 
			"Adap{" + 
			"adabakhlak = '" + adabakhlak + '\'' + 
			"}";
		}

	public class AdabAkhlakList{

		@SerializedName("materi")
		private String materi;

		@SerializedName("jenis")
		private String jenis;

		@SerializedName("id")
		private String id;

		@SerializedName("judul")
		private String judul;

		public void setMateri(String materi){
			this.materi = materi;
		}

		public String getMateri(){
			return materi;
		}

		public void setJenis(String jenis){
			this.jenis = jenis;
		}

		public String getJenis(){
			return jenis;
		}

		public void setId(String id){
			this.id = id;
		}

		public String getId(){
			return id;
		}

		public void setJudul(String judul){
			this.judul = judul;
		}

		public String getJudul(){
			return judul;
		}

		@Override
		public String toString(){
			return
					"AdabakhlakItem{" +
							"materi = '" + materi + '\'' +
							",jenis = '" + jenis + '\'' +
							",id = '" + id + '\'' +
							",judul = '" + judul + '\'' +
							"}";
		}
	}
}