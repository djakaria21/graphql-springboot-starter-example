package com.review.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PayType {
    @Id
    @GeneratedValue
    private Long id;

    String salary;

    String hourly;
    @OneToMany(fetch = FetchType.LAZY)
    List<Commission> commission;
    @OneToMany(fetch = FetchType.LAZY)
    List<Bonus> bonus;
}
