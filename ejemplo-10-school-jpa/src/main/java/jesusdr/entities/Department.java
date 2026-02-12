package jesusdr.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Parent;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @Basic(optional = false)
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100)
    private String location;

    @OneToMany(mappedBy = "department")
    private List<Teacher> teachers = new ArrayList<>();
}
