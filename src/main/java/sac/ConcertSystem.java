package sac;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="ConcertSystem_table")
public class ConcertSystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String concertName;
    private Integer customerNumber;

    @PostPersist
    public void onPostPersist(){
        ConcertOpened concertOpened = new ConcertOpened();
        BeanUtils.copyProperties(this, concertOpened);
        concertOpened.publish();


    }

    @PostRemove
    public void onPostRemove(){
        ConcertCanceled concertCanceled = new ConcertCanceled();
        BeanUtils.copyProperties(this, concertCanceled);
        concertCanceled.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getConcertName() {
        return concertName;
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName;
    }
    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }




}
