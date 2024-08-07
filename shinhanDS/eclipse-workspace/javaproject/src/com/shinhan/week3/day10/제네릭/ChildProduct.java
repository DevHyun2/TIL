package com.shinhan.week3.day10.제네릭;

//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.ToString;

//상속

@NoArgsConstructor
@Getter@Setter
//@ToString
public class ChildProduct<K, V, P> extends Product<K, V>{

	P price;

	public ChildProduct(K kind, V model, P price) {
		super(kind, model);
		this.price = price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChildProduct [price=").append(price).append(", toString()=").append(super.toString())
				.append("]");
		return builder.toString();
	}

	
}
