package com.app.utils;

import com.app.exceptions.LoginException;

public interface LoginUtils {
static void validateEmailAndPasswordLength(String email, String password) {
	if (email.length() > 30 || password.length() > 30)
		throw new LoginException("Invalid login");
}
}
