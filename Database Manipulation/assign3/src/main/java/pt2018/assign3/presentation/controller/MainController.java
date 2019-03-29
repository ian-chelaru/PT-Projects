package pt2018.assign3.presentation.controller;

import pt2018.assign3.business.ClientBLL;
import pt2018.assign3.business.OrderBLL;
import pt2018.assign3.business.ProductBLL;
import pt2018.assign3.model.Client;
import pt2018.assign3.model.Order;
import pt2018.assign3.model.Product;
import pt2018.assign3.presentation.view.AddClientView;
import pt2018.assign3.presentation.view.AddOrderView;
import pt2018.assign3.presentation.view.AddProductView;
import pt2018.assign3.presentation.view.DeleteObjectView;
import pt2018.assign3.presentation.view.EditClientView;
import pt2018.assign3.presentation.view.EditProductView;
import pt2018.assign3.presentation.view.StartView;
import pt2018.assign3.presentation.view.ViewAllObjects;
import pt2018.assign3.presentation.view.WindowClientOperations;
import pt2018.assign3.presentation.view.WindowOrderOperations;
import pt2018.assign3.presentation.view.WindowProductOperations;

public class MainController
{
	private StartView start = new StartView();
	private WindowClientOperations wco = new WindowClientOperations();
	private WindowProductOperations wpo = new WindowProductOperations();
	private WindowOrderOperations woo = new WindowOrderOperations();
	private AddClientView acv = new AddClientView();
	private AddProductView apv = new AddProductView();
	private AddOrderView aov = new AddOrderView();
	private DeleteObjectView dov;
	private EditClientView ecv = new EditClientView();
	private EditProductView epv = new EditProductView();
	private ClientBLL clientBLL = new ClientBLL();
	private ProductBLL productBLL = new ProductBLL();
	private OrderBLL orderBLL = new OrderBLL();
	private ViewAllObjects vao;

	public MainController()
	{
		start.setVisible(true);

		start.actionListenerForClients(al1 ->
		{
			wco.setVisible(true);

			wco.actionListenerForAdd(al2 ->
			{
				acv.setVisible(true);

				acv.actionListenerForAdd(al3 ->
				{
					String name = acv.getNameTf().getText();
					String address = acv.getAddressTf().getText();
					String city = acv.getCityTf().getText();
					String email = acv.getEmailTf().getText();
					Client client = new Client(name, address, city, email);
					clientBLL.insertClient(client);
					acv.getNameTf().setText("");
					acv.getAddressTf().setText("");
					acv.getCityTf().setText("");
					acv.getEmailTf().setText("");
				});
			});

			wco.actionListenerForDelete(al4 ->
			{
				dov = new DeleteObjectView("client");
				dov.setVisible(true);

				dov.actionListenerForDelete(al5 ->
				{
					int id = Integer.parseInt(dov.getIdTf().getText());
					clientBLL.deleteClientById(id);
					dov.getIdTf().setText("");
				});
			});

			wco.actionListenerForEdit(al6 ->
			{
				ecv.setVisible(true);

				ecv.actionListenerForEdit(al7 ->
				{
					int id = Integer.parseInt(ecv.getIdTf().getText());
					String name = ecv.getNameTf().getText();
					String address = ecv.getAddressTf().getText();
					String city = ecv.getCityTf().getText();
					String email = ecv.getEmailTf().getText();
					Client client = new Client(id, name, address, city, email);
					clientBLL.updateClientById(client);
					ecv.getNameTf().setText("");
					ecv.getAddressTf().setText("");
					ecv.getCityTf().setText("");
					ecv.getEmailTf().setText("");
					ecv.getIdTf().setText("");
				});
			});

			wco.actionListenerForViewAll(al8 ->
			{
				String[] columnNames = clientBLL.getClientFieldsName();
				Object[][] data = clientBLL.getClientData();
				vao = new ViewAllObjects(columnNames, data, "Clients");
				vao.setVisible(true);
			});
		});

		start.actionListenerForProducts(al9 ->
		{
			wpo.setVisible(true);

			wpo.actionListenerForAdd(al10 ->
			{
				apv.setVisible(true);

				apv.actionListenerForAdd(al11 ->
				{
					String description = apv.getDescriptionTf().getText();
					double pricePerUnit = Double.parseDouble(apv.getPricePerUnitTf().getText());
					int quantity = Integer.parseInt(apv.getQuantityTf().getText());
					Product product = new Product(description, pricePerUnit, quantity);
					productBLL.insertProduct(product);
					apv.getDescriptionTf().setText("");
					apv.getPricePerUnitTf().setText("");
					apv.getQuantityTf().setText("");
				});
			});

			wpo.actionListenerForDelete(al12 ->
			{
				dov = new DeleteObjectView("product");
				dov.setVisible(true);

				dov.actionListenerForDelete(al13 ->
				{
					int id = Integer.parseInt(dov.getIdTf().getText());
					productBLL.deleteProductById(id);
					dov.getIdTf().setText("");
				});
			});

			wpo.actionListenerForEdit(al14 ->
			{
				epv.setVisible(true);

				epv.actionListenerForEdit(al15 ->
				{
					int id = Integer.parseInt(epv.getIdTf().getText());
					String description = epv.getDescriptionTf().getText();
					String pricePerUnit = epv.getPricePerUnitTf().getText();
					String quantity = epv.getQuantityTf().getText();
					productBLL.editProduct(id, description, pricePerUnit, quantity);
					epv.getIdTf().setText("");
					epv.getDescriptionTf().setText("");
					epv.getPricePerUnitTf().setText("");
					epv.getQuantityTf().setText("");
				});
			});

			wpo.actionListenerForViewAll(al16 ->
			{	
				String[] columnNames = productBLL.getProductFieldsName();
				Object[][] data = productBLL.getProductData();
				vao = new ViewAllObjects(columnNames, data, "Products");
				vao.setVisible(true);
			});

		});

		start.actionListenerForOrders(al17 ->
		{
			woo.setVisible(true);

			woo.actionListenerForAdd(al18 ->
			{
				aov.setVisible(true);

				aov.actionListenerForAdd(al19 ->
				{
					int idClient = Integer.parseInt(aov.getIdClientTf().getText());
					int idProduct = Integer.parseInt(aov.getIdProductTf().getText());
					int amount = Integer.parseInt(aov.getAmountTf().getText());
					if (amount < 1)
					{
						aov.setErrorText("The amount must be a positive value");
					}
					else
					{
						String status = aov.getStatusTf().getText();
						Order order = new Order(idClient, idProduct, amount, status);
						Product p = productBLL.selectProductById(idProduct);
						int remainingQuantity = p.getQuantity() - amount;
						if (remainingQuantity < 0)
						{
							aov.setErrorText("Not enough products on stock");
						}
						else
						{
							if (orderBLL.insertOrder(order))
							{
								p.setQuantity(remainingQuantity);
								productBLL.editProduct(p);
							}
							else
							{
								aov.setErrorText("No existing client or product with the given id");
							}
						}
					}
					aov.getIdClientTf().setText("");
					aov.getIdProductTf().setText("");
					aov.getAmountTf().setText("");
					aov.getStatusTf().setText("");
				});
			});

			woo.actionListenerForViewAll(al20 ->
			{
				String[] columnNames = orderBLL.getOrderFieldsName();
				Object[][] data = orderBLL.getOrderData();
				vao = new ViewAllObjects(columnNames, data, "Orders");
				vao.setVisible(true);
			});

		});
	}

}
