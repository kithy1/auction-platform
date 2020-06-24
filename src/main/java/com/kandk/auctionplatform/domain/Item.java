package com.kandk.auctionplatform.domain;

import lombok.*;

import javax.persistence.Entity;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Item extends BaseEntity{

    private String name;
}
