import java.util.Scanner;
//DO NOT EDIT THIS CLASS
class Product {
	private int prodCode;
	private String prodName;
	private double price;
	private String category;
	
	public Product(int prodCode, String prodName, double price, String category) {
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.price = price;
		this.category = category;
	}

	public int getProdCode() {
		return prodCode;
	}

	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}


//DO NOT EDIT THIS CLASS
class ProductData {
	
	private static Product[] products;
				
	static {
		products = new Product[8];
		products[0] = new Product(101, "keyboard", 300, "computers");
		products[1] = new Product(102, "mouse", 600, "computers");
		products[2] = new Product(103, "monitor", 5000, "computers");
		products[3] = new Product(104, "t-shirt", 500, "clothing");
		products[4] = new Product(105, "jeans", 2000, "clothing");
		products[5] = new Product(106, "sweater", 1000, "clothing");
		products[6] = new Product(107, "doll", 500, "toys");
		products[7] = new Product(108, "car", 1000, "toys");
	}

	public static Product[] getProducts() {
		return products;
	}
}


class ProductService 
{
    static Product[] products=ProductData.getProducts();

    public static String findNameByCode(int code){
        for(int i=0;i<products.length;i++){
            if(products[i].getProdCode()==code)  return products[i].getProdName();
            
        }
        return null;
    }
    
    public static Product findMaxPriceProduct(String category){
        int index=-1;
        double indexPrice=0;
        for(int i=0;i<products.length;i++){
            if(products[i].getCategory().equalsIgnoreCase(category)){
                if(products[i].getPrice()>indexPrice){
                    indexPrice=products[i].getPrice();
                    index=i;
                }
            }
        }
        if(index==-1) return null;
        return products[index];
        
    }
}

public class ProductAnalysis{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int op=sc.nextInt();
        switch(op){
            case 1:
                int code=sc.nextInt();
                String name=ProductService.findNameByCode(code);
                if(name!=null)System.out.println(name);
                else System.out.println("Product Not Found");
                break;
            case 2:
                String category=sc.next();
                Product p=ProductService.findMaxPriceProduct(category);
                if(p==null){
                   System.out.println("No products in given category");
                   break;
                } 
                System.out.println(p.getProdCode()+
                            " | "+p.getProdName()+" | "+p.getPrice());
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}