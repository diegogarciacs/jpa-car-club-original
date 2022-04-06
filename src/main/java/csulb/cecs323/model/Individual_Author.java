package csulb.cecs323.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import java.util.Set;

@Entity
@NamedNativeQuery(
        name = "ReturnIndividualAuthor",
        query = "SELECT * " +
                "FROM AUTHORING_ENTITIES " +
                "WHERE name = ? AND AUTHORING_ENTITY_TYPE = 'Individual Author'",
        resultClass = Individual_Author.class
)
@DiscriminatorValue("Individual Author")
public class Individual_Author extends Authoring_Entity
{

    @ManyToMany(mappedBy = "authors")
    Set<Ad_Hoc_Team> ad_hoc_teams;
    //Default constructor
    public Individual_Author() {};

    /***
     *
     * Basic constructor for an individual author entity.
     *
     * @param name name of author.
     * @param email email of author.
     */
    public Individual_Author(String name, String email)
    {
        super(name,email);

    }

}
