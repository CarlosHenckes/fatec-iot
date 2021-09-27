package br.com.fatec.iot;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "sensordata")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class DataDTO {
	
	@Id
	private String id;
	
	private LocalDateTime time;

	private String field1;
	
	private String field2;
	
	private String field3;
	
}
