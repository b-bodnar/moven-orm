package ua.logos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "teachers")
public class TeacherEntity extends BaseEntity {

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    // mappedBy don't use on prod, there we will use join
    @OneToMany(mappedBy = "teacher", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<CourseEntity> courses;

    @OneToOne(mappedBy = "teacher")
    private TeacherDetailsEntity teacherDetails;
}
