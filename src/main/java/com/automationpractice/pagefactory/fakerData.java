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
public interface fakerData {
	Fairy fairy = Fairy.create();
	Person person = fairy.person();
	Company company = fairy.company();
}
