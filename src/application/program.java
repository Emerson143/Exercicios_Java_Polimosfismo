package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import etitiens.ImportedProduct;
import etitiens.produto;
import etitiens.usedProduct;

public class program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<produto> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<produto> lista = new ArrayList<>();

		System.out.print("Enter the number of Products:");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (ch == 'c') {

				list.add(new produto(name, price));
			}

			else if (ch == 'u') {

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());

				list.add(new usedProduct(name, price, date));
			} else {
				System.out.print("Customs fee:");
				double customsFree = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFree));

			}

		}

		System.out.println("PRICE TAGS:");
		for (produto emp : lista) {

			System.out.println(emp.priceTag());
		}
		sc.close();
	}
}
