package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    private String checkin;
    private String checkout;

//    public String getCheckin() {
//        return checkin;
//    }
//
//    public void setCheckin(String checkin) {
//        this.checkin = checkin;
//    }
//
//    public String getCheckout() {
//        return checkout;
//    }
//
//    public void setCheckout(String checkout) {
//        this.checkout = checkout;
//    }
}
