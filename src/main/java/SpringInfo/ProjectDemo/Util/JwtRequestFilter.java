package SpringInfo.ProjectDemo.Util;
import SpringInfo.ProjectDemo.Service.CustomUserDetailsService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;

@Component

public class JwtRequestFilter  extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(JwtRequestFilter.class);

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        logger.debug("Authorization Header: {}", authorizationHeader);

        String username = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            logger.debug("Extracted JWT: {}", jwt);

            try {
                username = jwtUtil.extractUsername(jwt);
                logger.debug("Extracted Username: {}", username);
            } catch (Exception e) {
                logger.error("Error extracting username from JWT", e);
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            logger.debug("SecurityContextHolder has no authentication, proceeding with user validation.");

            UserDetails userDetails = null;
            try {
                userDetails = userDetailsService.loadUserByUsername(username);
                logger.debug("UserDetails fetched successfully for username: {}", username);
            } catch (UsernameNotFoundException e) {
                logger.error("User not found for username: {}", username, e);
            }

            if (jwtUtil.validateToken(jwt, userDetails)) {
                logger.debug("JWT validation successful for username: {}", username);

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                logger.debug("Authentication set in SecurityContextHolder for username: {}", username);
            } else {
                logger.warn("JWT validation failed for username: {}", username);
            }
        }

        chain.doFilter(request, response);
    }
}