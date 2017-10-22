package edu.ldcollege.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;


/**
 * 
 * @author raindrops on 20171018
 *
 */
public class JwtUtils {
	
	private static Logger logger = Logger.getLogger(JwtUtils.class);
	
	private static final String secret = "leaderHpEdu2017";
	
	/**
	 * sign JWT
	 * 签发
	 * @param userId 用户ID
	 * @return
	 */
    public static String signJWT(String username) {
        //head头部分是默认的
        //Sign JWT (HS256)
        final long iat = System.currentTimeMillis() / 1000L; // issued at claim
        final long exp = iat + 60L*60*24*30; // expires claim. In this case the token expires in 60 seconds
        final JWTSigner signer = new JWTSigner(secret);
        final HashMap<String, Object> claims = new HashMap<String, Object>();
//        claims.put("iss", issuer);//JWT issuer
        claims.put("exp", exp);// expire time
        claims.put("iat", iat);// sign time
        claims.put("username", username); // content
        final String jwt = signer.sign(claims);
        if(logger.isDebugEnabled()) {
    		logger.debug(jwt);
    	}
        return jwt;
    }
    
    /**
     * Verify
     * 验证
     * @param jwt
     * @return
     */
    public static String verifyJWT(String jwt) {
        try {
            final JWTVerifier verifier = new JWTVerifier(secret);
            final Map<String, Object> claims = verifier.verify(jwt);

            String username= (String) claims.get("username");
            if(logger.isDebugEnabled()) {
        		logger.debug(claims.toString());
        	}
            return username;
        } catch (Exception e) {
            // Invalid Token
        	logger.error("过期的或错误的");
            return null;
        }
    }

    public static void main(String[] args) {
    	System.out.println(signJWT("121"));
    }
}
