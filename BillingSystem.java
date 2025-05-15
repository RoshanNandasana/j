class InvoiceDetail<N extends Number> {  
    private String invoiceName;  
    private N amount;  
    private N Discount;  

    public InvoiceDetail(String invoiceName, N amount, N Discount) {  
        this.invoiceName = invoiceName;  
        this.amount = amount;  
        this.Discount = Discount;  
    }  

    public String getInvoiceName() {  
        return invoiceName;  
    }  

    public void setInvoiceName(String invoiceName) {  
        this.invoiceName = invoiceName;  
    }  

    public N getAmount() {  
        return amount;  
    }  

    public void setAmount(N amount) {  
        this.amount = amount;  
    }  

    public N getDiscount() {  
        return Discount;  
    }  

    public void setDiscount(N Discount) {  
        this.Discount = Discount;  
    }  
}  

public class Invoice {  
    public static void main(String[] args) {  
        InvoiceDetail<Integer> invoice1 = new InvoiceDetail<>("Invoice1", 1000, 150);  
        InvoiceDetail<Double> invoice2 = new InvoiceDetail<>("Invoice2", 2000.5, 300.75);  

        System.out.println("Invoice 1: " + invoice1.getInvoiceName()  
            + "\n Amount: " + invoice1.getAmount() + "\n Discount: " +  
            invoice1.getDiscount() + "\n Final Amount: " +  
            (invoice1.getAmount().doubleValue() - invoice1.getDiscount().doubleValue()));  

        System.out.println("Invoice 2: " + invoice2.getInvoiceName()  
            + "\n Amount: " + invoice2.getAmount() + "\n Discount: " +  
            invoice2.getDiscount() + "\n Final Amount: " +  
            (invoice2.getAmount().doubleValue() - invoice2.getDiscount().doubleValue()));  
    }  
}