package system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner scanner = new Scanner(System.in);
		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int numberProducts = scanner.nextInt();
		scanner.nextLine();

		for (int i = 1; i <= numberProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = scanner.next().charAt(0);
			scanner.nextLine();
			System.out.print("Name: ");
			String productName = scanner.nextLine();
			System.out.print("Price: ");
			double productPrice = scanner.nextDouble();
			scanner.nextLine();

			if (productType == 'c') {
				products.add(new Product(productName, productPrice));
			} else if (productType == 'u') {
				System.out.print("Manufacture data (DD/MM/YYYY): ");
				LocalDate manufactureDate = LocalDate.parse(scanner.nextLine(), fmt);
				products.add(new UsedProduct(productName, productPrice, manufactureDate));
			} else if (productType == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = scanner.nextDouble();
				products.add(new ImportedProduct(productName, productPrice, customsFee));
			}
		}

		scanner.close();
		System.out.println("\nPRICE TAGS:");
		for (Product x : products) {
			System.out.println(x.priceTag());
		}

	}

}
