package MovieTicketBookingSystem;

public class Booking {
    private String bookingId;
    private Show show;
    private Payment payment;

    public Booking(String bookingId, Show show, Payment payment) {
        this.bookingId = bookingId;
        this.show = show;
        this.payment = payment;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
