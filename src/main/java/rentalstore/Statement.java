package rentalstore;

public abstract class Statement {
    public abstract String getHeader(Customer customer);
    public abstract String eachRental(Rental rental);
    public abstract String getFooter(Customer customer);
}
