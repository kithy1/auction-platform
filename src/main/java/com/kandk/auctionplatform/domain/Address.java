package com.kandk.auctionplatform.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Komponenty osadzalne dziedziczą strategię dostępu po encji będącej właścicielem.
 * To znaczy, że Hibernate będzie sięgał do właściwości klasy Address z wykorzystaniem tej samej
 * strategii jak dla właściwości klasy User. W tym wypadku jest to dostęp na poziomie pól,
 * gdyż adnotacja @Id znajduje się bezpośrednio nad polem
 * (alternatywnie można użyć adnotacji @Access(AccessType.FIELD na klasie).
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {

    /**
     * @NotNull podczas generowania schematu bazy danych Hibernate nie mapuje ograniczeń @NotNull
     * na właściwościach osadzanych komponentów na ograniczenia NOT NULL. Hibernate używa adnotacji @NotNull
     * dla właściwości komponentów wyłącznie w fazie działania, żeby wspomagać działania mechanizmów Bean Validation.
     * Aby wygenerować ograniczenie w schemacie, należy zmapować właściwość z adnotacją @Column(nullable = false).
     * Ten defekt jest identyfikowany w bazie błędów Hibernate jako HVAL-3.
     */
    @NotNull
    @Column(nullable = false)
    private String street;

    @NotNull
    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "name", column = @Column(name = "CITY", nullable = false))
    )
    private City city;


}
