package products;

import java.util.Objects;
import java.util.Optional;

import promotions.Promotion;

public class Product {

	public Product(String productName, float productPrice, boolean isPromotionApplied, String promotionType) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.isPromotionApplied = isPromotionApplied;
		this.promotionType = promotionType;
	}

	public Product() {
		super();
	}

	String productName;
	float productPrice;
	boolean isPromotionApplied;
	String promotionType;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public boolean isPromotionApplied() {
		return isPromotionApplied;
	}

	public void setPromotionApplied(boolean isPromotionApplied) {
		this.isPromotionApplied = isPromotionApplied;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isPromotionApplied, productName, productPrice, promotionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return isPromotionApplied == other.isPromotionApplied && Objects.equals(productName, other.productName)
				&& Float.floatToIntBits(productPrice) == Float.floatToIntBits(other.productPrice)
				&& Objects.equals(promotionType, other.promotionType);
	}

	

}
