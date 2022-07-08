package promotions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import products.Product;

public class CheapestItemFreePromotion implements Promotion {
	
	public static final List<String> eligibleItems = Collections.unmodifiableList(
		    new ArrayList<String>() {{
		        add("X");
		        add("Y");
		        add("Z");
		        add("P");
		        add("Q");       
		    }});


	@Override
	public float getDiscountedAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float applyPromotion(List<Product> productList) {
		// TODO Auto-generated method stub
		Predicate<Product> p = i -> (i.isPromotionApplied() && eligibleItems.contains(i.getProductName()));
		List<Product> eligibleProductList = productList.stream().filter(i -> p.test(i)).collect(Collectors.toList());
		
		int totalNumberOfItems = (int)eligibleProductList.stream().count();
		
		int totalNumberOfItemsForFree = totalNumberOfItems / 3;
		
		List<Product> listOfItemsForFree = new ArrayList<Product>();
		
		
		
		float totalPriceBeforeDiscount = 0;
		
		for(Product product: eligibleProductList) {
			totalPriceBeforeDiscount = totalPriceBeforeDiscount + product.getProductPrice();
		}
		float totalPriceAfterDiscount = totalPriceBeforeDiscount;
		if(eligibleProductList.size() > 0) {
			for(int i =0; i < totalNumberOfItemsForFree; i++) {
				
				Product eligibleProductForFree = eligibleProductList.stream().min(Comparator.comparing(Product::getProductPrice)).get();
				//listOfItemsForFree.add(eligibleProductForFree);
				System.out.println("PRoduct price "+eligibleProductForFree.getProductPrice());
				totalPriceAfterDiscount = totalPriceAfterDiscount - eligibleProductForFree.getProductPrice();
				eligibleProductList.remove(eligibleProductForFree);
			}
		} 
		
		
		return totalPriceAfterDiscount;
	}

}
