package com.doneugene.kafkademoapp.dto;


import lombok.*;

import java.util.UUID;

/*
 * * @Author: Don Eugene
 * Employee to create Employees on the fly.
 * */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private UUID id;
    private UUID departmentId;
    private String username;
    private String firstName;
    private String otherName;
    private String lastName;
    private String employeeCode;

}