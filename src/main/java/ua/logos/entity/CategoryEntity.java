package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name", nullable = false, length = 45)
    private String name;
}
