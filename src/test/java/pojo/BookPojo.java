package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookPojo {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesPojo bookingdates;

//    public String getFirstname() {
//        return firstname;
//    }

//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public int getTotalprice() {
//        return totalprice;
//    }
//
//    public void setTotalprice(int totalprice) {
//        this.totalprice = totalprice;
//    }
//
//    public boolean isDepositpaid() {
//        return depositpaid;
//    }
//
//    public void setDepositpaid(boolean depositpaid) {
//        this.depositpaid = depositpaid;
//    }
//
//    public BookingDatesPojo getBookingdates() {
//        return bookingdates;
//    }
//
//    public void setBookingdates(BookingDatesPojo bookingdates) {
//        this.bookingdates = bookingdates;
//    }
}
