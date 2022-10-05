package com.review.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    String name;

    @Column(unique=true)
    String userName;
    String password;
    String role;
    String photo;
    @OneToMany(fetch = FetchType.LAZY)
    List<PayType> payType;
    @OneToMany(fetch = FetchType.LAZY)
    List<ContactInformation> contactInformation;
    @OneToMany(fetch = FetchType.LAZY)
    List<Pto> pto;



}
