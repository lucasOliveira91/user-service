package br.com.tailorit.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Integer passStrength;
    private Long parentUserId;
    private List<UserDTO> children;
}

