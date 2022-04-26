package com.casestudy.uday.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.uday.CustomException.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.uday.model.Train;
import com.casestudy.uday.repository.TrainRepository;

@Service
public class TrainService {


	@Autowired
	private TrainRepository trainrepository;

	Logger logger = LoggerFactory.getLogger(TrainService.class);


	public Train addTrain(Train train)	 {
		return trainrepository.save(train);
	}

	public List<Train> getTrain() {
		List<Train> train = trainrepository.findAll();
		System.out.println("Getting data from DB : " + train);
		return train;
	}

	public Optional<Train> getTrainbyId(String tid) {
		return trainrepository.findById(Integer.valueOf(tid));
	}

	public void deleteTrain(Train train) {
		trainrepository.delete(train);
	}


}
