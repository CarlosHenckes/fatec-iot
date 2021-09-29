package br.com.fatec.iot;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String save(@RequestParam("field1") final String field1, 
					   @RequestParam("field2") final String field2, 
					   @RequestParam("field3") final String field3) {
		log.info("SensorsController.save - start. field1: [{}], field2: [{}], field3: [{}]", field1, field2, field3);
		return service.saveSensorData(DataDTO.builder()
				.field1(field1)
				.field2(field2)
				.field3(field3)
				.build());
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping
	public String savePost(@RequestBody final DataDTO data) {
		log.info("SensorsController.savePost - start. data: [{}]", data);
		return service.saveSensorData(data);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value = "/data")
	public List<DataDTO> findAll() {
		log.info("SensorsController.findAll - start.");
		return service.findAll();
	}
}
