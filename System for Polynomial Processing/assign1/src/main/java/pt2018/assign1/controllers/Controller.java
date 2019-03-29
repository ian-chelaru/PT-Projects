package pt2018.assign1.controllers;

import java.util.ArrayList;
import java.util.List;

import pt2018.assign1.models.IntegerMonomial;
import pt2018.assign1.models.Monomial;
import pt2018.assign1.models.Polynomial;
import pt2018.assign1.views.View;


/**
 * It has three attributes: two Polynomials objects p1 and p2 and a View object.
 * It controls the whole system. It communicates data between the user to the application.
 *  
 * @author Ian Chelaru
 *
 */

public class Controller
{
		
	private View view = new View();
	private Polynomial p1;
	private Polynomial p2;
	
	/**
	 * The constructor Controller() is a public one, without parameters. Firstly, the constructor makes the frame
	 *  visible for the user. Then it implements the actions which should take place when a button is pressed 
	 *  (calling the methods from the View class). For each operation, the controller takes the list of coefficients
	 *  from the text fields, converts the strings to Polynomials, compute the desired operation using the
	 *  Polynomials objects and sets the text from the "labelResult" to the string representation of the 
	 *  output polynomial.
	 */
	
	public Controller()
	{
		view.setVisible(true);
		
		view.actionListenerForAdd(al ->
		{
			try
			{
				p1 = convertFromStringToPolynomial(view.getTf1().getText());
				p2 = convertFromStringToPolynomial(view.getTf2().getText());
				view.getLabelResult().setText(p1.addition(p2).toString());
			}
			catch (NumberFormatException e)
			{
				view.getLabelResult().setText("Invalid input");
			}
		});
		
		view.actionListenerForSub(al ->
		{
			try
			{
				p1 = convertFromStringToPolynomial(view.getTf1().getText());
				p2 = convertFromStringToPolynomial(view.getTf2().getText());
				view.getLabelResult().setText(p1.subtraction(p2).toString());
			}
			catch (NumberFormatException e)
			{
				view.getLabelResult().setText("Invalid input");
			}
		});
		
		view.actionListenerForDiff(al ->
		{
			try
			{
				p1 = convertFromStringToPolynomial(view.getTf1().getText());
				view.getLabelResult().setText(p1.differentiation().toString());
			}
			catch (NumberFormatException e)
			{
				view.getLabelResult().setText("Invalid input");
			}
		});
		
		view.actionListenerForInte(al ->
		{
			try
			{
				p1 = convertFromStringToPolynomial(view.getTf1().getText());
				view.getLabelResult().setText(p1.integration().toString());
			}
			catch (NumberFormatException e)
			{
				view.getLabelResult().setText("Invalid input");
			}
		});
		
		view.actionListenerForMul(al ->
		{
			try
			{
				p1 = convertFromStringToPolynomial(view.getTf1().getText());
				p2 = convertFromStringToPolynomial(view.getTf2().getText());
				view.getLabelResult().setText(p1.multiplication(p2).toString());
			}
			catch (NumberFormatException e)
			{
				view.getLabelResult().setText("Invalid input");
			}
		});
		
		view.actionListenerForDiv(al -> 
		{
			try
			{
				p1 = convertFromStringToPolynomial(view.getTf1().getText());
				p2 = convertFromStringToPolynomial(view.getTf2().getText());
				if (p2.getTerms().size() == 1 && p2.getTerms().get(0).getCoefficient().intValue() == 0)
				{
					view.getLabelResult().setText("Division by zero");
				}
				else if (p1.getTerms().size() == 1 && p2.getTerms().size() == 1)
				{
					double result = p1.getTerms().get(0).getCoefficient().doubleValue() / p2.getTerms().get(0).getCoefficient().doubleValue();
					view.getLabelResult().setText(String.valueOf(result));
				}
				else
				{
					view.getLabelResult().setText(p1.division(p2).toString());
				}
			}
			catch (NumberFormatException e)
			{
				view.getLabelResult().setText("Invalid input");
			}
		});
	}
	
	
	/**
	 * Takes the string given as a parameter and converts it (if possible) into a Polynomial object.
	 * 
	 * @param s	the string which represents a list of coefficients separated by a space one from the previous one
	 * @return a new Polynomial object
	 * @throws NumberFormatException the method uses the parseInt() method which throws the exception
	 */
	
	public Polynomial convertFromStringToPolynomial (String s) throws NumberFormatException
	{
		String coefArray[] = s.split(" ");
		List<Monomial> terms = new ArrayList<>();
		for (int i = 0; i < coefArray.length; i++)
		{
			IntegerMonomial m = new IntegerMonomial(Integer.parseInt(coefArray[i]), i);
			terms.add(m);
		}
		Polynomial p = new Polynomial(terms);
		return p;
	}
}

