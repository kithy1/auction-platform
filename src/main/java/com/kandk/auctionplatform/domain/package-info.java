/**
 * Strategia enhanced_sequence generuje sekwencyjne wartości liczbowe.
 * Jeżeli stosowany dialekt SQL obsługuje sekwencje, to Hibernate skorzysta z sekwencji w bazie danych.
 * Jeżeli wykorzystywany system DBMS nie wspiera natywnych sekwencji, to framework Hibernate skorzysta
 * z dodatkowej "tabeli sekwencji", która symuluje zachowanie sekwencji.
 * Program generujący wywoływany jest przed wykonaniem instrukcji INSERT.
 * W przypadku gdy ma znaczenie rywalizacja (ponieważ sekwencja musi być wywoływana przed każdą instrukcją INSERT),
 * można zastosować drugą odmianę generatora.
 */
@GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-sequence",
        parameters = {
                @Parameter(
                        name = "sequence_name",
                        value = "JPWH_SEQUENCE"
                ),
                @Parameter(
                        name = "initial_value",
                        value = "1000"
                )}
)
@GenericGenerator(
        name = "ID_GENERATOR_POOLED",
        strategy = "enhanced-sequence",
        parameters = {
                @Parameter(
                        name = "sequence_name",
                        value = "JPWH_SEQUENCE"
                ),
                @Parameter(
                        name = "increment_size",
                        value = "100"
                ),
                @Parameter(
                        name = "optimizer",
                        value = "pooled-lo"
                )})

package com.kandk.auctionplatform.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


