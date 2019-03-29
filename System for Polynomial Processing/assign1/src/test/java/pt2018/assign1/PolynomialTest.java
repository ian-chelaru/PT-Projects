package pt2018.assign1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pt2018.assign1.models.Monomial;
import pt2018.assign1.models.Polynomial;

/**
 * 
 * @author Ian Chelaru
 *
 */

public class PolynomialTest
{

	@Test
	public void testAddition()
	{
		List<Monomial> mList1 = new ArrayList<>();
		mList1.add(new Monomial(1,0)) ;
		mList1.add(new Monomial(0,1)) ;
		mList1.add(new Monomial(-5,2)) ;
		mList1.add(new Monomial(4,3)) ;
		mList1.add(new Monomial(2,4)) ;
		Polynomial p1 = new Polynomial(mList1);
		
		List<Monomial> mList2 = new ArrayList<>();
		mList2.add(new Monomial(7,0)) ;
		mList2.add(new Monomial(-9,1)) ;
		mList2.add(new Monomial(5,2)) ;
		mList2.add(new Monomial(3,3)) ;
		Polynomial p2 = new Polynomial(mList2);
		
		Polynomial p3 = p1.addition(p2);
		
		List<Monomial> mList3 = new ArrayList<>();
		mList3.add(new Monomial(8,0)) ;
		mList3.add(new Monomial(-9,1)) ;
		mList3.add(new Monomial(0,2)) ;
		mList3.add(new Monomial(7,3)) ;
		mList3.add(new Monomial(2,4)) ;
		Polynomial p4 = new Polynomial(mList3);
		
		assertEquals(p3.getTerms().size(), p4.getTerms().size());
		for (int i = 0; i < p3.getTerms().size(); i++)
		{
			assertEquals(p3.getTerms().get(i).getDegree(), p4.getTerms().get(i).getDegree());
			assertEquals(p3.getTerms().get(i).getCoefficient().intValue(), p4.getTerms().get(i).getCoefficient().intValue());
		}
	}

	@Test
	public void testSubtraction()
	{
		List<Monomial> mList1 = new ArrayList<>();
		mList1.add(new Monomial(1,0)) ;
		mList1.add(new Monomial(0,1)) ;
		mList1.add(new Monomial(-5,2)) ;
		mList1.add(new Monomial(4,3)) ;
		mList1.add(new Monomial(2,4)) ;
		Polynomial p1 = new Polynomial(mList1);
		
		List<Monomial> mList2 = new ArrayList<>();
		mList2.add(new Monomial(7,0)) ;
		mList2.add(new Monomial(-9,1)) ;
		mList2.add(new Monomial(5,2)) ;
		mList2.add(new Monomial(3,3)) ;
		Polynomial p2 = new Polynomial(mList2);
		
		Polynomial p3 = p1.subtraction(p2);
		
		List<Monomial> mList3 = new ArrayList<>();
		mList3.add(new Monomial(-6,0)) ;
		mList3.add(new Monomial(9,1)) ;
		mList3.add(new Monomial(-10,2)) ;
		mList3.add(new Monomial(1,3)) ;
		mList3.add(new Monomial(2,4)) ;
		Polynomial p4 = new Polynomial(mList3);
		
		assertEquals(p3.getTerms().size(), p4.getTerms().size());
		for (int i = 0; i < p3.getTerms().size(); i++)
		{
			assertEquals(p3.getTerms().get(i).getDegree(), p4.getTerms().get(i).getDegree());
			assertEquals(p3.getTerms().get(i).getCoefficient().intValue(), p4.getTerms().get(i).getCoefficient().intValue());
		}
	}

	@Test
	public void testDifferentiation()
	{
		List<Monomial> mList1 = new ArrayList<>();
		mList1.add(new Monomial(1,0)) ;
		mList1.add(new Monomial(0,1)) ;
		mList1.add(new Monomial(-5,2)) ;
		mList1.add(new Monomial(4,3)) ;
		mList1.add(new Monomial(2,4)) ;
		Polynomial p1 = new Polynomial(mList1);
		
		Polynomial p3 = p1.differentiation();
		
		List<Monomial> mList3 = new ArrayList<>();
		mList3.add(new Monomial(0,-1)) ;
		mList3.add(new Monomial(0,0)) ;
		mList3.add(new Monomial(-10,1)) ;
		mList3.add(new Monomial(12,2)) ;
		mList3.add(new Monomial(8,3)) ;
		Polynomial p4 = new Polynomial(mList3);
		
		assertEquals(p3.getTerms().size(), p4.getTerms().size());
		for (int i = 0; i < p3.getTerms().size(); i++)
		{
			assertEquals(p3.getTerms().get(i).getDegree(), p4.getTerms().get(i).getDegree());
			assertEquals(p3.getTerms().get(i).getCoefficient().intValue(), p4.getTerms().get(i).getCoefficient().intValue());
		}
	}

