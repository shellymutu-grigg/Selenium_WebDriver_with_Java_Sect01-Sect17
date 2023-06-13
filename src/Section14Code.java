import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Section14Code {

	// @Test
	public void regular() {
		// Count the number of names starting with A in a list
		ArrayList<String> namesStrings = new ArrayList<String>();

		namesStrings.add("Abby");
		namesStrings.add("Jim");
		namesStrings.add("Shelly");
		namesStrings.add("Gerado");
		namesStrings.add("Alfie");

		int count = 0;

		for (int i = 0; i < namesStrings.size(); i++) {
			String actualString = namesStrings.get(i);
			if (actualString.startsWith("A")) {
				count++;
			}
		}
		// Print count of names beginning with "A"
		System.out.println(MessageFormat.format("Number of names sytarting with 'A': {0}", count));
	}

	@Test
	public void streamFilter() {
		ArrayList<String> namesStrings = new ArrayList<String>();

		namesStrings.add("Abby");
		namesStrings.add("Jim");
		namesStrings.add("Shelly");
		namesStrings.add("Gerado");
		namesStrings.add("Alfie");
		// Print count of names beginning with "A"
		System.out.println(MessageFormat.format("Number of names sytarting with 'A': {0}",
				namesStrings.stream().filter(s -> s.startsWith("A")).count()));

		// Create stream instead of Array
		long namesCount = Stream.of("Abby", "Jim", "Shelly", "Gerado", "Alfie").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();

		// Print count of names beginning with "A"
		System.out.println(MessageFormat.format("Number of names sytarting with 'A': {0}", namesCount));

		// Print out all names with length greater than 4
		namesStrings.stream().filter(s -> s.length() > 4)
				.forEach(s -> System.out.println(MessageFormat.format("Name with length greater than 4: {0}", s)));

		// Limit printing out names with length greater than 4 to first instance
		namesStrings.stream().filter(s -> s.length() > 4).limit(1)
				.forEach(s -> System.out.println(MessageFormat.format("Name with length greater than 4: {0}", s)));

	}

	@Test
	public void streamMap() {

		ArrayList<String> namesStrings = new ArrayList<String>();

		namesStrings.add("Abby");
		namesStrings.add("Jim");
		namesStrings.add("Shelly");
		namesStrings.add("Gerado");
		namesStrings.add("Alfie");

		// Print all names that end in y in uppercase
		Stream.of("Abby", "Jim", "Shelly", "Gerado", "Alfie").filter(s -> s.endsWith("y")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(MessageFormat.format("Name ending in 'y' in uppercase: {0}", s)));

		// Print names with first letter 'A' as uppercase and sorted
		List<String> names = Arrays.asList("Abby", "Jim", "Shelly", "Gerado", "Alfie");
		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out
				.println(MessageFormat.format("Name beginning wth 'A' in uppercase and ordered: {0}", s)));

		//
		Stream<String> mergedStream = Stream.concat(namesStrings.stream(), names.stream());
		// mergedStream.sorted().forEach(s -> System.out
		// .println(MessageFormat.format("Name beginning wth 'A' in uppercase and
		// ordered: {0}", s)));

		boolean contained = mergedStream.anyMatch(s -> s.equalsIgnoreCase("Shelly"));
		System.out.println(MessageFormat.format("Matched: {0}", contained));
		Assert.assertTrue(contained);
	}

	@Test
	public void streamCollect() {
		// Collect results of function
		List<String> resultStrings = Stream.of("Abby", "Jim", "Shelly", "Gerado", "Alfie").filter(s -> s.endsWith("y"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(MessageFormat.format("First result: {0}", resultStrings.get(0)));

		List<Integer> values = Arrays.asList(3, 5, 6, 7, 8, 3, 8);

		// Print the distinct values in list
		values.stream().distinct().forEach(s -> System.out.println(MessageFormat.format("Unique value: {0}", s)));

		// Sort the list
		List<Integer> sortedValues = values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(MessageFormat.format("Sorted distinct list item at 3rd index: {0}", sortedValues.get(2)));

	}

	public static void main(String[] args) {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on a column
		webDriver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture all the web elements in a list
		List<WebElement> elementsList = webDriver.findElements(By.xpath("//tr/td[1]"));

		// Capture the text of all the web elements into new(original) list
		List<String> stringsList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort on the original list created at step 3
		List<String> sortedList = stringsList.stream().sorted().collect(Collectors.toList());

		// Compare lists and see if both are sorted - errors and stops test
		// Assert.assertTrue(elementsList.equals(sortedList));

		// Scan the vege name column with getText then print vege price
		List<String> price;

		// Navigate to relevant page
		do {
			List<WebElement> veggies = webDriver.findElements(By.xpath("//tr/td[1]"));
			price = veggies.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVegePrice(s))
					.collect(Collectors.toList());
			price.forEach(e -> System.out.println(MessageFormat.format("Price for Rice: {0}", e)));

			if (price.size() < 1) {
				webDriver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

		// Use the search field to find a vege
		webDriver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggieNames = webDriver.findElements(By.xpath("//tr/td[1]"));

		List<WebElement> filteredList = veggieNames.stream().filter(vege -> vege.getText().contains("Rice"))
				.collect(Collectors.toList());

		// Verify only one result
		Assert.assertEquals(veggieNames.size(), filteredList.size());
	}

	public static String getVegePrice(WebElement e) {
		String priceString = e.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceString;

	}

}
