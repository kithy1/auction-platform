package com.kandk.auctionplatform.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity implements Serializable {

    private String userName;
    private String firstName;
    private String lastName;

    private Address homeAddress;

    /**
     * Właściwość billingAddress to następna właściwość reprezentująca komponent osadzony w klasie User,
     * zatem w tabeli USERS musi być zapisany inny egzemplarz klasy Address.
     * Powoduje to konflikt mapowania, dlatego aby zapisać kolejny egzemplarz klasy Address dla każdego wiersza tabeli USERS potrzebujemy dodatkowych kolumn.
     * Podczas tworzenia mapy właściwości billingAddress przesłaniamy nazwy kolumn.
     * Kolumny BILLING_STREET, BILLING_ZIPCODE, BILLING_CITY mogą przyjmować wartość null (mechanizm Bean Validation nadal rozpoznaje adnotację @NotNull na właściwościach komponentu,
     * Hibernate przesłania wyłącznie adnotacje związane z utrwalaniem).
     * Adnotacja @Embedded nie jest konieczna, ale w niczym nie przeszkadza (przydatna jeśli chcemy zmapować klasę komponentu zewnętrznego dostawcy).
     * Jest to alternatywa dla adnotacji @Embeddable: należy wprowadzić adnotację dla klasy komponentu albo właściwości wewnątrz encji-właściciela.
     * @AttributeOverride wybiórzo przesłania mapowanie właściwości klasy osadzonej.
     * W klasie Address mamy zagnieżdżoną właściwość City. Do zagnieżdżonych właściwości można się odwoływać za pomocą notacji z kropką:
     * przykładowo adnotacja @AttributeOverride(name = "city.name") dla właściwości User#billingAddress odwołuje się do atrybutu Address#City#name.
     */
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
            @AttributeOverride(name = "city.zipcode", column = @Column(name = "BILLING_ZIPCODE", length = 5)),
            @AttributeOverride(name = "city.name", column = @Column(name = "BILLING_CITY")),
            @AttributeOverride(name = "city.country", column = @Column(name = "BILLING_COUNTRY"))
    })
    private Address billingAddress;
}
