package pt2018.assign3.business;

import pt2018.assign3.dao.DataAccessProduct;
import pt2018.assign3.model.Product;

/**
 * Manages the product processing.
 *  
 * @author Ian Chelaru
 *
 */

public class ProductBLL
{

	private DataAccessProduct productDAO;
	
	public ProductBLL()
	{
		productDAO = new DataAccessProduct();
	}
	
	public boolean insertProduct(Product product)
	{
		return productDAO.insert(product);
	}
	
	public void editProduct(Product product)
	{
		productDAO.update(product);
	}
	
	/**
	 * Creates a new product with the new characteristics.
	 * Finds the old product with the given id.
	 * Replaces the characteristics of the old product with the ones of the new product.
	 * The characteristics which have null values are kept from the old product.
	 * 
	 * @param id the id of the product which is going to be updated
	 * @param description a string which contains the new description of the product
	 * @param pricePerUnit a string which contains the new unity price of the product
	 * @param quantity a string which contains the new quantity of the product
	 */
	
	public void editProduct(int id, String description, String pricePerUnit, String quantity)
	{
		Product oldProduct = productDAO.select(id);
		Product newProduct = new Product();
		newProduct.setId(id);
		if (description.isEmpty())
		{
			newProduct.setDescription(oldProduct.getDescription());
		}
		else
		{
			newProduct.setDescription(description);
		}
		if (pricePerUnit.isEmpty())
		{
			newProduct.setPricePerUnit(oldProduct.getPricePerUnit());
		}
		else
		{
			newProduct.setPricePerUnit(Double.parseDouble(pricePerUnit));
		}
		if (quantity.isEmpty())
		{
			newProduct.setQuantity(oldProduct.getQuantity());
		}
		else
		{
			newProduct.setQuantity(Integer.parseInt(quantity));
		}
		productDAO.update(newProduct);
	}
	
	public void deleteProductById(int id)
	{
		productDAO.delete(id);
	}
	
	public Product selectProductById(int id)
	{
		return productDAO.select(id);
	}
	
	public String[] getProductFieldsName()
	{
		return productDAO.getFieldsName();
	}
	
	public Object[][] getProductData()
	{
		return productDAO.getData();
	}
}
