package com.alog.logistica.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Recipient {

    @Column(name = "receipient_name")
    private String name;
    @Column(name = "reicipient_address")
    private String address;
    @Column(name = "reicipient_number")
    private String number;
    @Column(name = "reicipient_complement")
    private String complement;
    @Column(name = "reicipient_neighborhood")
    private String neighborhood;
}
