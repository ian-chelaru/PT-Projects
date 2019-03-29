package pt2018.assign1.models;

/**
 * RealMonomial is a subclass of the Monomial class. The coefficient is a Double object.  
 * 
 * @author Ian Chelaru
 *
 */

public class RealMonomial extends Monomial
{
	/**
	 * Constructs and initialize a monomial with real coefficient. It calls the constructor from the
	 * super class Momonial using the keyword "super".
	 * @param coefficient the coefficient of the newly constructed monomial
	 * @param degree degree the degree of the newly constructed monomial
	 */
	
	public RealMonomial(Double coefficient, int degree)
	{
		super(coefficient, degree);
	}
}

