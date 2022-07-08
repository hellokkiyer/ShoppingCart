package promotions;

import java.util.HashMap;
import java.util.List;

import products.Product;

public interface Promotion {
	
	float getDiscountedAmount();
	float getTotalPrice();
	float applyPromotion(List<Product> productList);
	
}
