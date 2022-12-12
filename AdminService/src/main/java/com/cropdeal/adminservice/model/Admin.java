package com.cropdeal.adminservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="Admin")
	public class Admin {
		@Id
		private String adminId;
		private String adminUsername;
		private String adminPassword;

		public Admin() {
			
		}

		public Admin(String adminId, String adminUsername, String adminPassword) {
			super();
			this.adminId = adminId;
			this.adminUsername = adminUsername;
			this.adminPassword = adminPassword;
		}

		public String getAdminId() {
			return adminId;
		}

		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}

		public String getAdminUsername() {
			return adminUsername;
		}

		public void setAdminUsername(String adminUsername) {
			this.adminUsername = adminUsername;
		}

		public String getAdminPassword() {
			return adminPassword;
		}

		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}
		
}
