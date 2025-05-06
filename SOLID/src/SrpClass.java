//package solid;
//
//
//class Marker{
//    String name;
//    int price;
//
//    public Marker(String name , int price)
//    {
//        this.name = name;
//        this.price = price;
//    }
//}
//
//class Invoice{
//
//    public Marker marker;
//
//    private int quantity;
//
//    public Invoice(Marker marker, int quantity){
//        this.marker = marker;
//        this.quantity = quantity;
//    }
//
//    public int calcTotal(){
//        int price = ((marker.price)* quantity);
//        return price;
//
//        // 1st reson
//    }
//
//
//    public void printInvoice(){
//        // 2nd logic which can change
//    }
//    public void savetoDb(){
//        // 3rd reason
//    }
//
//    //hence not following single responsibilty principal
//
//}
//
//
//
//
//// SOLID
//
//
//class Invoice{
//
//    public Marker marker;
//
//    private int quantity;
//
//    public Invoice(Marker marker, int quantity){
//        this.marker = marker;
//        this.quantity = quantity;
//    }
//
//    public int calcTotal() {
//        int price = ((marker.price) * quantity);
//        return price;
//
//    }
//
//}
//
//class InvoiceDao{
//
//    Invoice invoice;
//    public InvoiceDao(Invoice inv){
//        this.invoice =  inv;
//    }
//
//    public void savetoDb(){
//
//    }
//}
//
//class InvoicePrinter{
//    private Invoice invoice;
//
//    public InvoicePrinter(Invoice inv){
//        this.invoice =  inv;
//    }
//
//    public void printInvoice() {
//        System.out.println("print");
//    }
//}
//
//
//public class main {
//    public static void main(String[] args){
//        Marker marker = new Marker("Blue Marker", 2.5);
//
//        // Create an invoice instance with the marker and a quantity
//        Invoice invoice = new Invoice(marker, 10);
//
//        // Calculate total price of the invoice
//        double total = invoice.calcTotal();
//        System.out.println("Total Price: " + total);
//
//        // Save the invoice to database (assuming savetoDb method is implemented)
//        InvoiceDao invoiceDao = new InvoiceDao(invoice);
//        invoiceDao.savetoDb();
//
//        // Print the invoice
//        InvoicePrinter invoicePrinter = new InvoicePrinter(invoice);
//        invoicePrinter.printInvoice();
//    }
//}
