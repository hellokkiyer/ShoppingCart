package promotions;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import products.Product;

public class NoPromotion implements Promotion {
	
	public static final String promotionName = "NoPromotion";

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

	
	public float applyPromotion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float applyPromotion(List<Product> productList) {
		// TODO Auto-generated method stub
		Predicate<Product> p = i -> (i.isPromotionApplied() == false);
		List<Product> productsWithNotPromotion = productList.stream().filter(i -> p.test(i)).collect(Collectors.toList());
		float totalPriceOfProducts = 0;
		for(Product product: productsWithNotPromotion) {
			totalPriceOfProducts =totalPriceOfProducts + product.getProductPrice();
		}
		return totalPriceOfProducts;
	}

}
