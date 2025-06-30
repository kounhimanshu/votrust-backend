package com.votrust.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
//            Jwt jwt = jwtAuth.getToken();
//            String username = jwt.getClaimAsString("name");
//            log.info("request by = {}", username);
//            return Optional.ofNullable(username);
//        }
        log.info("No valid JwtAuthenticationToken found in context, assigning 'system' as default");
        return Optional.of("system");
    }

}