	@Test
	public void testIntegration()
	{
		List<Monomial> mList1 = new ArrayList<>();
		mList1.add(new Monomial(1,0)) ;
		mList1.add(new Monomial(0,1)) ;
		mList1.add(new Monomial(-5,2)) ;
		mList1.add(new Monomial(4,3)) ;
		mList1.add(new Monomial(2,4)) ;
		Polynomial p1 = new Polynomial(mList1);
		
		Polynomial p3 = p1.integration();
		
		List<Monomial> mList3 = new ArrayList<>();
		mList3.add(new Monomial(1,1)) ;
		mList3.add(new Monomial(0,2)) ;
		mList3.add(new Monomial(-1.67,3)) ;
		mList3.add(new Monomial(1,4)) ;
		mList3.add(new Monomial(0.4,5)) ;
		Polynomial p4 = new Polynomial(mList3);
		
		assertEquals(p3.getTerms().size(), p4.getTerms().size());
		for (int i = 0; i < p3.getTerms().size(); i++)
		{
			assertEquals(p3.getTerms().get(i).getDegree(), p4.getTerms().get(i).getDegree());
			assertEquals(p3.getTerms().get(i).getCoefficient().doubleValue(), p4.getTerms().get(i).getCoefficient().doubleValue(), 0.01);
		}
		
	}

	@Test
	public void testMultiplication()
	{
		List<Monomial> mList1 = new ArrayList<>();
		mList1.add(new Monomial(1,0)) ;
		mList1.add(new Monomial(0,1)) ;
		mList1.add(new Monomial(-5,2)) ;
		mList1.add(new Monomial(4,3)) ;
		mList1.add(new Monomial(2,4)) ;
		Polynomial p1 = new Polynomial(mList1);
		
		List<Monomial> mList2 = new ArrayList<>();
		mList2.add(new Monomial(7,0)) ;
		mList2.add(new Monomial(-9,1)) ;
		mList2.add(new Monomial(-9,2)) ;
		mList2.add(new Monomial(3,3)) ;
		Polynomial p2 = new Polynomial(mList2);
		
		Polynomial p3 = p1.multiplication(p2);
		
		List<Monomial> mList3 = new ArrayList<>();
		mList3.add(new Monomial(7,0)) ;
		mList3.add(new Monomial(-9,1)) ;
		mList3.add(new Monomial(-44,2)) ;
		mList3.add(new Monomial(76,3)) ;
		mList3.add(new Monomial(23,4)) ;
		mList3.add(new Monomial(-69,5)) ;
		mList3.add(new Monomial(-6,6)) ;
		mList3.add(new Monomial(6,7)) ;
		Polynomial p4 = new Polynomial(mList3);
		
		assertEquals(p3.getTerms().size(), p4.getTerms().size());
		for (int i = 0; i < p3.getTerms().size(); i++)
		{
			assertEquals(p3.getTerms().get(i).getDegree(), p4.getTerms().get(i).getDegree());
			assertEquals(p3.getTerms().get(i).getCoefficient().intValue(), p4.getTerms().get(i).getCoefficient().intValue());
		}
	}

	@Test
	public void testDivision()
	{
		List<Monomial> mList1 = new ArrayList<>();
		mList1.add(new Monomial(1,0)) ;
		mList1.add(new Monomial(0,1)) ;
		mList1.add(new Monomial(-5,2)) ;
		mList1.add(new Monomial(4,3)) ;
		mList1.add(new Monomial(2,4)) ;
		Polynomial p1 = new Polynomial(mList1);
		
		List<Monomial> mList2 = new ArrayList<>();
		mList2.add(new Monomial(7,0)) ;
		mList2.add(new Monomial(-9,1)) ;
		mList2.add(new Monomial(5,2)) ;
		Polynomial p2 = new Polynomial(mList2);
		
		Polynomial p3 = p1.division(p2);
		
		List<Monomial> mList3 = new ArrayList<>();
		mList3.add(new Monomial(1.18,0)) ;
		mList3.add(new Monomial(1.52,1)) ;
		mList3.add(new Monomial(0.4,2)) ;
		
		Polynomial p4 = new Polynomial(mList3);
		
		assertEquals(p3.getTerms().size(), p4.getTerms().size());
		for (int i = 0; i < p3.getTerms().size(); i++)
		{
			assertEquals(p3.getTerms().get(i).getDegree(), p4.getTerms().get(i).getDegree());
			assertEquals(p3.getTerms().get(i).getCoefficient().doubleValue(), p4.getTerms().get(i).getCoefficient().doubleValue(), 0.01);
		}
	}

}
