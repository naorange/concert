package sac;

import sac.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTicketBooked_Ticketbooked(@Payload TicketBooked ticketBooked){

        if(ticketBooked.isMe()){
            System.out.println("##### listener 예약완료 : " + ticketBooked.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTicketCanceled_TicketCanceled(@Payload TicketCanceled ticketCanceled){

        if(ticketCanceled.isMe()){
            System.out.println("##### listener 예약취소 : " + ticketCanceled.toJson());
        }
    }

}
