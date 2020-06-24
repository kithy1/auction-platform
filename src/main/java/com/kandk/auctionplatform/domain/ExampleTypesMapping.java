package com.kandk.auctionplatform.domain;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;
import java.util.Locale;
import java.util.TimeZone;

@NoArgsConstructor
@Entity
public class ExampleTypesMapping extends BaseEntity {

    // Dla MS SQL SERVER

    Integer integer; //int
    Long aLong;  //bigint
    Short aShort;  //smallint
    Float aFloat;  //float
    Double aDouble; //float
    Byte aByte; // smallint
    Boolean aBoolean; // bit
    @Column(precision = 2, scale = 1)
    BigDecimal bigDecimal; // numeric(2,1) domyślnie (19,2) dzięki adnotacji przesłaniamy to zachowanie
    BigInteger bigInteger; // numeric(19,2)

    @Column(length = 255)
    String string; //varchar
    @Length(min = 1, max = 15)
    String anotherString;
    @Lob
    String longString;
    /**
     * Marks a character data type (String, Character, character, Clob)
     * as being a nationalized variant (NVARCHAR, NCHAR, NCLOB, etc).
     */
    @Nationalized
    String nationalized;
    Character character; //char
    Class aClass; //varchar
    Locale locale; //varchar
    TimeZone timeZone; //varchar
    Currency currency; //varchar
}
