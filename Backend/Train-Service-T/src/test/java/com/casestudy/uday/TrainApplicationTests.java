//package com.casestudy.uday;
//
//import com.casestudy.uday.model.Train;
//import com.casestudy.uday.service.TrainService;
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.casestudy.uday.repository.TrainRepository;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//class TrainApplicationTests {
//
//	@Autowired
//	private TrainService trainService;
//
//	@MockBean
//	private TrainRepository trainrepository;
//
//	@Test
//	 public  void getTrainTest() {
//		when(trainrepository.findAll()).thenReturn(Stream
//				.of(new Train(1,"12443"," Delhi-CDG express","Delhi","Chandigarh"), new Train(2,"12","Sachkhand Express","Amritsar","Agra")).collect(Collectors.toList()));
//		assertEquals(2,trainService.getTrain().size());
//	}
//		@Test
//		public void saveTrainTest() {
//			Train train = new Train(1,"12877","SNSI KLK SF Express","Shirdi sai ","Kalka");
//			when(trainrepository.save(train)).thenReturn(train);
//			Assert.assertEquals(train, trainService.addTrain(train));
//
//		}
//		@Test
//		public void deleteTrainTest() {
//			Train train = new Train(1,"12443","Delhi-CDG express","Delhi","Chandigarh");
//			trainService.deleteTrain(train);
//			verify(trainrepository, times(1)).delete(train);
//		}
//
//
//}