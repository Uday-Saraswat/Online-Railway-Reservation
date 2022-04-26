package com.casestudy.uday.resources;

import java.util.List;
import java.util.Optional;

import com.casestudy.uday.model.Train;
import com.casestudy.uday.repository.TrainRepository;
import com.casestudy.uday.service.TrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/search")
public class UserController {

    Logger logger = LoggerFactory.getLogger(TrainService.class);
	
	@Autowired
	private TrainRepository trainrepository;

    @GetMapping("/home")
    public String home(){
        logger.info("Hello User");
        return "Hello User";
    }

    @GetMapping("/findAllTrains")
    public List<Train> getTrains(){
	return trainrepository.findAll();
	
}
    @GetMapping("/findAllTrains/{trainid}")
    public Optional<Train> getTrains(@PathVariable String trainid){
	return trainrepository.findById(Integer.valueOf(trainid));
}
	
}