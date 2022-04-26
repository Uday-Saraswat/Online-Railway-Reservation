import axios from "axios";

import { addTrain } from "../components/addTrain";

jest.mock("axios");

it("addTrain", async () => {
  // given

  const api = "http://localhost:9030";

  const train = { trainName: "KLK HWR EXP" };

  const response = { trainid: "12311", trainName: "KLK HWR EXP", startStation:"Kalka", endStation:"Howrah"  };

  axios.post.mockImplementation(() => response);

  // when

  const result = await addTrain(train);

  // then

  expect(axios.post).toHaveBeenCalledWith(
    `${api}/trains/addTrain`,
    train
  );

  expect(result).toEqual(response);

  console.log(result);
});
