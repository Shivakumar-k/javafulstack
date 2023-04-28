package electricity.com.xworkz.policeStation.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import com.xworkz.showroom.dto.ShowRoomDTO;

public class ValidationUtil<T> {

	public boolean validDTO(T t) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		javax.validation.Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
		
		System.out.println("Total constraints violation:" + constraintViolations.size());
		constraintViolations.forEach(cv -> System.out.println(cv.getPropertyPath() + " " + cv.getMessage()));
		
		return constraintViolations.isEmpty();
	}
	

}
