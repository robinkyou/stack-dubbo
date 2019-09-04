package org.kyou.stack.dubbo.export;

import org.kyou.stack.dubbo.common.domain.Result;
import org.kyou.stack.dubbo.domain.po.Person;
import org.kyou.stack.dubbo.domain.res.PersonRes;

public interface PersonResource {

    Result insertPerson(Person req);

    Result updatePerson(Person req);

    Result deletePerson(Integer personId);

    PersonRes queryPersonList(Person req);

    PersonRes queryPersonByPersonId(Integer personId);
}
