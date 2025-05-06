package amazon;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class Main {
    public static void main(String[] args) {
        HttpResponse<JsonNode> response = Unirest.get("https://workwithus.lucioai.com/get-started").asJson();

        System.out.println(response.toString());

//        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response1 = Unirest.post("https://workwithus.lucioai.com/get-started")
                .header("Content-Type", "application/json")
                .body("{\r\n    \"name\": \"shreyas Dhoke\",\r\n    \"email\": \"shreyashdhoke30@gmail.com\"\r\n}")
                .asString();


//        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response2 = Unirest.get("https://workwithus.lucioai.com/access-check")
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoic2hyZXlhcyBEaG9rZSIsImVtYWlsIjoic2hyZXlhc2hkaG9rZTMwQGdtYWlsLmNvbSIsImRhdGUiOiIyMDI1LTAzLTIxIDAxOjA3OjIxIn0.Th3-M3oYVXXiNOFnJQ23dG7t-Sek7AiDPyR9u-3i9rQ")
                .asString();

//        Unirest.setTimeouts(0, 0);
        HttpResponse<JsonNode> response3 = Unirest.post("https://workwithus.lucioai.com/access-check")
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoic2hyZXlhcyBEaG9rZSIsImVtYWlsIjoic2hyZXlhc2hkaG9rZTMwQGdtYWlsLmNvbSIsImRhdGUiOiIyMDI1LTAzLTE5IDA5OjM5OjQ4In0.2nuh5NWR7ioG1FaTSmvyB28thielqoGmUYdpQPWwNy4")
                .header("Referer", "lucioai.com")
                .header("User-Agent", "mr_robot")
                .asJson();

        HttpResponse<JsonNode> response4 = Unirest.get("https://workwithus.lucioai.com/look-around")
                .header("Authorization", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoic2hyZXlhcyBEaG9rZSIsImVtYWlsIjoic2hyZXlhc2hkaG9rZTMwQGdtYWlsLmNvbSIsImRhdGUiOiIyMDI1LTAzLTE5IDA5OjM5OjQ4In0.2nuh5NWR7ioG1FaTSmvyB28thielqoGmUYdpQPWwNy4")
                .header("Referer", "lucioai.com")
                .header("User-Agent", "mr_robot")
                .asJson();


    }
}
