package org.example.jpa.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Martin
 * @since 2021/03/17
 */
@Entity
public class Address {
    @Id
    private Long id;
}