package recruitmentcode;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import recruitmentcode.model.Product;

/**
 * Class Basket DOCUMENTEZ_MOI.
 */
public class Basket {

	/** products. */
	private List<Product> products;

	/** basket. */
	private Map<Integer, Integer> basket = new HashMap<>();

	/**
	 * methode Init the products stock .
	 */
	public void initBasket() {
		products = Arrays.asList(new Product(1, "Apple", 0.2, 2), new Product(2, "Orange", 0.5, 1),
				new Product(3, "Watermelon", 0.8, 1.5));

	}

	/**
	 * methode New basket .
	 */
	public void newBasket() {
		Scanner sc = new Scanner(System.in);
		int productId = 0;
		boolean end = false;
		System.out.println("------------------------------");
		System.out.println("-- List products available  --");
		System.out.println("------------------------------");
		for (Product p : products) {
			System.out.println(p.getItem() + "\t : Enter " + p.getId());
		}
		System.out.println("Exit  : 0 ");
		while (!end) {
			System.out.println("Enter a validated number to choose a Product (0 to Exit): ");
			try {
				productId = sc.nextInt();

				if (productId == 0)
					end = true;
				else {

					Product product = getProduct(productId);
					if (product != null) {
						System.out.println("Enter a validated Quantity : ");
						int quantity = sc.nextInt();
						addOrUpdateProductToBasket(product.getId(), quantity);
						sc.nextLine();
					} else {
						System.out.println(" Product does not exist");
						sc.nextLine();
					}
				}
			} catch (Exception e) {
				System.out.println("Invalid number");
				sc.nextLine();
			}

		}
		sc.close();

	}

	/**
	 * methode Display basket .
	 */
	public void displayBasket() {
		DecimalFormat df = new DecimalFormat("####0.00");
		System.out.println("--------------------------------------------------------");
		System.out.println("    Item    :Quantity   :Quantity with Offer    :Price  ");
		System.out.println("--------------------------------------------------------");
		Product product;
		for (Entry<Integer, Integer> entry : basket.entrySet()) {
			int productId = entry.getKey();
			int quantity = entry.getValue();
			product = getProduct(productId);
			int quantityWithOffer = getQuantityWithOffer(product, quantity);
			double price = getPriceBasket(product, quantity);
			System.out.println(product.getItem() + " \t \t" + quantity + "\t \t" + quantityWithOffer + "\t \t "
					+ df.format(price));
		}
	}

	/**
	 * Accesseur de l attribut product.
	 *
	 * @param productId
	 * @return product
	 */
	public Product getProduct(int productId) {

		return products.stream().filter(x -> productId == (x.getId())).findAny().orElse(null);

	}

	/**
	 * methode add or update product to basket.
	 *
	 * @param productId
	 * @param quantity
	 */
	public void addOrUpdateProductToBasket(int productId, int quantity) {
		quantity += basket.getOrDefault(productId, 0);
		if (quantity < 0)
			quantity = 0;
		basket.put(productId, quantity);

	}

	/**
	 * Accesseur de l attribut quantity with offer.
	 *
	 * @param product
	 * @param quantity
	 * @return quantity with offer
	 */
	public int getQuantityWithOffer(Product product, int quantity) {
		return (int) (product.getOffer() * quantity);
	}

	/**
	 * Accesseur de l attribut price basket.
	 *
	 * @param product
	 * @param quantity
	 * @return price basket
	 */
	public double getPriceBasket(Product product, int quantity) {
		return product.getPrice() * product.getOffer() * quantity;
	}

}
