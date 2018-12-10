package org.ilyaklimov.flightmaster;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.ilyaklimov.flightmaster.UserRole;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-10T15:56:17")
@StaticMetamodel(AppUser.class)
public class AppUser_ { 

    public static volatile SingularAttribute<AppUser, String> firstName;
    public static volatile SingularAttribute<AppUser, String> lastName;
    public static volatile SingularAttribute<AppUser, String> password;
    public static volatile SingularAttribute<AppUser, UserRole> role;
    public static volatile SingularAttribute<AppUser, Integer> id;
    public static volatile SingularAttribute<AppUser, String> login;

}