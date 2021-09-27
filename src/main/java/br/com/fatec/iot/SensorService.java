package br.com.fatec.iot;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SensorService {

	private final SensorRepository repository;
	
	public String saveSensorData(final DataDTO data) {
		
		final DataDTO result = repository.save(data.toBuilder()
				.time(LocalDateTime.now())
				.build());
		
		return result.toString();
	}
	
	public List<DataDTO> findAll() {
		return repository.findAll();
	}
}
