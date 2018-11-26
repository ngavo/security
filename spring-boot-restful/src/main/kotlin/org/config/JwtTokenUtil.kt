package org.config

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.apache.tomcat.util.buf.StringUtils
import org.model.User
import org.springframework.stereotype.Component
import java.io.Serializable
import java.util.function.Function
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.Arrays.asList
import java.util.*


@Component
class JwtTokenUtil: Serializable{

    fun getUsernameFromToken(token: String): String {
        return getClaimFromToken(token).subject;
    }

    fun getExpirationDateFromToken(token: String): Date {
        return getClaimFromToken(token).expiration;
    }

    fun  getClaimFromToken(token: String): Claims {
        val claims: Claims = getAllClaimsFromToken(token)
        return claims;
    }

    private fun getAllClaimsFromToken(token: String): Claims {
        return Jwts.parser()
                .setSigningKey(Constants.SINGING_KEY)
                .parseClaimsJws(token)
                .getBody()
    }

    private fun isTokenExpired(token: String): Boolean{
        val experation: Date = getExpirationDateFromToken(token);
        return experation.before(Date());
    }


    public fun generateToken(user: User): String{
        return doGenerateToken(user.name);
    }


    private fun doGenerateToken(userName: String): String{
        var claims: Claims = Jwts.claims().setSubject(userName);
        claims.put("scopes", listOf(SimpleGrantedAuthority("ROLE_ADMIN")));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + Constants.ACCESS_TOKEN_VALIDITY_SECONDS*1000) )
                .signWith(SignatureAlgorithm.NONE, Constants.SINGING_KEY)
                .compact()
    }

    public fun validateToken(token: String, userDetail: UserDetails): Boolean{
        val username: String = getUsernameFromToken(token);
        return (username.equals(userDetail.username) && !isTokenExpired(token))
    }


}