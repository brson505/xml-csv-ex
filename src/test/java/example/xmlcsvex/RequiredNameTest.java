package example.xmlcsvex;

import example.xmlcsvex.validator.apache.Name;
import org.apache.commons.validator.*;
import org.apache.commons.validator.util.ValidatorUtils;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class RequiredNameTest {
    @Test
    public void test() throws IOException, SAXException, ValidatorException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("validator-name-required.xml");
        //InputStream in = this.getClass().getResourceAsStream("validator-name-required.xml");
        System.out.println(in);

        // Create an instance of ValidatorResources to initialize from an xml file.
        ValidatorResources resources = new ValidatorResources(in);
        // Create bean to run test on.
        Name name = new Name();
        name.setFirstName("a");
        name.setLastName("b");

        // Construct validator based on the loaded resources and the form key
        Validator validator = new Validator(resources, "nameForm");
// add the name bean to the validator as a resource
// for the validations to be performed on.
        validator.setParameter(Validator.BEAN_PARAM, name);

        // Get results of the validation.
        ValidatorResults results = null;

// throws ValidatorException (catch clause not shown here)
        results = validator.validate();
        Iterator<String> iter = results.getValidatorResult("firstName").getActions();
        while(iter.hasNext()){
            String action = iter.next();
            System.out.println("action:" + action);
            System.out.println("result:" + results.getValidatorResult("firstName").getResult(action));
        }

        name.setFirstName(null);
        name.setLastName(null);

        validator.setParameter(Validator.BEAN_PARAM, name);
        results = validator.validate();

        iter = results.getValidatorResult("firstName").getActions();
        while(iter.hasNext()){
            String action = iter.next();
            System.out.println("action:" + action);
            System.out.println("result:" + results.getValidatorResult("firstName").getResult(action));
        }

    }



    public static boolean validateRequired(Object bean, Field field) {
        String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
        return GenericValidator.isBlankOrNull(value);
    }
}
