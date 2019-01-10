package ple.sam.com.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Apires{

	@SerializedName("uid")
	private String uid;

	@SerializedName("password")
	private String password;

	@SerializedName("logintype")
	private String logintype;

	@SerializedName("name")
	private String name;

	@SerializedName("com_code")
	private String comCode;

	@SerializedName("id")
	private String id;

	@SerializedName("forgot")
	private String forgot;

	@SerializedName("email")
	private String email;

	@SerializedName("status")
	private String status;

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return uid;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setLogintype(String logintype){
		this.logintype = logintype;
	}

	public String getLogintype(){
		return logintype;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setComCode(String comCode){
		this.comCode = comCode;
	}

	public String getComCode(){
		return comCode;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setForgot(String forgot){
		this.forgot = forgot;
	}

	public String getForgot(){
		return forgot;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"uid = '" + uid + '\'' + 
			",password = '" + password + '\'' + 
			",logintype = '" + logintype + '\'' + 
			",name = '" + name + '\'' + 
			",com_code = '" + comCode + '\'' + 
			",id = '" + id + '\'' + 
			",forgot = '" + forgot + '\'' + 
			",email = '" + email + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	public String getCode() {
		return email;
	}

	public String toLowerCase() {
		return  email;
	}
}