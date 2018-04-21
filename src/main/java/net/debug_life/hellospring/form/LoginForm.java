package net.debug_life.hellospring.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.debug_life.hellospring.validation.GroupOrder1;
import net.debug_life.hellospring.validation.GroupOrder2;

public class LoginForm {

	@NotBlank(groups = { GroupOrder1.class }, message = "ユーザ名を入力してください。")
	private String loginName;

	@NotBlank(groups = { GroupOrder1.class }, message = "パスワードを入力してください。")
	@Size(min = 8, groups = { GroupOrder2.class }, message = "パスワードは{min}文字以上必要です。")
	@Pattern(regexp = "[a-zA-Z0-9]*", groups = { GroupOrder2.class }, message = "パスワードは英数である必要があります。")
	private String loginPassword;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}