package resources;

import pojo.LoginRequest;

public class PayLoadData {

	public LoginRequest getLoginPayload(String userID, String password) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail(userID);
		loginRequest.setUserPassword(password);
		return loginRequest;
	}
}
