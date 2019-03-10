package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.graalvm.compiler.graph.Node.InjectedNodeParameter;

@Entity //This tells Hibernate to make a table out of this class
public class User
{
    @Id
    @GeneratedValue(strategy=GeneratedType.AUTO)
    private Integer id;

    private String name;

    private String email;

    public Integer getId()
    {
        return id;
    }

    public void setID(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public String setEmail(String email)
    {
        this.email = email;
    }

}