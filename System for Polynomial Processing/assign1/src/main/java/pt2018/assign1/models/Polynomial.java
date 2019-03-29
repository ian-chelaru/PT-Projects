package pt2018.assign1.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * Polynomial class describes the polynomial function of variable x. A polynomial has one or more term,
 * each term representing a monomial of the same variable x. The value of the polynomial in the point x
 * is obtained by computing all the monomials over the same variable x and adding the results.
 * 
 * @author Ian Chelaru
 *
 */

public class Polynomial
{
	private List<Monomial> terms;
	
	/**
	 * Construct and initializes a polynomial.
	 * @param terms the list of monomials which form the polynomial
	 */

	public Polynomial(List<Monomial> terms)
	{
		this.terms = terms;
	}

	public List<Monomial> getTerms()
	{
		return this.terms;
	}

	public void setTerms(List<Monomial> terms)
	{
		this.terms = terms;
	}

	/**
	 * Computes the addition between this polynomial and the one which is transmitted as parameter.
	 * The algorithm add the coefficients of the terms which have the same degree. The terms which do not
	 * have a correspondent in the other polynomial are put in the result polynomial at the end.
	 * 
	 * @param p polynomial which is added to the polynomial which calls the method
	 * @return a new polynomial object which is equal to the sum of the two input polynomials
	 *  
	 */
	
	public Polynomial addition(Polynomial p)
	{
		List<Monomial> result = new ArrayList<>();
		Iterator<Monomial> it1 = this.terms.iterator();
		Iterator<Monomial> it2 = p.terms.iterator();
		while (it1.hasNext() && it2.hasNext())
		{
			Monomial m1 = it1.next();
			Monomial m2 = it2.next();
			RealMonomial m3 = new RealMonomial(m1.getCoefficient().doubleValue() + m2.getCoefficient().doubleValue(),
					m1.getDegree());
			result.add(m3);
		}
		while (it1.hasNext())
		{
			result.add(it1.next());
		}
		while (it2.hasNext())
		{
			result.add(it2.next());
		}
		Polynomial pResult = new Polynomial(result);
		return pResult;
	}
	
	/**
	 * Computes the subtraction of the polynomial which is transmitted as parameter from this polynomial.
	 * The algorithm performs like the one for the addition. In this case the coefficients are subtracted one
	 * from another. In the case there are more terms in the in the argument polynomial, the opposite of
	 * its terms are added to the result.
	 * 
	 * @param p polynomial which is subtracted from the polynomial which calls the method
	 * @return a new polynomial object which is equal to the difference of the two input polynomials
	 * 
	 */

	public Polynomial subtraction(Polynomial p)
	{
		List<Monomial> result = new ArrayList<>();
		Iterator<Monomial> it1 = this.terms.iterator();
		Iterator<Monomial> it2 = p.terms.iterator();
		while (it1.hasNext() && it2.hasNext())
		{
			Monomial m1 = it1.next();
			Monomial m2 = it2.next();
			RealMonomial m3 = new RealMonomial(m1.getCoefficient().doubleValue() - m2.getCoefficient().doubleValue(),
					m1.getDegree());
			result.add(m3);
		}
		while (it1.hasNext())
		{
			result.add(it1.next());
		}
		while (it2.hasNext())
		{
			Monomial m3 = it2.next();
			m3.setCoefficient(-m3.getCoefficient().doubleValue());
			result.add(m3);
		}
		Polynomial pResult = new Polynomial(result);
		return pResult;
	}

	/**
	 * Differentiate this polynomial. The operation is done by multiplying the degree with the coefficient, 
	 * the result being the new coefficient. The new degree is computed by subtracting 1 from the old one
	 * 
	 * @return a polynomial which is equal to the this polynomial derivative
	 * 
	 */
	
	public Polynomial differentiation()
	{
		this.terms.forEach(monomial ->
		{
			monomial.setCoefficient(monomial.getCoefficient().doubleValue() * monomial.getDegree());
			monomial.setDegree(monomial.getDegree() - 1);
		});
		return this;
	}

	/**
	 * Integrate this polynomial. The new degree is computed by adding 1 to the old one. The new coefficient is obtained by
	 * dividing the old coefficient by the new degree.
	 * 
	 * @return a polynomial which is equal to the this polynomial antiderivative
	 * 
	 */
	
