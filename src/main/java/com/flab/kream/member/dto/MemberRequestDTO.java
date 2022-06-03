package com.flab.kream.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequestDTO {

    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "패스워드를 입력해주세요")
    private String password;

    @NotBlank(message = "닉네임을 입력해주세요")
    private String nickName;

    @NotBlank(message = "성별을 입력해주세요")
    private String gender;

    @NotBlank(message = "생일 입력해주세요")
    private String birth;

    @NotBlank(message = "사진을 입력해주세요")
    private String imageUrl;
}
