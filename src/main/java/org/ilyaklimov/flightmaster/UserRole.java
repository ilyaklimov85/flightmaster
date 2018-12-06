package org.ilyaklimov.flightmaster;

public enum UserRole {
	
		ADMINISTRATOR(true, true),
		OPERATOR(true, false),
		CUSTOMER(false, false);
		
		private boolean hasAccessToReports;
		private boolean canManageUsers;
		
		private UserRole(boolean hasAccessToReports, boolean canManageUsers) {
			this.hasAccessToReports = hasAccessToReports;
			this.canManageUsers = canManageUsers;
		}
		
		public boolean hasAccessToReports(){
			return hasAccessToReports;
		}
		
		public boolean canManageUsers(){
			return canManageUsers;
		}

}
