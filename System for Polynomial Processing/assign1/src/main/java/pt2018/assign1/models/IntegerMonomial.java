package pt2018.assign1.models;

/**
 * IntgerMonomial is a subclass of the Monomial class. The coefficient is an Integer object.  
 * 
 * @author Ian Chelaru
 *
 */

public class IntegerMonomial extends Monomial
{
	/**
	 * Constructs and initialize a monomial with integer coefficient. It calls the constructor from the
	 * super class Momonial using the keyword "super".
	 * @param coefficient the coefficient of the newly constructed monomial
	 * @param degree degree the degree of the newly constructed monomial
	 */
	
	public IntegerMonomial(Integer coefficient, int degree)
	{
		super(coefficient, degree);
	}
}
