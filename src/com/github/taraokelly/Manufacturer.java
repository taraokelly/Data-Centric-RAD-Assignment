package com.github.taraokelly;

import javax.faces.bean.ManagedBean;
/*
 * Tara O'Kelly - G00322214
 * Manufacturer class.
 * Contains Manufacturer data.
 */
@ManagedBean
public class Manufacturer {
		//Variables
		private String manu_code;
		private String manu_name;
		private String manu_details;
		//Constructor(s)
		public Manufacturer() {
		}

		public Manufacturer(String manu_code, String manu_name, String manu_details) {
			super();
			this.manu_code=  manu_code;
			this.manu_name=  manu_name;
			this.manu_details=  manu_details;
		}
		//Getters and setters
		public String getManu_code() {
			return manu_code;
		}

		public void setManu_code(String manu_code) {
			this.manu_code = manu_code;
		}

		public String getManu_name() {
			return manu_name;
		}

		public void setManu_name(String manu_name) {
			this.manu_name = manu_name;
		}

		public String getManu_details() {
			return manu_details;
		}

		public void setManu_details(String manu_details) {
			this.manu_details = manu_details;
		}

}
