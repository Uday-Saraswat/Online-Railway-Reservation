package com.casestudy.uday.resources;

import java.util.List;
import java.util.Optional;

import com.casestudy.uday.CustomException.CustomException;
import com.casestudy.uday.model.Train;
import com.casestudy.uday.repository.TrainRepository;
import com.casestudy.uday.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trains")
@CrossOrigin("http://localhost:3000")
public class TrainController {
	
	@Autowired
	private TrainRepository trainrepository;

	@Autowired
	private TrainService trainService;


	@GetMapping("/alltrains")
	@CrossOrigin("http://localhost:4200")
	public List<Train> getAllTrains() {
		List<Train> trainList = trainrepository.findAll();
		if(trainList.isEmpty()) {
			throw new CustomException("603","Train List is completely empty");
		}
		else {
			return trainrepository.findAll();
		}}

	@PostMapping("/addTrain")
	@CrossOrigin("http://localhost:4200")
	public String saveTrain(@RequestBody Train trainid) {
	trainrepository.save(trainid);
	return "Added train with id :  " + trainid.getTrainid();
    }

	@GetMapping("{id}")
	@CrossOrigin("http://localhost:4200")
	public Optional<Train> getTrain(@PathVariable Integer id){
		return trainrepository.findById(id);
	}


		
	@DeleteMapping("/delete/{id}")
	@CrossOrigin("http://localhost:4200")
	public String deleteTrain (@PathVariable Integer id) {
		trainrepository.deleteById(id);
		return "Train deleted with id : "+id;
    }
	@PutMapping("/update/{trainid}")
	@CrossOrigin("http://localhost:4200")
	public Train updateTrain(@PathVariable("trainid") String trainid,@RequestBody Train t ) {
		t.setTrainid(trainid);
		trainrepository.save(t);
		return t;
		
}
	
	
	
}

