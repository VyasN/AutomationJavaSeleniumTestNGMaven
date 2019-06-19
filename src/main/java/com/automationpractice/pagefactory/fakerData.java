/**
 * 
 */
package com.automationpractice.pagefactory;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.company.Company;
import com.devskiller.jfairy.producer.person.Person;

/**
 * @author nartan.vyas
 *
 */

//Just an example to show we can use interface to leverage signs of methods 

public interface fakerData {
	Fairy fairy = Fairy.create();
	Person person = fairy.person();
	Company company = fairy.company();
}
