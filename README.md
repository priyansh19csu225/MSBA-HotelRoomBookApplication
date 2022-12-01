# HotelRoomBooking-SpringBootApp
 MicroService NCU 2022 Course - Mini Project 2
 
 ### SCREENSHOTS 

![Screenshot (97)](https://user-images.githubusercontent.com/71059426/205059751-de50b9be-985c-4c06-a695-6eb677f723db.png)

------------------------------------------------------------------------------------------------------------------

![Screenshot (98)](https://user-images.githubusercontent.com/71059426/205059805-ce4eafb3-63ce-4ce8-b9f3-27f6fff88e4e.png)

------------------------------------------------------------------------------------------------------------------

![Screenshot (99)](https://user-images.githubusercontent.com/71059426/205059849-9367e78b-6d03-4dc9-952b-9be0646ecacf.png)

### HOW TO RUN
1. Download the code or clone the repo
2. open projects in spring suite and update the project.
3. Start the database server and perform config according to db in **application.yml** file of Booking & Payment Service
4. start all four services 
5. Refer to application.yml file of Discovery and ApiGateway Service for other meta data of the project.
6. use API testing tool.

### TECHNOLOGY USED
1. SpringBoot
2. MySQL as database
3. Eureka for service registry

### APPLICATION FLOW
![Untitled Diagram drawio](https://user-images.githubusercontent.com/108087172/204868260-d9955b89-964d-4654-a76e-33ff0f8741f0.png)

### ENDPOINTS

1. path = "/booking/initiate"<br>
    Request Body : { toDate,fromDate,aadharNumber,numOfRooms }<br>
    Response Body : { generatedBookingId, ListOfRooms }

2. path = "/booking/confirm?bookingId=<generatedBookingId>"<br>
    Request Body : { paymentMode, upi/card }<br>
    Response Body : { BookingDetails }<br>
   
3. path = "/payment/initiate"<br>
    used by booking service <br>
    Request Body : { paymentDetails }<br>
    Response Body : { transactionId }<br>
   
4. path = "/booking/cancel?bookingId=<generatedBookingId>"<br>
    Delete the saved booking info<br>






