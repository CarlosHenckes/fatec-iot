package br.com.fatec.iot;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/v1/sensor")
@RestController
public class SensorsController {
	
	private final SensorService service;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping
	public String save(final DataDTO data) {
		log.info("SensorsController.save - start. data: [{}]", data);
		return service.saveSensorData(data);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value = "/data")
	public List<DataDTO> findAll() {
		log.info("SensorsController.findAll - start.");
		return service.findAll();
	}
}