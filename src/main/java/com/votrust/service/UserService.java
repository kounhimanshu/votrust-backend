package com.votrust.service;

import com.votrust.dto.UserDTO;
import com.votrust.entity.User;
import com.votrust.utils.RSAUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.KeyPair;

@Service
@Getter
@Setter
@Slf4j
public class UserService extends BasicService<User, UserDTO> {

    public UserService() {
        super(User.class, UserDTO.class);
    }

    public UserDTO register(UserDTO userDTO) throws Exception {
        // 1. Generate key pair

        KeyPair keyPair = RSAUtil.generateKeyPair();
        String publicKey = RSAUtil.encodeKey(keyPair.getPublic());
        String privateKey = RSAUtil.encodeKey(keyPair.getPrivate());
        userDTO.setPublicKey(publicKey);

        // 3. Map DTO to Entity and save
        User user = dtoToEntity(userDTO);
        user = save(user);

        // 4. Return response with private key included
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .name(user.getName())
                .publicKey(user.getPublicKey())
                .privateKey(privateKey)  // sent only in response
                .build();

    }

}
