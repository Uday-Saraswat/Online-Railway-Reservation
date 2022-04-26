import axios from "axios";

const api = "http://localhost:9030";

export const addTrain = async (train) => {

    return axios.post(`${api}/trains/addTrain`,train);

}