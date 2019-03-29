package pt2018.assign1.models;

/**
 * Monomial class describes the monomial function of one variable x. It is perfectly determined by its coefficient and degree.
 * The value of the monomial in the point x is computed by rising x to the power d and multiply the result
 * with c: c*x^d, where c is the coefficient and d the degree.
 *  
 * @author Ian Chelaru
 * 
 */

public class Monomial
{
	private Number coefficient;
	private int degree;
	
	/**
	 * Constructs and initializes a monomial.
	 * @param coefficient the coefficient of the newly constructed monomial
	 * @param degree the degree of the newly constructed monomial 
	 */
	
	public Monomial(Number coefficient, int degree)
	{
		this.coefficient = coefficient;
		this.degree = degree;
	}
	
	public Number getCoefficient()
	{
		return this.coefficient;
	}
	
	public void setCoefficient(Number coefficient)
	{
		this.coefficient = coefficient;
	}
	
	public int getDegree()
	{
		return this.degree;
	}
	
	public void setDegree(int degree)
	{
		this.degree = degree;
	}
	
	/**
	 * Returns a string which represents a monomial object in the way in which 
	 * it is seen in the real world by any person (cx^d).  
	 */
	public String toString()
	{
		this.setCoefficient(Math.round(this.getCoefficient().doubleValue() * 100.0));
		if (this.getCoefficient().doubleValue() % 100 == 0)
		{
			this.setCoefficient(this.getCoefficient().intValue() / 100);
		}
		else
		{
			this.setCoefficient(this.getCoefficient().doubleValue() / 100.0);
		}
		if (coefficient.doubleValue() != 0)
		{
			if (coefficient.doubleValue() == 1)
			{
				switch (degree)
				{
				case 0: return "1";
				case 1: return "x";
				default: return ("x^" + String.valueOf(degree));
				}
			}
			else if (coefficient.doubleValue() == -1)
			{
				switch (degree)
				{
				case 0: return "-1";
				case 1: return "-x";
				default: return ("-x^" + String.valueOf(degree));
				}
			}
			else
			{
				switch (degree)
				{
				case 0: return coefficient.toString();
				case 1: return (coefficient.toString() + "x");
				default: return (coefficient.toString() + "x^" + String.valueOf(degree));
				}
			}
		}
		return "";
	}
}

