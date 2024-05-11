package com.sandeep.emailsenderapp.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailSenderDto {
    private String to;
    private String subject;
    private String message;

}
