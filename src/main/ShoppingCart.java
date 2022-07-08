package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import products.Product;
import promotions.CheapestItemFreePromotion;
import promotions.HalfPricePromotions;
import promotions.NoPromotion;
import promotions.Promotion;
import utils.Constants;

public class ShoppingCart {

	public static void main(String[] args) {
		//(String productName, float productPrice, boolean isPromotionApplied, Promotion promotionType) {
		Product productA = new Product("A", 10.0f, true, Constants.halfPricePromotionName);
		Product productB = new Product("B", 9.0f, true, Constants.halfPricePromotionName);	
		Product productX = new Product("X", 10.0f, true, Constants.cheapestItemFreePromotionName);
		Product productY = new Product("Y", 5.0f, true, Constants.cheapestItemFreePromotionName);
		Product productZ = new Product("Z", 4.0f, true, Constants.cheapestItemFreePromotionName);
		Product productP = new Product("P", 3.0f, true, Constants.cheapestItemFreePromotionName);
		Product productQ = new Product("Q", 8.0f, true, Constants.cheapestItemFreePromotionName);
		Product productR = new Product("R", 2.0f, false, Constants.noPromotion);
		
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(productA);
		productList.add(productB);
		productList.add(productB);
		productList.add(productX);
		productList.add(productY);
		productList.add(productY);
		productList.add(productR);
		
		
		
		HalfPricePromotions halfPrice = new HalfPricePromotions();
		CheapestItemFreePromotion cheapestItemPromotion = new CheapestItemFreePromotion();
		NoPromotion noPromotion = new NoPromotion();
		float totalAmoutForHalfPriceProducts =  halfPrice.applyPromotion(productList);
		float totalAmountForCheapestItemProducts = cheapestItemPromotion.applyPromotion(productList);
		float totalAmountForNoPromotionItemProducts = noPromotion.applyPromotion(productList);
		
		float totalPrice = totalAmoutForHalfPriceProducts + totalAmountForCheapestItemProducts + totalAmountForNoPromotionItemProducts;
		System.out.println("HalfPrice promotion Price "+ totalAmoutForHalfPriceProducts);
		System.out.println("Cheapest Item Price "+ totalAmountForCheapestItemProducts);
		System.out.println("Total Price "+ totalPrice);
		
	}
}
