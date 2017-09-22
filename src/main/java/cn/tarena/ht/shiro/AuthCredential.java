package cn.tarena.ht.shiro;

import org.apache.shiro.authc.AuthenticationInfo;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.tarena.ht.tool.MD5HashPassword;


public class AuthCredential extends  SimpleCredentialsMatcher{
	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//密码加密
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String username = loginToken.getUsername();
		String password = String.valueOf(loginToken.getPassword());
		
		String md5Password = MD5HashPassword.getPassword(username, password);
		
		//密码存入令牌
		loginToken.setPassword(md5Password.toCharArray());
		
		return super.doCredentialsMatch(loginToken, info);
	}
}