	public Polynomial integration()
	{
		this.terms.forEach(monomial ->
		{
			monomial.setDegree(monomial.getDegree() + 1);
			monomial.setCoefficient(monomial.getCoefficient().doubleValue() / monomial.getDegree());
		});
		return this;
	}
	
	/**
	 * Computes the multiplication of this polynomial with the one which is transmitted as parameter.
	 * The algorithm multiply each term of this polynomial with each term of parameter polynomial.
	 * Every product obtained in this way is converted into a polynomial and is added to the final
	 * result. 
	 * 
	 * @param p polynomial which is multiplied to the polynomial which calls the method
	 * @return a new polynomial object which is equal to the product of the two input polynomials
	 * 
	 */

	public Polynomial multiplication(Polynomial p)
	{
		List<Monomial> result = new ArrayList<>();
		Polynomial pResult = new Polynomial(result);
		List<Monomial> aux = new ArrayList<>();
		Polynomial pAux = new Polynomial(aux);
		Monomial zero = new Monomial(0, 0);
		this.terms.forEach(monomial1 ->
		{
			p.terms.forEach(monomial2 ->
			{
				Monomial m3 = new Monomial(
						monomial1.getCoefficient().doubleValue() * monomial2.getCoefficient().doubleValue(),
						monomial1.getDegree() + monomial2.getDegree());
				for (int i = 0; i < m3.getDegree(); i++)
				{
					aux.add(zero);
				}
				aux.add(m3);
				pAux.setTerms(aux);
				pResult.setTerms((pResult.addition(pAux)).getTerms());
				aux.clear();
			});
		});
		return pResult;
	}
	
	/**
	 * 
	 * @return the Monomial from the list of Monomials with the biggest degree and coefficient different from 0
	 */
	
	public Monomial getMaxMonomial()
	{
		for (int i = this.getTerms().size() -1; i >=0; i--)
		{
			if (this.getTerms().get(i).getCoefficient().doubleValue() != 0)
			{
				return this.getTerms().get(i);
			}
		}
		Monomial m = new Monomial(0, -1);
		return m;
	}
	
	/**
	 * Divides this polynomial by the polynomial transmitted as a parameter.
	 * The algorithm applied is the polynomial long division.
	 * 
	 * @param p polynomial which divides this polynomial
	 * @return a new polynomial which represents the quotient 
	 * 
	 */

	public Polynomial division(Polynomial p)
	{
		List<Monomial> quotient = new ArrayList<>();
		List<Monomial> aux = new ArrayList<>();
		Polynomial pAux = new Polynomial(aux);
		Polynomial pAux2 = new Polynomial(this.getTerms());
		Monomial m1 = this.terms.get(this.terms.size() - 1);
		Monomial m2 = p.terms.get(p.terms.size() - 1);
		Monomial zero = new Monomial(0, 0);
		int steps = m1.getDegree() - m2.getDegree();
		for (int j = 0; j <= steps; j++)
		{
			RealMonomial m3 = new RealMonomial(m1.getCoefficient().doubleValue() / m2.getCoefficient().doubleValue(),
					m1.getDegree() - m2.getDegree());
			quotient.add(0, m3);
			aux.clear();
			for (int i = 0; i < m3.getDegree(); i++)
			{
				aux.add(zero);
			}
			aux.add(m3);
			pAux.setTerms(aux);
			pAux = pAux.multiplication(p);
			pAux = pAux2.subtraction(pAux);
			pAux2.setTerms(pAux.getTerms());
			m1 = pAux.getMaxMonomial();
		}
		if (quotient.size() == 0)
		{
			quotient.add(zero);
		}
		Polynomial pQuotient = new Polynomial(quotient);
		return pQuotient;
	}

	public String toString()
	{
		String s = "";
		s += terms.get(0).toString();
		for (int i = 1; i < terms.size(); i++)
		{
			if (terms.get(i).getCoefficient().doubleValue() > 0)
			{
				s += "+" + terms.get(i).toString();
			} else
			{
				s += terms.get(i).toString();
			}
		}		
		/*
		 * terms.forEach(monomial -> { s += monomial.toString() + " "; });
		 */
		if (s.length() == 0)
		{
			return "0";
		}
		return s;
	}

}

