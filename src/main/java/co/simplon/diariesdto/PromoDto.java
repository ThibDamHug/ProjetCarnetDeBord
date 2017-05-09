package co.simplon.diariesdto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class PromoDto {
	
	private long id;

	private String name;

	private Date startDate;

	private Date endDate;


}
