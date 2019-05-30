# CodeReview4
Project description
You need to create a part of IT systems of  CityBike Vienna: 
Prerequisite for the use of Citybike Wien is a one-time registration (to become a Registered User) .  
As soon as registered you can rent a bike at any Station in Vienna. Around the clock, the whole year.

Returning a bike is easy: just insert your bike into an empty bikebox at any Citybike Wien station.  

Your job is to create a system that track the Citybike Wien Bikes, Citybike Wien Stations  and Citybike Wien Users  

For this CodeReview, the following criteria will be graded:

Base Points:
(10) Create a Java class Bike containing following parameters:
•	bikeID (Integer)
•	color
•	state (which can be CanBeRended, CanNotBeRented, InService, Discarded (aka so broken that the service do not pay off)

(10) Create a Bike constructor that is using a static variable to create and increment BikeID automatically on creation of new Bike object.
(10) Create 8 or more Bike objects in your main().
(10) Put in your main() all existing Bikes in a HashMap that uses bikeID as a source for key value.
(10) Create Stations class containing following parameters:
•	stationID (Integer)
•	location (String)
•	bikes: Bikes data structure is storing all Bikes that are currently in this station. Decide yourself what data structure you want to use
(10) Create 3 Station object in your main() and put them in a HashMap stations
(10) Create a method of Station class:
addBike(... some parameter here ..)
that is storing a Bike in a Station. How you do that actually - it depends on the nature of your Station.bikes variable.
(10) Demonstrate the usage of addBike(...)  method by calling it in your main() method (put 3 bikes in Station1, and put 4 bikes in Station2).
(10) Create User class with parameters:
•	userID
•	name
•	surname
•	currentlyRentedBike: decide yourself if you are using a Bike object, or a key (depending on your data model).
Create 4 users.
(5) demonstrate the rental procedure:
•	UserZ rents a bike bikeX from stationY1
•	bikeX is removed from the data of that Station, and connected to a userZ
•	userZ returns a bike to stationY2
(5) Add Junit tests covering renting and returning process (hint: check that a rented bike has been removed from station)
Notes:
1.	All your java classes belong to a package citybike
2.	Feel free to use System.out.println in the programming process to make your debugging easier.
Additional points: 
(10) assure that a Station has the upper limit of bikes that can be returned (for instance, max 5 bikes). If someone wants to call the method addBike(...), and the station is full, report that to the user over System.out.println() and prevent
10) Add the rental tracking per user. User and Rent (new class) are connected, and the Rent class is tracking:
•	BikeID,
•	RentStart (DateTime)
•	RentEnd (DateTime)  

