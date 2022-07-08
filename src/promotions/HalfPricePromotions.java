package promotions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import products.Product;
import utils.Constants;

public class HalfPricePromotions implements Promotion {
	
	public static final String promotionName = "HalfPricePromotion";
	public static final List<String> eligibleItems = Collections.unmodifiableList(
		    new ArrayList<String>() {{
		        add("A");
		        add("B");
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
	
	List<Product> listOfA =  productList.stream().filter(i -> i.getProductName().equalsIgnoreCase("A")).collect(Collectors.toList());
	List<Product> listOfB =  productList.stream().filter(i -> i.getProductName().equalsIgnoreCase("B")).collect(Collectors.toList());
	
	float totalCostOfA = 0;
	float totalCostOfB =  0;
	float priceOfA = 0;
	float priceOfB = 0;
	long numberOfA = eligibleProductList.stream().filter(i -> i.getProductName().equalsIgnoreCase("A")).count();
	long numberOfB = eligibleProductList.stream().filter(i -> i.getProductName().equalsIgnoreCase("B")).count();

	if(numberOfA > 0) {
		priceOfA = listOfA.get(0).getProductPrice();
		totalCostOfA = numberOfA * priceOfA;		
	}
	if(numberOfB > 0) {
		priceOfB = listOfB.get(0).getProductPrice();
		totalCostOfB = numberOfB * priceOfB;
		
		if(numberOfA >= numberOfB) {
			
			totalCostOfB = totalCostOfB / 2;
			
		} else {
			
			float totalPriceOfBNotEligibleForPromotion = ((numberOfB - numberOfA) * priceOfB) ;
			float discountedPriceOfB = (totalCostOfB - totalPriceOfBNotEligibleForPromotion) / 2;
			
			totalCostOfB = totalPriceOfBNotEligibleForPromotion + discountedPriceOfB;
		}
	}

		
		return totalCostOfA + totalCostOfB;
	}
	

}
