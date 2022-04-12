package annotations;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import persistence.multiple.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedStoredProcedureQueries({ 
    @NamedStoredProcedureQuery(
        name = "count_by_name", 
        procedureName = "person.count_by_name", 
        parameters = { 
                @StoredProcedureParameter(
                    mode = ParameterMode.IN, 
                    name = "name", 
                    type = String.class),
                @StoredProcedureParameter(
                    mode = ParameterMode.OUT, 
                    name = "count", 
                    type = Long.class) 
                }) 
})

public class Person {

    @Id
    private Long id;

    @Transient
    private int age;

    @CreatedBy
    private User creator;

    @LastModifiedBy
    private User modifier;

    @CreatedDate
    private Date createdAt;

    @LastModifiedBy
    private Date modifiedAt;

}
