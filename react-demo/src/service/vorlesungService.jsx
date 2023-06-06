import axios from "axios";

const VORLESUNGEN_REST_API_URL = "http://localhost:8080/api";

class RestaurantService {
  getRestaurants() {
    return axios.get(VORLESUNGEN_REST_API_URL);
  }
}

export default new RestaurantService();
