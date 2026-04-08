package com.exception;

public class UserException extends RuntimeException {
  private String Exceptionmsg;
 
  public UserException(String a) {
	// TODO Auto-generated constructor stub
	  this.Exceptionmsg=a;
}
public String getException() {
	  return Exceptionmsg;
  }
@Override
public String toString() {
	return "UserException [Exceptionmsg=" + Exceptionmsg + "]";
}
  
  
}
